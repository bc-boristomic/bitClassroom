package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import models.course.Course;
import models.user.Mentorship;
import models.user.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserAPIController extends Controller {

    public Result login(){
        JsonNode json = request().body().asJson();
        String email = json.findPath("email").textValue();
        String password = json.findPath("password").textValue();
        Map<String,Object> map = new TreeMap<>();
        User u = User.findEmailAndPassword(email, password);
        if(u == null){
            return badRequest();
        }
        map.put("name",u.getFirstName());
        map.put("lastname",u.getLastName());
        map.put("token",u.getToken());
        map.put("role",u.getRoles().get(0).getName());
        JsonNode jsonObject = Json.toJson(map);
        return ok(jsonObject);
    }

    public Result sendCourses(){
        JsonNode json = request().body().asJson();
        String token = json.findPath("token").textValue();
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
        List<Course> courseList = Course.findAllCoursesPerUser(u);
        List<String> courseNames = new ArrayList<>();
        List<String> courseDescriptions = new ArrayList<>();
        List<String> courseTeacherNames = new ArrayList<>();
        for(Course c: courseList){
            courseNames.add(c.getName());
            courseDescriptions.add(c.getDescription());
            courseTeacherNames.add(c.getTeacher());
        }

        JSONArray jsonArray = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("names",courseNames);

            JSONObject object1 = new JSONObject();

            object1.put("descriptions",courseDescriptions);

            JSONObject object2 = new JSONObject();
            object2.put("teachers",courseTeacherNames);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);

        JsonNode jsonNode = Json.toJson(jsonArray);

        return ok(jsonNode);
    }

    public Result sendStudents(){
        JsonNode json = request().body().asJson();
        String token = json.findPath("token").textValue();
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
        List<User> students = Mentorship.findStudentsByMentor(u);
        List<String> studentNames = new ArrayList<>();
        List<String> studentLastnames = new ArrayList<>();
        List<String> studentTokens = new ArrayList<>();
        List<String> studentRoles = new ArrayList<>();
        for(User student: students){
            studentNames.add(student.getFirstName());
            studentLastnames.add(student.getLastName());
            studentRoles.add(student.getRoles().get(0).getName());
            studentTokens.add(student.getToken());
        }

        JSONArray jsonArray = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("names",studentNames);

        JSONObject object1 = new JSONObject();

        object1.put("lastnames", studentLastnames);

        JSONObject object2 = new JSONObject();
        object2.put("roles", studentRoles);

        JSONObject object3 = new JSONObject();
        object3.put("tokens",studentTokens);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);

        JsonNode jsonNode = Json.toJson(jsonArray);

        return ok(jsonNode);
    }
}
