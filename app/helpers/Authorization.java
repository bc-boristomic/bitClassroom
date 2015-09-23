package helpers;

import models.user.Role;
import models.user.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;

import static play.mvc.Controller.flash;
import static play.mvc.Controller.session;

/**
 * Created by NN on 16.9.2015.
 */
public class Authorization {


    /**
     * Created by boris on 9/12/15.
     */
    public static class Admin extends Security.Authenticator {

        @Override
        public String getUsername(Http.Context context) {
            if (!context.session().containsKey("username")) {
                return null;
            }
            User temp = User.findByEmail(context.session().get("username"));
            if (temp != null && temp.getRoles() != null && temp.getRoles().size() > 0) {
                for (Role r : temp.getRoles()) {
                    if (r.getId().equals(UserConstants.ADMIN) && temp.getStatus().equals(UserConstants.FULLY_ACTIVE)) {
                        return temp.getEmail();
                    }
                }
            }
            return null;
        }

        @Override
        public Result onUnauthorized(Http.Context context) {
            session().clear();
            flash("warning", "You don't have right permissions. You've been logged out.");
            return redirect("/login");
        }
    }


    /**
     * Created by boris on 9/12/15.
     */
    public static class Mentor extends Security.Authenticator {

        @Override
        public String getUsername(Http.Context context) {
            if (!context.session().containsKey("username")) {
                return null;
            }
            User temp = User.findByEmail(context.session().get("username"));
            if (temp != null && temp.getRoles() != null && temp.getRoles().size() > 0) {
                for (Role r : temp.getRoles()) {
                    if (r.getId().equals(UserConstants.MENTOR) && temp.getStatus().equals(UserConstants.FULLY_ACTIVE)) {
                        return temp.getEmail();
                    }
                }
            }
            return null;
        }

        @Override
        public Result onUnauthorized(Http.Context context) {
            session().clear();
            flash("warning", "You don't have right permissions. You've been logged out.");
            return redirect("/login");
        }
    }

    /**
     * Created by boris on 9/12/15.
     */
    public static class Teacher extends Security.Authenticator {

        @Override
        public String getUsername(Http.Context context) {
            if (!context.session().containsKey("username")) {
                return null;
            }
            User temp = User.findByEmail(context.session().get("username"));
            if (temp != null && temp.getRoles() != null && temp.getRoles().size() > 0) {
                for (Role r : temp.getRoles()) {
                    if (r.getId().equals(UserConstants.TEACHER) && temp.getStatus().equals(UserConstants.FULLY_ACTIVE)) {
                        return temp.getEmail();
                    }
                }
            }
            return null;
        }

        @Override
        public Result onUnauthorized(Http.Context context) {
            session().clear();
            flash("warning", "You don't have right permissions. You've been logged out.");
            return redirect("/login");
        }
    }

    /**
     * Created by boris on 9/12/15.
     */
    public static class Student extends Security.Authenticator {

        @Override
        public String getUsername(Http.Context context) {
            if (!context.session().containsKey("username")) {
                return null;
            }
            User temp = User.findByEmail(context.session().get("username"));
            if (temp != null && temp.getRoles() != null && temp.getRoles().size() > 0) {
                for (Role r : temp.getRoles()) {
                    if (r.getId().equals(UserConstants.STUDENT) && temp.getStatus().equals(UserConstants.FULLY_ACTIVE)) {
                        return temp.getEmail();
                    }
                }
            }
            return null;
        }

        @Override
        public Result onUnauthorized(Http.Context context) {
            session().clear();
            flash("warning", "You don't have right permissions. You've been logged out.");
            return redirect("/login");
        }
    }

    /**
     * Created by boris on 9/12/15.
     */
    public static class FullyActiveUser extends Security.Authenticator {

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
            session().clear();
            flash("warning", "You don't have right permissions. You've been logged out.");
            return redirect("/login");
        }
    }

    /**
     * Created by boris on 9/13/15.
     */
    public static class InactiveUser extends Security.Authenticator {

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

}
