package models.user;
import com.avaje.ebean.Model;
import models.CloudFile;
import models.Image;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.course.CourseUser;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import utility.MD5Hash;
import utility.UserConstants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by boris on 9/12/15.
 */
@Entity
@Table(name = "user")
public final class User extends Model {

    private static Finder<Long, User> finder = new Finder<>(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false)
    private Long id;
    @Column(name = "email", unique = true, updatable = false, length = 100)
    private String email;
    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "first_name", updatable = false, length = 100)
    private String firstName;
    @Column(name = "last_name", updatable = false, length = 100)
    private String lastName;
    @Column(name = "nick_name", length = 50)
    private String nickName;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "gender", length = 1)
    private Integer gender;
    @Column(name = "location", length = 150)
    private String location;
    @Column(name = "home_phone", length = 15)
    private String homePhone;
    @Column(name = "cell_phone", length = 15)
    private String cellPhone;
    @Column(name = "website")
    private String website;
    @Column(name = "skype")
    private String skype;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "twitter")
    private String twitter;
    @Column(name = "youtube")
    private String youtube;
    @OneToMany
    private List<Image> images;
    @Column(name = "status", length = 1)
    private Integer status = UserConstants.INACTIVE;
    @Column(name = "student_status", length = 1)
    private Integer studentStatus = 0;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime creationDate = new DateTime();
    @Column(name = "created_by", updatable = false, length = 50)
    private String createdBy;
    @Column(name = "homework_status", length = 1)
    private Integer homeworkStatus = 0;
    @Column(name = "weekly_status", length = 1)
    private Integer weeklyReportStatus = 0;
    @Column(name = "daily_status", length = 1)
    private Integer dailyReportStatus = 0;
    private Integer unreadMessage = 0;
    @Column(unique = true)
    public String token;
    @Column(name = "update_date", columnDefinition = "datetime")
    private DateTime updateDate;
    @Column(name = "updated_by", length = 50)
    private String updatedBy;
    @ManyToMany
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy="sender", cascade=CascadeType.ALL)
    private List<PrivateMessage> messages = new ArrayList<>();
    @OneToMany(cascade=CascadeType.ALL)
    private List<Assignment> assigments = new ArrayList<>();

    /**
     * Default empty constructor for Ebean
     */
    public User() {
    }

    /**
     * Consturctor used to create User by admin.
     *
     * @param email    <code>String</code> type value of email
     * @param password <code>String</code> type value of password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.images = new ArrayList<>();
    }

    /**
     * Returns all users from database as List.
     *
     * @return <code>List</code> type value of all users from database
     */
    public static List<User> findAll() {
        return finder.all();
    }

    /**
     * Returns User from database for inputed email and password.
     *
     * @param email    <code>String</code> type value of User email
     * @param password <code>String</code> type value of User password
     * @return <code>User</code> type object
     */
    public static User findByEmailAndPassword(String email, String password) {
        return finder.where().eq("email", email.toLowerCase()).eq("password", password).findUnique();
    }


    /**
     * Find user by specified nick
     * @param nick - String value of User nick
     * @return
     */
    public static User findByNick(String nick){
        return finder.where().eq("nickName", nick).findUnique();
    }

    /**
     * Returns User from database for inputed id
     *
     * @param id <code>Long</code> type value of User id
     * @return <code>User</code> type object
     */
    public static User findById(Long id) {
        return finder.byId(id);
    }

    /**
     * Returns User from database for inputed email
     *
     * @param email <code>String</code> type value
     * @return <code>User</code> type object
     */
    public static User findByEmail(String email) {
        return finder.where().eq("email", email).findUnique();
    }


    public static User findByName(String name){

        return finder.where().eq("firstName", name).findUnique();
    }



    /**
     * Returns finder on User model
     *
     * @return
     */
    public static Finder<Long, User> getFinder() {
        return finder;
    }


    /* ONLY GETTERS AND SETTERS FOR USER CLASS BELLOW */

    public Long getId() {
        return id;
    }

    public Integer getUnreadMessage() {
        return unreadMessage;
    }

    public void setUnreadMessage(Integer unreadMessage) {
        this.unreadMessage = unreadMessage;
    }

    public Integer getDailyReportStatus() {
        return dailyReportStatus;
    }

    public void setDailyReportStatus(Integer dailyReportStatus) {
        this.dailyReportStatus = dailyReportStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Image> getProfilePicture(){return images;}

    public void setProfilePicture(Image profilePicture) {
        this.images.add(profilePicture);
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getWeeklyReportStatus() {
        return weeklyReportStatus;
    }

    public void setWeeklyReportStatus(Integer weeklyReportStatus) {
        this.weeklyReportStatus = weeklyReportStatus;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getHomeworkStatus() {
        return homeworkStatus;
    }

    public void setHomeworkStatus(Integer homeworkStatus) {
        this.homeworkStatus = homeworkStatus;
    }


    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setUpdateDate(DateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public List<PrivateMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PrivateMessage> messages) {
        this.messages = messages;
    }

    public List<Assignment> getAssignments() {
        return assigments;
    }

    public void setCourseUsers(List<Assignment> assigments) {
        this.assigments = assigments;
    }

    public String getYearOfBirth() {
        if (birthDate != null) {
            return birthDate.split("\\.")[2];
        }
        return birthDate;
    }

    /**
     * MEthod for delete specified Uer
     * @param id - Long id of specified User
     * @return
     */
    public static boolean deleteUser(Long id) {

        List<Course> course = CourseUser.allUserCourses(User.findById(id));
        for ( int i = 0; i < course.size(); i++){

            course.get(i).delete();
        }
        finder.deleteById(id);
        return true;
    }


    public void setToken() {
        this.token = UUID.randomUUID().toString();
    }

    public String getToken() {
        return token;
    }

    public static User findUserByToken(String token){
        return finder.where().eq("token",token).findUnique();
    }

    public static User findEmailAndPassword(String email, String password) {
        User user = finder.where().eq("email",email).eq("password",password).findUnique();
        return user;
    }
}