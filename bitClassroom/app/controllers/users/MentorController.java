package controllers.users;

import helpers.MentorFilter;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(MentorFilter.class)
public class MentorController extends Controller {

    public Result test() {
        return ok("you are mentor");
    }

}