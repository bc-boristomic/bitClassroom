package helpers;

import models.user.User;
import static play.mvc.Controller.flash;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;

/**
 * Created by boris on 9/13/15.
 */
public class InactiveUserFilter extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context context) {
        if (!context.session().containsKey("username")) {
            return null;
        }
        User temp = User.findByEmail(context.session().get("username"));
        if (temp != null && temp.getStatus().equals(UserConstants.NOT_FULLY_ACTIVE)) {
            return temp.getEmail();
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        flash("info", "You already created your profile, perhaps you wanted to edit it?");
        return redirect("/user/editprofile");
    }

}
