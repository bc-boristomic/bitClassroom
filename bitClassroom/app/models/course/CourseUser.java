package models.course;

import com.avaje.ebean.Model;
import helpers.SessionHelper;
import models.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name="status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    private Course course;

    private static Finder<Long, CourseUser> finder = new Finder<>(CourseUser.class);


    /**
     * Returns all coursesUser objects from database as List.
     *
     * @return <code>List</code> type value of all courses from database
     */
    public static List<CourseUser> findAll(Long userId) {
        List<CourseUser> list = finder.all();
        List<CourseUser> courseUserList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUser().getId().equals(userId)) {
                courseUserList.add(list.get(i));
            }
        }
        return courseUserList;
    }

    public static List<Course> allUserCourses(User currentUser) {
        List<Course> courseByUserList = new ArrayList<>();

        List<CourseUser> courseUserList = CourseUser.findAll(currentUser.getId());

        if (courseUserList == null) {
            courseUserList = new ArrayList<>();
        } else {
            for (int i = 0; i < courseUserList.size(); i++) {
                courseByUserList.add(courseUserList.get(i).getCourse());
            }
        }
        return courseByUserList;
    }




    /**
     * Find all course_user
     * @return List
     */
    public static List<CourseUser> all() {

        return finder.all();
    }


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
