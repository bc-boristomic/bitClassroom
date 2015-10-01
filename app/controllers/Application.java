package controllers;

import helpers.SessionHelper;
import models.course.CourseUser;
import models.user.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utility.MD5Hash;
import utility.UserConstants;
import views.html.about;
import views.html.index;
import views.html.newMain;
import views.html.users.login;
import views.html.users.util.email;

import java.util.List;

public class Application extends Controller {

    private Form<User> userForm = Form.form(User.class);

    /**
     * Renders index page, front page of website
     *
     * @return
     */


    public Result welcome(){
        return ok(newMain.render());
    }

    public Result index() {
        User temp = SessionHelper.currentUser(ctx());
        //List<CourseUser> culist = CourseUser.findAll(temp.getId());

       // if (temp != null && culist.size()!= 0) {

         //   List<Course> list = CourseUser.allUserCourses(temp);
            List<CourseUser> userc = CourseUser.getFinder().all();

            return ok(index.render(temp, userc));
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
        return redirect("/login");
    }

    public Result getNotification() {
        User temp = SessionHelper.currentUser(ctx());
        int notify = CourseUser.getFinder().where().eq("status", 0).findRowCount();
        return ok(notify + "");
    }




}
