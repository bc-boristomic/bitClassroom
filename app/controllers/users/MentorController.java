package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import models.course.CourseUser;
import models.report.ReportWeeklyField;
import models.report.WeeklyField;
import models.user.Mentorship;
import models.user.User;
import models.report.WeeklyReport;
import org.joda.time.DateTime;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;
import views.html.dailyreports.weeklyreport;
import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Mentor.class)
public class MentorController extends Controller {

    private static final Form<WeeklyReport> reportForm = Form.form(WeeklyReport.class);

    /**
     *Renders view for mentor to write Weekly Report
     * @return ok and renders weeklyreport
     */
    public Result weeklyReport() {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.bindFromRequest(request());
        dynamicForm.get("1");

        List<WeeklyField> weeklyFields = WeeklyField.getFinder().findList();
        List<Mentorship> mentorship = Mentorship.getFinder().where().eq("mentor_id", SessionHelper.currentUser(ctx()).getId()).eq("status", UserConstants.ACTIVE_MENTORSHIP).findList();
        return ok(weeklyreport.render(reportForm, weeklyFields, mentorship));

    }

    /**
     *Takes values via dynamic form from html and creates new weekly report then saves to data base
     * @return redirect home
     */
    public Result saveRaport() {

        User temp = SessionHelper.currentUser(ctx());
        temp.setWeeklyReportStatus(2);
        temp.save();
        List<WeeklyField> fields = WeeklyField.getFinder().findList();
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());

        WeeklyReport weeklyReport = new WeeklyReport();

        weeklyReport.setMentor(temp.getFirstName() + " " + temp.getLastName());
        weeklyReport.setCreateDate(new DateTime());
        weeklyReport.setDate(dynamicForm.get("date"));
        weeklyReport.setName(dynamicForm.get("title"));
        weeklyReport.setStudent(dynamicForm.get("student"));
        weeklyReport.setData(dynamicForm.get("data"));
        User student = User.findByName(dynamicForm.get("student").substring(0,dynamicForm.get("student").indexOf(" ")));
        Mentorship mentorship =  Mentorship.findMentroship(temp, student);
        Logger.info(mentorship.getId()+"");
        Long tmpWeek = mentorship.getReportDate().getMillis()/1000;
        Long time = DateTime.now().getMillis()/1000;
        Long status = time - tmpWeek;

        Integer week = mentorship.getWeek();
        Logger.info(week + "");

        if(status > 604800) {
            week += 1;
            weeklyReport.setWeek(week);
            mentorship.setWeek(week);
            mentorship.setReportDate(DateTime.now());
            Logger.info(mentorship.getId() + "");
            mentorship.update();

        }else{
            weeklyReport.setWeek(week);
        }
        weeklyReport.save();

        for (WeeklyField field : fields) {
            ReportWeeklyField reportField = new ReportWeeklyField();
            reportField.setWeeklyReport(weeklyReport);
            String fieldId = dynamicForm.get(String.valueOf(field.getId()));
            reportField.setValue(fieldId);
            reportField.setWeeklyField(field);
            reportField.save();
        }

        User u = SessionHelper.currentUser(ctx());
        List<CourseUser> userc = CourseUser.getFinder().all();

        flash("success", "Your report has been sent");
        return redirect("/");
    }

}