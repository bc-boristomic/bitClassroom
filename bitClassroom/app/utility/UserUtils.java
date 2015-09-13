package utility;

import models.user.User;
import play.Logger;

/**
 * Created by boris on 9/13/15.
 */
public class UserUtils {

    public static User ckeckUserProfileDetails(User user, String nickname, String birthDate, String password, String location, String homePhone, String mobilePhone, String website, String skype, String facebook, String twitter, String youtube, String gender) {
        if (user == null) {
            return null;
        }
        if (nickname.length() > 3 && nickname != null) {
            user.setNickName(nickname);
        }
        if (birthDate.length() == 10 && birthDate != null) {
            String[] parts = birthDate.split("-");
            String baLocal = parts[2] + "." + parts[1] + "." + parts[0];
            user.setBirthDate(baLocal);
        }
        if (password.length() > 6 && password != null) {
            user.setPassword(password);
        }
        if (location.length() > 2 && location != null) {
            user.setLocation(location);
        }
        if (homePhone.length() > 6 && homePhone != null) {
            user.setHomePhone(homePhone);
        }
        if (mobilePhone.length() > 6 && mobilePhone != null) {
            user.setCellPhone(mobilePhone);
        }
        if (website.toLowerCase().contains("http://") && website.length() > 8 && website != null) {
            user.setWebsite(website);
        }
        if (skype.length() > 0 && skype != null) {
            user.setSkype(skype);
        }
        if (facebook.toLowerCase().contains("facebook.com") && facebook != null) {
            user.setFacebook(facebook);
        }
        if (twitter.toLowerCase().contains("twitter.com") && twitter != null) {
            user.setTwitter(twitter);
        }
        if (youtube.toLowerCase().contains("youtube.com") && youtube != null) {
            user.setYoutube(youtube);
        }
        if (gender.length() > 0 && gender != null) {
            try {
                Integer gend = Integer.parseInt(gender);
                user.setGender(gend);
            } catch (NumberFormatException e) {
                Logger.error(e.getMessage());
            }
        }
        user.setStatus(2);
        return user;
    }
}
