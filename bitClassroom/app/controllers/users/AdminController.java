package controllers.users;

import helpers.AdminFilter;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(AdminFilter.class)
public class AdminController extends Controller {

    public Result test() {
        return ok("you are admin");
    }

}