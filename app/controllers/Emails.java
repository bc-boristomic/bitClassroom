package controllers;


import helpers.GoogleRecaptcha;
import models.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import play.Logger;
import play.Play;
import play.data.Form;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by gordan.masic on 05/10/15.
 */
public class Emails extends Controller {
    private static Form<Email> mailForm = Form.form(Email.class);

    @Inject WSClient ws;
    public Result sendMail() {

        String user_name = mailForm.bindFromRequest().field("user_name").value();
        Logger.info("-----"+user_name+"-------");
        String mail = mailForm.bindFromRequest().field("mail").value();
        Logger.info("-----"+mail+"-------");
        String subject = mailForm.bindFromRequest().field("subject").value();
        Logger.info("-----"+subject+"-------");
        String message = mailForm.bindFromRequest().field("message").value();
        Logger.info("-----"+message+"-------");

        String recaptcha = mailForm.bindFromRequest().field("g-recaptcha-response").value();

        Boolean verify = GoogleRecaptcha.verifyGoogleRecaptcha(ws, recaptcha);

        if (verify) {
            SimpleEmail email = new SimpleEmail();
            email.setHostName(Play.application().configuration().getString("smtp.host"));
            email.setSmtpPort(587);
            try {
                email.setFrom(Play.application().configuration().getString("mailFrom"));
                email.setAuthentication(Play.application().configuration().getString("mailFromPass"), Play.application().configuration().getString("mail.smtp.pass"));
                email.setStartTLSEnabled(true);
                email.setDebug(true);
                email.addTo(Play.application().configuration().getString("mail.smtp.user"));
                email.setSubject(subject);
                email.setMsg(user_name + "\n" + mail + "\n\n"+subject +"\n" + message);

                email.send();
            } catch (EmailException e) {
                e.printStackTrace();
            }
            return redirect(routes.Application.index());
        } else {
            flash("error", "Not validated");
            return redirect(routes.Application.index());
        }
    }

}
