package controllers.users;

import helpers.Authorization;
import helpers.SessionHelper;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.course.CourseUser;
import models.report.*;
import models.user.Assignment;
import models.user.Mentorship;
import models.user.User;
import org.joda.time.DateTime;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;
import views.html.admins.newTableWeekly;
import views.html.dailyreports.dailyraport;
import views.html.index;
import views.html.posts.assignmentView;
import views.html.posts.teacherListsAssignment;
import views.html.users.mentorReportForStudent;
import views.html.users.studentsHomeworkStatus;
import views.html.users.teacherApprowedStudent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Teacher.class)
public class  TeacherController extends Controller {

    private static final Form<DailyReport> raportForm = Form.form(DailyReport.class);
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
    public Result test() {
        return ok("you are teacher");
    }

    public Result listAssignment() {
        User user = SessionHelper.currentUser(ctx());
        return ok(teacherListsAssignment.render(user.getPosts()));
    }

    public Result studentAssignmentStatus(Long id, String status) {

        Logger.info(id + "");
        Post post = Post.findPostById(id);
        Course course = post.getCourse();
        Logger.info(course.getName());
        List<User> users = CourseUser.allUserFromCourse(course.getId());
        List<User> students = new ArrayList<>();

        if (status.equals("Done")) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 2) {


                    students.add(users.get(i));
                }
            }
        } else if (status.equals("Working")) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 1) {

                    students.add(users.get(i));
                }
            }
        }
        if (status.equals("Not")) {
            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getRoles().get(0).getName().equals(UserConstants.NAME_STUDENT) && Assignment.findCurrentAssignment(users.get(i), post).getHomeworkPostStatus() == 0) {

                    students.add(users.get(i));
                }
            }
        }
        return ok(studentsHomeworkStatus.render(students, post));
    }

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
     * Send notification when admin approved user in the class
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
                Logger.error(reports.get(i).getStudent());
                Logger.error(studentCourseList.get(j).getUser().getFirstName() + " " + studentCourseList.get(j).getUser().getLastName());
                if( reports.get(i).getStudent().equals(studentCourseList.get(j).getUser().getFirstName() + " " + studentCourseList.get(j).getUser().getLastName())){
                    Logger.info(reports.get(i).getStudent());
                    Logger.info(studentCourseList.get(j).getUser().getFirstName() + " " + studentCourseList.get(j).getUser().getLastName());
                    studentsReport.add(reports.get(i));

                }
            }
        }

        return ok(mentorReportForStudent.render(ReportWeeklyField.getFinderReportWeeklyField().all(), studentsReport, WeeklyField.getFinder().all()));

    }
}

