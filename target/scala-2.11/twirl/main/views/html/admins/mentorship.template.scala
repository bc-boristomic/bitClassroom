
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
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/mentorship.scala.html
                  HASH: 3cdfd1516969a25938b10b350862c784f3387d40
                  MATRIX: 852->56|969->78|996->80|1042->118|1081->120|1113->127|1127->133|1290->287|1330->289|1367->300|1666->572|1703->593|1743->595|1792->617|1854->670|1894->672|1947->698|1989->724|2029->726|2086->756|2138->799|2178->801|2239->834|2282->850|2295->854|2322->860|2352->863|2365->867|2399->880|2428->882|2441->886|2474->898|2544->937|2601->963|2654->985|2703->1003|2748->1020|3009->1254|3046->1275|3086->1277|3135->1299|3197->1352|3237->1354|3290->1380|3332->1406|3372->1408|3429->1438|3547->1546|3588->1548|3649->1581|3692->1597|3705->1601|3732->1607|3762->1610|3775->1614|3809->1627|3838->1629|3851->1633|3884->1645|3954->1684|4011->1710|4064->1732|4113->1750|4158->1767|4301->1883|4321->1894|4389->1940|4474->1995|4508->1999
                  LINES: 31->3|36->3|37->4|37->4|37->4|39->6|39->6|39->6|39->6|42->9|47->14|47->14|47->14|48->15|48->15|48->15|49->16|49->16|49->16|50->17|50->17|50->17|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|51->18|52->19|53->20|54->21|55->22|56->23|61->28|61->28|61->28|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|65->32|66->33|67->34|68->35|69->36|70->37|72->39|72->39|72->39|76->43|79->46
                  -- GENERATED --
              */
          