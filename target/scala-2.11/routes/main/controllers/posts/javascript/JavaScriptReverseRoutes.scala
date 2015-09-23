
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:20
package controllers.posts.javascript {
  import ReverseRouteContext.empty

  // @LINE:20
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def savePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.posts.PostController.savePost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/"})
        }
      """
    )
  
    // @LINE:20
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