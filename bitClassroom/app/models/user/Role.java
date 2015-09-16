package models.user;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.List;

/**
 * Created by becir on 9/12/15.
 */
@Entity
@Table(name = "role")
public final class Role extends Model {

    private static Finder<Long, Role> finder = new Finder<>(Role.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 10)
    private String name;



   // private int accessLevel;


    /**
     * Default empty constructor for Ebean
     */
    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Finder<Long, Role> getFinder() {
        return finder;
    }

    /**
     * Returns list of all Roles from database
     *
     * @return <code>List</code> type of Roles
     */
    public static List<Role> findAll() {
        return finder.all();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User role: " + name;
    }
}