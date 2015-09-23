
package views.html.posts

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object allMessage_Scope0 {
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

     object allMessage_Scope1 {
import user.User

class allMessage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[User,List[PrivateMessage],List[PrivateMessage],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(u: User)(messagesReceived: List[PrivateMessage])(messagesSent: List[PrivateMessage]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.87*/("""

    """),_display_(/*4.6*/main("Inbox")/*4.19*/ {_display_(Seq[Any](format.raw/*4.21*/("""

        """),format.raw/*6.9*/("""<div class="wrap">
            <div class="main">
                <div class="content">
                    <div class="section group">
                        <div class="col span_2_of_3">
                            <div class="contact-form">

                                <h4 style=" font-size : 0.7 em ; color : #fa3953 ;">Inbox</h4>

                                <hr style="margin-top : 5 px ; margin-bottom : 5 px ;">
                                <ul>

                                """),_display_(/*18.34*/for(message <- messagesReceived) yield /*18.66*/ {_display_(Seq[Any](format.raw/*18.68*/("""
                                    """),format.raw/*19.37*/("""<li><h5><span style="padding-bottom : 0 px ;">Sender
                                        <a href="#">"""),_display_(/*20.54*/message/*20.61*/.getSender.getFirstName),format.raw/*20.84*/("""</a>: </span>
                                    </h5>
                                        <a href=""""),_display_(/*22.51*/controllers/*22.62*/.users.routes.UserController.seeMessage(message.getId)),format.raw/*22.116*/("""" ><p><mark style="font-size : 0.9 em ; font-family : verdana, arial, helvetica, helve, sans-serif ;">"""),_display_(/*22.219*/message/*22.226*/.getSubject),format.raw/*22.237*/("""
                                        """),format.raw/*23.41*/("""</mark>
                                        </p></a>

                                    </li>
                                    <hr style="margin-top : 5 px ; margin-bottom : 5 px ;">
                                    """)))}),format.raw/*28.38*/("""
                                """),format.raw/*29.33*/("""</ul>
                                <br>

                                <ul>

                                    <h4 style=" font-size : 0.7 em ; color : #fa3953 ;">Sent message</h4>

                                    <hr style="margin-top : 5 px ; margin-bottom : 5 px ;">

                                    """),_display_(/*38.38*/for(message <- messagesSent) yield /*38.66*/ {_display_(Seq[Any](format.raw/*38.68*/("""
                                        """),format.raw/*39.41*/("""<li><h5><span style="padding-bottom : 0 px ;">Receiver
                                            <a href="#">"""),_display_(/*40.58*/message/*40.65*/.getReceiver.getFirstName),format.raw/*40.90*/("""</a>: </span>
                                        </h5>
                                            <p>"""),_display_(/*42.49*/message/*42.56*/.getSubject),format.raw/*42.67*/("""
                                            """),format.raw/*43.45*/("""</p>
                                        </li>
                                        <hr style="margin-top : 5 px ; margin-bottom : 5 px ;">

                                        """)))}),format.raw/*47.42*/("""
                                """),format.raw/*48.33*/("""</ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    """)))}))
      }
    }
  }

  def render(u:User,messagesReceived:List[PrivateMessage],messagesSent:List[PrivateMessage]): play.twirl.api.HtmlFormat.Appendable = apply(u)(messagesReceived)(messagesSent)

  def f:((User) => (List[PrivateMessage]) => (List[PrivateMessage]) => play.twirl.api.HtmlFormat.Appendable) = (u) => (messagesReceived) => (messagesSent) => apply(u)(messagesReceived)(messagesSent)

  def ref: this.type = this

}


}
}

/**/
object allMessage extends allMessage_Scope0.allMessage_Scope1.allMessage
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/posts/allMessage.scala.html
                  HASH: 56931b94a2803b14a6698ffb69a52174e62df824
                  MATRIX: 851->19|1031->104|1063->111|1084->124|1123->126|1159->136|1687->637|1735->669|1775->671|1840->708|1973->814|1989->821|2033->844|2166->950|2186->961|2262->1015|2393->1118|2410->1125|2443->1136|2512->1177|2772->1406|2833->1439|3179->1758|3223->1786|3263->1788|3332->1829|3471->1941|3487->1948|3533->1973|3668->2081|3684->2088|3716->2099|3789->2144|4009->2333|4070->2366
                  LINES: 30->2|35->2|37->4|37->4|37->4|39->6|51->18|51->18|51->18|52->19|53->20|53->20|53->20|55->22|55->22|55->22|55->22|55->22|55->22|56->23|61->28|62->29|71->38|71->38|71->38|72->39|73->40|73->40|73->40|75->42|75->42|75->42|76->43|80->47|81->48
                  -- GENERATED --
              */
          