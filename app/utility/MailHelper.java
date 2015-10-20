package utility;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import play.Logger;
import play.Play;

/**
 * Created by Gordan on 12.10.2015.
 */
public class MailHelper {

    public static void send(String email, String message, String message1) {

        try {
            HtmlEmail mail = new HtmlEmail();
            mail.setSubject("bitClassroom Welcome");
            mail.setFrom("bitClassroom <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
            mail.addTo("Contact <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
            mail.addTo(email);
            mail.setMsg(message);
            mail.setHtmlMsg(String
                    .format("<html><body><strong> %s </strong> <p> %s </p> <p> %s </p> <p> %s </p> <p> %s </p> </body></html>",
                            "Thanks for signing up to bitClassroom!",
                            "Please confirm your Email address.\nYour password is: Student123", message,"In case you don't want to use this account or that this mail" +
                                    "is sent to wrong person please click on the link below:",message1));
            mail.setHostName("smtp.gmail.com");
            mail.setStartTLSEnabled(true);
            mail.setSSLOnConnect(true);
            mail.setAuthenticator(new DefaultAuthenticator(
                    Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV"),
                    Play.application().configuration().reference().getString("EMAIL_PASSWORD_ENV")
            ));
            mail.send();
        } catch (Exception e) {
            Logger.warn("Email error: " + e);
        }
    }

    public static void sendContactMessage(String name, String email, String message) {
        if (message != null) {

            try {
                HtmlEmail mail = new HtmlEmail();
                mail.setSubject("bitClassroom Contact Us");
                mail.setFrom("bitClassroom <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
                mail.addTo("Contact <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
                mail.addTo(email);
                mail.setMsg(message);
                mail.setHtmlMsg(String
                        .format("<html><body><strong> %s </strong>: <h4>%s:</h4><p> %s </p> </body></html>",
                                email, name, message));
                mail.setHostName("smtp.gmail.com");
                mail.setStartTLSEnabled(true);
                mail.setSSLOnConnect(true);
                mail.setAuthenticator(new DefaultAuthenticator(
                        Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV"),
                        Play.application().configuration().reference().getString("EMAIL_PASSWORD_ENV")
                ));
                mail.send();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void send(String email, String message) {

        try {
            HtmlEmail mail = new HtmlEmail();
            mail.setSubject("bitClassroom Reset your password!");
            mail.setFrom("bitClassroom <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
            mail.addTo("Contact <" + Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV") + ">");
            mail.addTo(email);
            mail.setMsg(message);
            mail.setHtmlMsg(String
                    .format("<html><body><strong> %s </strong> <p> %s </p> <p> %s </p></body></html>",
                            "Thanks for using bitClassroom!",
                            "Please click on link below to change your password", message));
            mail.setHostName("smtp.gmail.com");
            mail.setStartTLSEnabled(true);
            mail.setSSLOnConnect(true);
            mail.setAuthenticator(new DefaultAuthenticator(
                    Play.application().configuration().reference().getString("EMAIL_USERNAME_ENV"),
                    Play.application().configuration().reference().getString("EMAIL_PASSWORD_ENV")
            ));
            mail.send();
        } catch (Exception e) {
            Logger.warn("Email error: " + e);
        }
    }
}