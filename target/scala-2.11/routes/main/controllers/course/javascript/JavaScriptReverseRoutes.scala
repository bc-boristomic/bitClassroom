
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:80
package controllers.course.javascript {
  import ReverseRouteContext.empty

  // @LINE:80
  class ReverseCourseController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def course: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.course.CourseController.course",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/class"})
          }
        
        }
      """
    )
  
    // @LINE:80
    def allCourses: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.course.CourseController.allCourses",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/courses"})
        }
      """
    )
  
  }


}