//package helpers;
//
//import models.user.User;
//import play.mvc.Http;
//import play.mvc.Result;
//import play.mvc.Security;
//import utility.UserConstants;
//
///**
// * Created by boris on 9/12/15.
// */
//public class AdminFilter extends Security.Authenticator {
//
//    @Override
//    public String getUsername(Http.Context context) {
//        if (!context.session().containsKey("username")) {
//            return null;
//        }
//        User temp = User.findByEmail(context.session().get("username"));
//        if (temp != null && temp.getUserRoles().contains(UserConstants.ADMIN) && temp.getStatus().equals(UserConstants.ACTIVE)) {
//            return temp.getEmail();
//        }
//        return null;
//    }
//
//    @Override
//    public Result onUnauthorized(Http.Context context) {
//        return redirect("/login");
//    }
//}