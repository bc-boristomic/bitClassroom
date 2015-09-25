
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
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/posts/allMessage.scala.html
                  HASH: 7681518c9b4adcbc06ad290e226b1565a08e03a1
                  MATRIX: 851->20|1031->105|1065->114|1086->127|1125->129|1163->141|1703->654|1751->686|1791->688|1857->726|1991->833|2007->840|2051->863|2186->971|2206->982|2282->1036|2413->1139|2430->1146|2463->1157|2533->1199|2798->1433|2860->1467|3215->1795|3259->1823|3299->1825|3369->1867|3509->1980|3525->1987|3571->2012|3708->2122|3724->2129|3756->2140|3830->2186|4054->2379|4116->2413
                  LINES: 30->2|35->2|37->4|37->4|37->4|39->6|51->18|51->18|51->18|52->19|53->20|53->20|53->20|55->22|55->22|55->22|55->22|55->22|55->22|56->23|61->28|62->29|71->38|71->38|71->38|72->39|73->40|73->40|73->40|75->42|75->42|75->42|76->43|80->47|81->48
                  -- GENERATED --
              */
          