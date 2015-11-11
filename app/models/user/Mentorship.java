package models.user;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import utility.UserConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 9/21/15.
 */
@Entity
public final class Mentorship extends Model {

    private static Finder<Long, Mentorship> finder = new Finder<>(Mentorship.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User mentor;
    @ManyToOne
    private User student;
    @Column(name = "status", length = 1)
    private Integer status;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime creationDate = new DateTime();
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @Column(name = "update_date", columnDefinition = "datetime")
    private DateTime updateDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "week")
    private Integer week = 1;
    @Column(name = "date_of_report")
    private DateTime reportDate;

    /**
     * Default empty constructor for Ebean
     */
    public Mentorship(){
    }

    public static Finder<Long, Mentorship> getFinder() {
        return finder;
    }

    /**
     * Method for find students mentor
     * @param u - Student
     * @return - Students mentor
     */
    public static User findMentorByUser(User u){
       Mentorship m = finder.where().eq("student_id", u.getId()).eq("status", UserConstants.ACTIVE_MENTORSHIP).findUnique();
        if(m == null){
            return null;
        }
        return m.getMentor();

    }

    /**
     * Method for find all mentors students
     * @param u - Specified mentor
     * @return - List of User
     */
    public static List<User> findStudentsByMentor(User u){
        List<User> students = new ArrayList<>();
        List<Mentorship> mentorships = finder.where().eq("mentor_id",u.getId()).findList();
        for(Mentorship mentorship : mentorships){
            if(mentorship.getMentor().getId() == u.getId()){
             students.add(mentorship.getStudent());
            }
        }
        return students;
    }

    /**
     * MEthod for find specified mentorship with selected student and mentor
     * @param user - Mentor
     * @param student - Student
     * @return - Mentorship Object
     */
    public static Mentorship findMentroship(User user, User student){

        return finder.where().eq("mentor", user).eq("student", student).findUnique();
    }


    /* ONLY GETTERS AND SETTERS FOR COURSE CLASS BELLOW */


    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public DateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(DateTime reportDate) {
        this.reportDate = reportDate;
    }

    public Long getId() {
        return id;
    }

    public User getMentor() {
        return mentor;
    }

    public User getStudent() {
        return student;
    }

    public Integer getStatus() {
        return status;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public DateTime getUpdateDate() {
        return updateDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdateDate(DateTime updateDate) {
        this.updateDate = updateDate;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
