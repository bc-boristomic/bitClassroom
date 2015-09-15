package controllers.users;

import helpers.TeacherFilter;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(TeacherFilter.class)
public class TeacherController extends Controller {

    public Result test() {
        return ok("you are teacher");
    }
}