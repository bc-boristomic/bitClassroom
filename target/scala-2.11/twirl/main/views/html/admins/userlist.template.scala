
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
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/userlist.scala.html
                  HASH: 1513e6515c00a57d070b3e55ce6cede9b7c5944e
                  MATRIX: 846->58|963->80|991->83|1018->102|1057->104|1093->114|1743->737|1781->759|1821->761|1871->783|1946->831|1960->836|1994->849|2057->885|2071->890|2104->902|2167->938|2181->943|2211->952|2270->984|2334->1039|2374->1041|2432->1072|2475->1099|2515->1101|2577->1136|2628->1178|2668->1180|2734->1218|2861->1314|2923->1349|2976->1393|3016->1395|3082->1433|3262->1586|3283->1597|3358->1650|3574->1835|3636->1870|3688->1913|3728->1915|3794->1953|3973->2105|3994->2116|4069->2169|4285->2354|4347->2389|4400->2433|4440->2435|4506->2473|4686->2626|4707->2637|4782->2690|4998->2875|5060->2906|5118->2933|5168->2955|5223->2979|5269->2997
                  LINES: 31->3|36->3|37->4|37->4|37->4|40->7|60->27|60->27|60->27|61->28|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|66->33|66->33|67->34|67->34|67->34|68->35|70->37|71->38|71->38|71->38|72->39|74->41|74->41|74->41|77->44|78->45|78->45|78->45|79->46|81->48|81->48|81->48|84->51|85->52|85->52|85->52|86->53|88->55|88->55|88->55|91->58|92->59|93->60|94->61|95->62|96->63
                  -- GENERATED --
              */
          