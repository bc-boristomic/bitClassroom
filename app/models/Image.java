package models;

import com.avaje.ebean.Model;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import helpers.SessionHelper;
import models.course.Course;
import models.user.User;
import play.Logger;
import play.mvc.Http;

import javax.persistence.*;
import java.io.File;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by neo on 10/05/2015.
 *
 */
@Entity
public class Image extends Model {

    // Declaring variable.
    private static Finder<String, Image> finder =
            new Finder<>(Image.class);

    public static Cloudinary cloudinary;

    @Id
    public Long id;

    public String public_id;

    public String secret_image_url;

    public String image_url;

    @ManyToOne
    public User user;

    @OneToOne
    Course course;


    public static Image create(String public_id, String image_url, String secret_image_url) {
        Image img = new Image();
        img.public_id = public_id;
        img.image_url = image_url;
        img.secret_image_url = secret_image_url;
        img.save();
        return img;
    }

    public static Image create(File image, Long id) {
        Map result;
        try {
            result = cloudinary.uploader().upload(image, null);
            return create(result, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Image createCourseImage(File image, Long id) {
        Map result;
        try {
            result = cloudinary.uploader().upload(image, null);
            return courseImage(result, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image courseImage(Map uploadResult,Long id){
        Image img = new Image();
        img.public_id = (String) uploadResult.get("public_id");
        Logger.debug(img.public_id);
        img.image_url = (String) uploadResult.get("url");
        Logger.debug(img.image_url);
        img.secret_image_url = (String) uploadResult.get("secure_url");
        Logger.debug(img.secret_image_url);
        Course course = Course.findById(id);
        img.course = course;
        img.save();
        return img;
    }

    public static Image create(Map uploadResult, Long id) {
        Image img = new Image();

        img.public_id = (String) uploadResult.get("public_id");
        Logger.debug(img.public_id);
        img.image_url = (String) uploadResult.get("url");
        Logger.debug(img.image_url);
        img.secret_image_url = (String) uploadResult.get("secure_url");
        Logger.debug(img.secret_image_url);
        User user = SessionHelper.currentUser(Http.Context.current());
        img.user = user;
        img.save();
        return img;
    }

    public static List<Image> all() {
        return finder.all();
    }

//    public static String getImagePath(User user) {
//        List<Image> image = Image.finder.where().eq("user", user).findList();
//        if (image.size() > 0) {
//            return image.get(0).image_url;
//        } else {
//            return "http://placehold.it/450x600";
//        }
//    }

    public String getSize(int width, int height) {

        String url = cloudinary.url().format("jpg")
                .transformation(new Transformation().width(width).height(height).crop("fill"))
                .generate(public_id);

        return url;
    }

    public String getThumbnail(Integer width, Integer height){
        String url = cloudinary.url().format("png")
                .transformation(
                        new Transformation().width(width).height(height).crop("fill"))
                .generate(public_id);
        return url;
    }

    public void deleteImage() {
        try {
            cloudinary.uploader().destroy(public_id, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAvatar(){
        String url = cloudinary.url().format("png").transformation( new Transformation().width(32).height(32).crop("thumb").gravity("face").radius("max")).generate(public_id);
        return url;
    }



}