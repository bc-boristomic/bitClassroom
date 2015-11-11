package models.report;

import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.List;

/**
 * Created by enver on 9/12/15.
 */
@Entity
@Table(name = "field")
public final class Field extends Model {

    private static Finder<Long, Field> finder = new Finder<>(Field.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", unique = true)
    private String name;

    /**
     * Default empty constructor for Ebean
     */
    public Field() {
    }

    public static Finder<Long, Field> getFinder() {
        return finder;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Finds unique Field by id
     * @param id Long
     * @return Field
     */
    public static Field findFieldById(Long id) {
        List<Field> field = finder.where().eq("id", id).findList();
        if (field.size() == 0) {
            return null;
        }
        return (Field) field.get(0);
    }
}