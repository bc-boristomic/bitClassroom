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

	private static final String[] FIRST_NAME_TEAM = { "Medina", "Nidal", "Enver", "Becir", "Senadin", "Boris", "Dinko", "Gordan" };
	private static final String[] LAST_NAME_TEAM = { "Banjic", "Salkic", "Memic", "Omerbasic", "Botic", "Tomic", "Hodzic", "Masic" };
	private static final String[] EMAIL_TEAM = { "medina.banjic@bitcamp.ba", "nidal.salkic@bitcamp.ba",
			"enver.memic@bitcamp.ba", "becir.omerbasic@bitcamp.ba", "senadin.botic@bitcamp.ba",
			"boris.tomic@bitcamp.ba", "dinko.hodzic@bitcamp.ba", "gordan.masic@bitcamp.ba" };
	private static final String[] PASSWORD_TEAM = { "Medina123", "Nidal123", "Enver123", "Becir123", "Senadin123",
			"Boris123", "Dinko123", "Gordan123" };

	private static final String[] FIRST_NAME_TEACHERS = { "Benjamin", "Vedad", "Tarik", "Emir", "Elmedin", "Damir",
			"Zaid" };
	private static final String[] LAST_NAME_TEACHERS = { "Talic", "Letic", "Celik", "Arnautovic", "Selmanovic", "Zekic",
			"Zerdo" };
	private static final String[] EMAIL_TEACHERS = { "benjamin.talic@bitcamp.ba", "vedad.letic@bitcamp.ba",
			"tarik.celik@bitcamp.ba", "emir.arnautovic@bitcamp.ba", "elmedin.selmanovic@bitcamp.ba",
			"damir.zekic@bitcamp.ba", "zaid.zerdo@bitcamp.ba" };

	private static final String[] FIRST_NAME_STUDENTS = { "Adis", "Adnan", "Ajdin", "Ajla", "Alen", "Amra",
			"Edin", "Edvin", "Emina","Hajrudin", "Kerim", "Kristina", "Mladen", "Narena", "Ognjen", "Semir",
			"Tomislav", "Zeljko" };
	private static final String[] LAST_NAME_STUDENTS = { "Cehajic", "Lapendic", "Brkic", "El Tabari", "Bumbulovic",
			"Sabic", "Pilavdzic", "Mulabdic", "Arapcic", "Sehic", "Dragolj", "Pupavac", "Teofilovic",
			"Ibrisimovic", "Cetkovic", "Sahman", "Trifunovic", "Miljevic" };
	private static final String[] EMAIL_STUDENTS = { "adis.cehajic@bitcamp.ba", "adnan.lapendic@bitcamp.ba",
			"ajdin.brkic@bitcamp.ba", "ajla.eltabari@bitcamp.ba", "alen.bumbulovic@bitcamp.ba", "amra.sabic@bitcamp.ba",
			"edin.pilavdzic@bitcamp.ba", "edvin.mulabdic@bitcamp.ba",
			"emina.arapcic@bitcamp.ba", "hajrudin.sehic@bitcamp.ba",
			"kerim.dragolj@bitcamp.ba", "kristina.pupavac@bitcamp.ba", "mladen.teofilovic@bitcamp.ba",
			"narena.ibrisimovic@bitcamp.ba", "ognjen.cetkovic@bitcamp.ba", "semir.sahman@bitcamp.ba",
			"tomislav.trifunovic@bitcamp.ba", "zeljko.miljevic@bitcamp.ba" };

	private static final String[] FIRST_NAME_MENTORS = { "Nejra", "Nermin", "Mirza" };
	private static final String[] LAST_NAME_MENTORS = { "Hodzic", "Sehic", "Mujanovic" };
	private static final String[] EMAIL_MENTORS = { "nejra.hodzic@bitcamp.ba", "nermin.sehic@bitcamp.ba",
			"mirza.mujanovic@bitcamp.ba" };

	private static final String[] FIRST_NAME_STAFF = { "Naida", "Selma" };
	private static final String[] LAST_NAME_STAFF = { "Dervishalidovic", "Mameledzija" };
	private static final String[] EMAIL_STAFF = { "naida.dervis@bitcamp.ba", "selma.mamel@bitcamp.ba" };

	public static void saveUsers() {

		for (int i = 0; i < FIRST_NAME_TEAM.length; i++) {
			User whatUser = new User();
			whatUser.setEmail(EMAIL_TEAM[i]);
			whatUser.setPassword(MD5Hash.getEncriptedPasswordMD5(PASSWORD_TEAM[i]));
			whatUser.setFirstName(FIRST_NAME_TEAM[i]);
			whatUser.setLastName(LAST_NAME_TEAM[i]);
			whatUser.setStatus(UserConstants.FULLY_ACTIVE);
			whatUser.setStudentStatus(0);
			whatUser.setNickName("Nick" + i);
			whatUser.setRoles(new ArrayList<Role>(Arrays.asList(new Role[] { Roles.ADMIN })));
			whatUser.setCreatedBy("Global.java");
			if (i == 0) {
				whatUser.setGender(0);
			} else {
				whatUser.setGender(1);
			}
			whatUser.setToken();
			whatUser.save();
		}

		for (int i = 0; i < FIRST_NAME_TEACHERS.length; i++) {
			User teacher = new User();
			teacher.setEmail(EMAIL_TEACHERS[i]);
			teacher.setPassword(MD5Hash.getEncriptedPasswordMD5("Teacher123"));
			teacher.setFirstName(FIRST_NAME_TEACHERS[i]);
			teacher.setLastName(LAST_NAME_TEACHERS[i]);
			teacher.setStudentStatus(0);
			teacher.setRoles(new ArrayList<Role>(Arrays.asList(new Role[] { Roles.TEACHER })));
			teacher.setCreatedBy("Global.java");
			teacher.setToken();
			teacher.save();
		}

		for (int i = 0; i < FIRST_NAME_STUDENTS.length; i++) {
			User student = new User();
			student.setEmail(EMAIL_STUDENTS[i]);
			student.setPassword(MD5Hash.getEncriptedPasswordMD5("Student123"));
			student.setFirstName(FIRST_NAME_STUDENTS[i]);
			student.setLastName(LAST_NAME_STUDENTS[i]);
			student.setRoles(new ArrayList<Role>(Arrays.asList(new Role[] { Roles.STUDENT })));
			student.setStudentStatus(UserConstants.DONT_HAVE_MENTOR);
			student.setHomeworkStatus(0);
			student.setCreatedBy("Global.java");
			student.setToken();
			student.save();
		}

		for (int i = 0; i < FIRST_NAME_MENTORS.length; i++) {
			User mentor = new User();
			mentor.setEmail(EMAIL_MENTORS[i]);
			mentor.setPassword(MD5Hash.getEncriptedPasswordMD5("Mentor123"));
			mentor.setFirstName(FIRST_NAME_MENTORS[i]);
			mentor.setLastName(LAST_NAME_MENTORS[i]);
			mentor.setStudentStatus(0);
			mentor.setRoles(new ArrayList<Role>(Arrays.asList(new Role[] { Roles.MENTOR })));
			mentor.setCreatedBy("Global.java");
			mentor.setToken();
			mentor.save();
		}

		for (int i = 0; i < FIRST_NAME_STAFF.length; i++) {
			User staff = new User();
			staff.setEmail(EMAIL_STAFF[i]);
			staff.setPassword(MD5Hash.getEncriptedPasswordMD5("Staff123"));
			staff.setFirstName(FIRST_NAME_STAFF[i]);
			staff.setLastName(LAST_NAME_STAFF[i]);
			staff.setStudentStatus(0);
			staff.setRoles(new ArrayList<Role>(Arrays.asList(new Role[] { Roles.ADMIN })));
			staff.setCreatedBy("Global.java");
			staff.setToken();
			staff.save();
		}
	}

}
