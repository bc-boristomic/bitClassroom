
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object setingsdailyraport_Scope0 {
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

     object setingsdailyraport_Scope1 {
import models.report.Field

class setingsdailyraport extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Field],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(listField: List[Field]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.26*/("""
"""),_display_(/*3.2*/adminmain("Add field")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""

    """),_display_(/*5.6*/helper/*5.12*/.form(action = controllers.users.routes.AdminController.saveField())/*5.80*/ {_display_(Seq[Any](format.raw/*5.82*/("""
        """),format.raw/*6.9*/("""<!-- custom css -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*7.54*/routes/*7.60*/.Assets.versioned("stylesheets/dailyraport.css")),format.raw/*7.108*/("""">
        <script type="text/javascript" src=""""),_display_(/*8.46*/routes/*8.52*/.Assets.versioned("javascripts/dailyraport.js")),format.raw/*8.99*/(""" """),format.raw/*8.100*/(""""></script>

        <div class="container">
            <br><br>
            <h3 class="page-head-line">Add a field day reports</h3>
        </div>
        <body>
            <form class="container">
                <div class="row ">
                    <div class="col-md-offset-1">
                        <div class="col-md-4" style="background: #dff0d8; border: 1px solid black">
                            <h4 style="text-align: center ; color: blueviolet">Adding fields</h4>
                            <div class="form-group" style="margin: 25px">
                                <label>Field Name</label>
                                <input class="form-control" id="scriptName" name="scriptName" required>
                                <input style="margin-top: 30px" type="submit" value="Add" onclick=""/>
                            </div>
                        </div>
                        <div class="col-md-6 col-md-offset-1" style="background: #dff0d8; border: 1px solid black">
                            <h4 style="text-align: center; color: blueviolet">Preview</h4>
                            <div style="margin: 25px">
                                <div class="row top30">
                                    <label class="col-md-offset-7 col-md-1">Date</label>
                                    <div class=" col-md-4"><input class="form-control" disabled></div>
                                </div>

                                <div class="row top30">
                                    <label class="col-sm-5">Title</label>
                                    <div class="col-sm-7"><input class="form-control" disabled></div>
                                </div>
                                """),_display_(/*38.34*/for(rf <- listField) yield /*38.54*/ {_display_(Seq[Any](format.raw/*38.56*/("""
                                    """),format.raw/*39.37*/("""<div class="row top30">
                                        <div class="col-sm-5">
                                            <label>"""),_display_(/*41.53*/rf/*41.55*/.getName),format.raw/*41.63*/("""</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea class="form-control" rows="1" disabled></textarea>
                                        </div>
                                    </div>
                                """)))}),format.raw/*47.34*/("""
                                """),format.raw/*48.33*/("""<div class="row top30">
                                    <label class="col-sm-5 control-label">Report</label>
                                    <div class="col-sm-7">
                                        <textarea class="form-control" rows="3" disabled></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </body>


    """)))}),format.raw/*62.6*/("""
""")))}))
      }
    }
  }

  def render(listField:List[Field]): play.twirl.api.HtmlFormat.Appendable = apply(listField)

  def f:((List[Field]) => play.twirl.api.HtmlFormat.Appendable) = (listField) => apply(listField)

  def ref: this.type = this

}


}
}

/**/
object setingsdailyraport extends setingsdailyraport_Scope0.setingsdailyraport_Scope1.setingsdailyraport
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/setingsdailyraport.scala.html
                  HASH: 7edd17a23dcb041645f118b3fcead394f1007ec7
                  MATRIX: 851->29|970->53|997->55|1027->77|1066->79|1098->86|1112->92|1188->160|1227->162|1262->171|1361->244|1375->250|1444->298|1518->346|1532->352|1599->399|1628->400|3398->2143|3434->2163|3474->2165|3539->2202|3705->2341|3716->2343|3745->2351|4123->2698|4184->2731|4728->3245
                  LINES: 30->2|35->2|36->3|36->3|36->3|38->5|38->5|38->5|38->5|39->6|40->7|40->7|40->7|41->8|41->8|41->8|41->8|71->38|71->38|71->38|72->39|74->41|74->41|74->41|80->47|81->48|95->62
                  -- GENERATED --
              */
          