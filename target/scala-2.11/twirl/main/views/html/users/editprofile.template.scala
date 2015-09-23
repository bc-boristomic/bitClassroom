
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
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/users/editprofile.scala.html
                  HASH: e76a0d20176014e22e5e3375052aa3b5f5e8715a
                  MATRIX: 819->26|926->38|953->40|988->67|1027->69|1057->74|1071->80|1230->230|1270->232|1304->240|1386->295|1399->299|1431->310|1589->441|1604->447|1691->512|2221->1014|2235->1018|2269->1030|3522->2255|3536->2259|3570->2271|3937->2610|3951->2614|3986->2627|4452->3065|4466->3069|4501->3082|4934->3487|4948->3491|4979->3500|5423->3916|5437->3920|5471->3932|5888->4321|5902->4325|5935->4336|6266->4639|6280->4643|6313->4654|6621->4934|6642->4945|6709->4989|6819->5068|6852->5070
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|42->9|43->10|43->10|43->10|47->14|47->14|47->14|59->26|59->26|59->26|84->51|84->51|84->51|91->58|91->58|91->58|99->66|99->66|99->66|107->74|107->74|107->74|115->82|115->82|115->82|123->90|123->90|123->90|130->97|130->97|130->97|139->106|139->106|139->106|146->113|147->114
                  -- GENERATED --
              */
          