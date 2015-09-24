
package views.html.posts

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object seeMessage_Scope0 {
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

     object seeMessage_Scope1 {
import user.User

class seeMessage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[PrivateMessage,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(message: PrivateMessage):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.27*/("""
"""),_display_(/*3.2*/main("Message")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""

"""),format.raw/*5.1*/("""<br> <br> <br>

<div class="Compose-Message">
    <div class="panel panel-success">
        <div class="panel-heading">
        From: """),_display_(/*10.16*/message/*10.23*/.getSender.getFirstName),format.raw/*10.46*/(""" """),_display_(/*10.48*/message/*10.55*/.getSender.getLastName),format.raw/*10.77*/("""
        """),format.raw/*11.9*/("""</div>
        <div class="panel-body">

            <label>Subject :  </label>
            <input type="text" name="subject" class="form-control" readonly value=""""),_display_(/*15.85*/message/*15.92*/.getSubject),format.raw/*15.103*/("""" />
            <label>Text Message : </label>
            <textarea rows="9" name="content" class="form-control" readonly>"""),_display_(/*17.78*/message/*17.85*/.getContent),format.raw/*17.96*/("""</textarea>
            <hr />
            <a class="col-xs-offset-11" href=""""),_display_(/*19.48*/controllers/*19.59*/.users.routes.UserController.newMessage(message.getSender.getId)),format.raw/*19.123*/("""">
                Reply</a>

        </div>

    </div>
</div>

""")))}))
      }
    }
  }

  def render(message:PrivateMessage): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((PrivateMessage) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}
}

/**/
object seeMessage extends seeMessage_Scope0.seeMessage_Scope1.seeMessage
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/posts/seeMessage.scala.html
                  HASH: 4f82b738d07f09b89562c347c3dd61c8158e8a71
                  MATRIX: 819->20|939->45|967->48|990->63|1029->65|1059->69|1226->209|1242->216|1286->239|1315->241|1331->248|1374->270|1411->280|1606->448|1622->455|1655->466|1809->593|1825->600|1857->611|1964->691|1984->702|2070->766
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|43->10|43->10|43->10|43->10|43->10|43->10|44->11|48->15|48->15|48->15|50->17|50->17|50->17|52->19|52->19|52->19
                  -- GENERATED --
              */
          