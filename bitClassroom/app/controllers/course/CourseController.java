package controllers.course;

import helpers.SessionHelper;

import models.Post;
import models.course.Course;
import models.course.CourseUser;
import models.user.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.courses.courseList;
import views.html.courses.courseView;
import views.html.courses.courseView;

import models.course.Course;
import models.user.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.courses.courseList;
import java.util.List;
import views.html.*;

/**
 * Created by Medina and Senadin on 16/09/15.
 */
public class CourseController extends Controller {

    public Result allCourses() {

        return ok(courseList.render(Course.findAll()));
    }

    public Result course(){
<<<<<<< HEAD

        List<CourseUser>  courUserList = CourseUser.all();
        return ok(courseView.render(courUserList));
=======
        User temp = SessionHelper.currentUser(ctx());
        return ok(courseView.render(temp));
>>>>>>> 12031afd18a58c1a8a7516242003e7853ff99504
    }





}
