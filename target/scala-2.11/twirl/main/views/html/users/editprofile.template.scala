
package views.html.users

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object editprofile_Scope0 {
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

     object editprofile_Scope1 {
import models.user.User

class editprofile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.14*/("""
"""),_display_(/*3.2*/main("Update your profile")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

  """),_display_(/*5.4*/helper/*5.10*/.form(action = controllers.users.routes.UserController.saveProfile(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*5.160*/ {_display_(Seq[Any](format.raw/*5.162*/("""



    """),format.raw/*9.5*/("""<div class="col-lg-11 col-lg-offset-0">
      <legend>"""),_display_(/*10.16*/user/*10.20*/.getEmail()),format.raw/*10.31*/("""</legend>

      <div class="col-md-4">
        <div class="text-center">
          <img class="center-block img-responsive" src=""""),_display_(/*14.58*/routes/*14.64*/.Assets.versioned("images/users/"  + user.getProfilePicture + "")),format.raw/*14.129*/(""""/>
          <input type="file" name="profile-picture" accept="image/*" class="form-control" id="profile-picture">

        </div>
      </div>

        <!-- edit form column -->
      <div class="col-md-8">

        <div class="form-group">
          <label for="nickname" class="col-lg-3 control-label">Nickname</label>
          <div class="col-lg-9">
            <input name="nickname" type="text" class="form-control" id="inputName"  onblur="checkNameInput()" placeholder="Your nickname" value=""""),_display_(/*26.147*/user/*26.151*/.getNickName),format.raw/*26.163*/("""">
            <span id="nameError" class="alert-warning " data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="inputPassword1" class="col-lg-3 control-label">Password</label>
          <div class="col-lg-9">
            <input name="password1" type="password" class="form-control" onblur="checkPassword()" id="inputPassword1" placeholder="Type new password">
            <span id="passError" class="alert-warning " data-error-for="" ></span>
          </div>
        </div>


        <div class="form-group">
          <label for="inputPassword" class="col-lg-3 control-label">Password</label>
          <div class="col-lg-9">
            <input name="password2" type="password" class="form-control" onblur="checkPasswords()" id="inputPassword" placeholder="Retype your password">
            <span id="repassError" class="alert-warning" data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="location" class="col-lg-3 control-label">Location</label>
          <div class="col-lg-9">
            <input name="location" type="text" class="form-control" id="location" placeholder="Your location" value=""""),_display_(/*51.119*/user/*51.123*/.getLocation),format.raw/*51.135*/("""">
          </div>
        </div>

        <div class="form-group">
          <label for="home-phone" class="col-lg-3 control-label">Home phone</label>
          <div class="col-lg-9">
            <input name="home-phone" type="text" class="form-control" onblur="checkPhone()" id="home-phone" placeholder="Your home phone number" value=""""),_display_(/*58.154*/user/*58.158*/.getHomePhone),format.raw/*58.171*/("""">
            <span id="phoneCheck" class="alert-warning" data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="mobile-phone" class="col-lg-3 control-label">Mobile phone</label>
          <div class="col-lg-9">
            <input name="mobile-phone" type="text" class="form-control" onblur="checkMobilePhone()" id="mobile-phone" placeholder="Your mobile phone number" value=""""),_display_(/*66.166*/user/*66.170*/.getCellPhone),format.raw/*66.183*/("""">
            <span id="mobilePhoneCheck" class="alert-warning" data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="skype" class="col-lg-3 control-label">Skype</label>
          <div class="col-lg-9">
            <input name="skype" type="text" class="form-control" onblur="checkSkypeName()" id="skype" placeholder="Your skype name" value=""""),_display_(/*74.141*/user/*74.145*/.getSkype),format.raw/*74.154*/("""">
            <span id="skypeCheck" class="alert-warning" data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="facebook" class="col-lg-3 control-label">Facebook</label>
          <div class="col-lg-9">
            <input name="facebook" type="text" class="form-control" onblur="checkFacebook()" id="facebook" placeholder="Your facebook profile" value=""""),_display_(/*82.152*/user/*82.156*/.getFacebook),format.raw/*82.168*/("""">
            <span id="facebookCheck" class="alert-warning" data-error-for="" ></span>
          </div>
        </div>

        <div class="form-group">
          <label for="twitter" class="col-lg-3 control-label">Twitter</label>
          <div class="col-lg-9">
            <input name="twitter" type="text" class="form-control" id="twitter" placeholder="Your twitter profile" value=""""),_display_(/*90.124*/user/*90.128*/.getTwitter),format.raw/*90.139*/("""">
          </div>
        </div>

        <div class="form-group">
          <label for="youtube" class="col-lg-3 control-label">Youtube</label>
          <div class="col-lg-9">
            <input name="youtube" type="text" class="form-control" id="youtube" placeholder="Your youtube profile" value=""""),_display_(/*97.124*/user/*97.128*/.getYoutube),format.raw/*97.139*/("""">
          </div>
        </div>

        <br>

        <div class="form-group">
          <div class="col-lg-10 col-lg-offset-2">
            <button type="reset" class="btn btn-default">Clear all</button>
            <button type="submit" class="btn btn-primary focus" href=""""),_display_(/*106.72*/controllers/*106.83*/.users.routes.UserController.updateProfile()),format.raw/*106.127*/("""">Submit</button>
          </div>
        </div>
      </div>
    </div>


  """)))}),format.raw/*113.4*/("""
""")))}),format.raw/*114.2*/("""
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
object editprofile extends editprofile_Scope0.editprofile_Scope1.editprofile
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/users/editprofile.scala.html
                  HASH: 15aecb5ca05cebb08b2818da9b27cb2ad4e6bc8e
                  MATRIX: 819->27|926->39|954->42|989->69|1028->71|1060->78|1074->84|1233->234|1273->236|1311->248|1394->304|1407->308|1439->319|1601->454|1616->460|1703->525|2245->1039|2259->1043|2293->1055|3571->2305|3585->2309|3619->2321|3993->2667|4007->2671|4042->2684|4516->3130|4530->3134|4565->3147|5006->3560|5020->3564|5051->3573|5503->3997|5517->4001|5551->4013|5976->4410|5990->4414|6023->4425|6361->4735|6375->4739|6408->4750|6725->5039|6746->5050|6813->5094|6930->5180|6964->5183
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|42->9|43->10|43->10|43->10|47->14|47->14|47->14|59->26|59->26|59->26|84->51|84->51|84->51|91->58|91->58|91->58|99->66|99->66|99->66|107->74|107->74|107->74|115->82|115->82|115->82|123->90|123->90|123->90|130->97|130->97|130->97|139->106|139->106|139->106|146->113|147->114
                  -- GENERATED --
              */
          