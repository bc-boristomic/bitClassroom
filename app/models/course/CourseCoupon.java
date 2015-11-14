package models.course;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Korisnik on 11/12/2015.
 */
@Entity
public class CourseCoupon extends Model {

    @Id
    private Long id;

    private Course course;

    private String code;

    public CourseCoupon(Course course, String code) {
        this.course = course;
        this.code = code;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
