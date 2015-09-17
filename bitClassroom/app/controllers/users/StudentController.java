package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import models.course.Course;
import models.course.CourseUser;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Student.class)
public class StudentController extends Controller {

    public Result joinCourse() {
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());

        Course c = Course.findById(Long.valueOf(dynamicForm.get("course-id")));
        CourseUser courseUser = new CourseUser();
        courseUser.setCourse(c);
        courseUser.setUser(SessionHelper.currentUser(ctx()));
        courseUser.setStatus(0);

        if (courseUser != null) {
            courseUser.save();
        }
        flash("success", "You successfuly applied to " + c.getName());
        return redirect("/user/courses");
    }

    public Result test() {
        return ok("you are student");
    }
}