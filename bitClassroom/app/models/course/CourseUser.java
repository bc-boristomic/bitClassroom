package models.course;

import com.avaje.ebean.Model;
import models.user.User;

import javax.persistence.*;

/**
 * Created by NN on 17.9.2015.
 */

@Entity
@Table(name = "course_user")
public class CourseUser extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false)
    private Long id;
    @Column
    private Integer status;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Course course;

    private static Finder<Long, CourseUser> finder = new Finder<>(CourseUser.class);

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public User getUser() {
        return user;
    }

    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static Finder<Long, CourseUser> getFinder() {
        return finder;
    }

    @Override
    public String toString() {
        return "CourseUser{" +
                "status=" + status +
                ", user=" + user +
                ", course=" + course +
                '}';
    }
}
