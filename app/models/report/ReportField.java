package models.report;

import com.avaje.ebean.Model;
import javax.persistence.*;


/**
 * Created by enver on 9/12/15.
 */
@Entity
@Table(name = "report_field")
public final class ReportField extends Model {

    private static Finder<Long, ReportField> finder = new Finder<>(ReportField.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "daly_id", referencedColumnName = "id")
    private DailyReport dailyReport;
    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;

    /**
     * Default empty constructor for Ebean
     */
    public ReportField() {
    }

    /** GETTERS AND SETTERS FOR REPORTFIELD CLASS BELLOW */

    public static Finder<Long, ReportField> getFinder() {
        return finder;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DailyReport getDailyReport() {
        return dailyReport;
    }

    public void setDailyReport(DailyReport dailyReport) {
        this.dailyReport = dailyReport;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

}