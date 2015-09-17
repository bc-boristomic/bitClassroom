package controllers.course;

import helpers.SessionHelper;
import models.Post;
import models.course.Course;
import models.user.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.courses.courseList;
import views.html.courses.courseView;
import views.html.courses.courseView;

/**
 * Created by Medina and Senadin on 16/09/15.
 */
public class CourseController extends Controller {

    public Result allCourses (){

        return ok(courseList.render(Course.findAll()));
    }

    public Result course (){

        User temp = SessionHelper.currentUser(ctx());
        return ok(courseView.render(temp));
    }




}
