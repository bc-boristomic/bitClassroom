package controllers.course;

import helpers.Authorization;
import helpers.SessionHelper;
import models.course.Course;
import models.course.CourseUser;
import models.user.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.courses.courseList;
import views.html.courses.courseView;
import views.html.courses.redeemcode;

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

    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result redeemCode(){
        return ok(redeemcode.render());
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
