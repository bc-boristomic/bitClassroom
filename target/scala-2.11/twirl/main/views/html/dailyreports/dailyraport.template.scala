
package views.html.dailyreports

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object dailyraport_Scope0 {
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

     object dailyraport_Scope1 {
import models.report.DailyReport
import play.data.Form
import models.report

class dailyraport extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[DailyReport],List[report.Field],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(raportForm: Form[DailyReport])(fields: List[report.Field]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.61*/("""

"""),_display_(/*6.2*/main("Raport Model")/*6.22*/ {_display_(Seq[Any](format.raw/*6.24*/("""
    """),_display_(/*7.6*/helper/*7.12*/.form(action = controllers.users.routes.TeacherController.saveRaport())/*7.83*/ {_display_(Seq[Any](format.raw/*7.85*/("""
        """),format.raw/*8.9*/("""<!-- custom css -->
        <link rel="stylesheets" media="screen" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.versioned("bootstrap/css/bootstrap.css")),format.raw/*9.109*/("""">
        <body>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="container">
                        <h3 class="page-head-line">Fill the report:</h3>
                    </div>
                    <form class="form-horizontal">
                        <div class="row top30">
                                  <label class="col-md-offset-7 col-md-1">Date</label>
                            <div class=" col-md-4"><input class="form-control" name="date" type="date" min="2015-01-01" required></div>
                        </div>

                        <div class="row top30">
                            <label class="col-sm-2">Title</label>
                            <div class="col-sm-10"><input class="form-control" name="title" value="" required></div>
                        </div>
                        <div class="form-group top30">
                        """),_display_(/*27.26*/fields/*27.32*/.map/*27.36*/ { field =>_display_(Seq[Any](format.raw/*27.47*/("""
                            """),format.raw/*28.29*/("""<div class="row top10">
                                <div class="col-sm-2">
                                    <label for="field_"""),_display_(/*30.56*/field/*30.61*/.getId()),format.raw/*30.69*/("""" >"""),_display_(/*30.73*/field/*30.78*/.getName()),format.raw/*30.88*/("""</label>
                                </div>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="2" name=""""),_display_(/*33.84*/field/*33.89*/.getId()),format.raw/*33.97*/("""" id="field_"""),_display_(/*33.110*/field/*33.115*/.getId()),format.raw/*33.123*/("""" type="text"></textarea>
                                </div>
                            </div>
                        """)))}),format.raw/*36.26*/("""
                        """),format.raw/*37.25*/("""</div>
                        <div class="row top30">
                            <label class="col-sm-2 control-label">Report</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="4" name="data"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10 top30" style="margin-bottom: 30px">
                                <button type="submit" class="btn btn-success">Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </body>
    """)))}),format.raw/*53.6*/("""
""")))}),format.raw/*54.2*/("""
"""),format.raw/*55.1*/("""<script src=""""),_display_(/*55.15*/routes/*55.21*/.Assets.versioned("javascripts/deleteConfirm.js")),format.raw/*55.70*/(""""></script>





"""))
      }
    }
  }

  def render(raportForm:Form[DailyReport],fields:List[report.Field]): play.twirl.api.HtmlFormat.Appendable = apply(raportForm)(fields)

  def f:((Form[DailyReport]) => (List[report.Field]) => play.twirl.api.HtmlFormat.Appendable) = (raportForm) => (fields) => apply(raportForm)(fields)

  def ref: this.type = this

}


}
}

/**/
object dailyraport extends dailyraport_Scope0.dailyraport_Scope1.dailyraport
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/dailyreports/dailyraport.scala.html
                  HASH: 7de04a728a239dcf03f652d4dcd54651b8fbe8e4
                  MATRIX: 910->83|1064->142|1094->147|1122->167|1161->169|1193->176|1207->182|1286->253|1325->255|1361->265|1462->340|1476->346|1545->394|2533->1355|2548->1361|2561->1365|2610->1376|2668->1406|2831->1542|2845->1547|2874->1555|2905->1559|2919->1564|2950->1574|3167->1764|3181->1769|3210->1777|3251->1790|3266->1795|3296->1803|3455->1931|3509->1957|4305->2723|4338->2726|4367->2728|4408->2742|4423->2748|4493->2797
                  LINES: 32->4|37->4|39->6|39->6|39->6|40->7|40->7|40->7|40->7|41->8|42->9|42->9|42->9|60->27|60->27|60->27|60->27|61->28|63->30|63->30|63->30|63->30|63->30|63->30|66->33|66->33|66->33|66->33|66->33|66->33|69->36|70->37|86->53|87->54|88->55|88->55|88->55|88->55
                  -- GENERATED --
              */
          