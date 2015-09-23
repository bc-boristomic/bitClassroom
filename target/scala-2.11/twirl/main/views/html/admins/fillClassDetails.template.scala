
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
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/fillClassDetails.scala.html
                  HASH: b179fd7f5d7c857011d77f53518185ad1e0f20a9
                  MATRIX: 911->85|1051->130|1080->134|1117->163|1156->165|1188->172|1202->178|1361->328|1401->330|1438->340|2307->1182|2341->1200|2381->1202|2434->1228|2496->1281|2536->1283|2593->1313|2635->1339|2675->1341|2736->1375|2789->1419|2829->1421|2894->1458|2937->1474|2950->1478|2984->1491|3014->1494|3027->1498|3061->1511|3135->1554|3197->1585|3254->1611|3307->1633|3356->1654|3944->2215|3964->2226|4028->2268|4204->2414
                  LINES: 32->4|37->4|40->7|40->7|40->7|42->9|42->9|42->9|42->9|44->11|62->29|62->29|62->29|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|66->33|66->33|66->33|66->33|66->33|66->33|67->34|69->36|70->37|71->38|72->39|89->56|89->56|89->56|96->63
                  -- GENERATED --
              */
          