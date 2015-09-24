
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:16
package controllers.users.javascript {
  import ReverseRouteContext.empty

  // @LINE:31
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def approveStudent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.approveStudent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/approvestudent"})
        }
      """
    )
  
    // @LINE:50
    def deleteMentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteMentorship",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/activementors/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:57
    def genField: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.genField",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createdaily"})
        }
      """
    )
  
    // @LINE:46
    def saveMentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveMentorship",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/mentorship"})
        }
      """
    )
  
    // @LINE:49
    def seeMentorsAndStudents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.seeMentorsAndStudents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/activementors"})
        }
      """
    )
  
    // @LINE:38
    def listOfUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.listOfUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/allusers"})
        }
      """
    )
  
    // @LINE:66
    def addCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.addCourse",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createcourse"})
        }
      """
    )
  
    // @LINE:70
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteUser",
      """
        function(id) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/delete/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
          }
        
        }
      """
    )
  
    // @LINE:54
    def awaitList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.awaitList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/awaitlist"})
        }
      """
    )
  
    // @LINE:62
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
  
    // @LINE:41
    def seeErrors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.seeErrors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/errors"})
        }
      """
    )
  
    // @LINE:99
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/test"})
        }
      """
    )
  
    // @LINE:35
    def saveNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveNewUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/adduser"})
        }
      """
    )
  
    // @LINE:67
    def saveCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveCourse",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/createcourse"})
        }
      """
    )
  
    // @LINE:58
    def saveField: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.saveField",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/savefielddaily"})
        }
      """
    )
  
    // @LINE:42
    def deleteError: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.deleteError",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/error/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:31
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
        }
      """
    )
  
    // @LINE:34
    def addNewUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.addNewUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/adduser"})
        }
      """
    )
  
    // @LINE:45
    def mentorship: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.mentorship",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/mentorship"})
        }
      """
    )
  
    // @LINE:61
    def listReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.AdminController.listReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listReport"})
        }
      """
    )
  
  }

  // @LINE:81
  class ReverseStudentController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:82
    def haveCourseAccess: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.haveCourseAccess",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/joincourse/haveaccess"})
        }
      """
    )
  
    // @LINE:81
    def joinCourse: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.joinCourse",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/joincourse"})
        }
      """
    )
  
    // @LINE:102
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.StudentController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/test"})
        }
      """
    )
  
  }

  // @LINE:76
  class ReverseTeacherController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:77
    def saveRaport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.saveRaport",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "daily/reportSubmit"})
        }
      """
    )
  
    // @LINE:100
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "teacher/test"})
        }
      """
    )
  
    // @LINE:76
    def dailyReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.TeacherController.dailyReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "daily/report"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def createProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.createProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createprofile"})
        }
      """
    )
  
    // @LINE:24
    def newMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.newMessage",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:98
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/test"})
        }
      """
    )
  
    // @LINE:20
    def saveProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.saveProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/editprofile"})
        }
      """
    )
  
    // @LINE:19
    def editProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.editProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/editprofile"})
        }
      """
    )
  
    // @LINE:23
    def studentList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.studentList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/message"})
        }
      """
    )
  
    // @LINE:17
    def updateProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.updateProfile",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createprofile"})
        }
      """
    )
  
    // @LINE:26
    def allMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.allMessage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allMessage"})
        }
      """
    )
  
    // @LINE:25
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.sendMessage",
      """
        function(id) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "message/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
    // @LINE:27
    def seeMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.users.UserController.seeMessage",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/selected/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
        }
      """
    )
  
  }

  // @LINE:101
  class ReverseMentorController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:101
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