package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import models.user.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by boris.tomic on 30/09/15.
 */
public class UserAPIController extends Controller {

    public Result getUsers() {
        List<User> users = User.getFinder().all();
        return ok(play.libs.Json.toJson(users));
    }

    public Result getSpecificUser(Long id) {
        return ok(Json.toJson(User.getFinder().byId(id)));
    }

    public Result createUser() {
        JsonNode json = request().body().asJson(); //with headers json
        User user = Json.fromJson(json, User.class);
        user.save();
        return created(play.libs.Json.toJson(user));
    }

    public Result updateUser(Long id) {
        User user = Json.fromJson(request().body().asJson(), User.class);
        user.update();
        return ok(Json.toJson(user));
    }

    public Result deleteUser(Long id) {
        User user = User.findById(id);
        user.delete();
        return noContent();
    }


}
