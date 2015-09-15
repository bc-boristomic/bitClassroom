package controllers.users;

import com.avaje.ebean.Ebean;
import helpers.AdminFilter;
import helpers.SessionHelper;
import models.user.Role;
import models.user.User;
import org.joda.time.DateTime;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import utility.MD5Hash;
import utility.UserConstants;
import views.html.admins.adduser;
import views.html.admins.adminindex;
import views.html.admins.userlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(AdminFilter.class)
public class AdminController extends Controller {

    private final Form<User> userForm = Form.form(User.class);


    public Result index() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(adminindex.render(temp));
    }

    public Result addNewUser() {
        return ok(adduser.render(userForm));
    }

    public Result listOfUser(){

        List<User> userList = User.findAll();
        return ok(userlist.render(userList));

    }

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
            } catch(NumberFormatException e) {
                // TODO all logger
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
            u.save();
        }


        Logger.info(fname + " " + lname + " " + email + " " + password + " " + role);
        List<User> userList = User.findAll();
        return ok(userlist.render(userList));
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

}