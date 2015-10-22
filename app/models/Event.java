package models;

import com.avaje.ebean.Expr;

import com.avaje.ebean.Model;
import models.course.Course;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by NN on 18.10.2015.
 */

@Entity
@Table(name="event_setup")
public class Event extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;


    @Constraints.Required
    @Column(name="title")
    private String title;

    @Column(name="is_all_day")
    private Boolean allDay;

    @Constraints.Required
    @Formats.DateTime(pattern = "dd.MM.yyyy HH:mm")
    @Column(name="start")
    private Date start = new Date();

    @Formats.DateTime(pattern = "dd.MM.yyyy HH:mm")
    @Column(name="end")
    private Date end = new Date();

    @ManyToOne
    private Course course;

    private Boolean endsSameDay;


    public static Finder<Long,Event> find = new Finder<>(Event.class);

    public Event(String title, Date start, Date end, Boolean allDay) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.allDay = allDay;

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getEndsSameDay() {
        return endsSameDay;
    }

    public void setEndsSameDay(Boolean endsSameDay) {
        this.endsSameDay = endsSameDay;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static List<Event> findInDateRange(Date start, Date end) {


        return find.where().or(
                Expr.and(
                        Expr.lt("start", start),
                        Expr.gt("end", end)
                ),
                Expr.or(
                        Expr.and(
                                Expr.gt("start", start),
                                Expr.lt("start", end)
                        ),
                        Expr.and(
                                Expr.gt("end", start),
                                Expr.lt("end", end)
                        )
                )
        ).findList();
    }



}
