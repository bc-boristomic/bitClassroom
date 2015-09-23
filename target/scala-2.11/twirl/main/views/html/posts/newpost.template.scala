
package views.html.posts

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object newpost_Scope0 {
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

class newpost extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[Post],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(postForm: Form[Post]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.24*/("""
"""),_display_(/*2.2*/main("Publish post")/*2.22*/ {_display_(Seq[Any](format.raw/*2.24*/("""

    """),_display_(/*4.6*/helper/*4.12*/.form(action = controllers.posts.routes.PostController.savePost(), 'class -> "form-horizontal", 'role -> "form", 'enctype -> "multipart/form-data")/*4.159*/ {_display_(Seq[Any](format.raw/*4.161*/("""


        """),format.raw/*7.9*/("""<legend>Create new post</legend>
        <div class="form-group">

        <div class="form-group">
            <label for="title" class="col-lg-2 control-label">Title<abbr class="req" title="Please select due date." style="color : red"> * </abbr></label>
            <div class="col-lg-6">
                <input name="title" type="text" class="form-control" id="title" placeholder="Write post title here." required>
            </div>
        </div>

            <div class="form-group">
                <label for="date"class="col-lg-2 control-label">
                    Date <abbr class="req" title="Please select due date." style="color : red"> * </abbr></label>
                <div class="col-lg-2">
                    <input name="date" type="date" min="2015-09-18" max="2020-01-01" class="form-control" id="date" required>
                </div>
            </div>

        <div class="form-group">
            <label for="textArea" class="col-lg-2 control-label">Content<abbr class="req" title="Please select due date." style="color : red"> * </abbr></label>
            <div class="col-lg-8">
                <textarea name="content" class="form-control" rows="5" id="textArea" placeholder="Write post content here." required></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="link" class="col-lg-2 control-label">Add link</label>
            <div class="col-lg-6">
                <input name="link" type="url" class="form-control" id="link" placeholder="https://www." pattern="https?://.+">
            </div>
        </div>

        <div class="form-group">
            <label for="files" class="col-lg-2 control-label">Add files</label>
            <div class="col-lg-4">
                <input type="file" name="files" accept="" multiple class="form-control" id="files">
            </div>
        </div>

            <label class="col-lg-2 control-label">Please select post type<abbr class="req" title="Please select due date." style="color : red"> * </abbr></label>
            <div class="col-lg-6">
                <div class="radio">
                    <label>
                        <input name="post-type" type="radio" name="optionsRadios" id="optionsRadios1" value="0" checked required>
                        Announcement
                    </label>
                    <label class="col-lg-offset-1">
                        <input name="post-type" type="radio" name="optionsRadios" id="optionsRadios2" value="1" required>
                        Assignment
                    </label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-offset-8">
                <label>
                    <input name="visible" type="checkbox"> Visible to mentors
                </label>
            </div>
        </div>

        <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
                <button type="reset" class="btn btn-default">Clear all</button>
                <button type="submit" class="btn btn-primary focus" href=""""),_display_(/*72.76*/controllers/*72.87*/.posts.routes.PostController.savePost()),format.raw/*72.126*/("""">
                    Publish</button>
            </div>
        </div>
    """)))}),format.raw/*76.6*/("""
""")))}))
      }
    }
  }

  def render(postForm:Form[Post]): play.twirl.api.HtmlFormat.Appendable = apply(postForm)

  def f:((Form[Post]) => play.twirl.api.HtmlFormat.Appendable) = (postForm) => apply(postForm)

  def ref: this.type = this

}


}

/**/
object newpost extends newpost_Scope0.newpost
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/posts/newpost.scala.html
                  HASH: bcde15b0022fe032e6059dcb7d53983151778047
                  MATRIX: 759->1|876->23|903->25|931->45|970->47|1002->54|1016->60|1172->207|1212->209|1249->220|4383->3327|4403->3338|4464->3377|4573->3456
                  LINES: 27->1|32->1|33->2|33->2|33->2|35->4|35->4|35->4|35->4|38->7|103->72|103->72|103->72|107->76
                  -- GENERATED --
              */
          