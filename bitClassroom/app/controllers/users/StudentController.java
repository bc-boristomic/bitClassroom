package controllers.users;

import helpers.Authorization;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by boris on 9/12/15.
 */
@Security.Authenticated(Authorization.Student.class)
public class StudentController extends Controller {

    public Result test() {
        return ok("you are student");
    }
}