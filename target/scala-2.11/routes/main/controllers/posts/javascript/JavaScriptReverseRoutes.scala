
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:90
package controllers.posts.javascript {
  import ReverseRouteContext.empty

  // @LINE:90
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:91
    def savePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.posts.PostController.savePost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/"})
        }
      """
    )
  
    // @LINE:90
    def addPost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.posts.PostController.addPost",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/new"})
        }
      """
    )
  
  }


}