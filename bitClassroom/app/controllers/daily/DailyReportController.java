package controllers.daily;

import models.report.DailyReport;
import models.report.Field;
import models.report.ReportField;
import org.joda.time.DateTime;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.dailyreports.dailyraport;
import java.util.List;

/**
 * Created by enver.memic on 07/09/15.
 */
public class DailyReportController extends Controller {

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
        dailyReport.setName(dynamicForm.get("report_name"));
        dailyReport.setCreatedDate(new DateTime());
        dailyReport.save();

        for (Field field: fields){
            ReportField reportField = new ReportField();
            reportField.setDailyReport(dailyReport);

            String fieldId = String.valueOf(field.getId());

            if (dynamicForm.get(fieldId) == null)
                continue;

            reportField.setValue(fieldId);
            reportField.setField(field);
            reportField.save();
        }

        return ok();
    }

    public Result listRaport() {
        return TODO;
    }

    public Result setRaport() {
        return TODO;
    }

    public Result deleteRaport() {
        return TODO;
    }




}
