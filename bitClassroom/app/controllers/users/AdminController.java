package controllers.users;

import com.avaje.ebean.Ebean;
import helpers.AdminFilter;
import helpers.SessionHelper;
import models.ErrorLog;
import models.report.Field;
import models.user.Role;
import models.user.User;
import org.joda.time.DateTime;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utility.MD5Hash;
import utility.UserConstants;
import views.html.admins.adduser;
import views.html.admins.adminindex;
import views.html.admins.allerrors;
import views.html.admins.userlist;
import views.html.dailyreports.dailyraport;
import views.html.admins.setingsdailyraport;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(AdminFilter.class)
public class AdminController extends Controller {

    private final Form<User> userForm = Form.form(User.class);


    /**
     * Admin index page.
     *
     * @return
     */
    public Result index() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(adminindex.render(temp));
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

    public Result listOfUser(){
        return ok(userlist.render(User.findAll()));

    }

    /**
     * Registers new user to the site.
     *
     * @return
     */
    public Result saveNewUser() {
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("register");
        }

        String fname = boundForm.bindFromRequest().field("firstname").value();
        String lname = boundForm.bindFromRequest().field("lastname").value();
        String email = boundForm.bindFromRequest().field("email").value();
        String password = boundForm.bindFromRequest().field("password").value();
        String tmpRole = boundForm.bindFromRequest().field("type").value();
        String passwordHashed = MD5Hash.getEncriptedPasswordMD5(password);
        Long role = 1L;
        if (tmpRole != null) {
            try {
                role = Long.parseLong(tmpRole);
            } catch (NumberFormatException e) {
                Ebean.save(new ErrorLog(e.getMessage()));
            }
        }

        Role r = new Role(role, UserConstants.NAME_ADMIN);
        List<Role> roles = new ArrayList<>();
        roles.add(r);
        User u = new User();
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
                flash("warning", "Something went wrong, user could not be saved to database. Possible duplicate user.");
                return redirect("/admin/new");
            }
            flash("success", String.format("User %s successfully added to database", u.getFirstName()));
            return redirect("/admin/adduser");
        }
        flash("warning", "Something went wrong, user could not be saved to database.");
        Ebean.save(new ErrorLog("Could not save user: " + u.getEmail()));
        return redirect("/admin");
    }

    /**
     * Lists all errors caught in the code with exception getMessage message,
     * or custom message, And time of occurence.
     *
     * @return
     */
    public Result seeErrors() {
        return ok(allerrors.render(ErrorLog.findAllErrors()));
    }


    public Result test() {
        return ok("you are admin");
    }


    public Result deleteUser(Long id) {

        final User user = User.findById(id);
        if (user == null) {
            return notFound(String.format("User %s does not exists.", id));
        }
        Ebean.delete(user);
        return redirect("/admin/allusers");
    }
    public Result genField() {
        return ok(setingsdailyraport.render());
    }

    private static final Form<Field> fieldForm = Form.form(Field.class);



    public Result saveField() {
        return ok(dailyraport.render(fieldForm)); }
}