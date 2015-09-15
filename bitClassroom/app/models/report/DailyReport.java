//package models.report;
//
//import com.avaje.ebean.Model;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//
//import javax.persistence.*;
//
///**
// * Created by enver on 9/12/15.
// */
//@Entity
//@Table(name = "daily_report")
//public final class DailyReport extends Model {
//
//    private static Finder<Long, DailyReport> finder = new Finder<>(DailyReport.class);
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
//    private DateTime createdDate = new DateTime();
//
//    @Column(name = "data")
//    private String data;    // TODO
//
//    /*
//     * Default empty constructor for Ebean
//     */
//    public DailyReport() {
//    }
//
//    public static Finder<Long, DailyReport> getFinder() {
//        return finder;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
//
//    public void setCreatedDate(DateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//
//    public String getFormattedCreationDate() {
//        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
//        return dtf.print(createdDate);
//    }
//}