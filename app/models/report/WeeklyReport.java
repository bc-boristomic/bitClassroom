package models.report;



import com.avaje.ebean.Model;
import com.avaje.ebean.Model.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enver.memic on 30/09/15.
 */
@Entity
@Table(name = "weekly_report")

public class WeeklyReport extends Model{

    private static Finder<Long, WeeklyReport> weeklyFinder = new Finder<>(WeeklyReport.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime createDate = new DateTime();

    @Column(name = "date")
    private String date;

    @Column(name = "name")
    private String name;

    @Column(name = "student")
    private String student;

    @Column(name = "data")
    private String data;

    //Constructior
    public WeeklyReport() {

    }

    public static Finder<Long, WeeklyReport> getFinder() {
        return weeklyFinder;
    }

    //Getter
    public static Finder<Long, WeeklyReport> getWeeklyFinder() {
        return weeklyFinder;
    }

    //Setter
    public static void setWeeklyFinder(Finder<Long, WeeklyReport> weeklyFinder) {
        WeeklyReport.weeklyFinder = weeklyFinder;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getCreateDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.MM.yyyy");
        return dtf.print(createDate); }
    public String getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public String getStudent() {
        return student;
    }
    public String getData() {
        return data;
    }
    public void setId(Long id) {
        this.id = id;
    }


    //Setters
    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudent(String student) {
        this.student = student;
    }
    public void setData(String data) {
        this.data = data;
    }


//    @OneToMany(mappedBy = "weeklyReport", cascade = CascadeType.ALL)
//    private List<WeeklyField> fieldList = new ArrayList<>();

}
