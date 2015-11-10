package controllers.users;

import com.avaje.ebean.Ebean;
import helpers.Authorization;
import helpers.SessionHelper;
import it.innove.play.pdf.PdfGenerator;
import models.Event;
import models.Image;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.course.CourseUser;
import models.report.*;
import models.user.Mentorship;
import models.user.Role;
import models.user.User;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.json.simple.JSONArray;
import play.Configuration;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import utility.MD5Hash;
import utility.MailHelper;
import utility.UserConstants;
import utility.UserUtils;
import views.html.*;
import views.html.admins.openReports;
import views.html.admins.openWeeklyReports;
import views.html.pdf.dailypdf;
import views.html.pdf.pdfOpenWeeklyReport;
import views.html.pdf.pdfopenreport;
import views.html.posts.message;
import views.html.users.editprofile;
import views.html.users.login;
import views.html.users.profile;
import views.html.posts.studentList;
import views.html.posts.allMessage;
import views.html.users.util.resetpassword;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by boris on 9/12/15.
 */
public class UserController extends Controller {

    @Inject
    public PdfGenerator pdfGenerator;

    final static Form<Event> eventForm = Form.form(Event.class);
    private final Form<User> userForm = Form.form(User.class);
    private final Form<String> emailForm = Form.form(String.class);
    private static String url = Play.application().configuration().getString("url");

