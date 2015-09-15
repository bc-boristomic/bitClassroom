import models.user.User;
import org.junit.*;

import play.Logger;
import play.mvc.*;
import play.test.*;
import play.libs.F.*;
import utility.MD5Hash;

import java.util.List;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest extends WithApplication {

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

//    /**
//     * Checks if user successfully logged in.
//     */
//    @Test
//    public void testLogin() {
//        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, browser -> {
//            browser.goTo("http://localhost:3333/login");
//
//        User temp = new User();
//        temp.setEmail("login@test.com");
//        temp.setPassword("password1L!");
//        temp.save();
//
//        browser.fill("#inputEmail").with("login@test.com");
//            //String hash = MD5Hash.getEncriptedPasswordMD5("password");
//        browser.fill("#inputPassword").with("password1L!");
//
//            List<User> u =User.findAll();
//        //Logger.info("SEE ALL RESULTS" + u.toString() + "SEE ALL RESULTS");
//
//            //browser.submit("#login");
//        browser.click("#login");
//
//            assert
//        assertTrue(browser.pageSource().contains("Ovdje ubaciti kod"));
//
//        });
//    }
}
