
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

     object index_Scope1 {
import helpers.SessionHelper
import models.user.User
import models.course.Course
import models.course.CourseUser

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[User,List[CourseUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(user: User)(courseUser: List[CourseUser]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.44*/("""
"""),_display_(/*6.2*/main("Welcome to bitClassroom")/*6.33*/ {_display_(Seq[Any](format.raw/*6.35*/("""
    """),_display_(/*7.6*/if(user == null)/*7.22*/ {_display_(Seq[Any](format.raw/*7.24*/("""
        """),format.raw/*8.9*/("""<div class="row top5">
            <div class="text-center">
                <div class="row">
                    <h1> Welcome to <em>bitClassroom</em></h1>
                </div>
                <div class="row top30">
                    <p>We are currently developing web application that is similar to Google classroom. Login to see current work.</p>
                </div>
            </div>
        </div>


        <div class="text-justify">
            <div class="row top15">
                <h2>How it works</h2><br>
                <h3>Easy set up</h3>

                <p>Teachers can add students directly or share a code with their class to join. It takes just minutes to set up.</p>

                <h3>Saves time</h3>

                <p>The simple, paperless assignment workflow allows teachers to create, review, and grade assignments quickly, all in one place.</p>

                <h3>Improves organization</h3>

                <p>Students can see all of their assignments on an assignments page, and all class materials are automatically filed into folders in Google Drive.</p>

                <h3>Enhances communication</h3>

                <p>Classroom allows teachers to send announcements and start class discussions instantly. Students can share resources with each other or provide answers to questions on the stream.</p>

                <h3>Affordable and secure</h3>

                <p>Like the rest of our Google Apps for Education services, Classroom contains no ads, never uses your content or student data for advertising purposes, and is free for schools.</p>

            </div>
        </div>
    """)))}),format.raw/*45.6*/("""
    """),_display_(/*46.6*/if(user != null)/*46.22*/ {_display_(Seq[Any](format.raw/*46.24*/("""
        """),format.raw/*47.9*/("""<div class="text-center">
            <h4>Wellcome back """),_display_(/*48.32*/user/*48.36*/.getFirstName),format.raw/*48.49*/(""" """),_display_(/*48.51*/user/*48.55*/.getLastName),format.raw/*48.67*/("""</h4>
        </div>
        """),_display_(/*50.10*/for(cU <- courseUser) yield /*50.31*/ {_display_(Seq[Any](format.raw/*50.33*/("""
            """),_display_(/*51.14*/if(cU.getUser.getId == user.getId)/*51.48*/ {_display_(Seq[Any](format.raw/*51.50*/("""
                """),_display_(/*52.18*/if(cU.getStatus == 2)/*52.39*/ {_display_(Seq[Any](format.raw/*52.41*/("""
                    """),format.raw/*53.21*/("""<div class="col-sm-3" id="courseDiv">
                        <div class="thumbnail" style="max-height: 700px; max-width: 300px">
                            <img src=""""),_display_(/*55.40*/routes/*55.46*/.Assets.versioned("/images/courses/" + cU.getCourse.getImage)),format.raw/*55.107*/("""" alt="" style="width:280px; height: 200px">
                            <div class="caption">
                                <a href="/user/class"><h2>"""),_display_(/*57.60*/cU/*57.62*/.getCourse.getName),format.raw/*57.80*/("""</h2>
                                <h4>"""),_display_(/*58.38*/cU/*58.40*/.getCourse.getDescription),format.raw/*58.65*/("""</h4></a>
                                <br>
                                <h6>"""),_display_(/*60.38*/cU/*60.40*/.getCourse.getTeacher),format.raw/*60.61*/("""</h6>

                            </div>

                        </div>
                    </div>
                """)))}),format.raw/*66.18*/("""
            """)))}),format.raw/*67.14*/("""
        """)))}),format.raw/*68.10*/("""



    """)))}),format.raw/*72.6*/("""
    """),format.raw/*93.11*/("""
""")))}),format.raw/*94.2*/("""
"""))
      }
    }
  }

  def render(user:User,courseUser:List[CourseUser]): play.twirl.api.HtmlFormat.Appendable = apply(user)(courseUser)

  def f:((User) => (List[CourseUser]) => play.twirl.api.HtmlFormat.Appendable) = (user) => (courseUser) => apply(user)(courseUser)

  def ref: this.type = this

}


}
}

/**/
object index extends index_Scope0.index_Scope1.index
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/index.scala.html
                  HASH: 16e28abbf135cb048010326931095d5e14e0140f
                  MATRIX: 901->118|1038->160|1065->162|1104->193|1143->195|1174->201|1198->217|1237->219|1272->228|2943->1869|2975->1875|3000->1891|3040->1893|3076->1902|3160->1959|3173->1963|3207->1976|3236->1978|3249->1982|3282->1994|3339->2024|3376->2045|3416->2047|3457->2061|3500->2095|3540->2097|3585->2115|3615->2136|3655->2138|3704->2159|3900->2328|3915->2334|3998->2395|4179->2549|4190->2551|4229->2569|4299->2612|4310->2614|4356->2639|4467->2723|4478->2725|4520->2746|4669->2864|4714->2878|4755->2888|4794->2897|4827->3329|4859->3331
                  LINES: 33->5|38->5|39->6|39->6|39->6|40->7|40->7|40->7|41->8|78->45|79->46|79->46|79->46|80->47|81->48|81->48|81->48|81->48|81->48|81->48|83->50|83->50|83->50|84->51|84->51|84->51|85->52|85->52|85->52|86->53|88->55|88->55|88->55|90->57|90->57|90->57|91->58|91->58|91->58|93->60|93->60|93->60|99->66|100->67|101->68|105->72|106->93|107->94
                  -- GENERATED --
              */
          