    /**
     * Renders template for creating initial user profile with all information, once profile is created status of user is
     *
     * @return
     */
    @Security.Authenticated(Authorization.InactiveUser.class)
    public Result createProfile() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(profile.render(temp));
    }

    /**
     * Method for update user profile info.
     * Complements users profile , each new user is required to fill in the requested information
     * in order to have access to the application
     *
     * @return
     */
    @Security.Authenticated(Authorization.InactiveUser.class)
    public Result updateProfile() {
        User temp = SessionHelper.currentUser(ctx());
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("/");
        }

        String password1 = boundForm.field("password1").value();
        String password2 = boundForm.field("password2").value();
        if (!password1.equals(password2)) {
            flash("warning", "Your passwords don't match.");
            return redirect("/user/createprofile");
        }


        String nickname = boundForm.field("nickname").value();
        String birthDate = boundForm.field("birth-date").value();
        String location = boundForm.field("location").value();
        String homePhone = boundForm.field("home-phone").value();
        String mobilePhone = boundForm.field("mobile-phone").value();
        String website = boundForm.field("website").value();
        String skype = boundForm.field("skype").value();
        String facebook = boundForm.field("facebook").value();
        String twitter = boundForm.field("twitter").value();
        String youtube = boundForm.field("youtube").value();
        String gender = boundForm.field("gender").value();

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, birthDate, password1, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, gender);
        temp.save();

        MultipartFormData data = request().body().asMultipartFormData();
        MultipartFormData.FilePart filePart = data.getFile("image");

        if (filePart != null) {
            File file = filePart.getFile();
            Image image = Image.create(file, temp.getId());
            image.save();
            temp.setProfilePicture(image);
            temp.save();
        }

        if (temp != null) {
            temp.setUpdateDate(new DateTime());
            temp.setUpdatedBy(temp.getEmail());
            flash("success", "You successfuly updated your profile.");
            return redirect("/");
        }

        temp.save();

        flash("warning", "Your profile could not be updated. Please contact site administrator.");
        return redirect("/");
    }

    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result editProfile() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(editprofile.render(temp));
    }


    /**
     * Method for edit user profile information and user profile picture.
     * @return
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result saveProfile() {
        User temp = SessionHelper.currentUser(ctx());
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("/");
        }

        String password1 = boundForm.field("password1").value();
        String password2 = boundForm.field("password2").value();
        if (!password1.equals(password2)) {
            flash("warning", "Your passwords don't match.");
            return redirect("/user/editprofile");
        }


        String nickname = boundForm.field("nickname").value();
        String location = boundForm.field("location").value();
        String homePhone = boundForm.field("home-phone").value();
        String mobilePhone = boundForm.field("mobile-phone").value();
        String website = boundForm.field("website").value();
        String skype = boundForm.field("skype").value();
        String facebook = boundForm.field("facebook").value();
        String twitter = boundForm.field("twitter").value();
        String youtube = boundForm.field("youtube").value();

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, null, password1, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, null);
        temp.update();

        MultipartFormData data = request().body().asMultipartFormData();
        MultipartFormData.FilePart filePart = data.getFile("image");

        if (filePart != null) {
            File file = filePart.getFile();
            Image image = Image.create(file, temp.getId());
            temp.setProfilePicture(image);
            temp.save();
        }


        if (temp != null) {
            temp.setUpdateDate(new DateTime());
            temp.setUpdatedBy(temp.getEmail());
            temp.save();
            flash("success", "You successfuly updated your profile.");
            return redirect("/");
        }

        flash("warning", "Your profile could not be updated. Please contact site administrator.");
        return redirect("/");
    }

    /**
     * Method for see all student in the class.
     * Current user must be added in the class first to see other student
     * Also then he can send message other students, teacher and mentors.
     *
     * @return - view of all students in the class
     */

    public Result studentList(Long id) {
        List<User> students = CourseUser.allUserFromCourse(id);
        return ok(studentList.render(students));
    }

    /**
     * Method for write new message, with required Subject and content
     * @param id - long id of selected User for send message
     * @return -
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result newMessage(Long id) {
        User sender = SessionHelper.currentUser(ctx());
        User receiver = User.findById(id);
        return ok(message.render(sender, receiver));
    }

    /**
     * Method for send message to selected user from same Class
     * @param id - Long id of selected user which message was send
     * @return - view of all message, inbox and sent message
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result sendMessage(Long id) {
        DynamicForm form = Form.form().bindFromRequest();

        User sender = SessionHelper.currentUser(ctx());
        User receiver = User.findById(id);
        String subject = form.get("subject");
        String content = form.get("content");

        PrivateMessage privMessage = PrivateMessage.create(subject, content, sender, receiver);
        privMessage.setStatus(0);
        receiver.getMessages().add(privMessage);
        receiver.save();

        return redirect("/allMessage");
    }

    /**
     * Method for see all message., received and sent message.
     * @return - view of sent and inbox.
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result allMessage() {

        User u = SessionHelper.currentUser(ctx());
        if (u == null) {

            return redirect("/");
        }
        List<PrivateMessage> messagesReceived = PrivateMessage.getFind().where().eq("receiver.id", u.getId()).orderBy().desc("create_date").findList();
        List<PrivateMessage> messagesSent = PrivateMessage.getFind().where().eq("sender.id", u.getId()).orderBy().desc("create_date").findList();

        return ok(allMessage.render(u, messagesReceived, messagesSent));

    }

    /**
     * Method for delete message
     * @param id - Long id of selected message for delte
     * @return - view of other message
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result deleteInboxMessage(Long id) {

        PrivateMessage msg = PrivateMessage.findMessageById(id);
        msg.setInboxStatus(1);
        msg.setStatus(1);
        Ebean.save(msg);
        return redirect("/allMessage");
    }

    /**
     * Method for delete send messages
     * @param id - selected message
     * @return
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result deleteSendMessage(Long id){

        PrivateMessage msg = PrivateMessage.findMessageById(id);
        msg.setSendStatus(1);
        msg.setStatus(1);
        Ebean.save(msg);
        return redirect("/allMessage");
    }

    /**
     * Method for read recived message fr0om other user
     * @param id - Long message id
     * @return - view of message content
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result seeMessage(Long id) {

        PrivateMessage msg = PrivateMessage.findMessageById(id);
        if( msg.getReceiver().getEmail().equals(SessionHelper.currentUser(ctx()).getEmail()) || msg.getSender().getEmail().equals(SessionHelper.currentUser(ctx()).getEmail())){
            if(msg.getReceiver().getEmail().equals(SessionHelper.currentUser(ctx()).getEmail())){
                msg.setStatus(1);
                Ebean.save(msg);
            }
        return ok(views.html.posts.seeMessage.render(PrivateMessage.getFind().where().eq("id", id).findUnique()));
        }

          return  redirect("/");
    }

    /**
     * Get's user by id passed in method param <code>Long</code> type value.
     * If id is not <code>Long</code> value badRequest is sent.
     * If user is foud by id, a public profile is rendered, otherwise site redirects
     * to index page with warning message.
     *
     * @param id <code>Long</code> type value of user's id
     * @return bad request if user's id is null, redirects to index page if user doesn't exist,
     * renders user's profile if everything is ok.
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result publicProfile(Long id) {
        if (id != null) {
            User temp = User.getFinder().byId(id);
            if (temp != null) {
                return ok(views.html.users.publicProfile.render(temp));
            }
            flash("warning", "User does not exist.");
            return redirect("/");
        }
        return badRequest();
    }


    public Result refusedUser(String token){
        User user = User.findUserByToken(token);
        if(user == null){
            return ok(views.html.fornaidarefuseduser.render());
        }else {
            User.getFinder().deleteById(user.getId());
            return ok(views.html.refuseduserfdbck.render());
        }
    }

    public Result forgotPassword(){
        return ok(views.html.users.util.email.render());
    }

    public Result sendRecoveryMail(){
        Form<String> boundForm = emailForm.bindFromRequest();
        String email = boundForm.bindFromRequest().field("email").value();
        if(email.equals("") || email == null){
            flash("error", "Something is wrong!");
        }else{
            User user = User.findByEmail(email);
            String message = url + "reset/password/" + user.getToken();
            MailHelper.send(email,message);
            flash("success", "Recovery mail is sent to you!");
        }
        return redirect(routes.UserController.forgotPassword());
    }

    public Result showResetPassword(String token){
        User user = User.findUserByToken(token);
        if(user == null){
            return badRequest(views.html.notfound.render());
        }
        return ok(views.html.users.util.resetpassword.render(token));
    }

    public Result resetPassword(String token){
        Form<User> boundForm = userForm.bindFromRequest();
        String pass1 = boundForm.bindFromRequest().field("password1").value();
        String pass2 = boundForm.bindFromRequest().field("password2").value();

        if(!pass1.equals("") && pass1 != null && pass2.equals(pass1)){
            User user = User.findUserByToken(token);
            user.setPassword(MD5Hash.getEncriptedPasswordMD5(pass1));
            user.setToken();
            user.update();
            flash("success", "You successfully changed your password!");
            return ok(login.render(userForm));
        }else{
            flash("Please fill form correctly!");
            return redirect(routes.UserController.showResetPassword(token));
        }

    }


    /**
     * Displays full calendar
     * @return Result
     */
    public static Long courseId;
    public static Course course;
    public  Result calendar(Long id) {
        courseId = id;
        course = Course.findById(id);
        return ok(calendar.render("Title of this calendar...", course));
    }


    /**
     * Returns list of events for calendar view
     * @param start Long Timestamp of current view start
     * @param end Long Timestamp of current view end
     * @return Result
     */
    public  Result json(Long start, Long end) {

        Date startDate = new Date(start*1000);
        Date endDate = new Date(end*1000);

        List<Event> courseEvent = new ArrayList<>();
        List<Event> resultList = Event.findInDateRange(startDate, endDate);
        for ( int i = 0; i < resultList.size(); i++){
            if(resultList.get(i).getCourse().getId().equals(courseId)){
                courseEvent.add(resultList.get(i));
            }
        }
        ArrayList<Map<Object, Serializable>> allEvents = new ArrayList<Map<Object, Serializable>>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Event event : courseEvent) {
            Map<Object, Serializable> eventRemapped = new HashMap<Object, Serializable>();
            eventRemapped.put("id", event.getId());
            eventRemapped.put("title", event.getTitle());
            eventRemapped.put("start", df.format(event.getStart()));
            eventRemapped.put("end", df.format(event.getEnd()));
            eventRemapped.put("allDay", event.getAllDay());
            eventRemapped.put("url", "/calendar/event/"+event.getId().toString());

            allEvents.add(eventRemapped);

        }
        Logger.info(allEvents.toString());
        JSONArray obj = new JSONArray();
        obj.addAll(allEvents);

        return ok(obj.toJSONString());
    }

    /**
     * Dislays form for editing existing event
     * @param id Long
     * @return Result
     */
    public Result edit(Long id) {
        Event event = Event.find.byId(id);
        Form<Event> eventForm = Form.form(Event.class).fill(event);
        return ok(formEdit.render(id, eventForm, event, course));
    }

    /********************************Calendar option for admin*********************************/
    /**
     * Checks if events ends the same day which starts
     * @param start Date
     * @param end Date
     * @return Boolean: True if ends same day
     */
    @Security.Authenticated(Authorization.Admin.class)
    private  Boolean endsSameDay(Date start, Date end){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(start).equals(dateFormat.format(end));
    }


    /**
     * List of events in table view
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public  Result list() {
        List<Event> events = Event.find.order().desc("start").findList();
        return ok(list.render(events, course));
    }


    /**
     * Displays blank form
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public  Result blank() {
        return ok(formNew.render(eventForm));
    }


    /**
     * Save new event in DB (a.k.a. submit action in other examples)
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result add() {
        Form<Event> eventForm = Form.form(Event.class).bindFromRequest();
        if (eventForm.hasErrors()) {
            return badRequest(formNew.render(eventForm));
        }

        Event newEvent = eventForm.get();

        newEvent.setAllDay(false);
        if (newEvent.getEnd() == null) {
            newEvent.setEnd(new DateTime(newEvent.getStart()).plusMinutes(30).toDate());
        }
        newEvent.setEndsSameDay(endsSameDay(newEvent.getStart(), newEvent.getEnd()));
        newEvent.setCourse(course);
        newEvent.save();
        return redirect("/admin/calendar/events");
    }

    /**
     * Save new event in DB (a.k.a. submit action in other examples)
     * @param id Long
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result update(Long id) {
        Form<Event> eventForm = Form.form(Event.class).bindFromRequest();
        if (eventForm.hasErrors()) {
            return badRequest(formEdit.render(id, eventForm, Event.find.byId(id), Course.findById(courseId)));
        }
        Event updatedEvent = Event.find.byId(id);
        updatedEvent.setAllDay(false);
        if (updatedEvent.getEnd() == null) {
            updatedEvent.setEnd(new DateTime(updatedEvent.getStart()).plusMinutes(30).toDate());
        }
        updatedEvent.setEndsSameDay(endsSameDay(updatedEvent.getStart(), updatedEvent.getEnd()));
        updatedEvent.setCourse(course);
        updatedEvent.setStart(eventForm.get().getStart());
        updatedEvent.setEnd(eventForm.get().getEnd());
        Ebean.update(updatedEvent);
        updatedEvent.update();
        return redirect("/admin/calendar/events");
    }


    /**
     * Deletes event
     * @param id Long
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result delete(Long id) {
        Event.find.ref(id).delete();
        return redirect("/admin/calendar/events");
    }


    /**
     * Adds event after clicking on calendar
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result addByAjax() {

        Form<Event> eventForm = Form.form(Event.class).bindFromRequest();
        Event newEvent = eventForm.get();
        newEvent.setEndsSameDay(endsSameDay(newEvent.getStart(), newEvent.getEnd()));
        newEvent.setCourse(course);
        newEvent.save();

        if (eventForm.hasErrors()){
            return badRequest("There was some errors in form");
        }

        Map<String, String> result = new HashMap<String, String>();
        result.put("id", newEvent.getId().toString());
        result.put("url", "/calendar/event/" + newEvent.getId().toString());
        Logger.info(result.toString());

        return ok(play.libs.Json.toJson(result));
    }


    /**
     * Saves in DB date changed by event drag
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result move() {

        Long id = Long.valueOf(Form.form().bindFromRequest().get("id"));
        int dayDelta = Integer.parseInt(Form.form().bindFromRequest().get("dayDelta"));
        int minuteDelta = Integer.parseInt(Form.form().bindFromRequest().get("minuteDelta"));

        Event event = Event.find.byId(id);
        event.setStart(new DateTime(event.getStart()).plusDays(dayDelta).plusMinutes(minuteDelta).toDate());
        event.setEnd(new DateTime(event.getEnd()).plusDays(dayDelta).plusMinutes(minuteDelta).toDate());
        event.setAllDay(Boolean.valueOf(Form.form().bindFromRequest().get("allDay")));
        event.setEndsSameDay(endsSameDay(event.getStart(), event.getEnd()));
        event.setCourse(course);
        event.update();


        return ok("changed");
    }

    /**
     * Saves in DB end date changed by event resize
     * @return Result
     */
    @Security.Authenticated(Authorization.Admin.class)
    public Result resize() {

        Long id = Long.valueOf(Form.form().bindFromRequest().get("id"));
        int dayDelta = Integer.parseInt(Form.form().bindFromRequest().get("dayDelta"));
        int minuteDelta = Integer.parseInt(Form.form().bindFromRequest().get("minuteDelta"));

        Event event = Event.find.byId(id);
        event.setEnd(new DateTime(event.getEnd()).plusDays(dayDelta).plusMinutes(minuteDelta).toDate());
        event.setEndsSameDay(endsSameDay(event.getStart(), event.getEnd()));
        event.update();

        return ok("changed");
    }

    public Result openWeeklyReport(Long id) {
        return ok(openWeeklyReports.render(WeeklyReport.findWeeklyReportById(id), WeeklyReport.previousWeeklyReport(id), WeeklyReport.nextWeeklyReport(id), ReportWeeklyField.getFinderReportWeeklyField().all()));
    }

    public Result pdfWeeklyReports(Long id) {
        return pdfGenerator.ok(pdfOpenWeeklyReport.render(WeeklyReport.findWeeklyReportById(id), ReportWeeklyField.getFinderReportWeeklyField().all()), Configuration.root().getString("application.host"));
    }

    public Result openReport(Long id) {
        return ok(openReports.render(DailyReport.findDailyReportById(id), DailyReport.nextReport(id), DailyReport.previousReport(id), ReportField.getFinder().all()));
    }

    public Result pdfDailyTable() {
        return pdfGenerator.ok(dailypdf.render(ReportField.getFinder().all(), DailyReport.getFinder().all(), Field.getFinder().all()), Configuration.root().getString("application.host"));
    }

    public Result pdfDailyReports(Long id) {
        return pdfGenerator.ok(pdfopenreport.render(DailyReport.findDailyReportById(id), ReportField.getFinder().all()), Configuration.root().getString("application.host"));
    }
}