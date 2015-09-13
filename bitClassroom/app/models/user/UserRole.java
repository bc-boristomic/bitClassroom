//package models.user;
//
//import com.avaje.ebean.Model;
//import org.joda.time.DateTime;
//
//import javax.persistence.*;
//
///**
// * Created by senadin on 9/12/15.
// */
//@Entity
//@Table(name = "user_role")
//public final class UserRole extends Model {
//
//    private static Finder<Long, UserRole> finder = new Finder<>(UserRole.class);
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
//    private DateTime createdDate = new DateTime();
//    @Column(name = "created_by", updatable = false)
//    private String createdBy;
//    @Column(name = "modified_date", columnDefinition = "datetime")
//    private DateTime modifiedDate;
//    @Column(name = "modified_by")
//    private String modifiedBy;
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id")
//    private Role role;
//
//    /**
//     * Default empty constructor for Ebean
//     */
//    public UserRole() {
//    }
//
//    public static Finder<Long, UserRole> getFinder() {
//        return finder;
//    }
//}