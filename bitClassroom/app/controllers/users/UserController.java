package controllers.users;

import helpers.CurrentUserFilter;
import helpers.InactiveUserFilter;
import helpers.SessionHelper;
import models.user.Role;
import models.user.User;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import play.Logger;
import play.Play;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import play.mvc.Security;
import utility.MD5Hash;
import utility.UserConstants;
import utility.UserUtils;
import views.html.users.editprofile;
import views.html.users.profile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by boris on 9/12/15.
 */
public class UserController extends Controller {

    private List<String> imageList = new ArrayList<>();

    private final Form<User> userForm = Form.form(User.class);

    /**
     * Renders template for creating initial user profile with all information, once profile is created status of user is
     * @return
     */
    @Security.Authenticated(InactiveUserFilter.class)
    public Result createProfile() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(profile.render(temp));
    }

    @Security.Authenticated(InactiveUserFilter.class)
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
            temp.setProfilePicture(temp.getId() + "\\" + picName);
        }

        String newPassword = MD5Hash.getEncriptedPasswordMD5(password1);
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

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, birthDate, newPassword, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, gender);

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

    @Security.Authenticated(CurrentUserFilter.class)
    public Result editProfile() {
        User temp = SessionHelper.currentUser(ctx());
        return ok(editprofile.render(temp));
    }


    @Security.Authenticated(CurrentUserFilter.class)
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
            temp.setProfilePicture(temp.getId() + "\\" + picName);
        }

        String newPassword = MD5Hash.getEncriptedPasswordMD5(password1);
        String nickname = boundForm.bindFromRequest().field("nickname").value();
        String location = boundForm.bindFromRequest().field("location").value();
        String homePhone = boundForm.bindFromRequest().field("home-phone").value();
        String mobilePhone = boundForm.bindFromRequest().field("mobile-phone").value();
        String website = boundForm.bindFromRequest().field("website").value();
        String skype = boundForm.bindFromRequest().field("skype").value();
        String facebook = boundForm.bindFromRequest().field("facebook").value();
        String twitter = boundForm.bindFromRequest().field("twitter").value();
        String youtube = boundForm.bindFromRequest().field("youtube").value();

        temp = UserUtils.ckeckUserProfileDetails(temp, nickname, null, newPassword, location, homePhone, mobilePhone, website, skype, facebook, twitter, youtube, null);

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

    @Security.Authenticated(CurrentUserFilter.class)
    public Result test() {
        return ok("test");
    }
}