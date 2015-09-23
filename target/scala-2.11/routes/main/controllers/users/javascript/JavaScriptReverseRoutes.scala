
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:14
package controllers.users.javascript {
  import ReverseRouteContext.empty

  // @LINE:23
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def approveStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.approveStudent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/approvestudent"})
        }
      """
    )
  
    // @LINE:88
    def deleteMentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteMentorship",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/activementors/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:42
    def genField: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.genField",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createdaily"})
        }
      """
    )
  
    // @LINE:86
    def saveMentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveMentorship",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/mentorship"})
        }
      """
    )
  
    // @LINE:87
    def seeMentorsAndStudents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.seeMentorsAndStudents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/activementors"})
        }
      """
    )
  
    // @LINE:28
    def listOfUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.listOfUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/allusers"})
        }
      """
    )
  
    // @LINE:56
    def addCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.addCourse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createcourse"})
        }
      """
    )
  
    // @LINE:62
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteUser",
      """
        function(id) {
        
          if (true) {
            return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
          }
        
        }
      """
    )
  
    // @LINE:35
    def awaitList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.awaitList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/awaitlist"})
        }
      """
    )
  
    // @LINE:50
    def deleteReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteReport",
      """
        function(id) {
        
          if (true) {
            return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "listReport/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
          }
        
        }
      """
    )
  
    // @LINE:29
    def seeErrors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.seeErrors",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/errors"})
          }
        
        }
      """
    )
  
    // @LINE:69
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/test"})
        }
      """
    )
  
    // @LINE:26
    def saveNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveNewUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/adduser"})
        }
      """
    )
  
    // @LINE:57
    def saveCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveCourse",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createcourse"})
        }
      """
    )
  
    // @LINE:45
    def saveField: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveField",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/savefielddaily"})
        }
      """
    )
  
    // @LINE:65
    def deleteError: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteError",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/error/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:23
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:25
    def addNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.addNewUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/adduser"})
        }
      """
    )
  
    // @LINE:85
    def mentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.mentorship",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/mentorship"})
        }
      """
    )
  
    // @LINE:49
    def listReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.listReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listReport"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseStudentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def haveCourseAccess: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.haveCourseAccess",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/joincourse/haveaccess"})
        }
      """
    )
  
    // @LINE:37
    def joinCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.joinCourse",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/joincourse"})
        }
      """
    )
  
    // @LINE:72
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/test"})
        }
      """
    )
  
  }

  // @LINE:59
  class ReverseTeacherController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:60
    def saveRaport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.saveRaport",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "daily/reportSubmit"})
        }
      """
    )
  
    // @LINE:70
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "teacher/test"})
        }
      """
    )
  
    // @LINE:59
    def dailyReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.dailyReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "daily/report"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def createProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.createProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createprofile"})
        }
      """
    )
  
    // @LINE:99
    def newMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.newMessage",
      """
        function(id) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
          }
        
        }
      """
    )
  
    // @LINE:68
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/test"})
        }
      """
    )
  
    // @LINE:18
    def saveProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.saveProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/editprofile"})
        }
      """
    )
  
    // @LINE:17
    def editProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.editProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/editprofile"})
        }
      """
    )
  
    // @LINE:98
    def studentList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.studentList",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/message"})
          }
        
        }
      """
    )
  
    // @LINE:15
    def updateProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.updateProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createprofile"})
        }
      """
    )
  
    // @LINE:101
    def allMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.allMessage",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allMessage"})
          }
        
        }
      """
    )
  
    // @LINE:100
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.sendMessage",
      """
        function(id) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/send"})
          }
        
        }
      """
    )
  
    // @LINE:113
    def seeMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.seeMessage",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/selected/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
  }

  // @LINE:71
  class ReverseMentorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:71
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.MentorController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mentor/test"})
        }
      """
    )
  
  }


}