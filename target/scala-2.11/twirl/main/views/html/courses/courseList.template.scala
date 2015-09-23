
package views.html.courses

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object courseList_Scope0 {
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

     object courseList_Scope1 {
import models.course.Course

class courseList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Course],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(courseList: List[Course]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.28*/("""
"""),_display_(/*4.2*/main("Course")/*4.16*/ {_display_(Seq[Any](format.raw/*4.18*/("""

    """),_display_(/*6.6*/for(course <- courseList) yield /*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
        """),format.raw/*7.9*/("""<form action=""""),_display_(/*7.24*/controllers/*7.35*/.users.routes.StudentController.joinCourse()),format.raw/*7.79*/("""" method="post">

            <div class="col-sm-3" id="courseDiv">

                <div class="thumbnail">
                    <img src=""""),_display_(/*12.32*/routes/*12.38*/.Assets.versioned("/images/courses/"+ course.getImage)),format.raw/*12.92*/("""" alt="">
                    <div class="caption">
                        <input type="text" name="course-id" id="courseId"""),_display_(/*14.74*/course/*14.80*/.getId),format.raw/*14.86*/("""" value=""""),_display_(/*14.96*/course/*14.102*/.getId),format.raw/*14.108*/("""" hidden/>
                        <a href="#"><h2>"""),_display_(/*15.42*/course/*15.48*/.getName),format.raw/*15.56*/("""</h2>
                            <h4>"""),_display_(/*16.34*/course/*16.40*/.getDescription),format.raw/*16.55*/("""</h4></a>
                        """),_display_(/*17.26*/course/*17.32*/.getId),format.raw/*17.38*/("""
                        """),format.raw/*18.25*/("""<br>
                        <h6>"""),_display_(/*19.30*/course/*19.36*/.getTeacher),format.raw/*19.47*/("""</h6>
                        <input type="submit" class="btn btn-success" id="courseSubmit"""),_display_(/*20.87*/course/*20.93*/.getId),format.raw/*20.99*/("""" href=""""),_display_(/*20.108*/controllers/*20.119*/.users.routes.StudentController.joinCourse()),format.raw/*20.163*/("""" value="Join"/>
                    </div>
                </div>

            </div>
            
        </form>
        <script>
            $(document).ready(function()"""),format.raw/*28.41*/("""{"""),format.raw/*28.42*/("""
                """),format.raw/*29.17*/("""var idCourse = """),_display_(/*29.33*/course/*29.39*/.getId),format.raw/*29.45*/(""";
                var courseId = $("#courseId" + idCourse).val();

                $.ajax("""),format.raw/*32.24*/("""{"""),format.raw/*32.25*/("""
                    """),format.raw/*33.21*/("""type : "post",
                    url : """"),_display_(/*34.29*/controllers/*34.40*/.users.routes.StudentController.haveCourseAccess()),format.raw/*34.90*/("""",
                    data : "courseId=" + courseId
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""").success(function(response)"""),format.raw/*36.46*/("""{"""),format.raw/*36.47*/("""
                    """),format.raw/*37.21*/("""var button = document.getElementById("courseSubmit" + idCourse);
                    if(response == "1")"""),format.raw/*38.40*/("""{"""),format.raw/*38.41*/("""
                        """),format.raw/*39.25*/("""button.disabled = true;
                    """),format.raw/*40.21*/("""}"""),format.raw/*40.22*/("""else if(response === "2")"""),format.raw/*40.47*/("""{"""),format.raw/*40.48*/("""
                        """),format.raw/*41.25*/("""button.disabled = false;
                    """),format.raw/*42.21*/("""}"""),format.raw/*42.22*/("""

                """),format.raw/*44.17*/("""}"""),format.raw/*44.18*/(""")
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/(""");
        </script>
    """)))}),format.raw/*47.6*/("""

""")))}))
      }
    }
  }

  def render(courseList:List[Course]): play.twirl.api.HtmlFormat.Appendable = apply(courseList)

  def f:((List[Course]) => play.twirl.api.HtmlFormat.Appendable) = (courseList) => apply(courseList)

  def ref: this.type = this

}


}
}

/**/
object courseList extends courseList_Scope0.courseList_Scope1.courseList
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/courses/courseList.scala.html
                  HASH: 2ad80e57441a05f9c74607c677ab81c463781bc1
                  MATRIX: 830->33|951->59|979->62|1001->76|1040->78|1074->87|1114->112|1153->114|1189->124|1230->139|1249->150|1313->194|1485->339|1500->345|1575->399|1729->526|1744->532|1771->538|1808->548|1824->554|1852->560|1932->613|1947->619|1976->627|2043->667|2058->673|2094->688|2157->724|2172->730|2199->736|2253->762|2315->797|2330->803|2362->814|2482->907|2497->913|2524->919|2561->928|2582->939|2648->983|2857->1164|2886->1165|2932->1183|2975->1199|2990->1205|3017->1211|3138->1304|3167->1305|3217->1327|3288->1371|3308->1382|3379->1432|3478->1503|3507->1504|3563->1532|3592->1533|3642->1555|3775->1660|3804->1661|3858->1687|3931->1732|3960->1733|4013->1758|4042->1759|4096->1785|4170->1831|4199->1832|4247->1852|4276->1853|4319->1868|4348->1869|4406->1897
                  LINES: 30->3|35->3|36->4|36->4|36->4|38->6|38->6|38->6|39->7|39->7|39->7|39->7|44->12|44->12|44->12|46->14|46->14|46->14|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|50->18|51->19|51->19|51->19|52->20|52->20|52->20|52->20|52->20|52->20|60->28|60->28|61->29|61->29|61->29|61->29|64->32|64->32|65->33|66->34|66->34|66->34|68->36|68->36|68->36|68->36|69->37|70->38|70->38|71->39|72->40|72->40|72->40|72->40|73->41|74->42|74->42|76->44|76->44|77->45|77->45|79->47
                  -- GENERATED --
              */
          