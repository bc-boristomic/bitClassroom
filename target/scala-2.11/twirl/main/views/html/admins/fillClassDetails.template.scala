
package views.html.admins

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


"""),_display_(/*7.2*/adminmain("Fill in the form")/*7.31*/ {_display_(Seq[Any](format.raw/*7.33*/("""

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
                    <select id="selection" name="type" required>

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

            <div class="form-group" id="courseTemplate">
                <div class="col-lg-6">

                    <label>Insert course background image</label>
                    <input type="file" name="course-image" accept="image/*" class="form-control" id="course-image">
                </div>
            </div>


            <div class="form-group">
                <div class="col-xs-5 col-xs-offset-1">
                    <button type="submit" href=""""),_display_(/*56.50*/controllers/*56.61*/.users.routes.AdminController.saveCourse()),format.raw/*56.103*/("""" id="saveCourse" class="btn btn-success">
                        Save</button>
                </div>
            </div>
        </form>


    """)))}),format.raw/*63.6*/("""
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
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/fillClassDetails.scala.html
                  HASH: f87311b1d0bf3d7ded6b3b10f1d1936e3761e993
                  MATRIX: 911->88|1051->133|1083->140|1120->169|1159->171|1193->180|1207->186|1366->336|1406->338|1445->350|2332->1210|2366->1228|2406->1230|2460->1257|2522->1310|2562->1312|2620->1343|2662->1369|2702->1371|2764->1406|2817->1450|2857->1452|2923->1490|2966->1506|2979->1510|3013->1523|3043->1526|3056->1530|3090->1543|3165->1587|3229->1620|3287->1647|3341->1670|3391->1692|3996->2270|4016->2281|4080->2323|4263->2476
                  LINES: 32->4|37->4|40->7|40->7|40->7|42->9|42->9|42->9|42->9|44->11|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|66->33|66->33|66->33|66->33|66->33|66->33|67->34|69->36|70->37|71->38|72->39|89->56|89->56|89->56|96->63
                  -- GENERATED --
              */
          