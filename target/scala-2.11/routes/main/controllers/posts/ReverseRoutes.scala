
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:90
package controllers.posts {

  // @LINE:90
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:91
    def savePost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "post/")
    }
  
    // @LINE:90
    def addPost(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "post/new")
    }
  
  }


}