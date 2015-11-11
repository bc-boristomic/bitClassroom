package models.course;

import com.avaje.ebean.Model;
import models.user.User;
import utility.UserConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NN on 17.9.2015.
 */

@Entity
@Table(name = "course_user")
public final class CourseUser extends Model {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false)
    private Long id;
    @Column(name="status", length = 1)
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
        return finder.where().eq("user_id", userId).findList();

    }

    /**
     * Find all courses which student attending
     * @param currentUser - user
     * @return List of Courses
     */
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
     * Find all users from specific course
     * @param id - Long course id
     * @return List of users
     */
    public static List<User> allUserFromCourse (Long id){

        List<User> courseUsers = new ArrayList<>();
        List<CourseUser> list = finder.all();

        for ( int i = 0; i < list.size(); i++){
            if( list.get(i).getCourse().getId() == id ){

                courseUsers.add(list.get(i).getUser());
            }
        }

        return courseUsers;
    }

    /**
     * Count student in a classs
     * @param id - Long
     * @return Integer number of students
     */

    public static Integer studentsInClass(Long id){

        Integer numberOFStudents = 0;
       List<User> users = allUserFromCourse(id);

        for( int i = 0; i < users.size(); i++){

            if( users.get(i).getRoles().get(0).getId().equals(UserConstants.STUDENT)){

                numberOFStudents++;
            }
        }

        return numberOFStudents;

    }

    /**
     * Find course user
     * @param u  - User
     * @param c  - Course
     * @return CourseUser
     */
    public static CourseUser findCourseUser(User u , Course c){
        return finder.where().eq("user_id", u.getId()).eq("course_id", c.getId()).findUnique();
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

    public static List<CourseUser> getCoursesPerUser(User u){
        List<CourseUser> courseUsers = finder.where().eq("user_id",u.getId()).eq("status",2).findList();
        return courseUsers;
    }

    public static boolean isAllowed(User user, Course course){

      if ( finder.where().eq("user_id", user.getId()).eq("course_id", course.getId()).findUnique() != null){

          return true;
      }

        return false;

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
