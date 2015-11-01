package helpers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.user.User;
import play.libs.Json;

/**
 * Created by Mladen13 on 25.10.2015.
 */
public class JSONHelper {

    public static ObjectNode jsonUser(User u){

        ObjectNode user = Json.newObject();
        user.put("id", u.getId());
        user.put("password", u.getPassword());
        user.put("email", u.getEmail());
        return user;

    }

}
