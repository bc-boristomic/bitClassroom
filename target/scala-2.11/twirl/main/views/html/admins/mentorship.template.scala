
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object mentorship_Scope0 {
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

     object mentorship_Scope1 {
import models.user.User
import utility.UserConstants

class mentorship extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userList: List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.24*/("""
"""),_display_(/*4.2*/adminmain("Assign mentor to students")/*4.40*/ {_display_(Seq[Any](format.raw/*4.42*/("""

    """),_display_(/*6.6*/helper/*6.12*/.form(action = controllers.users.routes.AdminController.saveMentorship(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*6.166*/ {_display_(Seq[Any](format.raw/*6.168*/("""


        """),format.raw/*9.9*/("""<legend>Mentorship process</legend>
        <div class="form-group">
            <label for="select" class="col-lg-2 control-label">Mentors</label>
            <div class="col-lg-4">
                <select class="form-control" id="select" name="mentor">
                """),_display_(/*14.18*/for(user <- userList) yield /*14.39*/ {_display_(Seq[Any](format.raw/*14.41*/("""
                    """),_display_(/*15.22*/if(user.getRoles != null && user.getRoles.size() > 0)/*15.75*/ {_display_(Seq[Any](format.raw/*15.77*/("""
                        """),_display_(/*16.26*/for(role <- user.getRoles) yield /*16.52*/ {_display_(Seq[Any](format.raw/*16.54*/("""
                            """),_display_(/*17.30*/if(role.getId.equals(UserConstants.MENTOR))/*17.73*/ {_display_(Seq[Any](format.raw/*17.75*/("""
                                """),format.raw/*18.33*/("""<option value=""""),_display_(/*18.49*/user/*18.53*/.getId),format.raw/*18.59*/("""">"""),_display_(/*18.62*/user/*18.66*/.getFirstName),format.raw/*18.79*/(""" """),_display_(/*18.81*/user/*18.85*/.getLastName),format.raw/*18.97*/("""</option>
                            """)))}),format.raw/*19.30*/("""
                        """)))}),format.raw/*20.26*/("""
                    """)))}),format.raw/*21.22*/("""
                """)))}),format.raw/*22.18*/("""
                """),format.raw/*23.17*/("""</select>
            </div>
            <label for="select" class="col-lg-2 control-label">Students</label>
            <div class="col-lg-4">
                <select class="form-control" id="select" name="student">
                """),_display_(/*28.18*/for(user <- userList) yield /*28.39*/ {_display_(Seq[Any](format.raw/*28.41*/("""
                    """),_display_(/*29.22*/if(user.getRoles != null && user.getRoles.size() > 0)/*29.75*/ {_display_(Seq[Any](format.raw/*29.77*/("""
                        """),_display_(/*30.26*/for(role <- user.getRoles) yield /*30.52*/ {_display_(Seq[Any](format.raw/*30.54*/("""
                            """),_display_(/*31.30*/if(role.getId.equals(UserConstants.STUDENT) && user.getStudentStatus.equals(UserConstants.DONT_HAVE_MENTOR))/*31.138*/ {_display_(Seq[Any](format.raw/*31.140*/("""
                                """),format.raw/*32.33*/("""<option value=""""),_display_(/*32.49*/user/*32.53*/.getId),format.raw/*32.59*/("""">"""),_display_(/*32.62*/user/*32.66*/.getFirstName),format.raw/*32.79*/(""" """),_display_(/*32.81*/user/*32.85*/.getLastName),format.raw/*32.97*/("""</option>
                            """)))}),format.raw/*33.30*/("""
                        """)))}),format.raw/*34.26*/("""
                    """)))}),format.raw/*35.22*/("""
                """)))}),format.raw/*36.18*/("""
                """),format.raw/*37.17*/("""</select>
            </div>
            <button type="submit" class="btn btn-primary col-lg-offset-6 top50" href=""""),_display_(/*39.88*/controllers/*39.99*/.users.routes.AdminController.saveMentorship()),format.raw/*39.145*/("""">
                Asign</button>
        </div>

    """)))}),format.raw/*43.6*/("""


""")))}),format.raw/*46.2*/("""

"""))
      }
    }
  }

  def render(userList:List[User]): play.twirl.api.HtmlFormat.Appendable = apply(userList)

  def f:((List[User]) => play.twirl.api.HtmlFormat.Appendable) = (userList) => apply(userList)

  def ref: this.type = this

}


}
}

/**/
object mentorship extends mentorship_Scope0.mentorship_Scope1.mentorship
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/mentorship.scala.html
                  HASH: 02d27542258582bb40428abe907026861fcdedfb
                  MATRIX: 852->58|969->80|997->83|1043->121|1082->123|1116->132|1130->138|1293->292|1333->294|1373->308|1677->585|1714->606|1754->608|1804->631|1866->684|1906->686|1960->713|2002->739|2042->741|2100->772|2152->815|2192->817|2254->851|2297->867|2310->871|2337->877|2367->880|2380->884|2414->897|2443->899|2456->903|2489->915|2560->955|2618->982|2672->1005|2722->1024|2768->1042|3034->1281|3071->1302|3111->1304|3161->1327|3223->1380|3263->1382|3317->1409|3359->1435|3399->1437|3457->1468|3575->1576|3616->1578|3678->1612|3721->1628|3734->1632|3761->1638|3791->1641|3804->1645|3838->1658|3867->1660|3880->1664|3913->1676|3984->1716|4042->1743|4096->1766|4146->1785|4192->1803|4337->1921|4357->1932|4425->1978|4514->2037|4551->2044
                  LINES: 31->3|36->3|37->4|37->4|37->4|39->6|39->6|39->6|39->6|42->9|47->14|47->14|47->14|48->15|48->15|48->15|49->16|49->16|49->16|50->17|50->17|50->17|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|52->19|53->20|54->21|55->22|56->23|61->28|61->28|61->28|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|66->33|67->34|68->35|69->36|70->37|72->39|72->39|72->39|76->43|79->46
                  -- GENERATED --
              */
          