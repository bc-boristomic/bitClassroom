
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object mentorshipList_Scope0 {
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

     object mentorshipList_Scope1 {
import models.user.Mentorship

class mentorshipList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Mentorship],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(mentorship: List[Mentorship]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.32*/("""
"""),_display_(/*3.2*/adminmain("Mentorship program")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""


  """),format.raw/*6.3*/("""<div class="container">
    <h4 class="page-head-line">Active mentorship</h4>

  </div>


  <div class="container">
    <div class="table-responsive">

      <table id="sort" class="table-condensed table-hover table table-bordered">
        <thead>
          <tr class="success">
            <th>Mentor</th>
            <th>Student</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
        """),_display_(/*24.10*/for(men <- mentorship) yield /*24.32*/ {_display_(Seq[Any](format.raw/*24.34*/("""
          """),format.raw/*25.11*/("""<tr class="info">
            <td>"""),_display_(/*26.18*/men/*26.21*/.getMentor.getFirstName),format.raw/*26.44*/(""" """),_display_(/*26.46*/men/*26.49*/.getMentor.getLastName),format.raw/*26.71*/("""</td>
            <td>"""),_display_(/*27.18*/men/*27.21*/.getStudent.getFirstName),format.raw/*27.45*/(""" """),_display_(/*27.47*/men/*27.50*/.getStudent.getLastName),format.raw/*27.73*/("""</td>
            <td>
              <a data-role="delete" data-delete-parent="tr" href=""""),_display_(/*29.68*/controllers/*29.79*/.users.routes.AdminController.deleteMentorship(men.getId)),format.raw/*29.136*/("""" role="button">
                <i class="glyphicon glyphicon-trash"></i></a>
            </td>
          </tr>
        """)))}),format.raw/*33.10*/("""
        """),format.raw/*34.9*/("""</tbody>
      </table>
    </div>
  </div>

""")))}))
      }
    }
  }

  def render(mentorship:List[Mentorship]): play.twirl.api.HtmlFormat.Appendable = apply(mentorship)

  def f:((List[Mentorship]) => play.twirl.api.HtmlFormat.Appendable) = (mentorship) => apply(mentorship)

  def ref: this.type = this

}


}
}

/**/
object mentorshipList extends mentorshipList_Scope0.mentorshipList_Scope1.mentorshipList
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/mentorshipList.scala.html
                  HASH: 5ffacf4bb05bcaaa90c5b818aedae25d324c9a34
                  MATRIX: 847->33|972->63|1000->66|1039->97|1078->99|1112->107|1580->548|1618->570|1658->572|1698->584|1761->620|1773->623|1817->646|1846->648|1858->651|1901->673|1952->697|1964->700|2009->724|2038->726|2050->729|2094->752|2213->844|2233->855|2312->912|2469->1038|2506->1048
                  LINES: 30->2|35->2|36->3|36->3|36->3|39->6|57->24|57->24|57->24|58->25|59->26|59->26|59->26|59->26|59->26|59->26|60->27|60->27|60->27|60->27|60->27|60->27|62->29|62->29|62->29|66->33|67->34
                  -- GENERATED --
              */
          