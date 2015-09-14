package controllers;

import models.user.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utility.MD5Hash;
import utility.UserConstants;
import views.html.about;
import views.html.index;
import views.html.users.login;
import views.html.users.util.email;

public class Application extends Controller {

    private Form<User> userForm = Form.form(User.class);

    /**
     * Renders index page, front page of website
     *
     * @return
     */
    public Result index() {
        return ok(index.render());
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

        String email = boundForm.bindFromRequest().field("email").value();
        String password = boundForm.bindFromRequest().field("password").value();
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
        return redirect("login");
    }

}
