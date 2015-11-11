package models.course;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by NN on 11.11.2015.
 */

@Entity
public class PremiumCourse extends Model{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false)
    private Long id;
    @Column(name = "price")
    private String price;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "course")
    @OneToOne
    private Course course;

    private static Finder<Long, PremiumCourse> finder = new Finder<>(PremiumCourse.class);

    public static Finder<Long, PremiumCourse> getFinder() {
        return finder;
    }

    public PremiumCourse() {

    }

    public PremiumCourse(String price, Course course, String quantity) {
        this.price = price;
        this.course = course;
        this.quantity = quantity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }
}
