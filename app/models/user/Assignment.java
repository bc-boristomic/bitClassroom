package models.user;

import com.avaje.ebean.Model;
import models.Post;
import play.Logger;

import javax.persistence.*;
import java.util.List;

/**
 * Created by becir.omerbasic on 12/10/15.
 */
@Entity
public class Assignment extends Model {

    private static Finder<Long, Assignment> finder = new Finder<>(Assignment.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
    @Column(name = "homework_post_status", length = 1)
    private Integer homeworkPostStatus;

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }

    public Integer getHomeworkPostStatus() {
        return homeworkPostStatus;
    }

    public void setHomeworkPostStatus(Integer homeworkPostStatus) {
        this.homeworkPostStatus = homeworkPostStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Find assignment by user and post
     * @param currentUser - User
     * @param post - Post
     * @return Assignment
     */
    public static Assignment findCurrentAssignment(User currentUser, Post post){
        Logger.debug(currentUser.getId() + "    : " + post.getId() + "     ");
      return  finder.where().eq("user_id", currentUser.getId()).eq("post_id", post.getId()).findUnique();
    }

    /**
     * Find all assignments for given user
     * @param user - User
     * @return List of assignments
     */
    public static List<Assignment> findAllAssignmentsPerUser(User user){
        List<Assignment> assignments = finder.where().eq("user_id",user.getId()).findList();
        return assignments;
    }



}
