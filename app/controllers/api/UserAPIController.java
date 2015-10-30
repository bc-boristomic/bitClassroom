package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.user.Mentorship;
import models.user.User;
import org.joda.time.DateTime;
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
        map.put("user_id",u.getId());
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
        List<String> courseIds = new ArrayList<>();
        for(Course c: courseList){
            courseNames.add(c.getName());
            courseDescriptions.add(c.getDescription());
            courseTeacherNames.add(c.getTeacher());
            courseIds.add(c.getId().toString());
        }

        JSONArray jsonArray = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("names",courseNames);

            JSONObject object1 = new JSONObject();

            object1.put("descriptions",courseDescriptions);

            JSONObject object2 = new JSONObject();
            object2.put("teachers",courseTeacherNames);

            JSONObject object3 = new JSONObject();
            object3.put("course_id",courseIds);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);

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
        List<String> studentIds = new ArrayList<>();
        for(User student: students){
            studentNames.add(student.getFirstName());
            studentLastnames.add(student.getLastName());
            studentRoles.add(student.getRoles().get(0).getName());
            studentTokens.add(student.getToken());
            studentIds.add(student.getId().toString());
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

        JSONObject object4 = new JSONObject();
        object4.put("user_id",studentIds);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);
        jsonArray.add(object4);
        JsonNode jsonNode = Json.toJson(jsonArray);
        return ok(jsonNode);
    }

    public Result sendPosts() {
        JsonNode json = request().body().asJson();
        String id = json.findPath("course_id").textValue();
        Course course = Course.findById(Long.parseLong(id));

        if(course == null){
            return badRequest();
        }
        List <Post> posts = course.getPosts();
        List <String> postNames = new ArrayList<>();
        List <String> postContents = new ArrayList<>();
        List <String> postTimestamps = new ArrayList<>();
        List <String> postDueDates = new ArrayList<>();
        List <String> postUsers = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            postNames.add(posts.get(i).getTitle());
            postContents.add(posts.get(i).getContent());
            postTimestamps.add(posts.get(i).getCreateDate());
            postDueDates.add(posts.get(i).getDate() + " " + posts.get(i).getTime());
            postUsers.add(posts.get(i).getUser().getFirstName() + " " + posts.get(i).getUser().getLastName());
        }

        JSONArray jsonArray = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("names",postNames);

        JSONObject object1 = new JSONObject();
        object1.put("contents", postContents);

        JSONObject object2 = new JSONObject();
        object2.put("timestamps", postTimestamps);

        JSONObject object3 = new JSONObject();
        object3.put("duedates",postDueDates);

        JSONObject object4 = new JSONObject();
        object4.put("users",postUsers);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);
        jsonArray.add(object4);
        JsonNode jsonNode = Json.toJson(jsonArray);

        return ok(jsonNode);
    }

    public String formatDate(DateTime date){
        return String.format("%s.%s.%s at %s:%s",date.getDayOfMonth(),date.getMonthOfYear(),date.getYear(),date.getHourOfDay(),date.getMinuteOfHour());
    }

    public Result sendAllMessages(){
        JsonNode json = request().body().asJson();
        String id = json.findPath("user_id").textValue();

        if(id == null){
            return badRequest();
        }

        List<PrivateMessage> sendMessages = PrivateMessage.getSentMessages(Long.parseLong(id));
        List<PrivateMessage> receivedMessages = PrivateMessage.getReceivedMessages(Long.parseLong(id));


        List <String> senders = new ArrayList<>();
        List <String> titlesSent = new ArrayList<>();
        List <String> contentsSent = new ArrayList<>();
        List <String> dateTimesSent = new ArrayList<>();
        List <String> receivers = new ArrayList<>();
        List <String> titlesReceived = new ArrayList<>();
        List <String> contentsReceived = new ArrayList<>();
        List <String> dateTimesReceived = new ArrayList<>();


        for(PrivateMessage messageSent: sendMessages){
            senders.add(messageSent.getSender().getFirstName() + " " + messageSent.getSender().getLastName());
            titlesSent.add(messageSent.getSubject());
            contentsSent.add(messageSent.getContent());
            dateTimesSent.add(formatDate(messageSent.getCreationDate()));
        }
        for(PrivateMessage messageReceived: receivedMessages){
            receivers.add(messageReceived.getSender().getFirstName() + " " + messageReceived.getSender().getLastName());
            titlesReceived.add(messageReceived.getSubject());
            contentsReceived.add(messageReceived.getContent());
            dateTimesReceived.add(formatDate(messageReceived.getCreationDate()));
        }


        JSONArray jsonArray = new JSONArray();

        JSONObject object = new JSONObject();
        object.put("sender", senders);

        JSONObject object1 = new JSONObject();
        object1.put("title_sent", titlesSent);

        JSONObject object2 = new JSONObject();
        object2.put("content_sent", contentsSent);

        JSONObject object3 = new JSONObject();
        object3.put("dateTime_sent", dateTimesSent);

        JSONObject object4 = new JSONObject();
        object4.put("receiver", receivers);

        JSONObject object5 = new JSONObject();
        object5.put("title_rec", titlesReceived);

        JSONObject object6 = new JSONObject();
        object6.put("content_rec", contentsReceived);

        JSONObject object7 = new JSONObject();
        object7.put("dateTime_rec", dateTimesReceived);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);
        jsonArray.add(object4);
        jsonArray.add(object5);
        jsonArray.add(object6);
        jsonArray.add(object7);
        JsonNode jsonNode = Json.toJson(jsonArray);
        return ok(jsonNode);
    }

}
