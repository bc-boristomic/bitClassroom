package controllers.posts;

import helpers.Authorization;
import helpers.CurrentUserFilter;
import helpers.SessionHelper;
import models.Post;
import models.user.User;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import play.Logger;
import play.Play;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.posts.newpost;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by banjich on 9/14/15.
 */
@Security.Authenticated(Authorization.FullyActiveUser.class)
public class PostController extends Controller {

    private final Form<Post> postForm = Form.form(Post.class);

    private List<String> filesList = new ArrayList<>();


    public Result addPost() {
        return ok(newpost.render(postForm));
    }

    public Result savePost() {
        Form<Post> boundForm = postForm.bindFromRequest();
        User user = SessionHelper.currentUser(ctx());

        Post post = new Post();
        MultipartFormData data = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> files = data.getFiles();
        String fileName = "";

        if (files != null) {
            String fName = null;
            for (MultipartFormData.FilePart filePart : files) {
                fName = filePart.getFilename();
                int n = fName.lastIndexOf(".");
                fName = fName.substring(n, fName.length());
                File file = filePart.getFile();
                try {
                    fileName = String.valueOf(new DateTime().getMillis());
                    FileUtils.moveFile(file, new File(Play.application().path() + "/public/files/users/" + user.getId() + "/" + fileName + fName));
                    filesList.add(fileName);
                } catch (IOException e) {
                    Logger.info("Could not move file. " + e.getMessage());
                    flash("error", "Could not move file.");
                }
            }
            post.setFiles(filesList);

        }

        String date = boundForm.bindFromRequest().field("date").value();
        String title = boundForm.bindFromRequest().field("title").value();
        String message = boundForm.bindFromRequest().field("content").value();
        String mentor = boundForm.bindFromRequest().field("visible").value();
        String type = boundForm.bindFromRequest().field("post-type").value();
        String link = boundForm.bindFromRequest().field("").value();

        Boolean visible = false;
        if ("on".equals(mentor)) {
            visible = true;
        }
        //type 0 announcement
        Integer typeOfPost = 0;
        if (type.equals("1")) {
            typeOfPost = 1; //type 1 assignment
        }

        if (user != null) {
            post.setTitle(title);
            post.setContent(message);
            post.setPostType(typeOfPost);
            post.setVisibleToMentors(visible);
            post.setUser(user);
            post.setDate(date);
            post.setLink(link);
            post.save();
            flash("success", "You successfully added new post.");
            return redirect("/"); // TODO add call to route for listing posts
        }
        flash("warning", "Could not save your post.");
        return redirect("/");

    }

}
