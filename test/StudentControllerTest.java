import java.util.*;

import controllers.routes;
import com.fasterxml.jackson.databind.JsonNode;

import helpers.SessionHelper;
import models.Post;
import models.course.Course;
import models.course.CourseUser;
import models.report.DailyReport;
import models.user.Role;
import models.user.User;
import org.fluentlenium.core.domain.FluentWebElement;
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
 * Created by becir.omerbasic on 23/09/15.
 */
public class StudentControllerTest {

    @Before
    public void configureDatabase() {
        fakeApplication(inMemoryDatabase());
    }

/*
    @Test
    public void testJoin() {
        running(testServer(9000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                testBrowser.goTo("http://localhost:9000/login");
                testBrowser.fill("#inputEmail").with("amra.sabic@bitcamp.ba");
                testBrowser.fill("#inputPassword").with("Student123");
                testBrowser.click("#login");
                testBrowser.goTo("http://localhost:8000/user/createprofile");
                testBrowser.fill("#inputName").with("Amraaaa");
                testBrowser.fill("#birth-date").with("1997-01-01");
                testBrowser.fill("#inputPassword1").with("Student123");
                testBrowser.fill("#inputPassword").with("Student123");
                testBrowser.fill("#location").with("Sarajevo");
                testBrowser.fill("#mobile-phone").with("+38762626262");
                testBrowser.fill("#skype").with("amra");
                testBrowser.fill("#facebook").with("http://www.facebook.com/amra");
                testBrowser.click("#SubmitProfile");
                testBrowser.goTo("http://localhost:9000");
                testBrowser.goTo("http://localhost:9000/user/courses");
                String disabled = testBrowser.find("#courseSubmit1").getAttribute("disabled");
                assertEquals("true", disabled);
            }
        });
    }
    @Test
    public void createProfile(){
        running(testServer(8000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                loginAndCreatingProfileAjdinBrkic(testBrowser);
                assertTrue(testBrowser.pageSource().contains("You successfuly updated your profile."));
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                assertTrue(testBrowser.pageSource().contains("You successfuly signed out."));
            }
        });
    }
    */
/*
    @Test
    public void testMessageVisibility(){
        running(testServer(8000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                loginAndCreatingProfileAjdinBrkic(testBrowser);
                assertTrue(testBrowser.pageSource().contains("You successfuly updated your profile."));
                joinCourseJavaMethod(testBrowser);
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                loginAndCreatingProfileSemirSahman(testBrowser);
                joinCourseJavaMethod(testBrowser);
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                assertTrue(testBrowser.pageSource().contains("You successfuly signed out."));
                loginAsAdmin(testBrowser);
                testBrowser.goTo("http://localhost:9000/admin");
                testBrowser.goTo("http://localhost:9000/admin/awaitlist");
                testBrowser.find("#approved1").click();
                testBrowser.find("#approved2").click();
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                loginAsAjdinBrkic(testBrowser);
                assertTrue(testBrowser.pageSource().contains("Java"));
                assertTrue(testBrowser.pageSource().contains("Benjamin"));
                testBrowser.goTo("http://localhost:9000/user/message");
                testBrowser.find("#messageIcon").click();
                testBrowser.goTo("http://localhost:9000/message/31");
                testBrowser.fill("#subjectMessage").with("Hello");
                testBrowser.fill("#subjectArea").with("My first message");
                testBrowser.click("#sendMessage");
                testBrowser.goTo("http://localhost:9000/allMessage");
                testBrowser.click("#sent");
                assertTrue(testBrowser.pageSource().contains("Hello"));
                assertTrue(testBrowser.pageSource().contains("Semir-Sahman"));
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
            }
        });
    }
    @Test
    public void approveJoinRequests(){
        running(testServer(8000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                loginAndCreatingProfileAjdinBrkic(testBrowser);
                assertTrue(testBrowser.pageSource().contains("You successfuly updated your profile."));
                joinCourseJavaMethod(testBrowser);
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                loginAndCreatingProfileSemirSahman(testBrowser);
                joinCourseJavaMethod(testBrowser);
                testBrowser.goTo("http://localhost:8000/logout");
                testBrowser.goTo("http://localhost:8000/login");
                assertTrue(testBrowser.pageSource().contains("You successfuly signed out."));
                loginAsAdmin(testBrowser);
                testBrowser.goTo("http://localhost:9000/admin");
                testBrowser.goTo("http://localhost:9000/admin/awaitlist");
                testBrowser.find("#approved1").click();
                testBrowser.find("#approved2").click();
                testBrowser.click("approved1");
            }
        });
    }
    */

