package utility;

/**
 * Created by boris on 9/12/15.
 */
public abstract class UserConstants {

    public static final Long ADMIN = 1L;
    public static final Long TEACHER = 2L;
    public static final Long MENTOR = 3L;
    public static final Long STUDENT = 4L;

    public static final String NAME_ADMIN = "Admin";
    public static final String NAME_TEACHER = "Teacher";
    public static final String NAME_MENTOR = "Mentor";
    public static final String NAME_STUDENT = "Student";

    public static final int INACTIVE = 0;
    public static final int NOT_FULLY_ACTIVE = 1;
    public static final int FULLY_ACTIVE = 2;
    public static final int DELETED = 3;
    public static final int ACTIVE_MENTOR = 14;

    public static final int DONT_HAVE_MENTOR = 10;
    public static final int HAVE_MENTOR = 11;
    public static final int ACTIVE_MENTORSHIP = 12;
    public static final int EXPIRED_MENTORSHIP = 13;

}