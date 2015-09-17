package controllers.course;

import models.course.Course;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.courses.courseList;
import views.html.*;

/**
 * Created by Medina and Senadin on 16/09/15.
 */
public class CourseController extends Controller {

    public Result allCourses (){

        return ok(courseList.render(Course.findAll()));
    }


}
