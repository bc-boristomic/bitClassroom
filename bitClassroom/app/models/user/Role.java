//package models.user;
//
//import com.avaje.ebean.Model;
//import org.joda.time.DateTime;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * Created by becir on 9/12/15.
// */
//@Entity
//@Table(name = "role")
//public final class Role extends Model {
//
//    private static Finder<Long, Role> finder = new Finder<>(Role.class);
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "name", length = 10)
//    private String name;
//    @Column(name = "description", length = 500)
//    private String description;
//    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
//    private DateTime createdDate = new DateTime();
//    @Column(name = "created_by", updatable = false)
//    private String createdBy;
//    @OneToMany(mappedBy = "role")
//    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
//    private List<UserRole> userRoles;
//
//    /**
//     * Default empty constructor for Ebean
//     */
//    public Role() {
//    }
//
//    public static Finder<Long, Role> getFinder() {
//        return finder;
//    }
//
//    /**
//     * Returns list of all Roles from database
//     *
//     * @return <code>List</code> type of Roles
//     */
//    public static List<Role> findAll() {
//        return finder.all();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//
//}