
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

package controllers.course;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.course.ReverseCourseController CourseController = new controllers.course.ReverseCourseController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.course.javascript.ReverseCourseController CourseController = new controllers.course.javascript.ReverseCourseController(RoutesPrefix.byNamePrefix());
  }

}
