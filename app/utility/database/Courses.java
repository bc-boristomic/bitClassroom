package utility.database;

import models.course.Course;

/**
 * Created by boris.tomic on 21/09/15.
 */
public class Courses {

    public static void saveCourses() {
        Course javaL = new Course();
        javaL.setName("Java");
        javaL.setDescription("Lectures");
        javaL.setCreatedBy("Global.java");
        javaL.setTeacher("Benjamin");
        javaL.save();
    }
}
