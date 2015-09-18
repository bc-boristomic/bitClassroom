package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
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
import views.html.dailyreports.dailyraport;
import views.html.index;

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
        List<Field> fields = Field.getFinder().findList();
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());

        DailyReport dailyReport = new DailyReport();
        dailyReport.setName(dynamicForm.get("title"));
        dailyReport.setCreatedDate(new DateTime());
        dailyReport.setData(dynamicForm.get("data"));

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
        List<Course> list = CourseUser.allUserCourses(u);
        CourseUser userc = CourseUser.findAll(u.getId()).get(0);

        return ok(index.render(u, list,userc));

    }


    public Result test() {
        return ok("you are teacher");
    }
}