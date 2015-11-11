package models.report;

import com.avaje.ebean.Model;
import models.course.Course;
import models.user.User;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.Logger;

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

    @Column(name = "teacher")
    @ManyToOne
    private User teacher;

    @Column(name = "course")
    @ManyToOne
    private Course course;

    @Column(name = "week")
    private Integer week = 1;

    /**
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

    public String getCreateDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.MM.yyyy - HH:mm");
        return dtf.print(createdDate);
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public User getTeacher() {
        return teacher;
    }

    public String getDate() {
        return date;
    }

    @OneToMany(mappedBy = "dailyReport", cascade = CascadeType.ALL)
    private List<ReportField> fieldList = new ArrayList<>();

    /**
     * Checks if Field already exists in database.
     *
     * @param field Field
     * @return Boolean true if exist, false if not.
     */
    public boolean containsField(Field field) {
        for (ReportField rf : fieldList) {
            if (rf.getField().equals(field)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns Report Field if Report Field name is same as field.
     *
     * @param field Field
     * @return Report Field
     */
    public ReportField getField(Field field) {
        for (ReportField rf : fieldList) {
            if (rf.getField().equals(field)) {
                return rf;
            }
        }
        return null;
    }

    /**
     * Returns Daily Report for given dailyReportId
     *
     * @param id Long
     * @return Daily Report
     */
    public static DailyReport findDailyReportById(Long id) {
        return finder.where().eq("id", id).findUnique();
    }

    /**
     * Formats date.
     *
     * @return String.
     */
    public String getFormattedCreationDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
        return dtf.print(createdDate);
    }

    /**
     * Formats date
     *
     * @param date String
     * @return String
     */
    public static String formaterDate(String date) {
        Logger.info(date);
        if (date.contains("-")) {
            String[] parts = date.split("-");
            String year = parts[0];
            String month = parts[1];
            String day = parts[2];
            return day + "." + month + "." + year;
        } else if (date.contains("/")) {
            String[] parts = date.split("/");
            String year = parts[0];
            String month = parts[1];
            String day = parts[2];
            return day + "." + month + "." + year;
        }
        return date;
    }

    /**
     * Finds previous Report from all reports.
     *
     * @param id Long
     * @return Daily Report
     */
    public static DailyReport previousReport(Long id) {
        List<DailyReport> reports = getFinder().where().lt("id", id).orderBy("id Desc").findList();
        if (reports.size() > 0) {
            return reports.get(0);
        }
        return null;
    }

    /**
     * Finds next Report from all reports.
     *
     * @param id Long
     * @return Daily Report
     */
    public static DailyReport nextReport(Long id) {
        List<DailyReport> reports = getFinder().where().gt("id", id).orderBy("id asc").findList();
        if (reports.size() > 0) {
            return reports.get(0);
        }
        return null;
    }
}