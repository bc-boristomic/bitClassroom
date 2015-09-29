package models.report;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enver on 9/12/15.
 */
@Entity
@Table(name = "daily_report")
public final class DailyReport extends Model {

    private static Finder<Long, DailyReport> finder = new Finder<>(DailyReport.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime createdDate = new DateTime();
    @Column(name = "data", length = 4000)
    private String data;
    @Column(name = "date")
    private String date;

    /*
     * Default empty constructor for Ebean
     */
    public DailyReport() {
    }

    public static Finder<Long, DailyReport> getFinder() {
        return finder;
    }

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getCreateDate() {DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.MM.yyyy");
        return dtf.print(createdDate); }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setDate(String date) { this.date = date;}



    public String getDate() {  return date;}



    @OneToMany(mappedBy = "dailyReport", cascade = CascadeType.ALL)
    private List<ReportField> fieldList = new ArrayList<>();
    //Enver sprint 4

    /** Metoda se poziva iz vieiw.admins.newTableDaily preko scale,
     * vraca true ukoliko pronadje isti field, ili false ukoliko ga ne pronadje*/

    public boolean containsField(Field field) {
        for (ReportField rf :fieldList) {
            if (rf.getField().equals(field)) {
                return true;
            }

        }

        return false;
    }

    //Enver sprint 4
    /** Metoda se poziva iz vieiw.admins.newTableDaily preko scale,
     * prima field koji je u boolean metodi containsField uporedjen sa fieldom iz tabele,
     * i ako su isti upisuje u njega value, ukoliko nisu ostavlja polje u tabeli prazno
     * */
    public ReportField getField(Field field) {
        for (ReportField rf : fieldList) {
            if (rf.getField().equals(field)) {
                return rf;
            }

        }

        return null;
    }


    public static DailyReport findDailyReportById(Long id) {

        List<DailyReport> report = finder.where().eq("id", id).findList();
        if (report.size() == 0) {
            return null;
        }
        return (DailyReport) report.get(0);
    }


    public String getFormattedCreationDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
        return dtf.print(createdDate);
    }


}