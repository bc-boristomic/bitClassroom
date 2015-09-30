import java.util.*;

import controllers.routes;
import com.fasterxml.jackson.databind.JsonNode;

import models.Post;
import models.report.DailyReport;
import models.user.User;
import org.joda.time.DateTime;
import org.junit.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import play.api.routing.Router;
import play.Logger;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;
import static org.fest.assertions.Assertions.*;
import org.openqa.selenium.Cookie;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {

    @Before
    public void configureDatabase() {
        fakeApplication(inMemoryDatabase());
    }



    /**
     * Checks if user table is empty
     */
    @Test
    public void testDatabase() {
        List<User> users = User.findAll();
        assertNotNull(users);
    }

    /**
     * Test saving user in database.
     */
    @Test
    public void testSavingInDatabase() {
        User u = new User();
        u.setEmail("test@test.com");
        u.setPassword("passwordtest");
        u.setFirstName("name");
        u.save();
    }

    /**
     * Test if user saved in testSavingInDatabase
     * method can be loaded from database.
     */
    @Test
    public void testSavingAndLoadingFromDatabase() {
        User temp = new User();
        temp.setEmail("email@email.com");
        temp.setPassword("password");
        temp.setFirstName("username");
        temp.save();

        User u = User.findByEmail("email@email.com");
        assertNotNull(u);
    }


    @Test
    public void testSavingDaily() {
        DailyReport daily = new DailyReport();
        daily.setName("name");
        daily.setData("data");
        daily.setCreatedDate(new DateTime());

        daily.save();

        List<DailyReport> d = DailyReport.getFinder().all();
        assertNotNull(d);

    }

    /**
     * Expected not to find user with this id
     */
    @Test
    public void testNonexistentUser() {
        User u = User.findById(90000000000L);
        assertNull(u);
    }

    @Test
    public void testFindPostByID() {
        User u = new User();
        u.setEmail("email@email.com");
        u.setPassword("password");
        u.setFirstName("username");
        u.save();

        Post p = new Post();
        p.setTitle("title");
        p.setContent("content");
        p.setUser(u);
        p.setVisibleToMentors(true);
        p.save();

        Post post = Post.findPostById(1L);

        assertEquals(post, p);
    }

    @Test
    public void testFindPostByUser() {
        User u = new User();
        u.setEmail("email@email.com");
        u.setPassword("password");
        u.setFirstName("username");
        u.save();

        Post p = new Post();
        p.setTitle("title");
        p.setContent("content");
        p.setUser(u);
        p.setVisibleToMentors(true);
        p.save();

        List<Post> posts = Post.findPostsByUser(u);

        assertNotNull(posts);
        assertEquals(p, posts.get(0));
    }

    @Test
    public void testFindAllPosts() {
        User u = new User();
        u.setEmail("email@email.com");
        u.setPassword("password");
        u.setFirstName("username");
        u.save();

        Post p = new Post();
        p.setTitle("title");
        p.setContent("content");
        p.setUser(u);
        p.setVisibleToMentors(true);
        p.save();

        User u1 = new User();
        u1.setEmail("email1@email.com");
        u1.setPassword("password1");
        u1.setFirstName("username1");
        u1.save();

        Post p1 = new Post();
        p1.setTitle("title1");
        p1.setContent("content1");
        p1.setUser(u1);
        p1.setVisibleToMentors(false);
        p1.save();

        List<Post> posts = Post.findAllPosts();

        assertEquals(2, posts.size());
        //assertThat(2).isEqualTo(posts.size());
    }


//    @Test
//    public void testIndex() {
//        running(fakeApplication(), () -> {
//            Result result = route(routes.UserController.test());
//            assertEquals(result.status(), SEE_OTHER);
//            assertThat(result.status()).isEqualTo(SEE_OTHER);
//            assertThat(result.redirectLocation()).isEqualTo("/login");
//        });
//    }

    @Test
    public void testLogin(){
        running(testServer(9000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                Logger.info(":D:D:D:D");
                User u = new User();
                u.setEmail("becir.omerbasic@bitcamp.ba");
                u.setPassword("936e0b608058ca689ec74c6025315a5a");
                u.setCellPhone("+38761-284-319");
                u.setFirstName("Becir");
                u.setGender(1);
                u.setLastName("Omerbasic");
                u.setStatus(1);

                u.save();

                testBrowser.goTo("http://localhost:9000/login");
                Http.Context.current().session().get("");


                assertFalse(testBrowser.pageSource().contains("successfully logged in"));

                testBrowser.fill("#inputEmail").with("becir.omerbasic@bitcamp.ba");
                testBrowser.fill("#inputPassword").with("Becir123");
                testBrowser.click("#login");
                testBrowser.goTo("http://localhost:9000/user/createprofile");



                assertTrue(testBrowser.pageSource().contains("successfully logged in"));

            }
        });
    }

//    @Test
//    public void testIsMessagesPrivate(){
//        running(testServer(9000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
//            @Override
//            public void invoke(TestBrowser testBrowser) throws Throwable {
//                testBrowser.goTo("http://localhost:9000/login");
//
//                testBrowser.fill("#inputEmail").with("ajdin.brkic@bitcamp.ba");
//                testBrowser.fill("#inputPassword").with("Student123");
//                testBrowser.click("#login");
//                testBrowser.goTo("http://localhost:9000/user/createprofile");
//                testBrowser.fill("#nickname").with("Dado");
//                testBrowser.fill("#birthdate").with("1997-01-01");
//                testBrowser.fill("#password1").with("Student123");
//                testBrowser.fill("#password2").with("Student123");
//                testBrowser.fill("#location").with("Sarajevo");
//                testBrowser.fill("#mobile-phone").with("+38762626262");
//                testBrowser.fill("#skype").with("dado");
//                testBrowser.fill("#facebook").with("http://www.facebook.com/dado");
//                testBrowser.click("#SubmitProfile");
//                testBrowser.goTo("http://localhost:9000");
//                assertTrue(testBrowser.pageSource().contains("You successfuly updated your profile."));
//
//
//                testBrowser.goTo("http://localhost:9000/user/courses");
//
//
//                testBrowser.submit("#courseSumbit1");
//
//                testBrowser.goTo("http://localhost:9000/logout");
//                testBrowser.goTo("http://localhost:9000/login");
//
//                testBrowser.fill("#inputEmail").with("becir.omerbasic@bitcamp.ba");
//                testBrowser.fill("#inputPassword").with("Becir123");
//                testBrowser.click("#login");
//                testBrowser.goTo("http://localhost:9000/admin");
//                testBrowser.goTo("http://localhost:9000/admin/awaitlist");
//                testBrowser.click("#approved1");
//
//
//
//            }
//        });
//    }


    }


