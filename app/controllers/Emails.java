package controllers;


import com.avaje.ebean.Ebean;
import helpers.GoogleRecaptcha;
import models.Email;
import models.ErrorLog;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import play.Logger;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.newMain;

import javax.inject.Inject;

/**
 * Created by gordan.masic on 05/10/15.
 */
public class Emails extends Controller {
    private static Form<Email> mailForm1 = Form.form(Email.class);

    @Inject WSClient ws;
    public Result sendMail() {
        DynamicForm mailForm = Form.form().bindFromRequest();
        String userName = mailForm.get("name");
        String mail = mailForm.get("mail");
        String subject = mailForm.get("subject");
        String message = mailForm.get("message");
        String recaptcha = mailForm.get("g-recaptcha-response");
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
                email.setMsg(userName + "\n" + mail + "\n\n"+subject +"\n" + message);

                email.send();
            } catch (EmailException e) {
                Ebean.save(new ErrorLog(e.getMessage()));
                e.printStackTrace();
            }
            return redirect(routes.Application.index());
        } else {
            flash("error", "Not validated");
            return redirect(routes.Application.index());
        }
    }

    @Inject WSClient wsU;
    public Result sendUserMail() {
        DynamicForm mailForm = Form.form().bindFromRequest();
        String userName = mailForm.get("name");
        String mail = mailForm.get("mail");
        String subject = mailForm.get("subject");
        String message = mailForm.get("message");
        String recaptcha = mailForm.get("g-recaptcha-response");
        Boolean verify = GoogleRecaptcha.verifyGoogleRecaptcha(wsU, recaptcha);

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
                email.setMsg(userName + "\n" + mail + "\n\n"+subject +"\n" + message);

                email.send();
            } catch (EmailException e) {
                Ebean.save(new ErrorLog(e.getMessage()));
                e.printStackTrace();
            }
            return redirect("/");
        } else {
            flash("error", "Not validated");
            return redirect("/");
        }
    }

}
