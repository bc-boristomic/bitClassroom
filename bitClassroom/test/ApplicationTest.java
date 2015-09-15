import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import models.user.User;
import org.junit.*;

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


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Before
    public void configureDatabase() {
        fakeApplication(inMemoryDatabase());
    }

    /**
     * Test application if it works or not.
     */
    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void testNullPointer() {
        String s = "Not null";
        assertNotNull(s);
    }

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

        User u = User.findByEmail("email@email.com");
        assertNull(u);
    }

    /**
     * Expected not to find user with this id
     */
    @Test
    public void testNonexistentUser() {
        User u = User.findById(90000000000L);
        assertNull(u);
    }




}
