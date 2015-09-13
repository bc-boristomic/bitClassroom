//package models;
//
//import com.avaje.ebean.Model;
//import org.joda.time.DateTime;
//import play.data.validation.Constraints;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Author: Medina Banjic
// */
//@Entity
//public class Post extends Model {
//
//    public static final int ASSIGNMENT = 1;
//    public static final int ANNOUNCEMENT = 2;
//
//    @Id
//    private Long id;
//
//    @Column(columnDefinition = "TEXT")
//    @Constraints.Required
//    private String content;
//
//    @ManyToOne
//    private User user;
//
//    @Column(name="title")
//    private String title;
//
//    @Column(name="post_type")
//    private Integer postType;
//
//    @Column(name="visible_mentors")
//    private Integer visibleToMentors;
//
//    @Column(name="date_create", columnDefinition = "datetime")
//    private DateTime dateTime = new DateTime();
//
//    public Post(String content, String title, Integer visible, User user) {
//        this.content = content;
//        this.title = title;
//        this.visibleToMentors = visible;
//        this.user = user;
//    }
//
//    public static final Model.Finder<Long, Post> find = new Model.Finder<>(
//            Post.class);
//
//    private static List<Post> posts = new ArrayList<Post>();
//
//    public static List<Post> findPostsByUser(final User user) {
//        return find
//                .where()
//                .eq("user", user)
//                .findList();
//    }
//
//    public static Post findPostById(Long id) {
//        return find
//                .where()
//                .eq("id", id)
//                .findUnique();
//    }
//
//    public static List<Post> findAllPosts() {
//        return find.all();
//    }
//
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public DateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Integer getPostType() {
//        return postType;
//    }
//
//    public void setPostType(Integer postType) {
//        this.postType = postType;
//    }
//
//    public Integer getVisibleToMentors() {
//        return visibleToMentors;
//    }
//
//    public void setVisibleToMentors(Integer visibleToMentors) {
//        this.visibleToMentors = visibleToMentors;
//    }
//
//    public static boolean remove(Post post) {
//
//        return posts.remove(post);
//    }
//
//    public static List<Post> descOrder(List<Post> post){
//        List<Post> descList = new ArrayList<>();
//        int size = post.size() - 1;
//        if(size > 0){
//            for (int i = size; i >= 0; i--){
//                descList.add(post.get(i));
//            }
//        } else {
//            return post;
//        }
//        return descList;
//    }
//
//    public String toString() {
//        return "Post: " + title + " ["  +
//                content + "]  " +
//                " by: " + user.firstName;
//    }
//}