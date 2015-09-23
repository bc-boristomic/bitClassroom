
package views.html.posts

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object studentList_Scope0 {
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

     object studentList_Scope1 {
import models.course.CourseUser
import helpers.SessionHelper

class studentList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[CourseUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(userList: List[CourseUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.30*/("""
"""),_display_(/*4.2*/main("Students")/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""


  """),format.raw/*7.3*/("""<div class="container">
    <h4 class="page-head-line">Users:</h4>

  </div>

  <div class="container">
    <div class="table-responsive">
      <table id="sort" class="table-condensed table-hover table table-bordered">
        <thead>
          <tr class="information">
            <th>Email:</th>
            <th>Class</th>
            <th>Role:</th>
            <th></th>

          </tr>
        </thead>
        <tbody>
        """),_display_(/*25.10*/for(users <- userList) yield /*25.32*/{_display_(Seq[Any](format.raw/*25.33*/("""
          """),_display_(/*26.12*/if(users.getStatus == 2)/*26.36*/{_display_(Seq[Any](format.raw/*26.37*/("""
            """),format.raw/*27.13*/("""<tr class="info">
              <td>"""),_display_(/*28.20*/users/*28.25*/.getUser.getEmail),format.raw/*28.42*/("""</td>
              <td>"""),_display_(/*29.20*/users/*29.25*/.getCourse.getName),format.raw/*29.43*/(""" """),format.raw/*29.44*/("""-  """),_display_(/*29.48*/users/*29.53*/.getCourse.getDescription),format.raw/*29.78*/("""</td>
              <td>"""),_display_(/*30.20*/users/*30.25*/.getUser.getRoles.get(0)),format.raw/*30.49*/("""</td>
              <td><a href=""""),_display_(/*31.29*/controllers/*31.40*/.users.routes.UserController.newMessage(users.getUser.getId)),format.raw/*31.100*/(""""><i class="glyphicon glyphicon-envelope"></i></a></td>
            </tr> """)))}),format.raw/*32.20*/("""

        """)))}),format.raw/*34.10*/("""
"""),format.raw/*35.1*/("""</tbody>
</table>

</div>

</div>

""")))}))
      }
    }
  }

  def render(userList:List[CourseUser]): play.twirl.api.HtmlFormat.Appendable = apply(userList)

  def f:((List[CourseUser]) => play.twirl.api.HtmlFormat.Appendable) = (userList) => apply(userList)

  def ref: this.type = this

}


}
}

/**/
object studentList extends studentList_Scope0.studentList_Scope1.studentList
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/posts/studentList.scala.html
                  HASH: 588ef885098188703b464de084f636897d588253
                  MATRIX: 868->64|991->92|1018->94|1042->110|1081->112|1112->117|1573->551|1611->573|1650->574|1689->586|1722->610|1761->611|1802->624|1866->661|1880->666|1918->683|1970->708|1984->713|2023->731|2052->732|2083->736|2097->741|2143->766|2195->791|2209->796|2254->820|2315->854|2335->865|2417->925|2523->1000|2565->1011|2593->1012
                  LINES: 31->3|36->3|37->4|37->4|37->4|40->7|58->25|58->25|58->25|59->26|59->26|59->26|60->27|61->28|61->28|61->28|62->29|62->29|62->29|62->29|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|67->34|68->35
                  -- GENERATED --
              */
          