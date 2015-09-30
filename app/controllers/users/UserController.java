package controllers.users;

import com.avaje.ebean.Ebean;
import helpers.Authorization;
import helpers.SessionHelper;
import models.PrivateMessage;
import models.course.CourseUser;
import models.user.User;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;
import utility.UserUtils;
import views.html.posts.message;
import views.html.users.editprofile;
import views.html.users.profile;
import views.html.posts.studentList;
import views.html.posts.allMessage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 9/12/15.
 */
public class UserController extends Controller {

    private List<String> imageList = new ArrayList<>();

    private final Form<User> userForm = Form.form(User.class);

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

    @Security.Authenticated(Authorization.InactiveUser.class)
    public Result updateProfile() {
        User temp = SessionHelper.currentUser(ctx());
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("/");
        }

        String password1 = boundForm.bindFromRequest().field("password1").value();
        String password2 = boundForm.bindFromRequest().field("password2").value();
        if (!password1.equals(password2)) {
            flash("warning", "Your passwords don't match.");
            return redirect("/user/createprofile");
        }

        MultipartFormData data = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> pictures = data.getFiles();

        if (pictures != null) {
            String picName = null;
            for (FilePart picture : pictures) {
                picName = picture.getFilename();
                File file = picture.getFile();

                try {
                    FileUtils.moveFile(file, new File(Play.application().path() + "/public/images/users/" + temp.getId() + "/" + picName));
                    Logger.info(Play.application().path() + "\\public\\images\\" + temp.getId() + "/" + picName);
                    imageList.add(picName);
                } catch (IOException e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
            if (picName != null) {
                temp.setProfilePicture(temp.getId() + "/" + picName);
            }
        }

        String nickname = boundForm.bindFromRequest().field("nickname").value();
        String birthDate = boundForm.bindFromRequest().field("birth-date").value();
        String location = boundForm.bindFromRequest().field("location").value();
        String homePhone = boundForm.bindFromRequest().field("home-phone").value();
        String mobilePhone = boundForm.bindFromRequest().field("mobile-phone").value();
        String website = boundForm.bindFromRequest().field("website").value();
        String skype = boundForm.bindFromRequest().field("skype").value();
        String facebook = boundForm.bindFromRequest().field("facebook").value();
        String twitter = boundForm.bindFromRequest().field("twitter").value();
        String youtube = boundForm.bindFromRequest().field("youtube").value();
        String gender = boundForm.bindFromRequest().field("gender").value();

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, birthDate, password1, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, gender);

        if (temp != null) {
            temp.setUpdateDate(new DateTime());
            temp.setUpdatedBy(temp.getEmail());
            temp.update();
            flash("success", "You successfuly updated your profile.");
            return redirect("/");
        }

        flash("warning", "Your profile could not be updated. Please contact site administrator.");
        return redirect("/");

    }

    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result editProfile() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(editprofile.render(temp));
    }


    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result saveProfile() {
        User temp = SessionHelper.currentUser(ctx());
        Form<User> boundForm = userForm.bindFromRequest();

        if (boundForm.hasErrors()) {
            flash("warning", "Please correct the form.");
            return redirect("/");
        }

        String password1 = boundForm.bindFromRequest().field("password1").value();
        String password2 = boundForm.bindFromRequest().field("password2").value();
        if (!password1.equals(password2)) {
            flash("warning", "Your passwords don't match.");
            return redirect("/user/editprofile");
        }

        MultipartFormData data = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> pictures = data.getFiles();

        if (pictures != null) {
            String picName = null;
            for (FilePart picture : pictures) {
                picName = picture.getFilename();
                File file = picture.getFile();

                try {
                    FileUtils.moveFile(file, new File(Play.application().path() + "/public/images/users/" + temp.getId() + "/" + picName));
                    Logger.info(Play.application().path() + "\\public\\images\\" + temp.getId() + "/" + picName);
                    imageList.add(picName);
                } catch (IOException e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
            if (picName != null) {
                temp.setProfilePicture(temp.getId() + "/" + picName);
            }
        }

        String nickname = boundForm.bindFromRequest().field("nickname").value();
        String location = boundForm.bindFromRequest().field("location").value();
        String homePhone = boundForm.bindFromRequest().field("home-phone").value();
        String mobilePhone = boundForm.bindFromRequest().field("mobile-phone").value();
        String website = boundForm.bindFromRequest().field("website").value();
        String skype = boundForm.bindFromRequest().field("skype").value();
        String facebook = boundForm.bindFromRequest().field("facebook").value();
        String twitter = boundForm.bindFromRequest().field("twitter").value();
        String youtube = boundForm.bindFromRequest().field("youtube").value();

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, null, password1, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, null);

        if (temp != null) {
            temp.setUpdateDate(new DateTime());
            temp.setUpdatedBy(temp.getEmail());
            temp.update();
            flash("success", "You successfuly updated your profile.");
            return redirect("/");
        }

        flash("warning", "Your profile could not be updated. Please contact site administrator.");
        return redirect("/");
    }


    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result test() {
        Logger.info(new DateTime().getMillis() + " ");
        return redirect("/login");
    }


    /**
     * Method for see all student in the class.
     * Current user must be added in the class first to see other student
     * Also then he can send message other students, teacher and mentors.
     *
     * @return - view of all students in the class
     */
    @Security.Authenticated(Authorization.FullyActiveUser.class)
    public Result studentList() {
        List<CourseUser> students = CourseUser.all();
        User u = SessionHelper.currentUser(ctx());
        for (CourseUser student : students) {
            if (student.getUser().getEmail().equals(u.getEmail())) {
                if (student.getStatus() == UserConstants.FULLY_ACTIVE) {
                    return ok(studentList.render(students));
                }
            }

        }
        return redirect("/user/courses");
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
    public Result deleteMessage(Long id) {

        PrivateMessage msg = PrivateMessage.findMessageById(id);
        msg.setStatus(3);
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
        msg.setStatus(1);
        Ebean.save(msg);
        if( msg.getReceiver().getEmail().equals(SessionHelper.currentUser(ctx()).getEmail()) || msg.getSender().getEmail().equals(SessionHelper.currentUser(ctx()).getEmail())){
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
}