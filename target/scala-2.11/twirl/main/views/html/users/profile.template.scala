
package views.html.users

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object profile_Scope0 {
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

     object profile_Scope1 {
import models.user.User

class profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.14*/("""
"""),_display_(/*3.2*/main("Update your profile")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

    """),_display_(/*5.6*/helper/*5.12*/.form(action = controllers.users.routes.UserController.updateProfile(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*5.164*/ {_display_(Seq[Any](format.raw/*5.166*/("""



        """),format.raw/*9.9*/("""<div class="col-lg-11 col-lg-offset-0">
            <legend>"""),_display_(/*10.22*/user/*10.26*/.getEmail()),format.raw/*10.37*/("""</legend>

            <div class="col-md-4">
                <div class="text-center">
                    <img class="center-block img-responsive" src=""""),_display_(/*14.68*/routes/*14.74*/.Assets.versioned("images/users/"  + user.getProfilePicture + "")),format.raw/*14.139*/(""""/>
                    <input type="file" name="profile-picture" accept="image/*" class="form-control" id="profile-picture">

                </div>
            </div>

                <!-- edit form column -->
            <div class="col-md-8">

                <div class="form-group">
                    <label for="nickname" class="col-lg-3 control-label">Nickname <abbr class="req" title="Select nickname for website interaction" style="color : red" > * </abbr></label>
                    <div class="col-lg-9">
                        <input name="nickname" type="text" class="form-control" id="inputName"  onblur="checkNameInput()"  placeholder="Your nickname" style="text-transform: capitalize" required>
                        <span id="nameError" class="alert-warning " data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="birth-date" class="col-lg-3 control-label">Birth date <abbr class="req" title="Select your bith date." style="color : red" > * </abbr></label>
                    <div class="col-lg-9">
                        <input name="birth-date" type="date" min="1965-01-01" max="1997-01-01" class="form-control" id="birth-date" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword1" class="col-lg-3 control-label">Password <abbr class="req" title="Password must contains special characters." style="color : red"> * </abbr></label>
                    <div class="col-lg-9">
                        <input name="password1" type="password" class="form-control" id="inputPassword1" onblur="checkPassword()" placeholder="Type new password" required>
                        <span id="passError" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>


                <div class="form-group">
                    <label for="inputPassword" class="col-lg-3 control-label">Password <abbr class="req" title="Passwords must match." style="color : red"> * </abbr></label>
                    <div class="col-lg-9">
                        <input name="password2" type="password" class="form-control" id="inputPassword" onblur="checkPasswords()" placeholder="Retype your password" required>
                        <span id="repassError" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="location" class="col-lg-3 control-label">Location <abbr class="req" title="Please provide your location." style="color : red" > * </abbr></label>
                    <div class="col-lg-9">
                        <input name="location" type="text" class="form-control" id="location" placeholder="Your location" style="text-transform: capitalize" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="home-phone" class="col-lg-3 control-label">Home phone</label>
                    <div class="col-lg-9">
                        <input name="home-phone" type="text" class="form-control" id="home-phone" onblur="checkPhone()" placeholder="Your home phone number +387-XX-XXX-XXX">
                        <span id="phoneCheck" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="mobile-phone" class="col-lg-3 control-label">Mobile phone <abbr class="req" title="Please provide your mobile phone number." style="color : red"> * </abbr></label>
                    <div class="col-lg-9">
                        <input name="mobile-phone" type="text" class="form-control" id="mobile-phone" onblur="checkMobilePhone()" placeholder="Your mobile phone number +387-XX-XXX-XXX" required>
                        <span id="mobilePhoneCheck" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="skype" class="col-lg-3 control-label">Skype <abbr class="req" title="Please provide your skype name." style="color : red">  </abbr></label>
                    <div class="col-lg-9">
                        <input name="skype" type="text" class="form-control" id="skype"  onblur="checkSkypeName()" placeholder="Your skype name" >
                        <span id="skypeCheck" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="facebook" class="col-lg-3 control-label">Facebook <abbr class="req" title="Please provide your facebook profile page." style="color : red">  </abbr></label>
                    <div class="col-lg-9">
                        <input name="facebook" type="url" class="form-control" id="facebook"  onblur="checkFacebook()" placeholder="Your facebook profile" value="http://www.facebook.com/" >
                        <span id="facebookCheck" class="alert-warning" data-error-for="" ></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="twitter" class="col-lg-3 control-label">Twitter</label>
                    <div class="col-lg-9">
                        <input name="twitter" type="text" class="form-control" id="twitter" placeholder="Your twitter profile">
                    </div>
                </div>

                <div class="form-group">
                    <label for="youtube" class="col-lg-3 control-label">Youtube</label>
                    <div class="col-lg-9">
                        <input name="youtube" type="text" class="form-control" id="youtube" placeholder="Your youtube profile">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Gender <abbr class="req" title="Please select your gender." style="color : red"> * </abbr></label>
                    <div class="col-lg-9">
                        <div class="radio">
                            <label>
                                <input name="gender" type="radio" name="optionsRadios" id="optionsRadios1" value="0" checked>
                                Female
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input name="gender" type="radio" name="optionsRadios" id="optionsRadios2" value="1">
                                Male
                            </label>
                        </div>
                    </div>
                </div>

                <br>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Clear all</button>
                        <button type="submit" class="btn btn-primary focus" href=""""),_display_(/*131.84*/controllers/*131.95*/.users.routes.UserController.updateProfile()),format.raw/*131.139*/("""">Submit</button>
                    </div>
                </div>
            </div>
        </div>


    """)))}),format.raw/*138.6*/("""
""")))}),format.raw/*139.2*/("""
"""))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}
}

/**/
object profile extends profile_Scope0.profile_Scope1.profile
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/users/profile.scala.html
                  HASH: 10d70457dc5c5fcdbba42af751d703a749ffea6d
                  MATRIX: 807->27|914->39|942->42|977->69|1016->71|1050->80|1064->86|1225->238|1265->240|1307->256|1396->318|1409->322|1441->333|1627->492|1642->498|1729->563|9036->7842|9057->7853|9124->7897|9271->8013|9305->8016
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|42->9|43->10|43->10|43->10|47->14|47->14|47->14|164->131|164->131|164->131|171->138|172->139
                  -- GENERATED --
              */
          