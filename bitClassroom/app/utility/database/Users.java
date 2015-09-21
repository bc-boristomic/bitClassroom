package utility.database;

import models.user.Role;
import models.user.User;
import utility.MD5Hash;
import utility.UserConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by boris.tomic on 21/09/15.
 */
public class Users {

    public static void saveUsers() {

        User medina = new User();
        medina.setEmail("medina.banjic@bitcamp.ba");
        medina.setPassword(MD5Hash.getEncriptedPasswordMD5("Medina123"));
        medina.setFirstName("Medina");
        medina.setLastName("Banjic");
        medina.setStatus(UserConstants.FULLY_ACTIVE);
        medina.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.ADMIN})));
        medina.setCreatedBy("Global.java");
        medina.save();

        User nidal = new User();
        nidal.setEmail("nidal.salkic@bitcamp.ba");
        nidal.setPassword(MD5Hash.getEncriptedPasswordMD5("Nidal123"));
        nidal.setFirstName("Nidal");
        nidal.setLastName("Salkic");
        nidal.setStatus(UserConstants.FULLY_ACTIVE);
        nidal.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.ADMIN})));
        nidal.setCreatedBy("Global.java");
        nidal.save();

        User boris = new User();
        boris.setEmail("boris.tomic@bitcamp.ba");
        boris.setPassword(MD5Hash.getEncriptedPasswordMD5("Boris123"));
        boris.setFirstName("Boris");
        boris.setLastName("Tomic");
        boris.setStatus(UserConstants.FULLY_ACTIVE);
        boris.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.ADMIN})));
        boris.setCreatedBy("Global.java");
        boris.save();

        User enver = new User();
        enver.setEmail("enver.memic@bitcamp.ba");
        enver.setPassword(MD5Hash.getEncriptedPasswordMD5("Enver123"));
        enver.setFirstName("Enver");
        enver.setLastName("Memic");
        enver.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.MENTOR})));
        enver.setCreatedBy("Global.java");
        enver.save();

        User becir = new User();
        becir.setEmail("becir.omerbasic@bitcamp.ba");
        becir.setPassword(MD5Hash.getEncriptedPasswordMD5("Becir123"));
        becir.setFirstName("Becir");
        becir.setLastName("Omerbasic");
        becir.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.STUDENT})));
        becir.setCreatedBy("Global.java");
        becir.save();

        User senadin = new User();
        senadin.setEmail("senadin.botic@bitcamp.ba");
        senadin.setPassword(MD5Hash.getEncriptedPasswordMD5("Senadin123"));
        senadin.setFirstName("Senadin");
        senadin.setLastName("Botic");
        senadin.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.STUDENT})));
        senadin.setCreatedBy("Global.java");
        senadin.save();

        User zaid = new User();
        zaid.setEmail("zaid.zerdo@bitcamp.ba");
        zaid.setPassword(MD5Hash.getEncriptedPasswordMD5("Zaid123"));
        zaid.setFirstName("Zaid");
        zaid.setLastName("Zerdo");
        zaid.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.TEACHER})));
        zaid.setCreatedBy("Global.java");
        zaid.save();

        User benjo = new User();
        benjo.setEmail("benjamin.talic@bitcamp.ba");
        benjo.setPassword(MD5Hash.getEncriptedPasswordMD5("Banjamin123"));
        benjo.setFirstName("Benjamin");
        benjo.setLastName("Talic");
        benjo.setRoles(new ArrayList<Role>(Arrays.asList(new Role[]{Roles.TEACHER})));
        benjo.setCreatedBy("Global.java");
        benjo.save();

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
