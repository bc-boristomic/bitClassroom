
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

package controllers.posts;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.posts.ReversePostController PostController = new controllers.posts.ReversePostController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.posts.javascript.ReversePostController PostController = new controllers.posts.javascript.ReversePostController(RoutesPrefix.byNamePrefix());
  }

}
