
package views.html.courses

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object fillClassDetails_Scope0 {
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

     object fillClassDetails_Scope1 {
import models.course.Course
import models.user.User
import utility.UserConstants

class fillClassDetails extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[User],Form[Course],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(users: List[User])(courseForm: Form[Course]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.47*/("""


"""),_display_(/*7.2*/main("Fill in the form")/*7.26*/ {_display_(Seq[Any](format.raw/*7.28*/("""

    """),_display_(/*9.6*/helper/*9.12*/.form(action = controllers.users.routes.AdminController.saveCourse(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*9.162*/ {_display_(Seq[Any](format.raw/*9.164*/("""

        """),format.raw/*11.9*/("""<legend>Create new course</legend>

        <form id="courseForm" method="post" class="form-horizontal">
                <!-- The template for adding new field -->
            <div class="form-group" id="courseTemplate">
                <div class="col-lg-6">
                    <input type="text" class="form-control" name="name" placeholder="Name" required/>
                </div>
                </div>
            <div class="form-group" id="courseTemplate">
                <div class="col-lg-6">
                    <input type="text" class="form-control" name="description" placeholder="Description" required />
                </div>
                </div>
            <div class="form-group" id="courseTemplate">
                <div class="col-lg-6">
                    <select id="selection" name="type">

                    """),_display_(/*29.22*/for(user <- users) yield /*29.40*/ {_display_(Seq[Any](format.raw/*29.42*/("""
                        """),_display_(/*30.26*/if(user.getRoles != null && user.getRoles.size() > 0)/*30.79*/ {_display_(Seq[Any](format.raw/*30.81*/("""
                            """),_display_(/*31.30*/for(role <- user.getRoles) yield /*31.56*/ {_display_(Seq[Any](format.raw/*31.58*/("""
                                """),_display_(/*32.34*/if(role.getId.equals(UserConstants.TEACHER))/*32.78*/ {_display_(Seq[Any](format.raw/*32.80*/("""
                                    """),format.raw/*33.37*/("""<option value=""""),_display_(/*33.53*/user/*33.57*/.getFirstName),format.raw/*33.70*/("""">"""),_display_(/*33.73*/user/*33.77*/.getFirstName),format.raw/*33.90*/("""</option>
                                """)))}),format.raw/*34.34*/("""

                            """)))}),format.raw/*36.30*/("""
                        """)))}),format.raw/*37.26*/("""
                    """)))}),format.raw/*38.22*/("""
                    """),format.raw/*39.21*/("""</select>
                    <label>Teacher</label>
                </div>

            </div>

            <div class="form-group">
                <div class="col-xs-5 col-xs-offset-1">
                    <button type="submit" href=""""),_display_(/*47.50*/controllers/*47.61*/.users.routes.AdminController.saveCourse()),format.raw/*47.103*/("""" id="saveCourse" class="btn btn-default">
                        Save</button>
                </div>
            </div>
        </form>


    """)))}),format.raw/*54.6*/("""
""")))}))
      }
    }
  }

  def render(users:List[User],courseForm:Form[Course]): play.twirl.api.HtmlFormat.Appendable = apply(users)(courseForm)

  def f:((List[User]) => (Form[Course]) => play.twirl.api.HtmlFormat.Appendable) = (users) => (courseForm) => apply(users)(courseForm)

  def ref: this.type = this

}


}
}

/**/
object fillClassDetails extends fillClassDetails_Scope0.fillClassDetails_Scope1.fillClassDetails
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/courses/fillClassDetails.scala.html
                  HASH: f79ba517b41380d03fa4de9ef8ba84d98567a232
                  MATRIX: 912->88|1052->133|1084->140|1116->164|1155->166|1189->175|1203->181|1362->331|1402->333|1441->345|2327->1204|2361->1222|2401->1224|2455->1251|2517->1304|2557->1306|2615->1337|2657->1363|2697->1365|2759->1400|2812->1444|2852->1446|2918->1484|2961->1500|2974->1504|3008->1517|3038->1520|3051->1524|3085->1537|3160->1581|3224->1614|3282->1641|3336->1664|3386->1686|3659->1932|3679->1943|3743->1985|3926->2138
                  LINES: 32->4|37->4|40->7|40->7|40->7|42->9|42->9|42->9|42->9|44->11|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|66->33|66->33|66->33|66->33|66->33|66->33|67->34|69->36|70->37|71->38|72->39|80->47|80->47|80->47|87->54
                  -- GENERATED --
              */
          