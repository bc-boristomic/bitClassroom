package controllers.api;

import com.fasterxml.jackson.databind.JsonNode;
import models.Event;
import models.Post;
import models.PrivateMessage;
import models.course.Course;
import models.user.Mentorship;
import models.user.User;
import org.joda.time.DateTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.apiCalendar;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserAPIController extends Controller {

    public Result login(){
        JsonNode json = request().body().asJson();
        String email = json.findPath("email").textValue();
        String password = json.findPath("password").textValue();
        Map<String,Object> map = new TreeMap<>();
        User user = User.findEmailAndPassword(email, password);
        if(user == null){
            return badRequest();
        }
        map.put("name",user.getFirstName());
        map.put("lastname",user.getLastName());
//        map.put("token",user.getToken());
        map.put("role",user.getRoles().get(0).getName());
        map.put("user_id",user.getId());
        JsonNode jsonObject = Json.toJson(map);
        response().setHeader("token",user.getToken());
        return ok(jsonObject);
    }

    public Result sendCourses(){
        String token = request().getHeader("userToken");
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
        List<Course> courseList = Course.findAllCoursesPerUser(u);
        List<String> courseNames = new ArrayList<>();
        List<String> courseDescriptions = new ArrayList<>();
        List<String> courseTeacherNames = new ArrayList<>();
        List<String> courseIds = new ArrayList<>();
        List<String> coursePics = new ArrayList<>();
        for(Course c: courseList){
            courseNames.add(c.getName());
            courseDescriptions.add(c.getDescription());
            courseTeacherNames.add(c.getTeacher());
            courseIds.add(c.getId().toString());
            if(c.getImage() != null) {
                coursePics.add(c.getImage().getSize(128, 128));
            }else{
                coursePics.add("http://res.cloudinary.com/dsjagtpwx/image/upload/v1446422806/graduation-cap2_lbwk2j.png");
            }
        }

        JSONArray jsonArray = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("names",courseNames);

            JSONObject object1 = new JSONObject();

            object1.put("descriptions",courseDescriptions);

            JSONObject object2 = new JSONObject();
            object2.put("teachers",courseTeacherNames);

            JSONObject object3 = new JSONObject();
            object3.put("course_id", courseIds);

            JSONObject object4 = new JSONObject();
            object4.put("course_pic", coursePics);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);
        jsonArray.add(object4);

        JsonNode jsonNode = Json.toJson(jsonArray);

        return ok(jsonNode);
    }

    public Result sendStudents(){
        String token = request().getHeader("userToken");
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
        List<String> studentPics = new ArrayList<>();
        for(User student: students){
            studentNames.add(student.getFirstName());
            studentLastnames.add(student.getLastName());
            studentRoles.add(student.getRoles().get(0).getName());
            studentTokens.add(student.getToken());
            studentIds.add(student.getId().toString());
            if(student.getProfilePicture().size() != 0) {
                studentPics.add(student.getProfilePicture().get(student.getProfilePicture().size() - 1).getAvatar());
            }else{
                studentPics.add("http://res.cloudinary.com/dsjagtpwx/image/upload/v1446422579/user43_zotlwc.png");
            }
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

        JSONObject object5 = new JSONObject();
        object5.put("user_pic",studentPics);

        jsonArray.add(object);
        jsonArray.add(object1);
        jsonArray.add(object2);
        jsonArray.add(object3);
        jsonArray.add(object4);
        jsonArray.add(object5);
        JsonNode jsonNode = Json.toJson(jsonArray);
        return ok(jsonNode);
    }

    public Result sendPosts() {
        String token = request().getHeader("userToken");
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
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
        String token = request().getHeader("userToken");
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
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

    public Result sendMessage() {
        String token = request().getHeader("userToken");
        User u = User.findUserByToken(token);
        if(u == null){
            return badRequest();
        }
        JsonNode json = request().body().asJson();
        String subject = json.findPath("subject").textValue();
        String message = json.findPath("message").textValue();
        String receiverId = json.findPath("receiver").textValue();
        String senderId = json.findPath("sender").textValue();

        User receiver = User.findById(Long.parseLong(receiverId));
        User sender = User.findById(Long.parseLong(senderId));

        PrivateMessage privMessage = PrivateMessage.create(subject, message, sender, receiver);
        privMessage.setStatus(0);
        receiver.getMessages().add(privMessage);
        receiver.save();
        JSONObject object = new JSONObject();

        object.put("response","ok");
        JsonNode jsonNode = Json.toJson(object);
        return ok(jsonNode);
    }


    public static Long courseId;
    public static Course course;
    public  Result calendar(Long id) {
        courseId = id;
        course = Course.findById(id);
        return ok(apiCalendar.render(course));
    }


    /**
     * Returns list of events for calendar view
     * @param start Long Timestamp of current view start
     * @param end Long Timestamp of current view end
     * @return Result
     */
    public  Result json(Long start, Long end) {

        Date startDate = new Date(start*1000);
        Date endDate = new Date(end*1000);

        List<Event> courseEvent = new ArrayList<>();
        List<Event> resultList = Event.findInDateRange(startDate, endDate);
        for ( int i = 0; i < resultList.size(); i++){
            if(resultList.get(i).getCourse().getId().equals(courseId)){
                courseEvent.add(resultList.get(i));
            }
        }
        ArrayList<Map<Object, Serializable>> allEvents = new ArrayList<Map<Object, Serializable>>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Event event : courseEvent) {
            Map<Object, Serializable> eventRemapped = new HashMap<Object, Serializable>();
            eventRemapped.put("id", event.getId());
            eventRemapped.put("title", event.getTitle());
            eventRemapped.put("start", df.format(event.getStart()));
            eventRemapped.put("end", df.format(event.getEnd()));
            eventRemapped.put("allDay", event.getAllDay());
            eventRemapped.put("url", "/calendar/event/"+event.getId().toString());

            allEvents.add(eventRemapped);

        }
        Logger.info(allEvents.toString());
        JSONArray obj = new JSONArray();
        obj.addAll(allEvents);

        return ok(obj.toJSONString());
    }
}
