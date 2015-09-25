
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/prile/Desktop/bitClassroom/conf/routes
// @DATE:Thu Sep 24 13:08:30 CEST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  Application_6: javax.inject.Provider[controllers.Application],
  // @LINE:16
  UserController_2: javax.inject.Provider[controllers.users.UserController],
  // @LINE:31
  AdminController_1: javax.inject.Provider[controllers.users.AdminController],
  // @LINE:76
  TeacherController_0: javax.inject.Provider[controllers.users.TeacherController],
  // @LINE:81
  StudentController_3: javax.inject.Provider[controllers.users.StudentController],
  // @LINE:86
  CourseController_4: javax.inject.Provider[controllers.course.CourseController],
  // @LINE:90
  PostController_8: javax.inject.Provider[controllers.posts.PostController],
  // @LINE:101
  MentorController_5: javax.inject.Provider[controllers.users.MentorController],
  // @LINE:106
  Assets_7: javax.inject.Provider[controllers.Assets],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    Application_6: javax.inject.Provider[controllers.Application],
    // @LINE:16
    UserController_2: javax.inject.Provider[controllers.users.UserController],
    // @LINE:31
    AdminController_1: javax.inject.Provider[controllers.users.AdminController],
    // @LINE:76
    TeacherController_0: javax.inject.Provider[controllers.users.TeacherController],
    // @LINE:81
    StudentController_3: javax.inject.Provider[controllers.users.StudentController],
    // @LINE:86
    CourseController_4: javax.inject.Provider[controllers.course.CourseController],
    // @LINE:90
    PostController_8: javax.inject.Provider[controllers.posts.PostController],
    // @LINE:101
    MentorController_5: javax.inject.Provider[controllers.users.MentorController],
    // @LINE:106
    Assets_7: javax.inject.Provider[controllers.Assets]
  ) = this(errorHandler, Application_6, UserController_2, AdminController_1, TeacherController_0, StudentController_3, CourseController_4, PostController_8, MentorController_5, Assets_7, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_6, UserController_2, AdminController_1, TeacherController_0, StudentController_3, CourseController_4, PostController_8, MentorController_5, Assets_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """@controllers.Application@.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """about""", """@controllers.Application@.about()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """@controllers.Application@.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """@controllers.Application@.logout()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """@controllers.Application@.checkLogin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """util/email""", """@controllers.Application@.sendEmail()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/createprofile""", """@controllers.users.UserController@.createProfile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/createprofile""", """@controllers.users.UserController@.updateProfile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/editprofile""", """@controllers.users.UserController@.editProfile()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/editprofile""", """@controllers.users.UserController@.saveProfile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/message""", """@controllers.users.UserController@.studentList()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>""", """@controllers.users.UserController@.newMessage(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>""", """@controllers.users.UserController@.sendMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allMessage""", """@controllers.users.UserController@.allMessage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/selected/$id<[^/]+>""", """@controllers.users.UserController@.seeMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin""", """@controllers.users.AdminController@.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/adduser""", """@controllers.users.AdminController@.addNewUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/adduser""", """@controllers.users.AdminController@.saveNewUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/allusers""", """@controllers.users.AdminController@.listOfUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/errors""", """@controllers.users.AdminController@.seeErrors()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/error/$id<[^/]+>""", """@controllers.users.AdminController@.deleteError(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/mentorship""", """@controllers.users.AdminController@.mentorship()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/mentorship""", """@controllers.users.AdminController@.saveMentorship()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/activementors""", """@controllers.users.AdminController@.seeMentorsAndStudents()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/activementors/$id<[^/]+>""", """@controllers.users.AdminController@.deleteMentorship(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/approvestudent""", """@controllers.users.AdminController@.approveStudent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/awaitlist""", """@controllers.users.AdminController@.awaitList()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createdaily""", """@controllers.users.AdminController@.genField()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/savefielddaily""", """@controllers.users.AdminController@.saveField()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport""", """@controllers.users.AdminController@.listReport()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport/$id<[^/]+>""", """@controllers.users.AdminController@.deleteReport(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport/$id<[^/]+>""", """@controllers.users.AdminController@.deleteReport(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createcourse""", """@controllers.users.AdminController@.addCourse()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createcourse""", """@controllers.users.AdminController@.saveCourse()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/delete/$id<[^/]+>""", """@controllers.users.AdminController@.deleteUser(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/delete/$id<[^/]+>""", """@controllers.users.AdminController@.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """daily/report""", """@controllers.users.TeacherController@.dailyReport()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """daily/reportSubmit""", """@controllers.users.TeacherController@.saveRaport()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/joincourse""", """@controllers.users.StudentController@.joinCourse()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/joincourse/haveaccess""", """@controllers.users.StudentController@.haveCourseAccess()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/courses""", """@controllers.course.CourseController@.allCourses()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/class""", """@controllers.course.CourseController@.course()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/new""", """@controllers.posts.PostController@.addPost()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/""", """@controllers.posts.PostController@.savePost()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """notify""", """@controllers.Application@.getNotification()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/test""", """@controllers.users.UserController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/test""", """@controllers.users.AdminController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """teacher/test""", """@controllers.users.TeacherController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mentor/test""", """@controllers.users.MentorController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/test""", """@controllers.users.StudentController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """@controllers.Assets@.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_6.get.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ 				:: APPLICATION ROUTES BELLOW ::
 Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_about1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("about")))
  )
  private[this] lazy val controllers_Application_about1_invoker = createInvoker(
    Application_6.get.about(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "about",
      Nil,
      "GET",
      """""",
      this.prefix + """about"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_login2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_login2_invoker = createInvoker(
    Application_6.get.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_logout3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Application_logout3_invoker = createInvoker(
    Application_6.get.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Application_checkLogin4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Application_checkLogin4_invoker = createInvoker(
    Application_6.get.checkLogin(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "checkLogin",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Application_sendEmail5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("util/email")))
  )
  private[this] lazy val controllers_Application_sendEmail5_invoker = createInvoker(
    Application_6.get.sendEmail(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "sendEmail",
      Nil,
      "GET",
      """""",
      this.prefix + """util/email"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_users_UserController_createProfile6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/createprofile")))
  )
  private[this] lazy val controllers_users_UserController_createProfile6_invoker = createInvoker(
    UserController_2.get.createProfile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "createProfile",
      Nil,
      "GET",
      """ 				:: USERS ROUTES BELLOW ::""",
      this.prefix + """user/createprofile"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_users_UserController_updateProfile7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/createprofile")))
  )
  private[this] lazy val controllers_users_UserController_updateProfile7_invoker = createInvoker(
    UserController_2.get.updateProfile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "updateProfile",
      Nil,
      "POST",
      """""",
      this.prefix + """user/createprofile"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_users_UserController_editProfile8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/editprofile")))
  )
  private[this] lazy val controllers_users_UserController_editProfile8_invoker = createInvoker(
    UserController_2.get.editProfile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "editProfile",
      Nil,
      "GET",
      """""",
      this.prefix + """user/editprofile"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_users_UserController_saveProfile9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/editprofile")))
  )
  private[this] lazy val controllers_users_UserController_saveProfile9_invoker = createInvoker(
    UserController_2.get.saveProfile(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "saveProfile",
      Nil,
      "POST",
      """""",
      this.prefix + """user/editprofile"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_users_UserController_studentList10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/message")))
  )
  private[this] lazy val controllers_users_UserController_studentList10_invoker = createInvoker(
    UserController_2.get.studentList(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "studentList",
      Nil,
      "GET",
      """ NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI """,
      this.prefix + """user/message"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_users_UserController_newMessage11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_newMessage11_invoker = createInvoker(
    UserController_2.get.newMessage(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "newMessage",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """message/$id<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_users_UserController_sendMessage12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_sendMessage12_invoker = createInvoker(
    UserController_2.get.sendMessage(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "sendMessage",
      Seq(classOf[Long]),
      "POST",
      """""",
      this.prefix + """message/$id<[^/]+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_users_UserController_allMessage13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allMessage")))
  )
  private[this] lazy val controllers_users_UserController_allMessage13_invoker = createInvoker(
    UserController_2.get.allMessage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "allMessage",
      Nil,
      "GET",
      """""",
      this.prefix + """allMessage"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_users_UserController_seeMessage14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/selected/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_seeMessage14_invoker = createInvoker(
    UserController_2.get.seeMessage(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "seeMessage",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """message/selected/$id<[^/]+>"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_users_AdminController_index15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_users_AdminController_index15_invoker = createInvoker(
    AdminController_1.get.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "index",
      Nil,
      "GET",
      """				:: ADMIN ROUTES BELLOW ::
 Admin index page""",
      this.prefix + """admin"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_users_AdminController_addNewUser16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/adduser")))
  )
  private[this] lazy val controllers_users_AdminController_addNewUser16_invoker = createInvoker(
    AdminController_1.get.addNewUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "addNewUser",
      Nil,
      "GET",
      """ Routes for registering new user""",
      this.prefix + """admin/adduser"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_users_AdminController_saveNewUser17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/adduser")))
  )
  private[this] lazy val controllers_users_AdminController_saveNewUser17_invoker = createInvoker(
    AdminController_1.get.saveNewUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "saveNewUser",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/adduser"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_users_AdminController_listOfUser18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/allusers")))
  )
  private[this] lazy val controllers_users_AdminController_listOfUser18_invoker = createInvoker(
    AdminController_1.get.listOfUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "listOfUser",
      Nil,
      "GET",
      """ Route for seeing all users""",
      this.prefix + """admin/allusers"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_users_AdminController_seeErrors19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/errors")))
  )
  private[this] lazy val controllers_users_AdminController_seeErrors19_invoker = createInvoker(
    AdminController_1.get.seeErrors(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "seeErrors",
      Nil,
      "GET",
      """ Route for seeing and deleting all errors logged in application""",
      this.prefix + """admin/errors"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_users_AdminController_deleteError20_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/error/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteError20_invoker = createInvoker(
    AdminController_1.get.deleteError(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteError",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """admin/error/$id<[^/]+>"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_users_AdminController_mentorship21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/mentorship")))
  )
  private[this] lazy val controllers_users_AdminController_mentorship21_invoker = createInvoker(
    AdminController_1.get.mentorship(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "mentorship",
      Nil,
      "GET",
      """ Assign mentor to student""",
      this.prefix + """admin/mentorship"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_users_AdminController_saveMentorship22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/mentorship")))
  )
  private[this] lazy val controllers_users_AdminController_saveMentorship22_invoker = createInvoker(
    AdminController_1.get.saveMentorship(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "saveMentorship",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/mentorship"""
    )
  )

  // @LINE:49
  private[this] lazy val controllers_users_AdminController_seeMentorsAndStudents23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/activementors")))
  )
  private[this] lazy val controllers_users_AdminController_seeMentorsAndStudents23_invoker = createInvoker(
    AdminController_1.get.seeMentorsAndStudents(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "seeMentorsAndStudents",
      Nil,
      "GET",
      """ See active mentorships and delete it""",
      this.prefix + """admin/activementors"""
    )
  )

  // @LINE:50
  private[this] lazy val controllers_users_AdminController_deleteMentorship24_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/activementors/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteMentorship24_invoker = createInvoker(
    AdminController_1.get.deleteMentorship(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteMentorship",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """admin/activementors/$id<[^/]+>"""
    )
  )

  // @LINE:53
  private[this] lazy val controllers_users_AdminController_approveStudent25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/approvestudent")))
  )
  private[this] lazy val controllers_users_AdminController_approveStudent25_invoker = createInvoker(
    AdminController_1.get.approveStudent(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "approveStudent",
      Nil,
      "POST",
      """ Routes for admin approval of user to join certain course""",
      this.prefix + """admin/approvestudent"""
    )
  )

  // @LINE:54
  private[this] lazy val controllers_users_AdminController_awaitList26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/awaitlist")))
  )
  private[this] lazy val controllers_users_AdminController_awaitList26_invoker = createInvoker(
    AdminController_1.get.awaitList(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "awaitList",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/awaitlist"""
    )
  )

  // @LINE:57
  private[this] lazy val controllers_users_AdminController_genField27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createdaily")))
  )
  private[this] lazy val controllers_users_AdminController_genField27_invoker = createInvoker(
    AdminController_1.get.genField(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "genField",
      Nil,
      "GET",
      """ Create report field""",
      this.prefix + """admin/createdaily"""
    )
  )

  // @LINE:58
  private[this] lazy val controllers_users_AdminController_saveField28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/savefielddaily")))
  )
  private[this] lazy val controllers_users_AdminController_saveField28_invoker = createInvoker(
    AdminController_1.get.saveField(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "saveField",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/savefielddaily"""
    )
  )

  // @LINE:61
  private[this] lazy val controllers_users_AdminController_listReport29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport")))
  )
  private[this] lazy val controllers_users_AdminController_listReport29_invoker = createInvoker(
    AdminController_1.get.listReport(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "listReport",
      Nil,
      "GET",
      """ See submited daily reports""",
      this.prefix + """listReport"""
    )
  )

  // @LINE:62
  private[this] lazy val controllers_users_AdminController_deleteReport30_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteReport30_invoker = createInvoker(
    AdminController_1.get.deleteReport(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteReport",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """listReport/$id<[^/]+>"""
    )
  )

  // @LINE:63
  private[this] lazy val controllers_users_AdminController_deleteReport31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteReport31_invoker = createInvoker(
    AdminController_1.get.deleteReport(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteReport",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """listReport/$id<[^/]+>"""
    )
  )

  // @LINE:66
  private[this] lazy val controllers_users_AdminController_addCourse32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createcourse")))
  )
  private[this] lazy val controllers_users_AdminController_addCourse32_invoker = createInvoker(
    AdminController_1.get.addCourse(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "addCourse",
      Nil,
      "GET",
      """ Create course""",
      this.prefix + """admin/createcourse"""
    )
  )

  // @LINE:67
  private[this] lazy val controllers_users_AdminController_saveCourse33_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createcourse")))
  )
  private[this] lazy val controllers_users_AdminController_saveCourse33_invoker = createInvoker(
    AdminController_1.get.saveCourse(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "saveCourse",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/createcourse"""
    )
  )

  // @LINE:70
  private[this] lazy val controllers_users_AdminController_deleteUser34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteUser34_invoker = createInvoker(
    AdminController_1.get.deleteUser(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteUser",
      Seq(classOf[Long]),
      "GET",
      """ List of all registered users and option to delete""",
      this.prefix + """admin/delete/$id<[^/]+>"""
    )
  )

  // @LINE:71
  private[this] lazy val controllers_users_AdminController_deleteUser35_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteUser35_invoker = createInvoker(
    AdminController_1.get.deleteUser(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteUser",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """admin/delete/$id<[^/]+>"""
    )
  )

  // @LINE:76
  private[this] lazy val controllers_users_TeacherController_dailyReport36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("daily/report")))
  )
  private[this] lazy val controllers_users_TeacherController_dailyReport36_invoker = createInvoker(
    TeacherController_0.get.dailyReport(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.TeacherController",
      "dailyReport",
      Nil,
      "GET",
      """				:: TEACHER ROUTES BELLOW ::
 Daily report for teachers""",
      this.prefix + """daily/report"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_users_TeacherController_saveRaport37_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("daily/reportSubmit")))
  )
  private[this] lazy val controllers_users_TeacherController_saveRaport37_invoker = createInvoker(
    TeacherController_0.get.saveRaport(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.TeacherController",
      "saveRaport",
      Nil,
      "POST",
      """""",
      this.prefix + """daily/reportSubmit"""
    )
  )

  // @LINE:81
  private[this] lazy val controllers_users_StudentController_joinCourse38_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/joincourse")))
  )
  private[this] lazy val controllers_users_StudentController_joinCourse38_invoker = createInvoker(
    StudentController_3.get.joinCourse(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.StudentController",
      "joinCourse",
      Nil,
      "POST",
      """				:: STUDENT ROUTES BELLOW ::
 Students joining course""",
      this.prefix + """student/joincourse"""
    )
  )

  // @LINE:82
  private[this] lazy val controllers_users_StudentController_haveCourseAccess39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/joincourse/haveaccess")))
  )
  private[this] lazy val controllers_users_StudentController_haveCourseAccess39_invoker = createInvoker(
    StudentController_3.get.haveCourseAccess(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.StudentController",
      "haveCourseAccess",
      Nil,
      "POST",
      """""",
      this.prefix + """student/joincourse/haveaccess"""
    )
  )

  // @LINE:86
  private[this] lazy val controllers_course_CourseController_allCourses40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/courses")))
  )
  private[this] lazy val controllers_course_CourseController_allCourses40_invoker = createInvoker(
    CourseController_4.get.allCourses(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.course.CourseController",
      "allCourses",
      Nil,
      "GET",
      """ NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI NEMA SIGURNOSTI 
 				::COURSE ROUTES BELLOW ::""",
      this.prefix + """user/courses"""
    )
  )

  // @LINE:87
  private[this] lazy val controllers_course_CourseController_course41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/class")))
  )
  private[this] lazy val controllers_course_CourseController_course41_invoker = createInvoker(
    CourseController_4.get.course(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.course.CourseController",
      "course",
      Nil,
      "GET",
      """""",
      this.prefix + """user/class"""
    )
  )

  // @LINE:90
  private[this] lazy val controllers_posts_PostController_addPost42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/new")))
  )
  private[this] lazy val controllers_posts_PostController_addPost42_invoker = createInvoker(
    PostController_8.get.addPost(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.posts.PostController",
      "addPost",
      Nil,
      "GET",
      """ 				:: POST ROUTES BELLOW ::""",
      this.prefix + """post/new"""
    )
  )

  // @LINE:91
  private[this] lazy val controllers_posts_PostController_savePost43_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/")))
  )
  private[this] lazy val controllers_posts_PostController_savePost43_invoker = createInvoker(
    PostController_8.get.savePost(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.posts.PostController",
      "savePost",
      Nil,
      "POST",
      """""",
      this.prefix + """post/"""
    )
  )

  // @LINE:94
  private[this] lazy val controllers_Application_getNotification44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("notify")))
  )
  private[this] lazy val controllers_Application_getNotification44_invoker = createInvoker(
    Application_6.get.getNotification(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getNotification",
      Nil,
      "POST",
      """ Notification for users that applied to course #TODO MOVE TO ADMIN""",
      this.prefix + """notify"""
    )
  )

  // @LINE:98
  private[this] lazy val controllers_users_UserController_test45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/test")))
  )
  private[this] lazy val controllers_users_UserController_test45_invoker = createInvoker(
    UserController_2.get.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "test",
      Nil,
      "GET",
      """ FOR TESTING ONLY""",
      this.prefix + """user/test"""
    )
  )

  // @LINE:99
  private[this] lazy val controllers_users_AdminController_test46_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/test")))
  )
  private[this] lazy val controllers_users_AdminController_test46_invoker = createInvoker(
    AdminController_1.get.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "test",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/test"""
    )
  )

  // @LINE:100
  private[this] lazy val controllers_users_TeacherController_test47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("teacher/test")))
  )
  private[this] lazy val controllers_users_TeacherController_test47_invoker = createInvoker(
    TeacherController_0.get.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.TeacherController",
      "test",
      Nil,
      "GET",
      """""",
      this.prefix + """teacher/test"""
    )
  )

  // @LINE:101
  private[this] lazy val controllers_users_MentorController_test48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mentor/test")))
  )
  private[this] lazy val controllers_users_MentorController_test48_invoker = createInvoker(
    MentorController_5.get.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.MentorController",
      "test",
      Nil,
      "GET",
      """""",
      this.prefix + """mentor/test"""
    )
  )

  // @LINE:102
  private[this] lazy val controllers_users_StudentController_test49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/test")))
  )
  private[this] lazy val controllers_users_StudentController_test49_invoker = createInvoker(
    StudentController_3.get.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.StudentController",
      "test",
      Nil,
      "GET",
      """""",
      this.prefix + """student/test"""
    )
  )

  // @LINE:106
  private[this] lazy val controllers_Assets_versioned50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned50_invoker = createInvoker(
    Assets_7.get.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_6.get.index())
      }
  
    // @LINE:8
    case controllers_Application_about1_route(params) =>
      call { 
        controllers_Application_about1_invoker.call(Application_6.get.about())
      }
  
    // @LINE:10
    case controllers_Application_login2_route(params) =>
      call { 
        controllers_Application_login2_invoker.call(Application_6.get.login())
      }
  
    // @LINE:11
    case controllers_Application_logout3_route(params) =>
      call { 
        controllers_Application_logout3_invoker.call(Application_6.get.logout())
      }
  
    // @LINE:12
    case controllers_Application_checkLogin4_route(params) =>
      call { 
        controllers_Application_checkLogin4_invoker.call(Application_6.get.checkLogin())
      }
  
    // @LINE:13
    case controllers_Application_sendEmail5_route(params) =>
      call { 
        controllers_Application_sendEmail5_invoker.call(Application_6.get.sendEmail())
      }
  
    // @LINE:16
    case controllers_users_UserController_createProfile6_route(params) =>
      call { 
        controllers_users_UserController_createProfile6_invoker.call(UserController_2.get.createProfile())
      }
  
    // @LINE:17
    case controllers_users_UserController_updateProfile7_route(params) =>
      call { 
        controllers_users_UserController_updateProfile7_invoker.call(UserController_2.get.updateProfile())
      }
  
    // @LINE:19
    case controllers_users_UserController_editProfile8_route(params) =>
      call { 
        controllers_users_UserController_editProfile8_invoker.call(UserController_2.get.editProfile())
      }
  
    // @LINE:20
    case controllers_users_UserController_saveProfile9_route(params) =>
      call { 
        controllers_users_UserController_saveProfile9_invoker.call(UserController_2.get.saveProfile())
      }
  
    // @LINE:23
    case controllers_users_UserController_studentList10_route(params) =>
      call { 
        controllers_users_UserController_studentList10_invoker.call(UserController_2.get.studentList())
      }
  
    // @LINE:24
    case controllers_users_UserController_newMessage11_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_newMessage11_invoker.call(UserController_2.get.newMessage(id))
      }
  
    // @LINE:25
    case controllers_users_UserController_sendMessage12_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_sendMessage12_invoker.call(UserController_2.get.sendMessage(id))
      }
  
    // @LINE:26
    case controllers_users_UserController_allMessage13_route(params) =>
      call { 
        controllers_users_UserController_allMessage13_invoker.call(UserController_2.get.allMessage())
      }
  
    // @LINE:27
    case controllers_users_UserController_seeMessage14_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_seeMessage14_invoker.call(UserController_2.get.seeMessage(id))
      }
  
    // @LINE:31
    case controllers_users_AdminController_index15_route(params) =>
      call { 
        controllers_users_AdminController_index15_invoker.call(AdminController_1.get.index())
      }
  
    // @LINE:34
    case controllers_users_AdminController_addNewUser16_route(params) =>
      call { 
        controllers_users_AdminController_addNewUser16_invoker.call(AdminController_1.get.addNewUser())
      }
  
    // @LINE:35
    case controllers_users_AdminController_saveNewUser17_route(params) =>
      call { 
        controllers_users_AdminController_saveNewUser17_invoker.call(AdminController_1.get.saveNewUser())
      }
  
    // @LINE:38
    case controllers_users_AdminController_listOfUser18_route(params) =>
      call { 
        controllers_users_AdminController_listOfUser18_invoker.call(AdminController_1.get.listOfUser())
      }
  
    // @LINE:41
    case controllers_users_AdminController_seeErrors19_route(params) =>
      call { 
        controllers_users_AdminController_seeErrors19_invoker.call(AdminController_1.get.seeErrors())
      }
  
    // @LINE:42
    case controllers_users_AdminController_deleteError20_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteError20_invoker.call(AdminController_1.get.deleteError(id))
      }
  
    // @LINE:45
    case controllers_users_AdminController_mentorship21_route(params) =>
      call { 
        controllers_users_AdminController_mentorship21_invoker.call(AdminController_1.get.mentorship())
      }
  
    // @LINE:46
    case controllers_users_AdminController_saveMentorship22_route(params) =>
      call { 
        controllers_users_AdminController_saveMentorship22_invoker.call(AdminController_1.get.saveMentorship())
      }
  
    // @LINE:49
    case controllers_users_AdminController_seeMentorsAndStudents23_route(params) =>
      call { 
        controllers_users_AdminController_seeMentorsAndStudents23_invoker.call(AdminController_1.get.seeMentorsAndStudents())
      }
  
    // @LINE:50
    case controllers_users_AdminController_deleteMentorship24_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteMentorship24_invoker.call(AdminController_1.get.deleteMentorship(id))
      }
  
    // @LINE:53
    case controllers_users_AdminController_approveStudent25_route(params) =>
      call { 
        controllers_users_AdminController_approveStudent25_invoker.call(AdminController_1.get.approveStudent())
      }
  
    // @LINE:54
    case controllers_users_AdminController_awaitList26_route(params) =>
      call { 
        controllers_users_AdminController_awaitList26_invoker.call(AdminController_1.get.awaitList())
      }
  
    // @LINE:57
    case controllers_users_AdminController_genField27_route(params) =>
      call { 
        controllers_users_AdminController_genField27_invoker.call(AdminController_1.get.genField())
      }
  
    // @LINE:58
    case controllers_users_AdminController_saveField28_route(params) =>
      call { 
        controllers_users_AdminController_saveField28_invoker.call(AdminController_1.get.saveField())
      }
  
    // @LINE:61
    case controllers_users_AdminController_listReport29_route(params) =>
      call { 
        controllers_users_AdminController_listReport29_invoker.call(AdminController_1.get.listReport())
      }
  
    // @LINE:62
    case controllers_users_AdminController_deleteReport30_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteReport30_invoker.call(AdminController_1.get.deleteReport(id))
      }
  
    // @LINE:63
    case controllers_users_AdminController_deleteReport31_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteReport31_invoker.call(AdminController_1.get.deleteReport(id))
      }
  
    // @LINE:66
    case controllers_users_AdminController_addCourse32_route(params) =>
      call { 
        controllers_users_AdminController_addCourse32_invoker.call(AdminController_1.get.addCourse())
      }
  
    // @LINE:67
    case controllers_users_AdminController_saveCourse33_route(params) =>
      call { 
        controllers_users_AdminController_saveCourse33_invoker.call(AdminController_1.get.saveCourse())
      }
  
    // @LINE:70
    case controllers_users_AdminController_deleteUser34_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteUser34_invoker.call(AdminController_1.get.deleteUser(id))
      }
  
    // @LINE:71
    case controllers_users_AdminController_deleteUser35_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteUser35_invoker.call(AdminController_1.get.deleteUser(id))
      }
  
    // @LINE:76
    case controllers_users_TeacherController_dailyReport36_route(params) =>
      call { 
        controllers_users_TeacherController_dailyReport36_invoker.call(TeacherController_0.get.dailyReport())
      }
  
    // @LINE:77
    case controllers_users_TeacherController_saveRaport37_route(params) =>
      call { 
        controllers_users_TeacherController_saveRaport37_invoker.call(TeacherController_0.get.saveRaport())
      }
  
    // @LINE:81
    case controllers_users_StudentController_joinCourse38_route(params) =>
      call { 
        controllers_users_StudentController_joinCourse38_invoker.call(StudentController_3.get.joinCourse())
      }
  
    // @LINE:82
    case controllers_users_StudentController_haveCourseAccess39_route(params) =>
      call { 
        controllers_users_StudentController_haveCourseAccess39_invoker.call(StudentController_3.get.haveCourseAccess())
      }
  
    // @LINE:86
    case controllers_course_CourseController_allCourses40_route(params) =>
      call { 
        controllers_course_CourseController_allCourses40_invoker.call(CourseController_4.get.allCourses())
      }
  
    // @LINE:87
    case controllers_course_CourseController_course41_route(params) =>
      call { 
        controllers_course_CourseController_course41_invoker.call(CourseController_4.get.course())
      }
  
    // @LINE:90
    case controllers_posts_PostController_addPost42_route(params) =>
      call { 
        controllers_posts_PostController_addPost42_invoker.call(PostController_8.get.addPost())
      }
  
    // @LINE:91
    case controllers_posts_PostController_savePost43_route(params) =>
      call { 
        controllers_posts_PostController_savePost43_invoker.call(PostController_8.get.savePost())
      }
  
    // @LINE:94
    case controllers_Application_getNotification44_route(params) =>
      call { 
        controllers_Application_getNotification44_invoker.call(Application_6.get.getNotification())
      }
  
    // @LINE:98
    case controllers_users_UserController_test45_route(params) =>
      call { 
        controllers_users_UserController_test45_invoker.call(UserController_2.get.test())
      }
  
    // @LINE:99
    case controllers_users_AdminController_test46_route(params) =>
      call { 
        controllers_users_AdminController_test46_invoker.call(AdminController_1.get.test())
      }
  
    // @LINE:100
    case controllers_users_TeacherController_test47_route(params) =>
      call { 
        controllers_users_TeacherController_test47_invoker.call(TeacherController_0.get.test())
      }
  
    // @LINE:101
    case controllers_users_MentorController_test48_route(params) =>
      call { 
        controllers_users_MentorController_test48_invoker.call(MentorController_5.get.test())
      }
  
    // @LINE:102
    case controllers_users_StudentController_test49_route(params) =>
      call { 
        controllers_users_StudentController_test49_invoker.call(StudentController_3.get.test())
      }
  
    // @LINE:106
    case controllers_Assets_versioned50_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned50_invoker.call(Assets_7.get.versioned(path, file))
      }
  }
}