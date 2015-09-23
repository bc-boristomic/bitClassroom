
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:14
package controllers.users {

  // @LINE:23
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def approveStudent(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/approvestudent")
    }
  
    // @LINE:88
    def deleteMentorship(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "admin/activementors/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:42
    def genField(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/createdaily")
    }
  
    // @LINE:86
    def saveMentorship(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/mentorship")
    }
  
    // @LINE:87
    def seeMentorsAndStudents(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/activementors")
    }
  
    // @LINE:28
    def listOfUser(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/allusers")
    }
  
    // @LINE:56
    def addCourse(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/createcourse")
    }
  
    // @LINE:62
    def deleteUser(id:Long): Call = {
    
      (id: @unchecked) match {
      
        // @LINE:62
        case (id)  =>
          import ReverseRouteContext.empty
          Call("DELETE", _prefix + { _defaultPrefix } + "admin/delete/" + implicitly[PathBindable[Long]].unbind("id", id))
      
      }
    
    }
  
    // @LINE:35
    def awaitList(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/awaitlist")
    }
  
    // @LINE:50
    def deleteReport(id:Long): Call = {
    
      (id: @unchecked) match {
      
        // @LINE:50
        case (id)  =>
          import ReverseRouteContext.empty
          Call("DELETE", _prefix + { _defaultPrefix } + "listReport/" + implicitly[PathBindable[Long]].unbind("id", id))
      
      }
    
    }
  
    // @LINE:29
    def seeErrors(): Call = {
    
      () match {
      
        // @LINE:29
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "admin/errors")
      
      }
    
    }
  
    // @LINE:69
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/test")
    }
  
    // @LINE:26
    def saveNewUser(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/adduser")
    }
  
    // @LINE:57
    def saveCourse(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/createcourse")
    }
  
    // @LINE:45
    def saveField(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/savefielddaily")
    }
  
    // @LINE:65
    def deleteError(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "admin/error/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:23
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin")
    }
  
    // @LINE:25
    def addNewUser(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/adduser")
    }
  
    // @LINE:85
    def mentorship(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/mentorship")
    }
  
    // @LINE:49
    def listReport(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "listReport")
    }
  
  }

  // @LINE:37
  class ReverseStudentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def haveCourseAccess(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "student/joincourse/haveaccess")
    }
  
    // @LINE:37
    def joinCourse(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "student/joincourse")
    }
  
    // @LINE:72
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "student/test")
    }
  
  }

  // @LINE:59
  class ReverseTeacherController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def saveRaport(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "daily/reportSubmit")
    }
  
    // @LINE:70
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "teacher/test")
    }
  
    // @LINE:59
    def dailyReport(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "daily/report")
    }
  
  }

  // @LINE:14
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def createProfile(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user/createprofile")
    }
  
    // @LINE:99
    def newMessage(id:Long): Call = {
    
      (id: @unchecked) match {
      
        // @LINE:99
        case (id)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "message/" + implicitly[PathBindable[Long]].unbind("id", id))
      
      }
    
    }
  
    // @LINE:68
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user/test")
    }
  
    // @LINE:18
    def saveProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "user/editprofile")
    }
  
    // @LINE:17
    def editProfile(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "user/editprofile")
    }
  
    // @LINE:98
    def studentList(): Call = {
    
      () match {
      
        // @LINE:98
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "user/message")
      
      }
    
    }
  
    // @LINE:15
    def updateProfile(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "user/createprofile")
    }
  
    // @LINE:101
    def allMessage(): Call = {
    
      () match {
      
        // @LINE:101
        case ()  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "allMessage")
      
      }
    
    }
  
    // @LINE:100
    def sendMessage(id:Long): Call = {
    
      (id: @unchecked) match {
      
        // @LINE:100
        case (id)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "message/" + implicitly[PathBindable[Long]].unbind("id", id) + "/send")
      
      }
    
    }
  
    // @LINE:113
    def seeMessage(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "message/selected/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }

  // @LINE:71
  class ReverseMentorController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:71
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "mentor/test")
    }
  
  }


}