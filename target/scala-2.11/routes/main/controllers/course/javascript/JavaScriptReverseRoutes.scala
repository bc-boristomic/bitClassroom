
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:86
package controllers.course.javascript {
  import ReverseRouteContext.empty

  // @LINE:86
  class ReverseCourseController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:87
    def course: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.course.CourseController.course",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/class"})
        }
      """
    )
  
    // @LINE:86
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