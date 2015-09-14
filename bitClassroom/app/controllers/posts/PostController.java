package controllers.posts;

import helpers.CurrentUserFilter;
import helpers.SessionHelper;
import models.Post;
import models.user.User;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.posts.newpost;

import java.util.List;

/**
 * Created by banjich on 9/14/15.
 */
@Security.Authenticated(CurrentUserFilter.class)
public class PostController extends Controller {

    private final Form<Post> postForm = Form.form(Post.class);

    public Result addPost() {
        return ok(newpost.render(postForm));
    }

    public Result savePost() {
        Form<Post> boundForm = postForm.bindFromRequest();
        User user = SessionHelper.currentUser(ctx());

        String date = boundForm.bindFromRequest().field("date").value();
        String title = boundForm.bindFromRequest().field("title").value();
        String message = boundForm.bindFromRequest().field("content").value();
        String mentor = boundForm.bindFromRequest().field("visible").value();
        String type = boundForm.bindFromRequest().field("post-type").value();

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
            Post post = new Post(title, message, typeOfPost, visible, user, date);
            post.save();
            flash("success", "You successfully added new post.");
            return redirect("/"); // TODO add call to route for listing posts
        }
        flash("warning", "Could not save your post.");
        return redirect("/");

    }

//    public Result listPosts() {
//        List<Post> posts = Post.findAllPosts();
//        return ok(allPosts.render(Post.descOrder(posts)));
//    }
}
