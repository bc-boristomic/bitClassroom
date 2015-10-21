package controllers;

import helpers.SessionHelper;

import models.Email;

import models.Event;
import models.Faq;
import models.PrivateMessage;
import models.course.CourseUser;
import models.user.Mentorship;
import models.user.User;
import org.json.simple.JSONArray;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utility.MD5Hash;
import utility.UserConstants;
import views.html.about;
import views.html.calendar;
import views.html.index;
import views.html.newMain;
import views.html.users.login;
import views.html.users.util.email;
import views.html.users.util.faq;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application extends Controller {

    private Form<User> userForm = Form.form(User.class);
    private Form<Email> emailForm = Form.form(Email.class);

    /**
     * Renders index page, front page of website
     *
     * @return
     */


    public Result welcome() {
        return ok(newMain.render());
    }

    public Result index() {
        User temp = SessionHelper.currentUser(ctx());

        if (temp == null) {
            return redirect("/home");
        }
        //List<CourseUser> culist = CourseUser.findAll(temp.getId());

        // if (temp != null && culist.size()!= 0) {

        //   List<Course> list = CourseUser.allUserCourses(temp);

        List<CourseUser> user = CourseUser.getFinder().all();

        return ok(index.render(temp, user));

        // } else {

        //     return ok(temp);
        // }

    }

    /**
     * Renders about page, page with information about team and project
     *
     * @return
     */
    public Result about() {
        return ok(about.render());
    }

    /**
     * Renders simple login form, email and password field only,
     * if everything checks out, submit button is routed to checkLogin() method.
     *
     * @return
     */
    public Result login() {
        return ok(login.render(userForm));
    }

    /**
     * Checks bound form for errors, if errors are found, user is redirected to login.
     * Otherwise user email and password is taken from form, password is hashed, and user is checked in database.
     * If user exists in database (not null) session is provided for user and user is redirected to index page.
     * If user is null, login is rendered with previously inputted values.
     *
     * @return
     */
    public Result checkLogin() {
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("login");
        }

        String email = boundForm.field("email").value();
        String password = boundForm.field("password").value();
        String passwordHashed = MD5Hash.getEncriptedPasswordMD5(password);
        User user = User.findByEmailAndPassword(email, passwordHashed);

        if (user != null) {
            if (user.getStatus() != UserConstants.FULLY_ACTIVE) {
                user.setStatus(1);
                user.update();
                session("username", user.getEmail());
                flash("success", String.format("%s successfully logged in", user.getFirstName()));
                return redirect("/user/createprofile");
            }
            session("username", user.getEmail());
            flash("success", String.format("%s successfully logged in", user.getFirstName()));
            return redirect("/");
        }
        flash("warning", "Wrong email or password, user not found.");
        return ok(login.render(userForm));
    }

    /**
     * Renders simple email form if user clicked on "Did you forget password ?" on login page.
     * Page pops-up!
     *
     * @return
     */
    public Result sendEmail() {
        return ok(email.render());
    }

    /**
     * Simply clears session, flashes user that he/she successfuly logged out and redirects to login.
     *
     * @return
     */
    public Result logout() {
        session().clear();
        flash("success", "You successfuly signed out.");
        return redirect("/home");
    }

    /**
     * Notification for applied students awaiting approval.
     *
     * @return
     */
    public Result getNotification() {
        int notify = CourseUser.getFinder().where().eq("status", 0).findRowCount();
        return ok(notify + "");
    }

    /**
     * Notification for unread messages for current user.
     * Notification is shown in main view.
     *
     * @return
     */
    public Result unreadMessages() {
        User u = SessionHelper.currentUser(ctx());
        int notify = PrivateMessage.getFind().where().eq("receiver_id", u.getId()).eq("status", 0).findRowCount();
        return ok(String.valueOf(notify));
    }

    public Result weeklyNotification(){

        int counter = User.getFinder().where().eq("studentStatus", 14).findRowCount();
        int notify = User.getFinder().where().eq("weeklyReportStatus", 2).findRowCount();
        return ok(notify + "/" + counter);
    }

    public Result faq(){

        List<Faq> faqList = Faq.findAllFAQ();
        return ok(faq.render(faqList));
    }


    /**
     * Displays full calendar
     * @return Result
     */
    public  Result calendar() {
        return ok(calendar.render("Title of this calendar..."));
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

        List<Event> resultList = Event.findInDateRange(startDate, endDate);
        ArrayList<Map<Object, Serializable>> allEvents = new ArrayList<Map<Object, Serializable>>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Event event : resultList) {
            Map<Object, Serializable> eventRemapped = new HashMap<Object, Serializable>();
            eventRemapped.put("id", event.getId());
            eventRemapped.put("title", event.getTitle());
            eventRemapped.put("start", df.format(event.getStart()));
            eventRemapped.put("end", df.format(event.getEnd()));
            eventRemapped.put("allDay", event.getAllDay());
            eventRemapped.put("url", "/admin/calendar/event/"+event.getId().toString()+"/edit");

            allEvents.add(eventRemapped);

        }
        Logger.info(allEvents.toString());
        JSONArray obj = new JSONArray();
        obj.addAll(allEvents);

        return ok(obj.toJSONString());
    }

}
