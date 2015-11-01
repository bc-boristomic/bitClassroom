package models.course;

import com.avaje.ebean.Model;
import models.Event;
import models.Image;
import models.Post;
import models.user.User;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import utility.CourseConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public final class Course extends Model {

    private static Finder<Long, Course> finder = new Finder<>(Course.class);


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description", length = 2000)
    private String description;
    @Column(name = "teacher", length = 50)
    private String teacher;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime creationDate = new DateTime();
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @Column(name = "update_date", columnDefinition = "datetime")
    private DateTime updateDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "status")
    private Integer status = CourseConstants.ACTIVE_COURSE;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();
    @OneToOne
    private Image image;
    @Column (name = "date_of_report")
    private DateTime reportDate;
    @Column (name = "week")
    private Integer week = 1;

    /**
     * Empty constructor for Ebean
     */
    public Course() {
    }

    /**
     * Constructor used to create Course by admin.
     *
     * @param name        <code>String</code> type value of name
     * @param description <code>String</code> type value of description
     * @param teacher     <code>String</code>   type value of teacher
     */
    public Course(String name, String description, String teacher) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    /**
     * Returns all courses from database as List.
     *
     * @return <code>List</code> type value of all courses from database
     */
    public static List<Course> findAll() {
        return finder.all();
    }

    /**
     * Returns Course from database for inputted id
     *
     * @param id <code>Long</code> type value of Course id
     * @return <code>Course</code> type object
     */
    public static Course findById(Long id) {

        return finder.byId(id);
    }

    /**
     * Returns true when Course with the given id is deleted
     */
    public static boolean delete(Long id) {
        finder.deleteById(id);

        return true;
    }


    /**
     * Returns finder on Course model
     *
     * @return
     */
    public static Finder<Long, Course> getFinder() {
        return finder;
    }


    /**
     * Overrided toString method returns Course name, descripton and teacher.
     *
     * @return <code>String</code> type value of Course information
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append(" ");
        sb.append("Description").append(description).append(" ");
        sb.append("Teacher ").append(teacher).append(" ");

        return sb.toString();

    }


    /* ONLY GETTERS AND SETTERS FOR COURSE CLASS BELLOW */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public DateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(DateTime reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getFormattedCreationDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
        return dtf.print(creationDate);
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getFormattedUpdateDate() {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm (dd.MM.yyyy)");
        return dtf.print(updateDate);
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdateDate(DateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Post> getPosts() {
        List<Post> newPosts = new ArrayList<>();
        for(int i = posts.size()-1; i >= 0; i--){
            newPosts.add(posts.get(i));
        }
        return newPosts;
    }

    public List<Event> getEvents() {
        return events;
    }

    public static List<Course> findAllCoursesPerUser(User user){
        List<Course> courses = new ArrayList<>();
        List<CourseUser> courseUsers = CourseUser.getCoursesPerUser(user);
        for(CourseUser courseUser: courseUsers){
            courses.add(courseUser.getCourse());
        }
        return courses;
    }
}
