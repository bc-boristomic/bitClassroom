package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

/**
 * Created by gordan.masic on 05/10/15.
 */
public class Email extends Model {

    @Constraints.Required(message = "Required field!")
    private String name;

    @Constraints.Required(message = "Required field!")
    private String mail;

    @Constraints.Required(message = "Required field!")
    private String message;

    public Email(){

    }
    public Email(String name, String mail, String message) {
        this.name = name;
        this.mail = mail;
        this.message = message;
    }

    public String toString() {
        return String.format("%s,%s,%s", name, mail, message);
    }

//    public List<ValidationError> validate(){
//        List<ValidationError> errors = new ArrayList<>();
//
//        return null;
//    }
}
