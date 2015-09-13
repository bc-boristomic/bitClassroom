package helpers;

import models.user.User;
import static play.mvc.Controller.flash;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;

/**
 * Created by boris on 9/12/15.
 */
public class CurrentUserFilter extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context context) {
        if (!context.session().containsKey("username")) {
            return null;
        }
        User temp = User.findByEmail(context.session().get("username"));
        if (temp != null && temp.getStatus().equals(UserConstants.FULLY_ACTIVE)) {
            return temp.getEmail();
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        flash("warning", "You don't have right permissions");
        return redirect("/login");
    }



}