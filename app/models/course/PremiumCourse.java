package models.course;

import com.avaje.ebean.Model;
import com.avaje.ebean.Expr;
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
    @Column(name = "quantity_bitbay")
    private Integer quantityBitbay;
    @Column(name = "quantityBooking")
    private Integer quantityBooking;
    @Column(name = "course")
    @OneToOne
    private Course course;

    @Column(name = "bit_bay")
    public String premiumIdBitBay;

    @Column(name = "bit_booking")
    public String premiumIdBitBooking;

    private static Finder<Long, PremiumCourse> finder = new Finder<>(PremiumCourse.class);

    public static Finder<Long, PremiumCourse> getFinder() {
        return finder;
    }

    public PremiumCourse() {

    }

    public PremiumCourse(String price, Course course, Integer quantityBitbay, Integer quantityBooking) {
        this.price = price;
        this.course = course;
        this.quantityBitbay = quantityBitbay;
        this.quantityBooking = quantityBooking;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getQuantityBitbay() {
        return quantityBitbay;
    }

    public void setQuantityBitbay(Integer quantity) {
        this.quantityBitbay = quantity;
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

    public static Course findCourseByPremiumId(String premiumId){
        return finder.where().or(Expr.eq("bit_bay",premiumId),Expr.eq("bit_booking",premiumId)).findUnique().getCourse();
    }

    public static PremiumCourse findByPremiumId(String premiumId){
        return finder.where().or(Expr.eq("bit_bay",premiumId),Expr.eq("bit_booking",premiumId)).findUnique();
    }

    public Integer getQuantityBooking() {
        return quantityBooking;
    }

    public void setQuantityBooking(Integer quantityBooking) {
        this.quantityBooking = quantityBooking;
    }
}
