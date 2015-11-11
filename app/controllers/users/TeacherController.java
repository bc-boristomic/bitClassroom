package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import it.innove.play.pdf.PdfGenerator;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.course.CourseUser;
import models.report.*;
import models.user.Assignment;
import models.user.Mentorship;
import models.user.User;
import org.joda.time.DateTime;
import play.Configuration;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utility.StatusConstants;
import utility.UserConstants;
import views.html.admins.newTableWeekly;
import views.html.admins.openWeeklyReports;
import views.html.dailyreports.dailyraport;
import views.html.index;
import views.html.pdf.pdfOpenWeeklyReport;
import views.html.pdf.weeklypdf;
import views.html.posts.assignmentView;
import views.html.posts.teacherListsAssignment;
import views.html.users.mentorReportForStudent;
import views.html.users.studentsHomeworkStatus;
import views.html.users.teacherApprowedStudent;
import views.html.users.teacherReports;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Teacher.class)
public class  TeacherController extends Controller {

    @Inject
    public PdfGenerator pdfGenerator;
    private static final Form<DailyReport> raportForm = Form.form(DailyReport.class);

    /**
     *
     * @return
     */
    public Result dailyReport() {
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.bindFromRequest(request());
        dynamicForm.get("1");
        List<Field> fields = Field.getFinder().findList();
        List<CourseUser> courseUserList = CourseUser.findAll(SessionHelper.currentUser(ctx()).getId());
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < courseUserList.size();  i++){
            courseList.add(courseUserList.get(i).getCourse());
        }
        return ok(dailyraport.render(raportForm, fields, courseList));
    }

    /**
     *
     * @return
     */
    public Result saveRaport() {
        User temp = SessionHelper.currentUser(ctx());
        List<Field> fields = Field.getFinder().findList();
        DynamicForm dynamicForm = Form.form().bindFromRequest();
        dynamicForm.bindFromRequest(request());
        DailyReport dailyReport = new DailyReport();
        dailyReport.setName(dynamicForm.get("title"));
        dailyReport.setCreatedDate(new DateTime());
        dailyReport.setData(dynamicForm.get("data"));
        dailyReport.setDate(dynamicForm.get("date"));
        dailyReport.setTeacher(temp);
        long courseId = Long.parseLong(dynamicForm.get("course"));
        Course course = Course.findById(courseId);
        dailyReport.setCourse(course);

        Long time = course.getReportDate().getMillis()/1000;
        Logger.info(time+"");
        Long tmp = DateTime.now().getMillis()/1000;
        Long result = tmp - time;
        Logger.info(result+"");
        Integer week = course.getWeek();
        if(result >  604800){
            week += 1;
            course.setReportDate(DateTime.now());
            course.setWeek(week);
            dailyReport.setWeek(week);
            course.update();
        }
        dailyReport.save();

        for (Field field : fields) {
            ReportField reportField = new ReportField();
            reportField.setDailyReport(dailyReport);
            String fieldId = dynamicForm.get(String.valueOf(field.getId()));
            reportField.setValue(fieldId);
            reportField.setField(field);
            reportField.save();
        }
        User u = SessionHelper.currentUser(ctx());
        // List<Course> list = CourseUser.allUserCourses(u);
        //CourseUser userc = CourseUser.findAll(u.getId()).get(0);
        List<CourseUser> userc = CourseUser.getFinder().all();
        return ok(index.render(u, userc));
    }

    /**
     * Method for get all assignemnts
     * @return
     */
    public Result listAssignment() {
        User user = SessionHelper.currentUser(ctx());
        return ok(teacherListsAssignment.render(user.getPosts()));
    }

    /**
     * Method for see homework activity,
     * teacher can see list of students who have done homework, who are still working  and which do not
     *
     * @param id - id of Post model.
     * @param status - String for selected list, Done, Working , Not
     * @return
     */
    public Result studentAssignmentStatus(Long id, String status) {

        Post post = Post.findPostById(id);
        Course course = post.getCourse();
        List<User> users = CourseUser.allUserFromCourse(course.getId());
        List<User> students = new ArrayList<>();

        if (StatusConstants.DONE.equals(status)) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 2) {


                    students.add(users.get(i));
                }
            }
        } else if (StatusConstants.WORKING.equals(status)) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 1) {

                    students.add(users.get(i));
                }
            }
        }
        if (StatusConstants.NOT_DONE.equals(status)) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 0) {

                    students.add(users.get(i));
                }
            }
        }
        return ok(studentsHomeworkStatus.render(students, post));
    }

    /**
     * List of students that applied for courses. Course name, student name and
     * approve, dissaprove buttons are displayed in a row.
     * @return
     */
    public Result awaitList(){

        List<CourseUser> allCourseUserList = CourseUser.getFinder().all();
        List<CourseUser> courseUserList = CourseUser.findAll(SessionHelper.currentUser(ctx()).getId());
        List<CourseUser> studentCourseList = new ArrayList<>();

        for ( int i = 0; i < allCourseUserList.size(); i++){
            for( int j = 0; j < courseUserList.size(); j++){

                if(allCourseUserList.get(i).getCourse().getId().equals(courseUserList.get(j).getCourse().getId())){

                    studentCourseList.add(allCourseUserList.get(i));
                }
            }
        }
        Logger.info(studentCourseList.size()+"");
        return ok(teacherApprowedStudent.render(studentCourseList));
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

        approvedNotification(cu.getCourse(), cu.getUser());
        Course c = cu.getCourse();
        for(int i = 0; i < c.getPosts().size(); i++){
            if(c.getPosts().get(i).getPostType() == 1){
                Assignment a = new Assignment();
                a.setUser(cu.getUser());
                a.setPost(c.getPosts().get(i));
                a.setHomeworkPostStatus(0);
                a.save();
            }
        }

        User u = Mentorship.findMentorByUser(cu.getUser());
        List<User> courseUsers = CourseUser.allUserFromCourse(cu.getCourse().getId());

        if( u != null) {
            for (int i = 0; i < courseUsers.size(); i++) {
                if (courseUsers.get(i).getId() == u.getId()) {
                    return ok("");
                }
            }
        }

        if(u != null){
            CourseUser cc = new CourseUser();
            cc.setCourse(cu.getCourse());
            cc.setStatus(Integer.parseInt(s));
            cc.setUser(u);
            cc.save();
        }

        return ok("");
    }

    /**
     * Send notification when treacheer approved user in the class
     * @param course
     * @param student
     */
    public void approvedNotification ( Course course, User student){

        String subject = "Course information";
        String content = "Your application for access to the course" + course.getName() + " is accepted";

        User sender = SessionHelper.currentUser(ctx());
        PrivateMessage privMessage = PrivateMessage.create(subject, content, sender, student);
        privMessage.setStatus(0);
        student.getMessages().add(privMessage);
        student.save();

    }

    /**
     * Method for see all mentors reports that are written about students
     * of which he is a teacher.
     * @return
     */
    public Result seeMentorReports(){

        List<CourseUser> allCourseUserList = CourseUser.getFinder().all();
        List<CourseUser> courseUserList = CourseUser.findAll(SessionHelper.currentUser(ctx()).getId());
        List<CourseUser> studentCourseList = new ArrayList<>();

        for ( int i = 0; i < allCourseUserList.size(); i++){
            for( int j = 0; j < courseUserList.size(); j++){

                if(allCourseUserList.get(i).getCourse().getId().equals(courseUserList.get(j).getCourse().getId())){

                    studentCourseList.add(allCourseUserList.get(i));
                }
            }

        }

        List<WeeklyReport> reports = WeeklyReport.getFinder().all();
        Set<WeeklyReport> studentsReport = new HashSet<>();
        for ( int i = 0; i < reports.size(); i++){
            for( int j = 0; j < studentCourseList.size(); j++){
                if( reports.get(i).getStudent().equals(studentCourseList.get(j).getUser().getFirstName() + " " + studentCourseList.get(j).getUser().getLastName())){
                    studentsReport.add(reports.get(i));

                }
            }
        }

        return ok(mentorReportForStudent.render(ReportWeeklyField.getFinderReportWeeklyField().all(), studentsReport, WeeklyField.getFinder().all()));

    }

    /**
     * Renders weeklyToPDF file into PDF file, PdfGenerator is used to render.
     *
     * @return ok and generates weekly in PDF format
     */
 public Result pdfWeeklyTable() {
     return pdfGenerator.ok(weeklypdf.render(ReportWeeklyField.getFinderReportWeeklyField().all(), WeeklyReport.getFinder().all(), WeeklyField.getFinder().all()), Configuration.root().getString("application.host"));
    }


    /**
     * Method for see all daily reports that the teacher had written
     * @return
     */
    public Result myReports (){

        List<DailyReport> myReports = new ArrayList<>();
        List<DailyReport> allReports = DailyReport.getFinder().all();

        for ( int i = 0; i < allReports.size(); i++){

            if(allReports.get(i).getTeacher().getId().equals(SessionHelper.currentUser(ctx()).getId())){
                myReports.add(allReports.get(i));
            }
        }
        return ok(teacherReports.render(ReportField.getFinder().all(), myReports, Field.getFinder().all()));
    }


}

