
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object approveuser_Scope0 {
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

     object approveuser_Scope1 {
import models.course.CourseUser
import utility.UserConstants

class approveuser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[CourseUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(courseUserForm: List[CourseUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.36*/("""
"""),_display_(/*4.2*/adminmain("List of applied students")/*4.39*/ {_display_(Seq[Any](format.raw/*4.41*/("""

    """),format.raw/*6.5*/("""<table class="table table-striped table-hover ">
        <thead>
            <tr>
                <th>Course</th>
                <th>Student</th>
                <th>Status</th>
                <th>Accept</th>
                <th>Decline</th>
            </tr>
        </thead>
        <tbody>
        """),_display_(/*17.10*/for(courseUser <- courseUserForm) yield /*17.43*/ {_display_(Seq[Any](format.raw/*17.45*/("""
            """),_display_(/*18.14*/if(courseUser.getStatus.equals(UserConstants.INACTIVE))/*18.69*/ {_display_(Seq[Any](format.raw/*18.71*/("""
                """),format.raw/*19.17*/("""<tr class="active">
                    <td>"""),_display_(/*20.26*/courseUser/*20.36*/.getCourse.getName),format.raw/*20.54*/("""</td>
                    <td>"""),_display_(/*21.26*/courseUser/*21.36*/.getUser.getFirstName),format.raw/*21.57*/(""" """),_display_(/*21.59*/courseUser/*21.69*/.getUser.getLastName),format.raw/*21.89*/("""</td>
                    <td>Inactive</td>
                    <td><button id="approved"""),_display_(/*23.46*/courseUser/*23.56*/.getCourse.getId),format.raw/*23.72*/("""" class="btn btn-success btn-xs " type="submit" ><i class="glyphicon glyphicon-ok"></i></button></td>
                    <td><button id="dissaproved"""),_display_(/*24.49*/courseUser/*24.59*/.getCourse.getId),format.raw/*24.75*/("""" class="btn btn-danger btn-xs " type="submit" ><i class="glyphicon glyphicon-remove"></i></button></td>
                    <td><input type="text" id="course" value=""""),_display_(/*25.64*/courseUser/*25.74*/.getId),format.raw/*25.80*/("""" hidden /></td>
                </tr>
            """)))}),format.raw/*27.14*/("""

            """),format.raw/*29.13*/("""<script src=""""),_display_(/*29.27*/routes/*29.33*/.Assets.versioned("javascripts/jquery.min.js")),format.raw/*29.79*/(""""></script>
            <script>
        var user = $('#course').val();
        $(document).ready(function() """),format.raw/*32.38*/("""{"""),format.raw/*32.39*/("""
            """),format.raw/*33.13*/("""var idCourse = """),_display_(/*33.29*/courseUser/*33.39*/.getCourse.getId),format.raw/*33.55*/(""";
            $("#approved" + idCourse ).click(function() """),format.raw/*34.57*/("""{"""),format.raw/*34.58*/("""
            """),format.raw/*35.13*/("""console.log(user);
                $.ajax("""),format.raw/*36.24*/("""{"""),format.raw/*36.25*/("""
                    """),format.raw/*37.21*/("""type: "post",
                    url: """"),_display_(/*38.28*/controllers/*38.39*/.users.routes.AdminController.approveStudent()),format.raw/*38.85*/("""",
                    data: "pressed=2" + "&courseUser=" + user
                """),format.raw/*40.17*/("""}"""),format.raw/*40.18*/(""").success(function(response) """),format.raw/*40.47*/("""{"""),format.raw/*40.48*/("""
                   """),format.raw/*41.20*/("""window.location.href = '/admin/awaitlist';
                """),format.raw/*42.17*/("""}"""),format.raw/*42.18*/(""")
            """),format.raw/*43.13*/("""}"""),format.raw/*43.14*/(""")
             $("#dissaproved" + idCourse).click(function() """),format.raw/*44.60*/("""{"""),format.raw/*44.61*/("""
                 """),format.raw/*45.18*/("""console.log(user);
                $.ajax("""),format.raw/*46.24*/("""{"""),format.raw/*46.25*/("""
                    """),format.raw/*47.21*/("""type: "post",
                    url: """"),_display_(/*48.28*/controllers/*48.39*/.users.routes.AdminController.approveStudent()),format.raw/*48.85*/("""",
                    data: "pressed=3" + "&courseUser=" + user
                """),format.raw/*50.17*/("""}"""),format.raw/*50.18*/(""").success(function(response) """),format.raw/*50.47*/("""{"""),format.raw/*50.48*/("""
                    """),format.raw/*51.21*/("""window.location.href = '/admin/awaitlist';
                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/(""")
            """),format.raw/*53.13*/("""}"""),format.raw/*53.14*/(""")
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/(""");
    </script>

        """)))}),format.raw/*57.10*/("""
        """),format.raw/*58.9*/("""</tbody>
    </table>






""")))}),format.raw/*66.2*/("""
"""))
      }
    }
  }

  def render(courseUserForm:List[CourseUser]): play.twirl.api.HtmlFormat.Appendable = apply(courseUserForm)

  def f:((List[CourseUser]) => play.twirl.api.HtmlFormat.Appendable) = (courseUserForm) => apply(courseUserForm)

  def ref: this.type = this

}


}
}

/**/
object approveuser extends approveuser_Scope0.approveuser_Scope1.approveuser
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/approveuser.scala.html
                  HASH: 7f5bf9a25b2c55280e2bbafbeb0b72d857dc95e1
                  MATRIX: 869->66|998->100|1026->103|1071->140|1110->142|1144->150|1486->465|1535->498|1575->500|1617->515|1681->570|1721->572|1767->590|1840->636|1859->646|1898->664|1957->696|1976->706|2018->727|2047->729|2066->739|2107->759|2225->850|2244->860|2281->876|2459->1027|2478->1037|2515->1053|2711->1222|2730->1232|2757->1238|2842->1292|2886->1308|2927->1322|2942->1328|3009->1374|3149->1486|3178->1487|3220->1501|3263->1517|3282->1527|3319->1543|3406->1602|3435->1603|3477->1617|3548->1660|3577->1661|3627->1683|3696->1725|3716->1736|3783->1782|3894->1865|3923->1866|3980->1895|4009->1896|4058->1917|4146->1977|4175->1978|4218->1993|4247->1994|4337->2056|4366->2057|4413->2076|4484->2119|4513->2120|4563->2142|4632->2184|4652->2195|4719->2241|4830->2324|4859->2325|4916->2354|4945->2355|4995->2377|5083->2437|5112->2438|5155->2453|5184->2454|5222->2465|5251->2466|5312->2496|5349->2506|5416->2543
                  LINES: 31->3|36->3|37->4|37->4|37->4|39->6|50->17|50->17|50->17|51->18|51->18|51->18|52->19|53->20|53->20|53->20|54->21|54->21|54->21|54->21|54->21|54->21|56->23|56->23|56->23|57->24|57->24|57->24|58->25|58->25|58->25|60->27|62->29|62->29|62->29|62->29|65->32|65->32|66->33|66->33|66->33|66->33|67->34|67->34|68->35|69->36|69->36|70->37|71->38|71->38|71->38|73->40|73->40|73->40|73->40|74->41|75->42|75->42|76->43|76->43|77->44|77->44|78->45|79->46|79->46|80->47|81->48|81->48|81->48|83->50|83->50|83->50|83->50|84->51|85->52|85->52|86->53|86->53|87->54|87->54|90->57|91->58|99->66
                  -- GENERATED --
              */
          