    @Test
    public void appliedToCourseTest(){
        running(testServer(8000, fakeApplication(inMemoryDatabase())), new HtmlUnitDriver(), new Callback<TestBrowser>() {
            @Override
            public void invoke(TestBrowser testBrowser) throws Throwable {
                testBrowser.goTo("http://localhost:8000/login");

                loginAndCreatingProfileAjdinBrkic(testBrowser);
                assertTrue(testBrowser.pageSource().contains("You successfuly updated your profile."));

                joinCourseJavaMethod(testBrowser);
            }
        });
    }

    public void loginAndCreatingProfileAjdinBrkic(TestBrowser testBrowser){
        testBrowser.goTo("http://localhost:8000/login");

        testBrowser.fill("#inputEmail").with("ajdin.brkic@bitcamp.ba");
        testBrowser.fill("#inputPassword").with("Student123");
        testBrowser.click("#login");
        testBrowser.goTo("http://localhost:8000/user/createprofile");
        testBrowser.fill("#inputName").with("Dado");
        testBrowser.fill("#birth-date").with("1997-01-01");
        testBrowser.fill("#inputPassword1").with("Student123");
        testBrowser.fill("#inputPassword").with("Student123");
        testBrowser.fill("#location").with("Sarajevo");
        testBrowser.fill("#mobile-phone").with("+38762626262");
        testBrowser.fill("#skype").with("dado");
        testBrowser.fill("#facebook").with("http://www.facebook.com/dado");
        testBrowser.click("#SubmitProfile");
        testBrowser.goTo("http://localhost:8000");
    }

    public void loginAsAjdinBrkic(TestBrowser testBrowser){
        testBrowser.fill("#inputEmail").with("ajdin.brkic@bitcamp.ba");
        testBrowser.fill("#inputPassword").with("Student123");
        testBrowser.click("#login");
        testBrowser.goTo("http://localhost:8000");
    }

    public void loginAndCreatingProfileSemirSahman(TestBrowser testBrowser){
        testBrowser.goTo("http://localhost:8000/login");

        testBrowser.fill("#inputEmail").with("semir.sahman@bitcamp.ba");
        testBrowser.fill("#inputPassword").with("Student123");
        testBrowser.click("#login");
        testBrowser.goTo("http://localhost:8000/user/createprofile");
        testBrowser.fill("#inputName").with("Sema");
        testBrowser.fill("#birth-date").with("1997-01-01");
        testBrowser.fill("#inputPassword1").with("Student123");
        testBrowser.fill("#inputPassword").with("Student123");
        testBrowser.fill("#location").with("Sarajevo");
        testBrowser.fill("#mobile-phone").with("+38762626262");
        testBrowser.fill("#skype").with("sema");
        testBrowser.fill("#facebook").with("http://www.facebook.com/sema");
        testBrowser.click("#SubmitProfile");
        testBrowser.goTo("http://localhost:8000");
    }

    public void loginAsAdmin(TestBrowser testBrowser){
        testBrowser.fill("#inputEmail").with("becir.omerbasic@bitcamp.ba");
        testBrowser.fill("#inputPassword").with("Becir123");
        testBrowser.click("#login");
        testBrowser.goTo("http://localhost:8000");
    }

    public void joinCourseJavaMethod(TestBrowser testBrowser){
        testBrowser.goTo("http://localhost:9000/user/courses");

        testBrowser.submit("#courseSubmit1");
        String logger = testBrowser.find("#courseSubmit1").getAttribute("disabled");
        Logger.info(logger);
        //assertTrue(testBrowser.pageSource().contains("You successfuly "));

    }

}