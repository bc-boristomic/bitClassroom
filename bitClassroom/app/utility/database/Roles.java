package utility.database;

import models.user.Role;
import utility.UserConstants;

/**
 * Created by boris.tomic on 21/09/15.
 */
public class Roles {

    protected static final Role ADMIN = new Role(UserConstants.ADMIN, UserConstants.NAME_ADMIN);
    protected static final Role TEACHER = new Role(UserConstants.TEACHER, UserConstants.NAME_TEACHER);
    protected static final Role MENTOR = new Role(UserConstants.MENTOR, UserConstants.NAME_MENTOR);
    protected static final Role STUDENT = new Role(UserConstants.STUDENT, UserConstants.NAME_STUDENT);

    public static void saveAllRoles() {
        ADMIN.save();
        TEACHER.save();
        MENTOR.save();
        STUDENT.save();
    }
}
