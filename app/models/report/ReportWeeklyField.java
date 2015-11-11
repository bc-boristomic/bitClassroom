package models.report;

import com.avaje.ebean.Model;
import javax.persistence.*;

/**
 * Created by enver.memic on 30/09/15.
 */

@Entity
@Table(name = "report_weekly_field")
public class ReportWeeklyField extends Model {

    private static Finder<Long, ReportWeeklyField> finderReportWeeklyField
            = new Finder<Long, ReportWeeklyField>(ReportWeeklyField.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "weekly_report", referencedColumnName = "id")
    private WeeklyReport weeklyReport;

    @ManyToOne
    @JoinColumn(name = "weekly_field", referencedColumnName = "id")
    private WeeklyField weeklyField;

    /**
     * Default empty constructor for Ebean
     */

    public ReportWeeklyField() {
    }

    /**
     * GETTERS AND SETTERS FOR REPORTWEEKLYFIELD CLASS BELLOW
     * */
    public static Finder<Long, ReportWeeklyField> getFinderReportWeeklyField() {
        return finderReportWeeklyField;
    }
    public Long getId() {
        return id;
    }
    public String getValue() {
        return value;
    }
    public WeeklyReport getWeeklyReport() {
        return weeklyReport;
    }
    public WeeklyField getWeeklyField() {
        return weeklyField;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setWeeklyReport(WeeklyReport weeklyReport) {
        this.weeklyReport = weeklyReport;
    }
    public void setWeeklyField(WeeklyField weeklyField) {
        this.weeklyField = weeklyField;
    }
}