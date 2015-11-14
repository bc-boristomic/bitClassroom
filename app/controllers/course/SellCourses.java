package controllers.course;

import com.fasterxml.jackson.databind.JsonNode;
import helpers.ServiceRequest;
import models.course.Course;
import models.course.CourseCoupon;
import models.course.PremiumCourse;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utility.MailHelper;

import java.util.UUID;

/**
 * Created by Korisnik on 11/12/2015.
 */
public class SellCourses extends Controller {

    public Result payCourses(){

        if(request().getHeader("secret_key").equals(ServiceRequest.KEY)){

            JsonNode jsonNode = request().body().asJson();
            String email = jsonNode.findPath("user_email").asText();
            String premiumId = jsonNode.findPath("premium_id").asText();

            Logger.info("----" + email + "-----" + premiumId + "---------");

            Course course = PremiumCourse.findCourseByPremiumId(premiumId);
            PremiumCourse premiumCourse = PremiumCourse.findByPremiumId(premiumId);
            if(premiumId.indexOf("bitbay") != -1) {
                premiumCourse.setQuantityBitbay(premiumCourse.getQuantityBitbay() - 1);
            }else{
                premiumCourse.setQuantityBooking(premiumCourse.getQuantityBooking() - 1);
            }
            CourseCoupon coupon = new CourseCoupon(course,premiumId+ UUID.randomUUID().toString());
            coupon.save();

            MailHelper.sendCoupon(email, coupon.getCode());

            Logger.info("+++bitbay: " + premiumCourse.getQuantityBitbay() + "++booking: " + premiumCourse.getQuantityBooking() + "++++++++++++");
        }

        JsonNode json = Json.toJson("successfull");

        return ok(json);
    }
}
