
package views.html.courses

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object courseView_Scope0 {
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

     object courseView_Scope1 {
import models.course.CourseUser

class courseView extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[CourseUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(userListCourse: List[CourseUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.36*/("""
"""),_display_(/*5.2*/main("Classroom")/*5.19*/ {_display_(Seq[Any](format.raw/*5.21*/("""


    """),format.raw/*8.5*/("""<div class="container">
        <h4 class="page-head-line">Your wall</h4>

    </div>

  """),_display_(/*13.4*/for(temp <- userListCourse) yield /*13.31*/{_display_(Seq[Any](format.raw/*13.32*/("""

     """),_display_(/*15.7*/if(temp.getStatus == 2)/*15.30*/{_display_(Seq[Any](format.raw/*15.31*/("""

       """),_display_(/*17.9*/for(post <- temp.getUser.getPosts) yield /*17.43*/{_display_(Seq[Any](format.raw/*17.44*/("""

        """),format.raw/*19.9*/("""<div class="container">

            <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div id="postlist">
            <div class="panel">
              <div class="panel-heading">
                <div class="text-center">
                  <div class="row">
                    <div class="col-sm-9">
                      <h3 class="pull-left">"""),_display_(/*30.46*/post/*30.50*/.getTitle),format.raw/*30.59*/("""</h3>
                        <h5 class="pull-left" style="font-family: Arial" y><em>"""),_display_(/*31.81*/post/*31.85*/.getDate),format.raw/*31.93*/("""</em></h5>
                    </div>
                    <div class="col-sm-3">
                      <h4 class="pull-right">
                       <a href="#"><small style="color:blue"><em>"""),_display_(/*35.67*/post/*35.71*/.getUser.getEmail),format.raw/*35.88*/("""<br></em></small></a>
                      </h4>
                    </div>
                  </div>
                </div>
              </div>

              <div class="panel-body">
                <h5><em>"""),_display_(/*43.26*/post/*43.30*/.getContent),format.raw/*43.41*/("""</em></h5>
                <br>
              </div>

              <div class="panel-body" style="border: 1px solid darkgrey; background-color: lightgrey; margin: 0 20px 0 20px; height: 60px">
                  <label>Link : </label>
                  <a href=""""),_display_(/*49.29*/post/*49.33*/.getLink),format.raw/*49.41*/("""">"""),_display_(/*49.44*/post/*49.48*/.getLink),format.raw/*49.56*/("""</a>
              </div>

              <div class="panel-body" style="border: 1px solid darkgrey; background-color: lightgrey; margin: 0 20px 20px 20px; height: 60px">
                  <label>Attachment : </label>
               <a href=""""),_display_(/*54.26*/routes/*54.32*/.Assets.versioned("/files/users/"+ post.getFiles)),format.raw/*54.81*/("""">"""),_display_(/*54.84*/post/*54.88*/.getFiles),format.raw/*54.97*/("""</a>
              </div>

              <div class="panel-footer">
                <span class="label label-default">"""),_display_(/*58.52*/if(post.getPostType == 0)/*58.77*/{_display_(Seq[Any](format.raw/*58.78*/(""" """),format.raw/*58.79*/("""Announcement""")))}),format.raw/*58.92*/(""" """),format.raw/*58.93*/("""Assigment </span> <span class="label label-default">"""),_display_(/*58.146*/post/*58.150*/.getCreateDate),format.raw/*58.164*/("""</span>
                  <span class="label label-default">Updates</span>
              </div>
            </div>
           </div>
         </div>
      </div>
    </div>
       """)))}),format.raw/*66.9*/("""
     """)))}/*67.7*/else/*67.11*/{_display_(Seq[Any](format.raw/*67.12*/("""

     """)))}),format.raw/*69.7*/("""
""")))}),format.raw/*70.2*/("""
""")))}),format.raw/*71.2*/("""
"""))
      }
    }
  }

  def render(userListCourse:List[CourseUser]): play.twirl.api.HtmlFormat.Appendable = apply(userListCourse)

  def f:((List[CourseUser]) => play.twirl.api.HtmlFormat.Appendable) = (userListCourse) => apply(userListCourse)

  def ref: this.type = this

}


}
}

/**/
object courseView extends courseView_Scope0.courseView_Scope1.courseView
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/courses/courseView.scala.html
                  HASH: 772d368420c970aed44e1f71b6a6fb749d34c25e
                  MATRIX: 838->36|967->70|994->72|1019->89|1058->91|1091->98|1207->188|1250->215|1289->216|1323->224|1355->247|1394->248|1430->258|1480->292|1519->293|1556->303|1977->697|1990->701|2020->710|2133->796|2146->800|2175->808|2395->1001|2408->1005|2446->1022|2684->1233|2697->1237|2729->1248|3019->1511|3032->1515|3061->1523|3091->1526|3104->1530|3133->1538|3402->1780|3417->1786|3487->1835|3517->1838|3530->1842|3560->1851|3706->1970|3740->1995|3779->1996|3808->1997|3852->2010|3881->2011|3962->2064|3976->2068|4012->2082|4223->2263|4248->2270|4261->2274|4300->2275|4338->2283|4370->2285|4402->2287
                  LINES: 30->4|35->4|36->5|36->5|36->5|39->8|44->13|44->13|44->13|46->15|46->15|46->15|48->17|48->17|48->17|50->19|61->30|61->30|61->30|62->31|62->31|62->31|66->35|66->35|66->35|74->43|74->43|74->43|80->49|80->49|80->49|80->49|80->49|80->49|85->54|85->54|85->54|85->54|85->54|85->54|89->58|89->58|89->58|89->58|89->58|89->58|89->58|89->58|89->58|97->66|98->67|98->67|98->67|100->69|101->70|102->71
                  -- GENERATED --
              */
          