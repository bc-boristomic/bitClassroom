package utility.database;

import models.user.Role;
import models.user.User;
import utility.MD5Hash;
import utility.UserConstants;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by boris.tomic on 21/09/15.
 */
public class Users {

    private static String[] firstNameTeam = {"Medina", "Nidal", "Enver", "Becir", "Senadin", "Boris"};
    private static String[] lastNameTeam = {"Banjic", "Salkic", "Memic", "Omerbasic", "Botic", "Tomic"};
    private static String[] emailTeam = {"medina.banjic@bitcamp.ba", "nidal.salkic@bitcamp.ba", "enver.memic@bitcamp.ba", "becir.omerbasic@bitcamp.ba", "senadin.botic@bitcamp.ba", "boris.tomic@bitcamp.ba"};
    private static String[] passwordTeam = {"Medina123", "Nidal123", "Enver123", "Becir123", "Senadin123", "Boris123"};

    private static String[] firstNameTeachers = {"Benjamin", "Vedad", "Tarik", "Emir", "Elmedin", "Damir", "Zaid"};
    private static String[] lastNameTeachers = {"Talic", "Letic", "Celik", "Arnautovic", "Selmanovic", "Zekic", "Zerdo"};
    private static String[] emailTeachers = {"benjamin.talic@bitcamp.ba", "vedad.letic@bitcamp.ba", "tarik.celik@bitcamp.ba", "emir.arnautovic@bitcamp.ba", "elmedin.selmanovic@bitcamp.ba", "damir.zekic@bitcamp.ba", "zaid.zerdo@bitcamp.ba"};

    private static String[] firstNameStudents = {"Adis", "Adnan", "Ajdin", "Ajla", "Alen", "Amra"};
    private static String[] lastNameStudents = {"Cehajic", "Lapendic", "Brkic", "El Tabari", "Bumbulovic", "Sabic"};
    private static String[] emailStudents = {"adis.cehajic@bitcamp.ba", "adnan.lapendic@bitcamp.ba", "ajdin.brkic@bitcamp.ba", "ajla.eltabari@bitcamp.ba", "alen.bumbulovic@bitcamp.ba", "amra.sabic@bitcamp.ba"};

    private static String[] firstNameMentors = {"Nejra", "Nermin", "Mirza"};
    private static String[] lastNameMentors = {"Hodzic", "Sehic", "Mujanovic"};
    private static String[] emailMentors = {"nejra.hodzic@bitcamp.ba", "nermin.sehic@bitcamp.ba", "mirza.mujanovic@bitcamp.ba"};

    public static void saveUsers() {

        for (int i = 0; i < firstNameTeam.length; i++) {
            User whatUser = new User();
            whatUser.setEmail(emailTeam[i]);
            whatUser.setPassword(MD5Hash.getEncriptedPasswordMD5(passwordTeam[i]));
            whatUser.setFirstName(firstNameTeam[i]);
            whatUser.setLastName(lastNameTeam[i]);
            whatUser.setStatus(UserConstants.FULLY_ACTIVE);
            whatUser.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.ADMIN})));
            whatUser.setCreatedBy("Global.java");
            whatUser.save();
        }

        for (int i = 0; i < firstNameTeachers.length; i++) {
            User teacher = new User();
            teacher.setEmail(emailTeachers[i]);
            teacher.setPassword(MD5Hash.getEncriptedPasswordMD5("Teacher123"));
            teacher.setFirstName(firstNameTeachers[i]);
            teacher.setLastName(lastNameTeachers[i]);
            teacher.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.TEACHER})));
            teacher.setCreatedBy("Global.java");
            teacher.save();
        }

        for (int i = 0; i < firstNameStudents.length; i++) {
            User student = new User();
            student.setEmail(emailStudents[i]);
            student.setPassword(MD5Hash.getEncriptedPasswordMD5("Student123"));
            student.setFirstName(firstNameStudents[i]);
            student.setLastName(lastNameStudents[i]);
            student.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.STUDENT})));
            student.setStudentStatus(UserConstants.DONT_HAVE_MENTOR);
            student.setCreatedBy("Global.java");
            student.save();
        }

        for (int i = 0; i < firstNameMentors.length; i++) {
            User mentor = new User();
            mentor.setEmail(emailMentors[i]);
            mentor.setPassword(MD5Hash.getEncriptedPasswordMD5("Mentor123"));
            mentor.setFirstName(firstNameMentors[i]);
            mentor.setLastName(lastNameMentors[i]);
            mentor.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.MENTOR})));
            mentor.setCreatedBy("Global.java");
            mentor.save();
        }

        User naida = new User();
        naida.setEmail("naida.dervis@bitcamp.ba");
        naida.setPassword(MD5Hash.getEncriptedPasswordMD5("Naida123"));
        naida.setFirstName("Naida");
        naida.setLastName("Dervishalidovic");
        naida.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.ADMIN})));
        naida.setCreatedBy("Global.java");
        naida.save();

    }


}
