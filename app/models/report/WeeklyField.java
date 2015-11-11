package models.report;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Enver on 9/29/2015.
 */
@Entity
@Table(name = "weekly_field")
public class WeeklyField extends Model{

    private static Finder<Long, WeeklyField> finderFieldWeekly = new Finder<Long, WeeklyField>(WeeklyField.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    /**
     * Default empty constructor for Ebean
     */
    public WeeklyField() {
    }

    public static Finder<Long, WeeklyField> getFinder() {
        return finderFieldWeekly;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Finds unique Weekly Field by id
     * @param id Long
     * @return Weekly Field
     */
    public static WeeklyField findFielWeeklydById(Long id) {
        List<WeeklyField> weeklyField = finderFieldWeekly.where().eq("id", id).findList();
        if (weeklyField.size() == 0) {
            return null;
        }
        return (WeeklyField) weeklyField.get(0);
    }
}