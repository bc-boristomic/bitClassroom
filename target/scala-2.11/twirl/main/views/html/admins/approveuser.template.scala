
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






""")))}))
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
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/approveuser.scala.html
                  HASH: a9e79b6759ff1a7c4dd7657af07f9f171a54a867
                  MATRIX: 869->64|998->98|1025->100|1070->137|1109->139|1141->145|1472->449|1521->482|1561->484|1602->498|1666->553|1706->555|1751->572|1823->617|1842->627|1881->645|1939->676|1958->686|2000->707|2029->709|2048->719|2089->739|2205->828|2224->838|2261->854|2438->1004|2457->1014|2494->1030|2689->1198|2708->1208|2735->1214|2818->1266|2860->1280|2901->1294|2916->1300|2983->1346|3120->1455|3149->1456|3190->1469|3233->1485|3252->1495|3289->1511|3375->1569|3404->1570|3445->1583|3515->1625|3544->1626|3593->1647|3661->1688|3681->1699|3748->1745|3857->1826|3886->1827|3943->1856|3972->1857|4020->1877|4107->1936|4136->1937|4178->1951|4207->1952|4296->2013|4325->2014|4371->2032|4441->2074|4470->2075|4519->2096|4587->2137|4607->2148|4674->2194|4783->2275|4812->2276|4869->2305|4898->2306|4947->2327|5034->2386|5063->2387|5105->2401|5134->2402|5171->2412|5200->2413|5258->2440|5294->2449
                  LINES: 31->3|36->3|37->4|37->4|37->4|39->6|50->17|50->17|50->17|51->18|51->18|51->18|52->19|53->20|53->20|53->20|54->21|54->21|54->21|54->21|54->21|54->21|56->23|56->23|56->23|57->24|57->24|57->24|58->25|58->25|58->25|60->27|62->29|62->29|62->29|62->29|65->32|65->32|66->33|66->33|66->33|66->33|67->34|67->34|68->35|69->36|69->36|70->37|71->38|71->38|71->38|73->40|73->40|73->40|73->40|74->41|75->42|75->42|76->43|76->43|77->44|77->44|78->45|79->46|79->46|80->47|81->48|81->48|81->48|83->50|83->50|83->50|83->50|84->51|85->52|85->52|86->53|86->53|87->54|87->54|90->57|91->58
                  -- GENERATED --
              */
          