import controllers.routes;
import models.user.User;
import org.junit.Test;
import play.mvc.Result;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

import static org.fest.assertions.Assertions.*;

public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://localhost:3333");
            assertTrue(browser.pageSource().contains("About"));
        });
    }

    /**
     * Checks if user successfully logged in.
     */
    @Test
    public void testLogin() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
            browser.goTo("http://localhost:3333/login");

            User temp = new User();
            temp.setEmail("boris.tomic@bitcamp.ba");
            temp.setPassword("password");
            temp.save();

            browser.fill("#inputEmail").with("boris.tomic@bitcamp.ba");
            //String hash = MD5Hash.getEncriptedPasswordMD5("password");
            browser.fill("#inputPassword").with("password");

            List<User> u = User.findAll();
            //Logger.info("SEE ALL RESULTS" + u.toString() + "SEE ALL RESULTS");

            browser.submit("#login");
            //browser.click("#login");

            Result result = route(routes.Application.login());
            //assertThat(result.status(), isEqualsTo(SEE_OTHER));
            assertEquals(result.status(), SEE_OTHER);

        });
    }
}
