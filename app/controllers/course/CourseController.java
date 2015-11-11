package controllers.course;

import helpers.Authorization;
import helpers.SessionHelper;

import models.Post;
import models.course.Course;
import models.course.CourseUser;
import models.user.User;
import play.data.Form;
import play.libs.F;
import play.mvc.*;
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

    /**
     * Shows on the page list of all courses
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result allCourses() {

        return ok(courseList.render(Course.findAll()));
    }

    /**
     * Shows on the page list of users who are going to the course
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result course(Long id){
        Course c = Course.findById(id);
        User user = SessionHelper.currentUser(ctx());
        if(CourseUser.isAllowed(user, c)) {
            return ok(courseView.render(c));
        }else{
            return redirect("/user/courses");
        }
    }

}
