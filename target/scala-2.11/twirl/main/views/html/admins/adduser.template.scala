
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adduser_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

     object adduser_Scope1 {
import models.user.User

class adduser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(userForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.24*/("""
"""),_display_(/*3.2*/adminmain("Add new user")/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""

    """),_display_(/*5.6*/helper/*5.12*/.form(action = controllers.users.routes.AdminController.saveNewUser(), 'class -> "form-horizontal", 'role -> "form")/*5.128*/ {_display_(Seq[Any](format.raw/*5.130*/("""
        """),format.raw/*6.9*/("""<div class="col-lg-offset-2" style="border: 5px #134fb8">
            <legend>Please fill the form to add new user</legend>
            <div class="form-group">
                <label for="fname" class="col-lg-2 control-label">
                    First name <abbr class="req" title="Please add users first name" style="color : red"> * </abbr></label>
                <div class="col-lg-6">
                    <input  type="text" name="firstname" class="form-control" id="inputName" onblur="checkNameInput()" placeholder="First name" required>
                    <span id="nameError" class="alert-warning" data-error-for="" ></span>
                </div>
            </div>
            <div class="form-group" >
                <label for="lname" class="col-lg-2 control-label">
                    Last name <abbr class="req" title="Please add users last name" style="color : red"> * </abbr></label>
                <div class="col-lg-6">
                    <input  type="text" name="lastname" class="form-control" id="inputLName" onblur="checkLastNameInput()" placeholder="Last name" required>
                    <span id="lastNameError" class="alert-warning" data-error-for="" ></span>
                </div>
            </div>
            <div class="form-group" >
                <label for="inputEmail" class="col-lg-2 control-label">
                    Email <abbr class="req" title="Login with &#64;bitcamp.ba email" style="color : red"> * </abbr></label>
                <div class="col-lg-6">
                    <input  type="email" name="email" class="form-control" id="inputEmail" onblur="checkEmail()" placeholder="name.surname&#64;bitcamp.ba" required>
                    <span id="emailError" class="alert-warning" data-error-for="" ></span>
                </div>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="col-lg-2 control-label">
                    Password <abbr class="req" title="Login with provided password" style="color : red"> * </abbr></label>
                <div class="col-lg-6">
                    <input  type="password" name="password" class="form-control" id="inputPassword1" onblur="checkPassword()" placeholder="Password must be strong eg. [A-Z, a-z, 0-9, special characters]." required>
                    <span id="passError" class="alert-warning" data-error-for="" ></span>
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 control-label">Role</label>
                <div class="col-lg-6">
                    <select id="selection" name="type">
                        <option value="1">Admin</option>
                        <option value="2">Teacher</option>
                        <option value="3">Mentor</option>
                        <option value="4">Student</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-5">
                    <button type="reset" class="btn btn-default"> Clear</button>
                    <button type="submit" id="login" class="btn btn-primary" href=""""),_display_(/*57.85*/controllers/*57.96*/.users.routes.AdminController.saveNewUser()),format.raw/*57.139*/("""">
                        Submit</button>
                </div>
            </div>
   </div>
    """)))}),format.raw/*62.6*/("""
""")))}))
      }
    }
  }

  def render(userForm:Form[User]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[User]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


}
}

/**/
object adduser extends adduser_Scope0.adduser_Scope1.adduser
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:16 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/adduser.scala.html
                  HASH: b5fd730602c4cc09433e069200e9fc207bef12b6
                  MATRIX: 814->27|931->49|959->52|992->77|1031->79|1065->88|1079->94|1204->210|1244->212|1280->222|4551->3466|4571->3477|4636->3520|4771->3625
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|39->6|90->57|90->57|90->57|95->62
                  -- GENERATED --
              */
          