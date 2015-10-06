package controllers.users;

import com.avaje.ebean.Ebean;
import helpers.Authorization;
import helpers.SessionHelper;
import models.ErrorLog;
import models.PrivateMessage;
import models.course.Course;
import models.course.CourseUser;
import models.report.*;
import models.user.Mentorship;
import models.user.Role;
import models.user.User;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import utility.CourseConstants;
import utility.MD5Hash;
import utility.UserConstants;
import utility.database.Roles;
import views.html.admins.adduser;
import views.html.admins.inactMentors;
import views.html.admins.setingsweeklyreport;
import views.html.admins.newTableWeekly;

import javax.persistence.PersistenceException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Admin.class)
public class AdminController extends Controller {

    private final Form<User> userForm = Form.form(User.class);

    private final Form<Field> fieldForm = Form.form(Field.class);

    private final Form<CourseUser> courseUserForm = Form.form(CourseUser.class);
    private final Form<Course> courseForm = Form.form(Course.class);
    private List<String> imageList = new ArrayList<>();

    /**
     * Admin index page.
     *
     * @return
     */
    public Result index() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(views.html.admins.adminindex.render(temp));
    }

    /**
     * Renders page with user information for registration.
     * TODO roles as checkboxes
     *
     * @return
     */
    public Result addNewUser() {
        return ok(adduser.render(userForm));
    }

    public Result listOfUser() {
        return ok(views.html.admins.userlist.render(User.findAll()));
    }


    /**
     * Method for set users new type of role.
     * @param id - Long user id, used for find selected User
     */
    public Result editUserRole(Long id){
        User user = User.findById(id);
        return ok(views.html.admins.editUserRole.render(userForm, user));
    }

    /**
     * Registers new user to the site.
     *
     * @return
     */
    public Result saveNewUser(String type) {
        Form<User> boundForm = userForm.bindFromRequest();

        String email = "";
        String passwordHashed = "";
        User u = null;

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("register");
        }

        String fname = boundForm.field("firstname").value();
        String lname = boundForm.field("lastname").value();
        if (type.equals("save")) {
            email = boundForm.field("email").value();
            String password = boundForm.field("password").value();
            passwordHashed = MD5Hash.getEncriptedPasswordMD5(password);
        }
        String admin = boundForm.field("admin").value();
        String teacher = boundForm.field("teacher").value();
        String mentor = boundForm.field("mentor").value();
        String student = boundForm.field("student").value();
        String tmpRole = boundForm.field("type").value();

            List<Role> roles = new ArrayList<>();
            Long role = null;
            if (tmpRole != null) {
                if ("1".equals(tmpRole)) {
                    role = 1L;
                    Role r = new Role(role, UserConstants.NAME_ADMIN);
                    roles.add(r);
                } else if ("2".equals(tmpRole)) {
                    role = 2L;
                    Role r = new Role(role, UserConstants.NAME_TEACHER);
                    roles.add(r);
                } else if ("3".equals(tmpRole)) {
                    role = 3L;
                    Role r = new Role(role, UserConstants.NAME_MENTOR);
                    roles.add(r);
                } else if ("4".equals(tmpRole)) {
                    role = 4L;
                    Role r = new Role(role, UserConstants.NAME_STUDENT);
                    roles.add(r);
                    if(type.equals("save")) {
                        u = new User();
                        u.setStudentStatus(UserConstants.DONT_HAVE_MENTOR);
                    }else {
                        u = User.findByNick(type);
                        u.setStudentStatus(UserConstants.DONT_HAVE_MENTOR);
                    }
                } else if ("5".equals(tmpRole)) {
                    roles.add(Roles.ADMIN);
                    roles.add(Roles.TEACHER);
                }
                try {
                    //role = Long.parseLong(tmpRole);
                } catch (NumberFormatException e) {
                    Ebean.save(new ErrorLog(e.getMessage()));
                }
            }

        if(type.equals("save")){
            u = new User();
            u.setFirstName(fname);
            u.setLastName(lname);
            u.setEmail(email);
            u.setPassword(passwordHashed);
            u.setRoles(roles);
            u.setCreationDate(new DateTime());
            u.setCreatedBy(SessionHelper.currentUser(ctx()).getFirstName());

            if (u != null) {
                try {
                    u.save();
                } catch (PersistenceException e) {
                    Ebean.save(new ErrorLog(e.getMessage()));
                    flash("warning", "Something went wrong, user could not be saved to database.");
                    return redirect("/admin");
                }

                flash("success", String.format("User %s successfully added to database", u.getFirstName()));
                return redirect("/admin/adduser");
            }
            flash("warning", "Something went wrong, user could not be saved to database.");
            Ebean.save(new ErrorLog("Could not save user: " + u.getEmail()));
            return redirect("/admin");
        }else{

            User tmp = User.findByNick(type);
            tmp.setNickName(fname);
            tmp.setRoles(roles);
            if (tmp != null) {
                try {
                    tmp.save();
                } catch (PersistenceException e) {
                    Ebean.save(new ErrorLog(e.getMessage()));
                    flash("warning", "Something went wrong, user could not be saved to database.");
                    return redirect("/admin");
                }

                flash("success", String.format("User %s is successfully edit", tmp.getFirstName()));
                return redirect("/admin/allusers");
            }
            flash("warning", "Something went wrong, user could not be saved to database.");
            Ebean.save(new ErrorLog("Could not save user: " + u.getEmail()));
            return redirect("/admin");

        }
    }

    /**
     * Lists all errors caught in the code with exception getMessage message,
     * or custom message, And time of occurence.
     *
     * @return
     */
    public Result seeErrors() {
        return ok(views.html.admins.allerrors.render(ErrorLog.findAllErrors()));
    }


    public Result test() {
        return ok("you are admin");
    }

    /**
     * Deletes user from database. When trashcan icon is pressed users id is send.
     * Id is taken as parameter in method and used to find user and delete it.
     *
     * @param id <code>Long</code> type value of User id
     * @return if user is deleted redirects to list of all users, othervise a bad request is sent
     */
    public Result deleteUser(Long id) {
        if (User.deleteUser(id))
            return redirect("/admin/allusers");
        else
            return badRequest("Can't delete last admin");
    }

    /**
     * Deletes error when trashcan icon is pressed. Id of error is send to this method
     * ErrorLog is found by id and then deleted.
     *
     * @param id <code>Long</code> type value of ErrorLog id
     * @return redirects to list of errors
     */
    public Result deleteError(Long id) {
        ErrorLog.findErrorById(id).delete();
        return redirect("/admin/errors");
    }

    /**
     * Deletes daily report from database. When delete button is pressed daily
     * report id is sent to this method. Daily report is then found and specific
     * report is deleted from database.
     *
     * @param id <code>Long</code> type value of DailyReport id
     * @return redirect to list of daily reports
     */
    public Result deleteReport(Long id) {
        DailyReport.findDailyReportById(id).delete();
        return redirect("/listReport");
    }

    /**
     * Renders single field and button for admin so he/she can create additional
     * fields for daily report. On the right side a live preview of current daily report is displayed.
     *
     * @return
     */
    public Result genField() {
        return ok(views.html.admins.setingsdailyraport.render(Field.getFinder().all()));
    }

    /**
     * Saves a field that admin has created to database. Field is later used so teacher
     * can write daily report.
     *
     * @return redirects to page for creating additional field
     */
    public Result saveField() {
        Form<Field> fieldModelForm = Form.form(Field.class);
        Field model = new Field();
        String name = fieldModelForm.bindFromRequest().field("scriptName").value();
        String name1 = AdminController.firstUpperCase(name);
        model.setName(name1);
        try {
            model.save();
        }catch (PersistenceException e){
            flash("warning", "Name field already exist");
            return redirect("/admin/createdaily");
        }
        flash("success", "You added another field.");
        return redirect("/admin/createdaily");

    }

    /**
     * Renders page for admin so he/she can create new course. Page have field for course name,
     * description, selection of teacher and option to upload course image.
     *
     * @return
     */
    public Result addCourse() {
        return ok(views.html.admins.fillClassDetails.render(User.getFinder().all(), courseForm));
    }

    /**
     * Saves course to database.
     *
     * @return
     */
    public Result saveCourse() {
        Form<Course> boundForm = courseForm.bindFromRequest();


        String name = boundForm.field("name").value();
        String description = boundForm.field("description").value();
        String getTeacher = boundForm.field("type").value();
        String teacher = getTeacher.split(" ")[0] + " " + getTeacher.split(" ")[1];
        
        String teacherId = getTeacher.split(" ")[2];


        Course course = new Course(name, description, teacher);
        course.setCreatedBy(SessionHelper.currentUser(ctx()).getFirstName());
        course.setUpdateDate(new DateTime());

        Http.MultipartFormData data = request().body().asMultipartFormData();
        List<Http.MultipartFormData.FilePart> pictures = data.getFiles();

        if (pictures != null) {
            String picName = null;
            for (Http.MultipartFormData.FilePart picture : pictures) {
                picName = picture.getFilename();
                File file = picture.getFile();

                try {
                    FileUtils.moveFile(file, new File(Play.application().path() + "/public/images/courses/" + course.getName() + "/" + picName));
                    imageList.add(picName);
                } catch (IOException e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
            if (picName != null) {
                course.setImage(course.getName() + "/" + picName);
            }
        }

        try {
            course.save();
        } catch (PersistenceException e) {
            Ebean.save(new ErrorLog(e.getMessage()));
            flash("warning", "Something went wrong, course could not be saved to data base");
            return redirect("/admin/createcourse");
        }

        CourseUser cu = new CourseUser();
        cu.setCourse(course);
        cu.setStatus(User.findById(Long.parseLong(teacherId)).getStatus());
        cu.setUser(User.findById(Long.parseLong(teacherId)));

        try {
            cu.save();
        } catch (PersistenceException e) {
            Ebean.save(new ErrorLog(e.getMessage()));
            flash("warning", "Something went wrong, course teacher could not be saved to data base");
            return redirect("/admin/createcourse");
        }

        flash("success", "You successfully added new course.");
        return redirect("/admin/createcourse");
    }

    /**
     * Based on option pressed eg. approve or dissaprove, option value is send along with
     * CourseUser id. CourseUser is found by id passed to this method, status is set and ok
     * is send so page can be refreshed. Ajax is used in approveuser view.
     *
     * @param id <code>Long</code> type value of CourseUser id
     * @return empty ok
     */
    public Result approveStudent(Long id) {
        DynamicForm form = Form.form().bindFromRequest();

        String s = form.data().get("pressed");
        CourseUser cu = CourseUser.getFinder().byId(id);
        if (s != null) {
            cu.setStatus(Integer.parseInt(s));
            cu.save();
        }
        return ok("");
    }

    /**
     * List of students that applied for courses. Course name, student name and
     * approve, dissaprove buttons are displayed in a row.
     *
     * @return
     */
    public Result awaitList() {
        return ok(views.html.admins.approveuser.render(CourseUser.getFinder().all()));
    }

    /**
     * See tables of daily reports
     *
     * @return
     */
    public Result listReport() {
        return ok(views.html.admins.newTableDaily.render(ReportField.getFinder().all(), DailyReport.getFinder().all(), Field.getFinder().all()));
    }


    /**
     * Renders page with two dropdown menus. One is for mentors and other is for
     * students that don't have mentor. User selects mentor on left side and student
     * on right side. Once buttom assign is pressed selected mentor is assigned to slected student.
     *
     * @return
     */
    public Result mentorship() {
        return ok(views.html.admins.mentorship.render(User.getFinder().orderBy().asc("first_name").findList(), User.getFinder().where().eq("student_status", UserConstants.DONT_HAVE_MENTOR).findRowCount()));
    }

    /**
     * Get's user inputed selection via DynamicForm, gets mentor.id value from mentor
     * selection in <code>String</code> type men variable and student.id value from
     * student selection in <code>String</code> type stu variable.
     * <p>
     * After that string is parsed into Long since id is Long value.
     * If everything goes well user mentor is found by mentor.id, and student by student.id.
     * <p>
     * Student's studentStatus is set to HAVE_MENTOR and student is updated.
     * Mentorship is created and status is set to ACTIVE.
     *
     * @return
     */
    public Result saveMentorship() {
        DynamicForm form = Form.form().bindFromRequest();
        String men = form.get("mentor");
        String stu = form.get("student");
        Long ment = null;
        Long stud = null;
        if (men != null && stu != null) {
            try {
                ment = Long.parseLong(men);
                stud = Long.parseLong(stu);
            } catch (NumberFormatException e) {
                Ebean.save(new ErrorLog("Could not parse users Id: " + e.getMessage()));
                flash("warning", "Something went wrong, could not assign mentor to student.");
                return redirect("/admin/mentorship");
            }
        }
        User mentor = User.findById(ment);
        User student = User.findById(stud);
        student.setStudentStatus(UserConstants.HAVE_MENTOR);
        student.update();

        Mentorship mentorship = new Mentorship();
        mentorship.setMentor(mentor);
        mentorship.setStudent(student);
        mentorship.setCreatedBy(SessionHelper.currentUser(ctx()).getEmail());
        mentorship.setStatus(UserConstants.ACTIVE_MENTORSHIP);
        mentorship.save();

        flash("success", String.format("Successfully assigned %s to %s.", mentor.getFirstName(), student.getFirstName()));
        return redirect("/admin/mentorship");
    }

    /**
     * Renders table with information about current mentorship status.
     *
     * @return
     */
    public Result seeMentorsAndStudents() {
        return ok(views.html.admins.mentorshipList.render(Mentorship.getFinder().where().eq("status", UserConstants.ACTIVE_MENTORSHIP).findList()));
    }


    /**
     * Method for get list of inactive mentors
     */
    public Result inactiveMentors(){

        List<PrivateMessage>  message = PrivateMessage.findAllMessage();
        List<User> inactiveMentors = new ArrayList<>();
        for( int i = 0; i < message.size(); i++){
            if(message.get(i).getStatus() == 0 && message.get(i).getReceiver().getRoles().get(0).getName().equals(UserConstants.NAME_MENTOR)){
                inactiveMentors.add(message.get(i).getReceiver());
            }
        }
        return ok(inactMentors.render(inactiveMentors));
    }

    /**
     * When trashcan icon is pressed, Mentorship id is sent to method. Mentorship is
     * found by id and status is set as expired. Also student is found from mentorship proces
     * and his/hers status is set as dont have mentor.
     *
     * @param id <code>Long</code> type value of Mentorship
     * @return redirects to list of currently active mentorship process
     */
    public Result deleteMentorship(Long id) {
        Mentorship men = Mentorship.getFinder().byId(id);
        men.setStatus(UserConstants.EXPIRED_MENTORSHIP);
        men.setUpdateDate(new DateTime());
        men.setUpdatedBy(SessionHelper.currentUser(ctx()).getEmail());
        men.update();

        men.getStudent().setStudentStatus(UserConstants.DONT_HAVE_MENTOR);
        men.getStudent().update();
        flash("success", String.format("Successfully removed %s to %s mentorship relationship.", men.getMentor().getFirstName(), men.getStudent().getFirstName()));
        return redirect("/admin/activementors");
    }

    /**
     * Renders view with table filled with all active courses and option to archive or delete course.
     *
     * @return
     */
    public Result courseList() {
        return ok(views.html.admins.coursesAll.render(Course.getFinder().where().eq("status", CourseConstants.ACTIVE_COURSE).findList()));
    }

    /**
     * Process ajax request, if pressed option 0 is passed course is automatically set as archived,
     * if option 2 is sent course is deleted. Course is found by id passed in method params.
     *
     * @param id <code>Long</code> type value of Course id
     * @return
     */
    public Result deleteOrArchiveCourse(Long id) {
        DynamicForm form = Form.form().bindFromRequest();
        Course course = Course.getFinder().byId(id);
        String s = form.data().get("pressed");
        if( Integer.parseInt(s) == 2){
            List<User> users = CourseUser.allUserFromCourse(id);
            for (int i = 0; i < users.size(); i++){
                sendAutoMessage(users.get(i).getId(), course);
            }

        }

        if (s != null) {
            course.setStatus(Integer.parseInt(s));
            course.setUpdateDate(new DateTime());
            course.setUpdatedBy(SessionHelper.currentUser(ctx()).getEmail());
            course.save();


        }
        return ok();
    }


    /**
     * Method for auto send message to User when course is deleted
     * @param id - User id.
     * @return
     */
    public Result sendAutoMessage(Long id, Course course) {

        User sender = SessionHelper.currentUser(ctx());
        User receiver = User.findById(id);
        String subject = "Information";
        String content = "Course " + course.getName()  + " is deleted by admin " + sender.getFirstName() +" " + sender.getLastName() +".";

        PrivateMessage privMessage = PrivateMessage.create(subject, content, sender, receiver);
        privMessage.setStatus(0);
        receiver.getMessages().add(privMessage);
        receiver.save();

        return redirect("admin/allusers");
    }

    /**
     * Renders view with table filled with all archived courses. Course name, description and email of user who
     * archived it is displayed,
     *
     * @return
     */
    public Result archivedCourses() {
        return ok(views.html.admins.coursesArchived.render(Course.getFinder().where().eq("status", CourseConstants.ARCHIVED_COURSE).findList()));
    }

    /**
     * Recieves <code>Long</code> type value of Course id, find's the course and set's
     * status to active, find's course in relational table and only deletes all Users (set's them to null).
     *
     * @param id <code>Long</code> type value of Course id
     * @return
     */
    public Result activateCourse(Long id) {
        Course course = Course.getFinder().byId(id);
        course.setStatus(CourseConstants.ACTIVE_COURSE);
        course.setUpdateDate(new DateTime());
        course.setUpdatedBy(SessionHelper.currentUser(ctx()).getEmail());
        course.update();

        List<CourseUser> cu = CourseUser.getFinder().where().eq("course_id", id).findList();
        for (CourseUser courseUser : cu) {
            courseUser.setUser(null);
            courseUser.update();
        }
        return ok();
    }

    public Result deleteWeeklyReport(Long id) {
        WeeklyReport.findWeeklyReportById(id).delete();
        return redirect("/listWeeklyReport");
    }

    public Result deleteField(Long id) {
        Field.findFieldById(id).delete();
        return redirect("/admin/createdaily");
    }

    public Result deleteWeeklyField(Long id) {
        WeeklyField.findFielWeeklydById(id).delete();
        return redirect("/admin/createweekly");
    }

    public Result genWeeklyField() {
        return ok(setingsweeklyreport.render(WeeklyField.getFinder().all()));
    }

    public Result saveWeeklyField() {
        Form<WeeklyField> fieldWeeklyForm = Form.form(WeeklyField.class);
        WeeklyField wf = new WeeklyField();
        String n = fieldWeeklyForm.bindFromRequest().field("scriptWeeklyName").value();
        String nameWF = AdminController.firstUpperCase(n);
        wf.setName(nameWF);
        try {
            wf.save();
        }catch (PersistenceException e){
            flash("warning", "Name field already exist");
        }
        return redirect("/admin/createweekly");
    }

    public static String firstUpperCase(String name) {
        String s = name.substring(0, 1);
        String s1 = s.toUpperCase();
        String s2 = name.substring(1, name.length());
        String name1 = s1 + s2;
        return name1;
    }

    /**
     * See tables of weekly reports
     *
     * @return
     */
    public Result listWeeklyReport() {
        return ok(newTableWeekly.render(ReportWeeklyField.getFinderReportWeeklyField().all(), WeeklyReport.getFinder().all(), WeeklyField.getFinder().all()));
    }


}
