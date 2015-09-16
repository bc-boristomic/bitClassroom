package helpers;

import models.user.Role;
import models.user.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;

import static play.mvc.Controller.flash;

/**
 * Created by boris on 9/12/15.
 */
public class TeacherFilter extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context context) {
        if (!context.session().containsKey("username")) {
            return null;
        }
        User temp = User.findByEmail(context.session().get("username"));
        if (temp != null && temp.getRoles() != null && temp.getRoles().size() > 0) {
            for (Role r : temp.getRoles()) {
                if (r.getId().equals(UserConstants.TEACHER)) {
                    return temp.getEmail();
                }
            }
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        flash("warning", "You don't have right permissions");
        return redirect("/login");
    }
}