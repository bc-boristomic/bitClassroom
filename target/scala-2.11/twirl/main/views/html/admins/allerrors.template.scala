
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object allerrors_Scope0 {
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

class allerrors extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[ErrorLog],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(errorList: List[ErrorLog]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""
"""),_display_(/*2.2*/adminmain("List of all errors")/*2.33*/ {_display_(Seq[Any](format.raw/*2.35*/("""


    """),format.raw/*5.5*/("""<div class="container">
        <h4 class="page-head-line">Errors:</h4>

    </div>


    <div class="container">
        <div class="table-responsive">

    <table id="sort" class="table-condensed table-hover table table-bordered">
        <thead>
            <tr class="danger">
                <th>Error message</th>
                <th>Time</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        """),_display_(/*23.10*/for(err <- errorList) yield /*23.31*/ {_display_(Seq[Any](format.raw/*23.33*/("""
            """),format.raw/*24.13*/("""<tr class="info">
                <td>"""),_display_(/*25.22*/err/*25.25*/.getMessage),format.raw/*25.36*/("""</td>
                <td>"""),_display_(/*26.22*/err/*26.25*/.getDate),format.raw/*26.33*/("""</td>
                <td>
                    <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*28.74*/controllers/*28.85*/.users.routes.AdminController.deleteError(err.getId)),format.raw/*28.137*/("""" role="button">
                        <i class="glyphicon glyphicon-trash"></i></a>
                </td>
            </tr>
        """)))}),format.raw/*32.10*/("""
        """),format.raw/*33.9*/("""</tbody>
    </table>
    </div>
    </div>

""")))}))
      }
    }
  }

  def render(errorList:List[ErrorLog]): play.twirl.api.HtmlFormat.Appendable = apply(errorList)

  def f:((List[ErrorLog]) => play.twirl.api.HtmlFormat.Appendable) = (errorList) => apply(errorList)

  def ref: this.type = this

}


}

/**/
object allerrors extends allerrors_Scope0.allerrors
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/allerrors.scala.html
                  HASH: 5fb8ceeaa86574ccea47f1c14451f33ae3212582
                  MATRIX: 768->1|890->28|917->30|956->61|995->63|1028->70|1491->506|1528->527|1568->529|1609->542|1675->581|1687->584|1719->595|1773->622|1785->625|1814->633|1941->733|1961->744|2035->796|2202->932|2238->941
                  LINES: 27->1|32->1|33->2|33->2|33->2|36->5|54->23|54->23|54->23|55->24|56->25|56->25|56->25|57->26|57->26|57->26|59->28|59->28|59->28|63->32|64->33
                  -- GENERATED --
              */
          