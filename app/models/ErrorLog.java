package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by boris.tomic on 09/09/15.
 */
@Entity
@Table(name="error_log")
public final class ErrorLog extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="message", length = 500)
    private String message;
    @Column(name="loged_date", columnDefinition = "datetime")
    private DateTime logedDate = new DateTime();

    static Finder<Long, ErrorLog> finder = new Finder<Long, ErrorLog>(ErrorLog.class);

    /**
     * Default constructor
     * @param message <code>String</code> type value
     */
    public ErrorLog(String message) {
        this.message = message;

    }

    /**
     * Finding error by id
     * @param id
     * @return error
     */
    public static ErrorLog findErrorById(Long id) {

        List<ErrorLog> error = finder.where().eq("id", id).findList();
        if (error.size() == 0) {
            return null;
        }
        return (ErrorLog) error.get(0);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
        return dtf.print(logedDate);
    }

    public static List<ErrorLog> findAllErrors() {
        return finder.orderBy("id desc").findList();
    }

    public static boolean deleteError(Long id){
        finder.deleteById(id);
        return true;
    }

    public String toString(){

        return "Error: " + message + " time:" + logedDate;
    }

}