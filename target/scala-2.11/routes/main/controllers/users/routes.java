
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

package controllers.users;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.users.ReverseAdminController AdminController = new controllers.users.ReverseAdminController(RoutesPrefix.byNamePrefix());
  public static final controllers.users.ReverseStudentController StudentController = new controllers.users.ReverseStudentController(RoutesPrefix.byNamePrefix());
  public static final controllers.users.ReverseTeacherController TeacherController = new controllers.users.ReverseTeacherController(RoutesPrefix.byNamePrefix());
  public static final controllers.users.ReverseUserController UserController = new controllers.users.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.users.ReverseMentorController MentorController = new controllers.users.ReverseMentorController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.users.javascript.ReverseAdminController AdminController = new controllers.users.javascript.ReverseAdminController(RoutesPrefix.byNamePrefix());
    public static final controllers.users.javascript.ReverseStudentController StudentController = new controllers.users.javascript.ReverseStudentController(RoutesPrefix.byNamePrefix());
    public static final controllers.users.javascript.ReverseTeacherController TeacherController = new controllers.users.javascript.ReverseTeacherController(RoutesPrefix.byNamePrefix());
    public static final controllers.users.javascript.ReverseUserController UserController = new controllers.users.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.users.javascript.ReverseMentorController MentorController = new controllers.users.javascript.ReverseMentorController(RoutesPrefix.byNamePrefix());
  }

}
