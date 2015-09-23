
package views.html.users

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
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

     object login_Scope1 {
import user.User

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(userForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.24*/("""

"""),_display_(/*4.2*/main("Sign in")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""

    """),_display_(/*6.6*/helper/*6.12*/.form(action = routes.Application.checkLogin(), 'class -> "form-horizontal", 'role -> "form")/*6.105*/ {_display_(Seq[Any](format.raw/*6.107*/("""
    """),format.raw/*7.5*/("""<div class="col-lg-offset-2">
        <legend>Please login to proceed</legend>
        <div class="form-group" >
            <label for="inputEmail" class="col-lg-2 control-label">
                Email <abbr class="req" title="Login with &#64;bitcamp.ba email" style="color : red"> * </abbr></label>
            <div class="col-lg-6">
                <input value=""""),_display_(/*13.32*/userForm/*13.40*/.bindFromRequest().field("email").value()),format.raw/*13.81*/("""" type="email" name="email" onblur="checkEmail()" class="form-control" id="inputEmail" placeholder="name.surname&#64;bitcamp.ba" required>
                <span id="emailError" class="alert-warning " data-error-for="" ></span>
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">
                Password <abbr class="req" title="Login with provided password" style="color : red"> * </abbr></label>
            <div class="col-lg-6">
                <input value=""""),_display_(/*22.32*/userForm/*22.40*/.bindFromRequest().field("password").value()),format.raw/*22.84*/("""" type="password" name="password" class="form-control" id="inputPassword" placeholder="Password must be strong eg. [A-Z, a-z, 0-9]." required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
                <button type="reset" class="btn btn-default"> Clear</button>
                <button type="submit" id="login" class="btn btn-primary" href=""""),_display_(/*29.81*/routes/*29.87*/.Application.checkLogin()),format.raw/*29.112*/("""">Submit</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
            <a href="popupex.html" onclick="return popitup('"""),_display_(/*35.62*/routes/*35.68*/.Application.sendEmail()),format.raw/*35.92*/("""')" class="a"><em>
                Did you forget password ?</em></a>
            </div>
        </div>
    </div>


        <script type="text/javascript">
            function popitup(url) """),format.raw/*43.35*/("""{"""),format.raw/*43.36*/("""
                """),format.raw/*44.17*/("""newwindow=window.open(url,'name','height=150,width=350');
                if (window.focus) """),format.raw/*45.35*/("""{"""),format.raw/*45.36*/("""
                    """),format.raw/*46.21*/("""newwindow.focus()
                """),format.raw/*47.17*/("""}"""),format.raw/*47.18*/("""
                """),format.raw/*48.17*/("""return false;
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/("""
        """),format.raw/*50.9*/("""</script>


    """)))}),format.raw/*53.6*/("""
""")))}),format.raw/*54.2*/("""
"""))
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
object login extends login_Scope0.login_Scope1.login
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/users/login.scala.html
                  HASH: 9ecfe74eba44b44d3fe8d4b8be487bf562a20a54
                  MATRIX: 800->19|917->41|945->44|968->59|1007->61|1039->68|1053->74|1155->167|1195->169|1226->174|1620->541|1637->549|1699->590|2277->1141|2294->1149|2359->1193|2806->1613|2821->1619|2868->1644|3094->1843|3109->1849|3154->1873|3373->2064|3402->2065|3447->2082|3567->2174|3596->2175|3645->2196|3707->2230|3736->2231|3781->2248|3835->2274|3864->2275|3900->2284|3947->2301|3979->2303
                  LINES: 30->2|35->2|37->4|37->4|37->4|39->6|39->6|39->6|39->6|40->7|46->13|46->13|46->13|55->22|55->22|55->22|62->29|62->29|62->29|68->35|68->35|68->35|76->43|76->43|77->44|78->45|78->45|79->46|80->47|80->47|81->48|82->49|82->49|83->50|86->53|87->54
                  -- GENERATED --
              */
          