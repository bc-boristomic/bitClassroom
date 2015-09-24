
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
                  DATE: Thu Sep 24 11:57:16 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/index.scala.html
                  HASH: 6f33c7ee493a50478e765dee13e2b1a29cd5543e
                  MATRIX: 901->122|1038->164|1066->167|1105->198|1144->200|1176->207|1200->223|1239->225|1275->235|2983->1913|3016->1920|3041->1936|3081->1938|3118->1948|3203->2006|3216->2010|3250->2023|3279->2025|3292->2029|3325->2041|3384->2073|3421->2094|3461->2096|3503->2111|3546->2145|3586->2147|3632->2166|3662->2187|3702->2189|3752->2211|3950->2382|3965->2388|4048->2449|4231->2605|4242->2607|4281->2625|4352->2669|4363->2671|4409->2696|4522->2782|4533->2784|4575->2805|4730->2929|4776->2944|4818->2955|4861->2968|4895->3421|4928->3424
                  LINES: 33->5|38->5|39->6|39->6|39->6|40->7|40->7|40->7|41->8|78->45|79->46|79->46|79->46|80->47|81->48|81->48|81->48|81->48|81->48|81->48|83->50|83->50|83->50|84->51|84->51|84->51|85->52|85->52|85->52|86->53|88->55|88->55|88->55|90->57|90->57|90->57|91->58|91->58|91->58|93->60|93->60|93->60|99->66|100->67|101->68|105->72|106->93|107->94
                  -- GENERATED --
              */
          