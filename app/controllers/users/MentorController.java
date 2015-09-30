package controllers.users;

import helpers.Authorization;

import helpers.SessionHelper;
import models.course.CourseUser;
import models.report.Field;
import models.user.User;
import models.report.WeeklyReport;

import org.joda.time.DateTime;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dailyreports.weeklyreport;
import views.html.index;


import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Mentor.class)
public class MentorController extends Controller {

    private static final Form<WeeklyReport> reportForm = Form.form(WeeklyReport.class);

    public Result weeklyReport() {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.bindFromRequest(request());
        dynamicForm.get("1");

        List<Field> fields = Field.getFinder().findList();
        return ok(weeklyreport.render(reportForm));

    }

    public Result saveRaport() {

//        List<Field> fields = Field.getFinder().findList();
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());

        WeeklyReport weeklyReport = new WeeklyReport();

        weeklyReport.setCreateDate(new DateTime());
        weeklyReport.setDate(dynamicForm.get("date"));
        weeklyReport.setName(dynamicForm.get("title"));
        weeklyReport.setStudent(dynamicForm.get("student"));
        weeklyReport.setData(dynamicForm.get("data"));
        weeklyReport.save();

//        for (Field field : fields) {
//            ReportField reportField = new ReportField();
//            reportField.setDailyReport(weeklyReport);
//
//            String fieldId = dynamicForm.get(String.valueOf(field.getId()));
//
//            reportField.setValue(fieldId);
//            reportField.setField(field);
//            reportField.save();
//        }
        User u = SessionHelper.currentUser(ctx());
        // List<Course> list = CourseUser.allUserCourses(u);
        //CourseUser userc = CourseUser.findAll(u.getId()).get(0);
        List<CourseUser> userc = CourseUser.getFinder().all();

        return ok(index.render(u, userc));

    }

    public Result test() {
        return ok("you are mentor");
    }

}