package controllers.course;

import models.course.Course;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.fillClassDetails;

/**
 * Created by Medina and Senadin on 16/09/15.
 */
public class CourseController extends Controller {

    private final Form<Course> courseForm = Form.form(Course.class);

    public Result addCourse() {
        return ok(fillClassDetails.render(courseForm));
    }

    public Result saveCourse() {
        Form<Course> boundForm = courseForm.bindFromRequest();

        String name = boundForm.bindFromRequest().field("name").value();
        String description = boundForm.bindFromRequest().field("description").value();
        String teacher = boundForm.bindFromRequest().field("teacher").value();

        Course course = new Course(name, description, teacher);
        course.save();
        flash("success", "You successfully added new course.");
        return redirect("/index"); // TODO add call to route for listing posts


    }
}
