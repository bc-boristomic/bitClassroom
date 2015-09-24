
package views.html.posts

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object message_Scope0 {
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

     object message_Scope1 {
import user.User

class message extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[User,User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(userSes: User)(receiver: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.33*/("""
"""),_display_(/*3.2*/main("Message")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""

    """),_display_(/*5.6*/helper/*5.12*/.form(action = controllers.users.routes.UserController.sendMessage(receiver.getId), 'role -> "form")/*5.112*/ {_display_(Seq[Any](format.raw/*5.114*/("""
        """),format.raw/*6.9*/("""<br> <br> <br>

        <div class="Compose-Message">
            <div class="panel panel-success">
                <div class="panel-heading">
                    Compose New Message
                </div>
                <div class="panel-body">

                    <label>Subject :  </label>
                    <input type="text" name="subject" class="form-control" required />
                    <label>Text Message : </label>
                    <textarea rows="9" name="content" class="form-control" required></textarea>
                    <hr />
                    <button type="submit" class="btn btn-success glyphicon-envelope" href=""""),_display_(/*20.93*/controllers/*20.104*/.users.routes.UserController.sendMessage(receiver.getId)),format.raw/*20.160*/("""">
                        Send Message</button>
                </div>
                <div class="panel-footer text-muted">
                    <strong>Note : </strong>Please note that we track all messages so don't send any spams.
                </div>
            </div>
        </div>

        <div class="col span_1_of_3">
            <div class="contact_info">

            </div>
        </div>
    """)))}),format.raw/*34.6*/("""
""")))}))
      }
    }
  }

  def render(userSes:User,receiver:User): play.twirl.api.HtmlFormat.Appendable = apply(userSes)(receiver)

  def f:((User) => (User) => play.twirl.api.HtmlFormat.Appendable) = (userSes) => (receiver) => apply(userSes)(receiver)

  def ref: this.type = this

}


}
}

/**/
object message extends message_Scope0.message_Scope1.message
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/posts/message.scala.html
                  HASH: 8c465b3c7001eaf43c75cba7003db0e7f3fdd8c4
                  MATRIX: 805->20|931->51|959->54|982->69|1021->71|1055->80|1069->86|1178->186|1218->188|1254->198|1944->861|1965->872|2043->928|2496->1351
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|39->6|53->20|53->20|53->20|67->34
                  -- GENERATED --
              */
          