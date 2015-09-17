package controllers.daily;

import com.avaje.ebean.Model;
import models.report.DailyReport;
import models.report.Field;
import models.report.ReportField;
import org.joda.time.DateTime;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dailyreports.tabledaily;

import views.html.dailyreports.dailyraport;

import java.util.*;

/**
 * Created by enver.memic on 07/09/15.
 */
public class DailyReportController extends Controller {
    private static Model.Finder<Long, DailyReport> finderDaily = new Model.Finder<>(DailyReport.class);

    public Result listReport() {

        List<Field> listFields = new ArrayList<>();
        List<ReportField> listReportField = new ArrayList<>();
        List<DailyReport> listDailyReport = new ArrayList<>();
        listFields = Field.getFinder().all();
        listReportField = ReportField.getFinder().all();
        listDailyReport = DailyReport.getFinder().all();

        return ok(tabledaily.render(listFields, listReportField, listDailyReport));
    }

    public Result setRaport() {
        return TODO;
    }

    public Result deleteRaport() {
        return TODO;
    }




}
