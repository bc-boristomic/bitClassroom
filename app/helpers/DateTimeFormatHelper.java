package helpers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Enver on 10/17/2015.
 */
public class DateTimeFormatHelper {


    public static String getCurrentDateFormated() {
        return new SimpleDateFormat("EEE, dd.MM.yyyy - HH:mm").format(new Date());
    }
    public String printDateTime(){
        DateTime dt = new DateTime();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("EEE, dd.MM.yyyy - HH:mm");
        return dtf.print(dt);
    }

}
