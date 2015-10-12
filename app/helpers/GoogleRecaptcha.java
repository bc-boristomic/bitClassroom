package helpers;


import com.fasterxml.jackson.databind.JsonNode;
import play.Play;
import play.libs.F;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;

/**
 * Created by gordan.masic on 05/10/15.
 */
public class GoogleRecaptcha {
    public static Boolean verifyGoogleRecaptcha(WSClient ws, String recaptcha) {

        WSRequest request = ws.url(Play.application().configuration().getString("recaptchaVerificationUrl"));
        request.setQueryParameter("secret", Play.application().configuration().getString("recaptchaKey"));
        request.setQueryParameter("response", recaptcha);


        F.Promise<JsonNode> responsePromise = request.get().map(response -> {
            return response.asJson();
        });

        JsonNode node = responsePromise.get(3000);
        String verified = node.findPath("success").asText();

        return verified.equals("true") ? true : false;
    }
}
