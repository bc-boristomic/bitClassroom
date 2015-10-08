package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import models.Post;
import models.course.Course;
import models.course.CourseUser;
import models.report.DailyReport;
import models.report.Field;
import models.report.ReportField;
import models.user.User;
import org.joda.time.DateTime;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;
import views.html.dailyreports.dailyraport;
import views.html.index;
import views.html.posts.assignmentView;
import views.html.posts.teacherListsAssignment;
import views.html.users.studentsHomeworkStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Teacher.class)
public class TeacherController extends Controller {

    private static final Form<DailyReport> raportForm = Form.form(DailyReport.class);

    public Result dailyReport() {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.bindFromRequest(request());
        dynamicForm.get("1");

        List<Field> fields = Field.getFinder().findList();
        return ok(dailyraport.render(raportForm, fields));

    }

    public Result saveRaport() {
        User temp = SessionHelper.currentUser(ctx());

        List<Field> fields = Field.getFinder().findList();

        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());

        DailyReport dailyReport = new DailyReport();
        dailyReport.setName(dynamicForm.get("title"));
        dailyReport.setCreatedDate(new DateTime());
        dailyReport.setData(dynamicForm.get("data"));
        dailyReport.setDate(dynamicForm.get("date"));
        dailyReport.setTeacher(temp.getFirstName() + " " + temp.getLastName());

        dailyReport.save();

        for (Field field : fields) {
            ReportField reportField = new ReportField();
            reportField.setDailyReport(dailyReport);

            String fieldId = dynamicForm.get(String.valueOf(field.getId()));

            reportField.setValue(fieldId);
            reportField.setField(field);
            reportField.save();
        }
        User u = SessionHelper.currentUser(ctx());
       // List<Course> list = CourseUser.allUserCourses(u);
        //CourseUser userc = CourseUser.findAll(u.getId()).get(0);
        List<CourseUser> userc = CourseUser.getFinder().all();

        return ok(index.render(u, userc));

    }



    public Result test() {
        return ok("you are teacher");
    }

    public Result listAssignment() {
        User user = SessionHelper.currentUser(ctx());
        return ok(teacherListsAssignment.render(user.getPosts()));
    }


    public Result studentAssignmentStatus(Long id, String status){

        Logger.info(id + "");
        Post post = Post.findPostById(id);
        Course course = post.getCourse();
        Logger.info(course.getName());
        List<User> users = CourseUser.allUserFromCourse(course.getId());
        List<User> students = new ArrayList<>();

        if( status.equals("Done")) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && users.get(i).getHomeworkStatus() == 2 ) {

                    students.add(users.get(i));
                }
            }
        }else if(status.equals("Working")){
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && users.get(i).getHomeworkStatus() == 1) {

                    students.add(users.get(i));
                }
            }
        }
        if( status.equals("Not")) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && users.get(i).getHomeworkStatus() == null) {

                    students.add(users.get(i));
                }
            }
        }
        return ok(studentsHomeworkStatus.render(students, post));
    }
}