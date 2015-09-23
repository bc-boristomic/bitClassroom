
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object newTableDaily_Scope0 {
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

     object newTableDaily_Scope1 {
import models.report.Field
import models.report.ReportField
import models.report.DailyReport

class newTableDaily extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[List[ReportField],List[DailyReport],List[Field],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(listReportField: List[ReportField], listDailyReport: List[DailyReport], listField: List[Field]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.98*/("""

"""),_display_(/*6.2*/adminmain("NEW List")/*6.23*/ {_display_(Seq[Any](format.raw/*6.25*/("""


    """),format.raw/*9.5*/("""<form>
        <div style="margin-top: 110px">
            <h3 class="page-head-line"> Table of daily reports </h3>
        </div>

        <table id="sort" class="table-bordered" style="background: papayawhip">
            <div style="margin: 40px 30px 0px 30px" >
                <thead>
                    <tr> <th>Date</th>
                        <th>Title</th>
                        """),_display_(/*19.26*/for(rf <- listField) yield /*19.46*/ {_display_(Seq[Any](format.raw/*19.48*/("""
                            """),format.raw/*20.29*/("""<th>"""),_display_(/*20.34*/rf/*20.36*/.getName),format.raw/*20.44*/("""</th>
                        """)))}),format.raw/*21.26*/("""
                        """),format.raw/*22.25*/("""<th>Report</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                """),_display_(/*26.18*/for(ldr <- listDailyReport) yield /*26.45*/ {_display_(Seq[Any](format.raw/*26.47*/("""
                    """),format.raw/*27.21*/("""<tbody>
                        <div>
                            <tr class="success" style="background: #81d186">
                                <td>"""),_display_(/*30.38*/ldr/*30.41*/.getDate),format.raw/*30.49*/("""</td>
                                <td>"""),_display_(/*31.38*/ldr/*31.41*/.getName),format.raw/*31.49*/("""</td>


                                """),_display_(/*34.34*/for(field <- listField) yield /*34.57*/ {_display_(Seq[Any](format.raw/*34.59*/("""
                                    """),_display_(/*35.38*/if(ldr.containsField(field) == true)/*35.74*/ {_display_(Seq[Any](format.raw/*35.76*/("""
                                        """),format.raw/*36.41*/("""<td>"""),_display_(/*36.46*/ldr/*36.49*/.getField(field).getValue()),format.raw/*36.76*/("""</td>
                                    """)))}/*37.39*/else/*37.44*/{_display_(Seq[Any](format.raw/*37.45*/("""
                                        """),format.raw/*38.41*/("""<td>/</td>
                                    """)))}),format.raw/*39.38*/("""
                                """)))}),format.raw/*40.34*/("""
                                """),format.raw/*41.33*/("""<td>"""),_display_(/*41.38*/ldr/*41.41*/.getData),format.raw/*41.49*/("""</td>
                                <td>
                                    <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*43.90*/controllers/*43.101*/.users.routes.AdminController.deleteReport(ldr.getId)),format.raw/*43.154*/("""">
                                        <i class="glyphicon glyphicon-trash"></i></a>
                                </td>
                            </tr>
                        </div>
                    </tbody>
                """)))}),format.raw/*49.18*/("""
            """),format.raw/*50.13*/("""</div>
        </table>
    </form>

""")))}))
      }
    }
  }

  def render(listReportField:List[ReportField],listDailyReport:List[DailyReport],listField:List[Field]): play.twirl.api.HtmlFormat.Appendable = apply(listReportField,listDailyReport,listField)

  def f:((List[ReportField],List[DailyReport],List[Field]) => play.twirl.api.HtmlFormat.Appendable) = (listReportField,listDailyReport,listField) => apply(listReportField,listDailyReport,listField)

  def ref: this.type = this

}


}
}

/**/
object newTableDaily extends newTableDaily_Scope0.newTableDaily_Scope1.newTableDaily
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/newTableDaily.scala.html
                  HASH: 5db23ce07c68e8f72991645d9531d60f8475616c
                  MATRIX: 938->97|1129->193|1157->196|1186->217|1225->219|1258->226|1678->619|1714->639|1754->641|1811->670|1843->675|1854->677|1883->685|1945->716|1998->741|2149->865|2192->892|2232->894|2281->915|2460->1067|2472->1070|2501->1078|2571->1121|2583->1124|2612->1132|2680->1173|2719->1196|2759->1198|2824->1236|2869->1272|2909->1274|2978->1315|3010->1320|3022->1323|3070->1350|3132->1394|3145->1399|3184->1400|3253->1441|3332->1489|3397->1523|3458->1556|3490->1561|3502->1564|3531->1572|3690->1704|3711->1715|3786->1768|4055->2006|4096->2019
                  LINES: 32->4|37->4|39->6|39->6|39->6|42->9|52->19|52->19|52->19|53->20|53->20|53->20|53->20|54->21|55->22|59->26|59->26|59->26|60->27|63->30|63->30|63->30|64->31|64->31|64->31|67->34|67->34|67->34|68->35|68->35|68->35|69->36|69->36|69->36|69->36|70->37|70->37|70->37|71->38|72->39|73->40|74->41|74->41|74->41|74->41|76->43|76->43|76->43|82->49|83->50
                  -- GENERATED --
              */
          