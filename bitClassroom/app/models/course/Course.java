package models.course;

import com.avaje.ebean.Model;
import models.user.User;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import utility.UserConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Medina and Senadin on 15/09/15.
 */
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
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User teacher;
    @ManyToOne
    @JoinColumn(name = "mentor_id", referencedColumnName = "id")
    private User mentor;
    @Column(name = "image")
    private String image;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime creationDate = new DateTime();
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @Column(name = "update_date", columnDefinition = "datetime")
    private DateTime updateDate;
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * Empty constructor for Ebean
     */
    public Course() {
    }

    /**
     * Consturctor used to create Course by admin.
     *
     * @param name        <code>String</code> type value of name
     * @param description <code>String</code> type value of description
     * @param teacher     <code>String</code>   type value of teacher
     */
    public Course(String name, String description, User teacher, User mentor) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.mentor = mentor;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

}
