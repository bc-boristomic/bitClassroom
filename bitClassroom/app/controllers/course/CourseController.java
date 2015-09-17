package controllers.course;

import helpers.SessionHelper;
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



}
