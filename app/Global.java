import com.cloudinary.Cloudinary;
import helpers.CloudHelper;
import models.Image;
import models.course.Course;
import models.user.Role;
import models.user.User;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import utility.database.Courses;
import utility.database.Roles;
import utility.database.Users;

import play.api.mvc.EssentialFilter;


import static play.mvc.Results.badRequest;
import static play.mvc.Results.notFound;

/**
 * Created by boris.tomic on 21/09/15.
 */
public class Global extends GlobalSettings {

    @Override
    public void onStart(Application application) {
        Image.cloudinary = new Cloudinary("cloudinary://" + Play.application().configuration().getString("cloudinary.string"));


        if (Role.getFinder().findRowCount() == 0) {
            Roles.saveAllRoles();
        }
        if (User.getFinder().findRowCount() == 0) {
            Users.saveUsers();
        }
        if (Course.getFinder().findRowCount() == 0) {
            //Courses.saveCourses();
        }


    }

    @Override
    public F.Promise<Result> onHandlerNotFound(Http.RequestHeader requestHeader) {
        return F.Promise.<Result>pure(notFound(views.html.notfound.render()));
    }

    @Override
    public F.Promise<Result> onBadRequest(Http.RequestHeader requestHeader, String s) {
        return F.Promise.<Result>pure(badRequest(views.html.notfound.render()));
    }

}
