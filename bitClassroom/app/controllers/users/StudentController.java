package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import models.course.Course;
import models.course.CourseUser;
import models.user.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Student.class)
public class StudentController extends Controller {


    /**
     * Check if user is joined to the course
     * Get from request course id
     * Get user from session
     * If user is already joined then error will be show and he will be redirect to /user/courses
     * otherwise it will be show success message and alse he will be redirected to /user/courses
     */
    public Result joinCourse() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());
        User u = SessionHelper.currentUser(ctx());
        Course c = Course.findById(Long.valueOf(dynamicForm.get("course-id")));
        List<Course> courses = CourseUser.allUserCourses(u);
        for(Course course: courses){
            if(course.getId() == c.getId()) {
                flash("error", "You already join to " + c.getName());
                return redirect("/user/courses");
            }
        }

        CourseUser courseUser = new CourseUser();
        courseUser.setCourse(c);
        courseUser.setUser(u);
        courseUser.setStatus(0);
        if (courseUser != null) {
            courseUser.save();
        }
        flash("success", "You successfuly applied to " + c.getName());
        return redirect("/user/courses");
    }


    /**
     *  Check if active user have access to join specified course
     *  If method returns "1" then access is denied otherwise user have possibility to join to the course
     */
    public Result haveCourseAccess() {
        DynamicForm form = Form.form().bindFromRequest();
        Long courseId = Long.parseLong(form.data().get("courseId"));
        Course c = Course.findById(courseId);
        List<Course> courses = CourseUser.allUserCourses(SessionHelper.currentUser(ctx()));
        for(Course course: courses){
            if(course.getId() == c.getId()) {
                return ok("1");
            }
        }
        return ok("2");
    }

    public Result test() {
        return ok("you are student");
    }
}