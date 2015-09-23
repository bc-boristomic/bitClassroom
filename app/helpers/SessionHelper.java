package helpers;

import models.user.User;
import play.mvc.Http;

/**
 * Created by banjich on 9/4/15.
 */
public class SessionHelper {
    /**
     * Getting user from session
     * @param context
     * @return user
     */
    public static User currentUser(Http.Context context) {
        String username = context.session().get("username");
        if (username == null) {
            return null;
        }
        User temp = User.findByEmail(username);
        if (temp == null) {
            return null;
        }
        return temp;
    }
}