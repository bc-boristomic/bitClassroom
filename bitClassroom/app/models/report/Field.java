package models.report;

import com.avaje.ebean.Model;
import javax.persistence.*;


//
//import com.avaje.ebean.Model;
//
//import javax.persistence.*;
//
///**
// * Created by enver on 9/12/15.
// */
@Entity
@Table(name = "field")
public class Field extends Model {

    private static Finder<Long, Field> finder = new Finder<>(Field.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
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
}