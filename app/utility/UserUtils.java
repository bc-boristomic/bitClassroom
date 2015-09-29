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
        if (nickname != null && nickname.length() > 3) {
            user.setNickName(nickname);
        }
        if (birthDate != null && birthDate.length() == 10) {
            String[] parts = birthDate.split("-");
            String baLocal = parts[2] + "." + parts[1] + "." + parts[0];
            user.setBirthDate(baLocal);
        }
        if (password != null && password.length() > 6) {
            user.setPassword(MD5Hash.getEncriptedPasswordMD5(password));
        }
        if (location != null && location.length() > 2) {
            user.setLocation(location);
        }
        if (homePhone != null && homePhone.length() > 6) {
            user.setHomePhone(homePhone);
        }
        if (mobilePhone != null && mobilePhone.length() > 6) {
            user.setCellPhone(mobilePhone);
        }
        if (website != null && website.toLowerCase().contains("http://") && website.length() > 8) {
            user.setWebsite(website);
        }
        if (skype != null && skype.length() > 0) {
            user.setSkype(skype);
        }
        if (facebook != null && facebook.toLowerCase().contains("facebook.com") && facebook.length() >= 28) {
            user.setFacebook(facebook);
        }
        if (twitter != null && twitter.toLowerCase().contains("twitter.com")) {
            user.setTwitter(twitter);
        }
        if (youtube != null && youtube.toLowerCase().contains("youtube.com")) {
            user.setYoutube(youtube);
        }
        if (gender != null && gender.length() > 0) {
            try {
                Integer gend = Integer.parseInt(gender);
                user.setGender(gend);
            } catch (NumberFormatException e) {
                Logger.error(e.getMessage());
            }
        }
        if (user.getStatus() != UserConstants.FULLY_ACTIVE) {
            user.setStatus(UserConstants.FULLY_ACTIVE);
        }
        return user;
    }

}
