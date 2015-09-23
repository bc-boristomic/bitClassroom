
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/conf/routes
// @DATE:Wed Sep 23 19:50:14 CEST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_6: javax.inject.Provider[controllers.Application],
  // @LINE:14
  UserController_2: javax.inject.Provider[controllers.users.UserController],
  // @LINE:20
  PostController_8: javax.inject.Provider[controllers.posts.PostController],
  // @LINE:23
  AdminController_1: javax.inject.Provider[controllers.users.AdminController],
  // @LINE:37
  StudentController_3: javax.inject.Provider[controllers.users.StudentController],
  // @LINE:59
  TeacherController_0: javax.inject.Provider[controllers.users.TeacherController],
  // @LINE:71
  MentorController_5: javax.inject.Provider[controllers.users.MentorController],
  // @LINE:77
  Assets_7: javax.inject.Provider[controllers.Assets],
  // @LINE:80
  CourseController_4: javax.inject.Provider[controllers.course.CourseController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_6: javax.inject.Provider[controllers.Application],
    // @LINE:14
    UserController_2: javax.inject.Provider[controllers.users.UserController],
    // @LINE:20
    PostController_8: javax.inject.Provider[controllers.posts.PostController],
    // @LINE:23
    AdminController_1: javax.inject.Provider[controllers.users.AdminController],
    // @LINE:37
    StudentController_3: javax.inject.Provider[controllers.users.StudentController],
    // @LINE:59
    TeacherController_0: javax.inject.Provider[controllers.users.TeacherController],
    // @LINE:71
    MentorController_5: javax.inject.Provider[controllers.users.MentorController],
    // @LINE:77
    Assets_7: javax.inject.Provider[controllers.Assets],
    // @LINE:80
    CourseController_4: javax.inject.Provider[controllers.course.CourseController]
  ) = this(errorHandler, Application_6, UserController_2, PostController_8, AdminController_1, StudentController_3, TeacherController_0, MentorController_5, Assets_7, CourseController_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_6, UserController_2, PostController_8, AdminController_1, StudentController_3, TeacherController_0, MentorController_5, Assets_7, CourseController_4, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/new""", """@controllers.posts.PostController@.addPost()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/""", """@controllers.posts.PostController@.savePost()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin""", """@controllers.users.AdminController@.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/adduser""", """@controllers.users.AdminController@.addNewUser()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/adduser""", """@controllers.users.AdminController@.saveNewUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/allusers""", """@controllers.users.AdminController@.listOfUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/errors""", """@controllers.users.AdminController@.seeErrors()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/approvestudent""", """@controllers.users.AdminController@.approveStudent()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/awaitlist""", """@controllers.users.AdminController@.awaitList()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/joincourse""", """@controllers.users.StudentController@.joinCourse()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/joincourse/haveaccess""", """@controllers.users.StudentController@.haveCourseAccess()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createdaily""", """@controllers.users.AdminController@.genField()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/savefielddaily""", """@controllers.users.AdminController@.saveField()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport""", """@controllers.users.AdminController@.listReport()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport/$id<[^/]+>""", """@controllers.users.AdminController@.deleteReport(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listReport/$id<[^/]+>""", """@controllers.users.AdminController@.deleteReport(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createcourse""", """@controllers.users.AdminController@.addCourse()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/createcourse""", """@controllers.users.AdminController@.saveCourse()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """daily/report""", """@controllers.users.TeacherController@.dailyReport()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """daily/reportSubmit""", """@controllers.users.TeacherController@.saveRaport()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/delete/$id<[^/]+>""", """@controllers.users.AdminController@.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/delete/$id<[^/]+>""", """@controllers.users.AdminController@.deleteUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/errors""", """@controllers.users.AdminController@.seeErrors()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/error/$id<[^/]+>""", """@controllers.users.AdminController@.deleteError(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/test""", """@controllers.users.UserController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/test""", """@controllers.users.AdminController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """teacher/test""", """@controllers.users.TeacherController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mentor/test""", """@controllers.users.MentorController@.test()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """student/test""", """@controllers.users.StudentController@.test()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """notify""", """@controllers.Application@.getNotification()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """@controllers.Assets@.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/courses""", """@controllers.course.CourseController@.allCourses()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/class""", """@controllers.course.CourseController@.course()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/mentorship""", """@controllers.users.AdminController@.mentorship()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/mentorship""", """@controllers.users.AdminController@.saveMentorship()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/activementors""", """@controllers.users.AdminController@.seeMentorsAndStudents()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/activementors/$id<[^/]+>""", """@controllers.users.AdminController@.deleteMentorship(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/message""", """@controllers.users.UserController@.studentList()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>""", """@controllers.users.UserController@.newMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>/send""", """@controllers.users.UserController@.sendMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allMessage""", """@controllers.users.UserController@.allMessage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/message""", """@controllers.users.UserController@.studentList()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>""", """@controllers.users.UserController@.newMessage(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/$id<[^/]+>""", """@controllers.users.UserController@.sendMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """allMessage""", """@controllers.users.UserController@.allMessage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message/selected/$id<[^/]+>""", """@controllers.users.UserController@.seeMessage(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/class""", """@controllers.course.CourseController@.course()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
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
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
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

  // @LINE:9
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

  // @LINE:10
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

  // @LINE:11
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

  // @LINE:12
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

  // @LINE:14
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
      """""",
      this.prefix + """user/createprofile"""
    )
  )

  // @LINE:15
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

  // @LINE:17
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

  // @LINE:18
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

  // @LINE:20
  private[this] lazy val controllers_posts_PostController_addPost10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/new")))
  )
  private[this] lazy val controllers_posts_PostController_addPost10_invoker = createInvoker(
    PostController_8.get.addPost(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.posts.PostController",
      "addPost",
      Nil,
      "GET",
      """""",
      this.prefix + """post/new"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_posts_PostController_savePost11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/")))
  )
  private[this] lazy val controllers_posts_PostController_savePost11_invoker = createInvoker(
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

  // @LINE:23
  private[this] lazy val controllers_users_AdminController_index12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin")))
  )
  private[this] lazy val controllers_users_AdminController_index12_invoker = createInvoker(
    AdminController_1.get.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """admin"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_users_AdminController_addNewUser13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/adduser")))
  )
  private[this] lazy val controllers_users_AdminController_addNewUser13_invoker = createInvoker(
    AdminController_1.get.addNewUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "addNewUser",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/adduser"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_users_AdminController_saveNewUser14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/adduser")))
  )
  private[this] lazy val controllers_users_AdminController_saveNewUser14_invoker = createInvoker(
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

  // @LINE:28
  private[this] lazy val controllers_users_AdminController_listOfUser15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/allusers")))
  )
  private[this] lazy val controllers_users_AdminController_listOfUser15_invoker = createInvoker(
    AdminController_1.get.listOfUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "listOfUser",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/allusers"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_users_AdminController_seeErrors16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/errors")))
  )
  private[this] lazy val controllers_users_AdminController_seeErrors16_invoker = createInvoker(
    AdminController_1.get.seeErrors(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "seeErrors",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/errors"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_users_AdminController_approveStudent17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/approvestudent")))
  )
  private[this] lazy val controllers_users_AdminController_approveStudent17_invoker = createInvoker(
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

  // @LINE:35
  private[this] lazy val controllers_users_AdminController_awaitList18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/awaitlist")))
  )
  private[this] lazy val controllers_users_AdminController_awaitList18_invoker = createInvoker(
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

  // @LINE:37
  private[this] lazy val controllers_users_StudentController_joinCourse19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/joincourse")))
  )
  private[this] lazy val controllers_users_StudentController_joinCourse19_invoker = createInvoker(
    StudentController_3.get.joinCourse(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.StudentController",
      "joinCourse",
      Nil,
      "POST",
      """""",
      this.prefix + """student/joincourse"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_users_StudentController_haveCourseAccess20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/joincourse/haveaccess")))
  )
  private[this] lazy val controllers_users_StudentController_haveCourseAccess20_invoker = createInvoker(
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

  // @LINE:42
  private[this] lazy val controllers_users_AdminController_genField21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createdaily")))
  )
  private[this] lazy val controllers_users_AdminController_genField21_invoker = createInvoker(
    AdminController_1.get.genField(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "genField",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/createdaily"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_users_AdminController_saveField22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/savefielddaily")))
  )
  private[this] lazy val controllers_users_AdminController_saveField22_invoker = createInvoker(
    AdminController_1.get.saveField(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "saveField",
      Nil,
      "POST",
      """POST          /admin/createdaily              @controllers.users.AdminController.saveField()
ovaj gore ne treba vise""",
      this.prefix + """admin/savefielddaily"""
    )
  )

  // @LINE:49
  private[this] lazy val controllers_users_AdminController_listReport23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport")))
  )
  private[this] lazy val controllers_users_AdminController_listReport23_invoker = createInvoker(
    AdminController_1.get.listReport(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "listReport",
      Nil,
      "GET",
      """""",
      this.prefix + """listReport"""
    )
  )

  // @LINE:50
  private[this] lazy val controllers_users_AdminController_deleteReport24_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteReport24_invoker = createInvoker(
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

  // @LINE:51
  private[this] lazy val controllers_users_AdminController_deleteReport25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listReport/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteReport25_invoker = createInvoker(
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

  // @LINE:56
  private[this] lazy val controllers_users_AdminController_addCourse26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createcourse")))
  )
  private[this] lazy val controllers_users_AdminController_addCourse26_invoker = createInvoker(
    AdminController_1.get.addCourse(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "addCourse",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/createcourse"""
    )
  )

  // @LINE:57
  private[this] lazy val controllers_users_AdminController_saveCourse27_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/createcourse")))
  )
  private[this] lazy val controllers_users_AdminController_saveCourse27_invoker = createInvoker(
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

  // @LINE:59
  private[this] lazy val controllers_users_TeacherController_dailyReport28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("daily/report")))
  )
  private[this] lazy val controllers_users_TeacherController_dailyReport28_invoker = createInvoker(
    TeacherController_0.get.dailyReport(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.TeacherController",
      "dailyReport",
      Nil,
      "GET",
      """""",
      this.prefix + """daily/report"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_users_TeacherController_saveRaport29_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("daily/reportSubmit")))
  )
  private[this] lazy val controllers_users_TeacherController_saveRaport29_invoker = createInvoker(
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

  // @LINE:62
  private[this] lazy val controllers_users_AdminController_deleteUser30_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteUser30_invoker = createInvoker(
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

  // @LINE:63
  private[this] lazy val controllers_users_AdminController_deleteUser31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteUser31_invoker = createInvoker(
    AdminController_1.get.deleteUser(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "deleteUser",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """admin/delete/$id<[^/]+>"""
    )
  )

  // @LINE:64
  private[this] lazy val controllers_users_AdminController_seeErrors32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/errors")))
  )
  private[this] lazy val controllers_users_AdminController_seeErrors32_invoker = createInvoker(
    AdminController_1.get.seeErrors(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "seeErrors",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/errors"""
    )
  )

  // @LINE:65
  private[this] lazy val controllers_users_AdminController_deleteError33_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/error/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteError33_invoker = createInvoker(
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

  // @LINE:68
  private[this] lazy val controllers_users_UserController_test34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/test")))
  )
  private[this] lazy val controllers_users_UserController_test34_invoker = createInvoker(
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

  // @LINE:69
  private[this] lazy val controllers_users_AdminController_test35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/test")))
  )
  private[this] lazy val controllers_users_AdminController_test35_invoker = createInvoker(
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

  // @LINE:70
  private[this] lazy val controllers_users_TeacherController_test36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("teacher/test")))
  )
  private[this] lazy val controllers_users_TeacherController_test36_invoker = createInvoker(
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

  // @LINE:71
  private[this] lazy val controllers_users_MentorController_test37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mentor/test")))
  )
  private[this] lazy val controllers_users_MentorController_test37_invoker = createInvoker(
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

  // @LINE:72
  private[this] lazy val controllers_users_StudentController_test38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("student/test")))
  )
  private[this] lazy val controllers_users_StudentController_test38_invoker = createInvoker(
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

  // @LINE:74
  private[this] lazy val controllers_Application_getNotification39_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("notify")))
  )
  private[this] lazy val controllers_Application_getNotification39_invoker = createInvoker(
    Application_6.get.getNotification(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getNotification",
      Nil,
      "POST",
      """""",
      this.prefix + """notify"""
    )
  )

  // @LINE:77
  private[this] lazy val controllers_Assets_versioned40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned40_invoker = createInvoker(
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

  // @LINE:80
  private[this] lazy val controllers_course_CourseController_allCourses41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/courses")))
  )
  private[this] lazy val controllers_course_CourseController_allCourses41_invoker = createInvoker(
    CourseController_4.get.allCourses(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.course.CourseController",
      "allCourses",
      Nil,
      "GET",
      """""",
      this.prefix + """user/courses"""
    )
  )

  // @LINE:82
  private[this] lazy val controllers_course_CourseController_course42_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/class")))
  )
  private[this] lazy val controllers_course_CourseController_course42_invoker = createInvoker(
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

  // @LINE:85
  private[this] lazy val controllers_users_AdminController_mentorship43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/mentorship")))
  )
  private[this] lazy val controllers_users_AdminController_mentorship43_invoker = createInvoker(
    AdminController_1.get.mentorship(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "mentorship",
      Nil,
      "GET",
      """ Mentorship routes""",
      this.prefix + """admin/mentorship"""
    )
  )

  // @LINE:86
  private[this] lazy val controllers_users_AdminController_saveMentorship44_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/mentorship")))
  )
  private[this] lazy val controllers_users_AdminController_saveMentorship44_invoker = createInvoker(
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

  // @LINE:87
  private[this] lazy val controllers_users_AdminController_seeMentorsAndStudents45_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/activementors")))
  )
  private[this] lazy val controllers_users_AdminController_seeMentorsAndStudents45_invoker = createInvoker(
    AdminController_1.get.seeMentorsAndStudents(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.AdminController",
      "seeMentorsAndStudents",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/activementors"""
    )
  )

  // @LINE:88
  private[this] lazy val controllers_users_AdminController_deleteMentorship46_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/activementors/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_AdminController_deleteMentorship46_invoker = createInvoker(
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

  // @LINE:98
  private[this] lazy val controllers_users_UserController_studentList47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/message")))
  )
  private[this] lazy val controllers_users_UserController_studentList47_invoker = createInvoker(
    UserController_2.get.studentList(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "studentList",
      Nil,
      "GET",
      """""",
      this.prefix + """user/message"""
    )
  )

  // @LINE:99
  private[this] lazy val controllers_users_UserController_newMessage48_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_newMessage48_invoker = createInvoker(
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

  // @LINE:100
  private[this] lazy val controllers_users_UserController_sendMessage49_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true), StaticPart("/send")))
  )
  private[this] lazy val controllers_users_UserController_sendMessage49_invoker = createInvoker(
    UserController_2.get.sendMessage(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "sendMessage",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """message/$id<[^/]+>/send"""
    )
  )

  // @LINE:101
  private[this] lazy val controllers_users_UserController_allMessage50_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allMessage")))
  )
  private[this] lazy val controllers_users_UserController_allMessage50_invoker = createInvoker(
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

  // @LINE:109
  private[this] lazy val controllers_users_UserController_studentList51_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/message")))
  )
  private[this] lazy val controllers_users_UserController_studentList51_invoker = createInvoker(
    UserController_2.get.studentList(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.users.UserController",
      "studentList",
      Nil,
      "GET",
      """""",
      this.prefix + """user/message"""
    )
  )

  // @LINE:110
  private[this] lazy val controllers_users_UserController_newMessage52_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_newMessage52_invoker = createInvoker(
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

  // @LINE:111
  private[this] lazy val controllers_users_UserController_sendMessage53_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_sendMessage53_invoker = createInvoker(
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

  // @LINE:112
  private[this] lazy val controllers_users_UserController_allMessage54_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("allMessage")))
  )
  private[this] lazy val controllers_users_UserController_allMessage54_invoker = createInvoker(
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

  // @LINE:113
  private[this] lazy val controllers_users_UserController_seeMessage55_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message/selected/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_users_UserController_seeMessage55_invoker = createInvoker(
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

  // @LINE:117
  private[this] lazy val controllers_course_CourseController_course56_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/class")))
  )
  private[this] lazy val controllers_course_CourseController_course56_invoker = createInvoker(
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_6.get.index())
      }
  
    // @LINE:7
    case controllers_Application_about1_route(params) =>
      call { 
        controllers_Application_about1_invoker.call(Application_6.get.about())
      }
  
    // @LINE:9
    case controllers_Application_login2_route(params) =>
      call { 
        controllers_Application_login2_invoker.call(Application_6.get.login())
      }
  
    // @LINE:10
    case controllers_Application_logout3_route(params) =>
      call { 
        controllers_Application_logout3_invoker.call(Application_6.get.logout())
      }
  
    // @LINE:11
    case controllers_Application_checkLogin4_route(params) =>
      call { 
        controllers_Application_checkLogin4_invoker.call(Application_6.get.checkLogin())
      }
  
    // @LINE:12
    case controllers_Application_sendEmail5_route(params) =>
      call { 
        controllers_Application_sendEmail5_invoker.call(Application_6.get.sendEmail())
      }
  
    // @LINE:14
    case controllers_users_UserController_createProfile6_route(params) =>
      call { 
        controllers_users_UserController_createProfile6_invoker.call(UserController_2.get.createProfile())
      }
  
    // @LINE:15
    case controllers_users_UserController_updateProfile7_route(params) =>
      call { 
        controllers_users_UserController_updateProfile7_invoker.call(UserController_2.get.updateProfile())
      }
  
    // @LINE:17
    case controllers_users_UserController_editProfile8_route(params) =>
      call { 
        controllers_users_UserController_editProfile8_invoker.call(UserController_2.get.editProfile())
      }
  
    // @LINE:18
    case controllers_users_UserController_saveProfile9_route(params) =>
      call { 
        controllers_users_UserController_saveProfile9_invoker.call(UserController_2.get.saveProfile())
      }
  
    // @LINE:20
    case controllers_posts_PostController_addPost10_route(params) =>
      call { 
        controllers_posts_PostController_addPost10_invoker.call(PostController_8.get.addPost())
      }
  
    // @LINE:21
    case controllers_posts_PostController_savePost11_route(params) =>
      call { 
        controllers_posts_PostController_savePost11_invoker.call(PostController_8.get.savePost())
      }
  
    // @LINE:23
    case controllers_users_AdminController_index12_route(params) =>
      call { 
        controllers_users_AdminController_index12_invoker.call(AdminController_1.get.index())
      }
  
    // @LINE:25
    case controllers_users_AdminController_addNewUser13_route(params) =>
      call { 
        controllers_users_AdminController_addNewUser13_invoker.call(AdminController_1.get.addNewUser())
      }
  
    // @LINE:26
    case controllers_users_AdminController_saveNewUser14_route(params) =>
      call { 
        controllers_users_AdminController_saveNewUser14_invoker.call(AdminController_1.get.saveNewUser())
      }
  
    // @LINE:28
    case controllers_users_AdminController_listOfUser15_route(params) =>
      call { 
        controllers_users_AdminController_listOfUser15_invoker.call(AdminController_1.get.listOfUser())
      }
  
    // @LINE:29
    case controllers_users_AdminController_seeErrors16_route(params) =>
      call { 
        controllers_users_AdminController_seeErrors16_invoker.call(AdminController_1.get.seeErrors())
      }
  
    // @LINE:34
    case controllers_users_AdminController_approveStudent17_route(params) =>
      call { 
        controllers_users_AdminController_approveStudent17_invoker.call(AdminController_1.get.approveStudent())
      }
  
    // @LINE:35
    case controllers_users_AdminController_awaitList18_route(params) =>
      call { 
        controllers_users_AdminController_awaitList18_invoker.call(AdminController_1.get.awaitList())
      }
  
    // @LINE:37
    case controllers_users_StudentController_joinCourse19_route(params) =>
      call { 
        controllers_users_StudentController_joinCourse19_invoker.call(StudentController_3.get.joinCourse())
      }
  
    // @LINE:38
    case controllers_users_StudentController_haveCourseAccess20_route(params) =>
      call { 
        controllers_users_StudentController_haveCourseAccess20_invoker.call(StudentController_3.get.haveCourseAccess())
      }
  
    // @LINE:42
    case controllers_users_AdminController_genField21_route(params) =>
      call { 
        controllers_users_AdminController_genField21_invoker.call(AdminController_1.get.genField())
      }
  
    // @LINE:45
    case controllers_users_AdminController_saveField22_route(params) =>
      call { 
        controllers_users_AdminController_saveField22_invoker.call(AdminController_1.get.saveField())
      }
  
    // @LINE:49
    case controllers_users_AdminController_listReport23_route(params) =>
      call { 
        controllers_users_AdminController_listReport23_invoker.call(AdminController_1.get.listReport())
      }
  
    // @LINE:50
    case controllers_users_AdminController_deleteReport24_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteReport24_invoker.call(AdminController_1.get.deleteReport(id))
      }
  
    // @LINE:51
    case controllers_users_AdminController_deleteReport25_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteReport25_invoker.call(AdminController_1.get.deleteReport(id))
      }
  
    // @LINE:56
    case controllers_users_AdminController_addCourse26_route(params) =>
      call { 
        controllers_users_AdminController_addCourse26_invoker.call(AdminController_1.get.addCourse())
      }
  
    // @LINE:57
    case controllers_users_AdminController_saveCourse27_route(params) =>
      call { 
        controllers_users_AdminController_saveCourse27_invoker.call(AdminController_1.get.saveCourse())
      }
  
    // @LINE:59
    case controllers_users_TeacherController_dailyReport28_route(params) =>
      call { 
        controllers_users_TeacherController_dailyReport28_invoker.call(TeacherController_0.get.dailyReport())
      }
  
    // @LINE:60
    case controllers_users_TeacherController_saveRaport29_route(params) =>
      call { 
        controllers_users_TeacherController_saveRaport29_invoker.call(TeacherController_0.get.saveRaport())
      }
  
    // @LINE:62
    case controllers_users_AdminController_deleteUser30_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteUser30_invoker.call(AdminController_1.get.deleteUser(id))
      }
  
    // @LINE:63
    case controllers_users_AdminController_deleteUser31_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteUser31_invoker.call(AdminController_1.get.deleteUser(id))
      }
  
    // @LINE:64
    case controllers_users_AdminController_seeErrors32_route(params) =>
      call { 
        controllers_users_AdminController_seeErrors32_invoker.call(AdminController_1.get.seeErrors())
      }
  
    // @LINE:65
    case controllers_users_AdminController_deleteError33_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteError33_invoker.call(AdminController_1.get.deleteError(id))
      }
  
    // @LINE:68
    case controllers_users_UserController_test34_route(params) =>
      call { 
        controllers_users_UserController_test34_invoker.call(UserController_2.get.test())
      }
  
    // @LINE:69
    case controllers_users_AdminController_test35_route(params) =>
      call { 
        controllers_users_AdminController_test35_invoker.call(AdminController_1.get.test())
      }
  
    // @LINE:70
    case controllers_users_TeacherController_test36_route(params) =>
      call { 
        controllers_users_TeacherController_test36_invoker.call(TeacherController_0.get.test())
      }
  
    // @LINE:71
    case controllers_users_MentorController_test37_route(params) =>
      call { 
        controllers_users_MentorController_test37_invoker.call(MentorController_5.get.test())
      }
  
    // @LINE:72
    case controllers_users_StudentController_test38_route(params) =>
      call { 
        controllers_users_StudentController_test38_invoker.call(StudentController_3.get.test())
      }
  
    // @LINE:74
    case controllers_Application_getNotification39_route(params) =>
      call { 
        controllers_Application_getNotification39_invoker.call(Application_6.get.getNotification())
      }
  
    // @LINE:77
    case controllers_Assets_versioned40_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned40_invoker.call(Assets_7.get.versioned(path, file))
      }
  
    // @LINE:80
    case controllers_course_CourseController_allCourses41_route(params) =>
      call { 
        controllers_course_CourseController_allCourses41_invoker.call(CourseController_4.get.allCourses())
      }
  
    // @LINE:82
    case controllers_course_CourseController_course42_route(params) =>
      call { 
        controllers_course_CourseController_course42_invoker.call(CourseController_4.get.course())
      }
  
    // @LINE:85
    case controllers_users_AdminController_mentorship43_route(params) =>
      call { 
        controllers_users_AdminController_mentorship43_invoker.call(AdminController_1.get.mentorship())
      }
  
    // @LINE:86
    case controllers_users_AdminController_saveMentorship44_route(params) =>
      call { 
        controllers_users_AdminController_saveMentorship44_invoker.call(AdminController_1.get.saveMentorship())
      }
  
    // @LINE:87
    case controllers_users_AdminController_seeMentorsAndStudents45_route(params) =>
      call { 
        controllers_users_AdminController_seeMentorsAndStudents45_invoker.call(AdminController_1.get.seeMentorsAndStudents())
      }
  
    // @LINE:88
    case controllers_users_AdminController_deleteMentorship46_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_AdminController_deleteMentorship46_invoker.call(AdminController_1.get.deleteMentorship(id))
      }
  
    // @LINE:98
    case controllers_users_UserController_studentList47_route(params) =>
      call { 
        controllers_users_UserController_studentList47_invoker.call(UserController_2.get.studentList())
      }
  
    // @LINE:99
    case controllers_users_UserController_newMessage48_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_newMessage48_invoker.call(UserController_2.get.newMessage(id))
      }
  
    // @LINE:100
    case controllers_users_UserController_sendMessage49_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_sendMessage49_invoker.call(UserController_2.get.sendMessage(id))
      }
  
    // @LINE:101
    case controllers_users_UserController_allMessage50_route(params) =>
      call { 
        controllers_users_UserController_allMessage50_invoker.call(UserController_2.get.allMessage())
      }
  
    // @LINE:109
    case controllers_users_UserController_studentList51_route(params) =>
      call { 
        controllers_users_UserController_studentList51_invoker.call(UserController_2.get.studentList())
      }
  
    // @LINE:110
    case controllers_users_UserController_newMessage52_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_newMessage52_invoker.call(UserController_2.get.newMessage(id))
      }
  
    // @LINE:111
    case controllers_users_UserController_sendMessage53_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_sendMessage53_invoker.call(UserController_2.get.sendMessage(id))
      }
  
    // @LINE:112
    case controllers_users_UserController_allMessage54_route(params) =>
      call { 
        controllers_users_UserController_allMessage54_invoker.call(UserController_2.get.allMessage())
      }
  
    // @LINE:113
    case controllers_users_UserController_seeMessage55_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_users_UserController_seeMessage55_invoker.call(UserController_2.get.seeMessage(id))
      }
  
    // @LINE:117
    case controllers_course_CourseController_course56_route(params) =>
      call { 
        controllers_course_CourseController_course56_invoker.call(CourseController_4.get.course())
      }
  }
}