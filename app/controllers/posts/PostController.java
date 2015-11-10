package controllers.posts;

import helpers.Authorization;
import helpers.CloudHelper;
import helpers.SessionHelper;
import models.CloudFile;
import models.Post;
import models.PrivateMessage;
import models.course.CourseUser;
import models.user.Assignment;
import models.user.Role;
import models.user.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Security;
import utility.UserConstants;
import views.html.posts.assignmentView;
import views.html.posts.editpost;
import views.html.posts.newpost;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import models.course.Course;


/**
 * Created by banjich on 9/14/15.
 */
@Security.Authenticated(Authorization.FullyActiveUser.class)
public class PostController extends Controller {

    private final Form<Post> postForm = Form.form(Post.class);
    private List<String> filesList = new ArrayList<>();
    private static List<String> deletedFiles = new ArrayList<>();
    private static List<CloudFile> cloud = new ArrayList<>();


    /**
     * Adding post and refresh the page with added post
     */
    public Result addPost() {
        return ok(newpost.render(postForm, SessionHelper.currentUser(ctx()), CourseUser.allUserCourses(SessionHelper.currentUser(ctx()))));
    }

    /**
     * Method for get view for edit post
     * @param id - selected post
     * @return
     */
    public Result editPost(Long id){
        Post post = Post.findPostById(id);

        return ok(editpost.render(postForm, post));
    }

    /**
     * MEthod for get assignment details
     * @param id - long Id of selected post
     * @return
     */
    public Result assignmentDetails(Long id){

        Post post = Post.findPostById(id);

        return ok(assignmentView.render(post));

    }

    /**
     * Getting http request
     * Getting user from session
     * Saving post in database
     */

    public Result deleteFile(){
        DynamicForm form = Form.form().bindFromRequest();
        String s = form.data().get("file");
        deletedFiles.add(s);

        return ok();
    }

    /**
     * Method for update post.Used when post is edited.
     * @param id - long id of selected Post
     * @return
     */
    public Result saveEditedPost(Long id){
        Form<Post> boundForm = postForm.bindFromRequest();

        Post post = Post.findPostById(id);
        User user = SessionHelper.currentUser(ctx());

        MultipartFormData data = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> files = data.getFiles();


        for(int j= 0;j < deletedFiles.size(); j++){
            Logger.error(deletedFiles.get(j));
            for(int i = 0; i< post.getFiles().size(); i++){
                if(post.getFiles().get(i).getFileName().contains(deletedFiles.get(j))){
                    post.getFiles().get(i).deleteFile();
                }
            }
        }

        if (files != null) {
            String fName = null;
            for (Http.MultipartFormData.FilePart filePart : files) {
                fName = filePart.getFilename();
                File file = filePart.getFile();
                try {
                    CloudHelper.uploadToCloud(file,fName, post.getId());
                    filesList.add(fName);
                } catch (Exception e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
        }
        String title = boundForm.field("title").value();
        String content = boundForm.field("content").value();
        String link = boundForm.field("link").value();

        if(user != null && user.getRoles().size() > 0 && user.getRoles() != null){
            for(Role r: user.getRoles()){
                if(r.getId().equals(UserConstants.TEACHER)){
                    String date = boundForm.field("date").value();
                    String time = boundForm.field("time").value();

                    if(date != null && time != null) {
                        post.setPostType(1);
                        post.setDate(date);
                        post.setTime(time);
                    }
                }
            }
        }
        deletedFiles.clear();

        post.setTitle(title);
        post.setContent(content);
        post.setLink(link);
        post.update();

        return redirect("/user/class/" + post.getCourse().getId());
    }

    /**
     * Method for save new post. With boundForm we get all entered informastion of post:
     * posts title, posts content, posts link,
     * posts files, post type, is visible to mentors.
     *
     * Also this method used for save new assignment if post type is 1, and to all classmates add this assignment in they works.
     *
     * @return
     */
    public Result savePost() {

        Form<Post> boundForm = postForm.bindFromRequest();
        String selectedCourse = boundForm.bindFromRequest().field("course").value();
        User user = SessionHelper.currentUser(ctx());

        Post post = new Post();
        post.save();
        MultipartFormData data = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> files = data.getFiles();

        if (files != null) {
            String fName = null;
            for (Http.MultipartFormData.FilePart filePart : files) {
                fName = filePart.getFilename();
                File file = filePart.getFile();
                try {
                    CloudHelper.uploadToCloud(file,fName, post.getId());
                    filesList.add(fName);
                } catch (Exception e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
        }


        String title = boundForm.field("title").value();
        String message = boundForm.field("content").value();
        String link = boundForm.field("link").value();
        String mentor = boundForm.field("visible").value();
        String type = boundForm.field("post-type").value();

        Boolean visible = false;
        if ("on".equals(mentor)) {
            visible = true;
        }


        if(user != null && user.getRoles().size() > 0 && user.getRoles() != null){
            for(Role r: user.getRoles()){
                if(r.getId().equals(UserConstants.TEACHER)){
                    String date = boundForm.field("date").value();
                    String time = boundForm.field("time").value();
                    Integer typeOfPost = 0;
                    if (type.equals("1")) {
                        typeOfPost = 1; //type 1 assignment
                    }

                    post.setPostType(typeOfPost);
                    post.setDate(date);
                    post.setTime(time);
                }
            }
        }

        if (user != null && selectedCourse!= null) {

            Course course = Course.findById(Long.parseLong(selectedCourse));
            post.setTitle(title);
            post.setContent(message);
            post.setUser(user);
            post.setLink(link);
            post.setVisibleToMentors(visible);
            post.setCourse(course);
            post.update();
            course.getPosts().add(post);

            if (post.getPostType().equals(1)) {
                for (int i = 0; i < CourseUser.allUserFromCourse(course.getId()).size(); i++) {
                    Assignment a = new Assignment();
                    a.setUser(CourseUser.allUserFromCourse(course.getId()).get(i));
                    a.setPost(post);
                    a.setHomeworkPostStatus(0);
                    a.save();
                }
            }

            List<User> classmates = CourseUser.allUserFromCourse(Long.parseLong(selectedCourse));
            for ( int i = 0; i < classmates.size(); i++){
                if(classmates.get(i).getId() != SessionHelper.currentUser(ctx()).getId()) {
                    postNotification(classmates.get(i), post, course);
                }
            }

            flash("success", "You successfully added new post.");
            return redirect("/user/class/" + Long.parseLong(selectedCourse)); // TODO add call to route for listing posts
        }
        flash("warning", "Could not save your post.");
        return redirect("/admin");

    }


    /**
     * Method for send notification to all users in class when someone posted new post.
     * @param student - Type of user
     * @param post - used for get post type.
     * @param course - used for Course information in notification
     */
    public void postNotification(User student, Post post, Course course) {

        String type;
        if(post.getPostType() == 1){
            type = "Assignment";
        }else{
            type = "Announcement";
        }

        User sender = SessionHelper.currentUser(ctx());
        String subject = course.getName() +" " + course.getDescription()+ " " + type;
        String content = sender.getFirstName() +" " + sender.getLastName() + " posted " + type +" to " + course.getName()+"." ;
        PrivateMessage privMessage = PrivateMessage.create(subject, content, sender, student);
        privMessage.setStatus(0);
        student.getMessages().add(privMessage);
        student.save();

    }

}
