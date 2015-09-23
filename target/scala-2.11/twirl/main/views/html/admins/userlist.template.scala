
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object userlist_Scope0 {
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

     object userlist_Scope1 {
import models.user.User
import utility.UserConstants

class userlist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userList: List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.24*/("""
"""),_display_(/*4.2*/adminmain("Users ")/*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""


    """),format.raw/*7.5*/("""<div class="container">
        <h4 class="page-head-line">Users:</h4>

    </div>


    <div class="container">
        <div class="table-responsive">
            <table id="sort" class="table-condensed table-hover table table-bordered">
                <thead>
                    <tr class="information">
                        <th>First name:</th>
                        <th>Last name:</th>
                        <th>Email:</th>
                        <th>Role:</th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>
                """),_display_(/*27.18*/for(users <- userList) yield /*27.40*/ {_display_(Seq[Any](format.raw/*27.42*/("""
                    """),format.raw/*28.21*/("""<tr class="info">
                        <td>"""),_display_(/*29.30*/users/*29.35*/.getFirstName),format.raw/*29.48*/("""</td>
                        <td>"""),_display_(/*30.30*/users/*30.35*/.getLastName),format.raw/*30.47*/("""</td>
                        <td>"""),_display_(/*31.30*/users/*31.35*/.getEmail),format.raw/*31.44*/("""</td>
                        """),_display_(/*32.26*/if(users.getRoles.size() > 0 && users.getRoles != null)/*32.81*/ {_display_(Seq[Any](format.raw/*32.83*/("""
                            """),_display_(/*33.30*/for(role <- users.getRoles) yield /*33.57*/ {_display_(Seq[Any](format.raw/*33.59*/("""
                                """),_display_(/*34.34*/if(role.getId.equals(UserConstants.ADMIN))/*34.76*/ {_display_(Seq[Any](format.raw/*34.78*/("""
                                    """),format.raw/*35.37*/("""<td>Admin</td>
                                    <td></td>
                                """)))}),format.raw/*37.34*/("""
                                """),_display_(/*38.34*/if(role.getId.equals(UserConstants.TEACHER))/*38.78*/ {_display_(Seq[Any](format.raw/*38.80*/("""
                                    """),format.raw/*39.37*/("""<td>Teacher</td>
                                    <td>
                                        <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*41.94*/controllers/*41.105*/.users.routes.AdminController.deleteUser(users.getId)),format.raw/*41.158*/("""" role="button">
                                            <i class="glyphicon glyphicon-trash"></i></a>
                                    </td>
                                """)))}),format.raw/*44.34*/("""
                                """),_display_(/*45.34*/if(role.getId.equals(UserConstants.MENTOR))/*45.77*/ {_display_(Seq[Any](format.raw/*45.79*/("""
                                    """),format.raw/*46.37*/("""<td>Mentor</td>
                                    <td>
                                        <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*48.94*/controllers/*48.105*/.users.routes.AdminController.deleteUser(users.getId)),format.raw/*48.158*/("""" role="button">
                                            <i class="glyphicon glyphicon-trash"></i></a>
                                    </td>
                                """)))}),format.raw/*51.34*/("""
                                """),_display_(/*52.34*/if(role.getId.equals(UserConstants.STUDENT))/*52.78*/ {_display_(Seq[Any](format.raw/*52.80*/("""
                                    """),format.raw/*53.37*/("""<td>Student</td>
                                    <td>
                                        <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*55.94*/controllers/*55.105*/.users.routes.AdminController.deleteUser(users.getId)),format.raw/*55.158*/("""" role="button">
                                            <i class="glyphicon glyphicon-trash"></i></a>
                                    </td>
                                """)))}),format.raw/*58.34*/("""
                            """)))}),format.raw/*59.30*/("""
                        """)))}),format.raw/*60.26*/("""
                    """),format.raw/*61.21*/("""</tr>
                """)))}),format.raw/*62.18*/("""
                """),format.raw/*63.17*/("""</tbody>
            </table>

        </div>

    </div>

""")))}))
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
object userlist extends userlist_Scope0.userlist_Scope1.userlist
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/userlist.scala.html
                  HASH: 4432a36dfaaaaeeb239c2c26c44eb0be14b816fb
                  MATRIX: 846->56|963->78|990->80|1017->99|1056->101|1089->108|1719->711|1757->733|1797->735|1846->756|1920->803|1934->808|1968->821|2030->856|2044->861|2077->873|2139->908|2153->913|2183->922|2241->953|2305->1008|2345->1010|2402->1040|2445->1067|2485->1069|2546->1103|2597->1145|2637->1147|2702->1184|2827->1278|2888->1312|2941->1356|2981->1358|3046->1395|3224->1546|3245->1557|3320->1610|3533->1792|3594->1826|3646->1869|3686->1871|3751->1908|3928->2058|3949->2069|4024->2122|4237->2304|4298->2338|4351->2382|4391->2384|4456->2421|4634->2572|4655->2583|4730->2636|4943->2818|5004->2848|5061->2874|5110->2895|5164->2918|5209->2935
                  LINES: 31->3|36->3|37->4|37->4|37->4|40->7|60->27|60->27|60->27|61->28|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|66->33|66->33|67->34|67->34|67->34|68->35|70->37|71->38|71->38|71->38|72->39|74->41|74->41|74->41|77->44|78->45|78->45|78->45|79->46|81->48|81->48|81->48|84->51|85->52|85->52|85->52|86->53|88->55|88->55|88->55|91->58|92->59|93->60|94->61|95->62|96->63
                  -- GENERATED --
              */
          