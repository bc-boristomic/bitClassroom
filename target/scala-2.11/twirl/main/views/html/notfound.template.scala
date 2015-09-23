
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object notfound_Scope0 {
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

class notfound extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>BSOD</title>
        <link rel="stylesheet" href=""""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("stylesheets/404.css")),format.raw/*6.85*/("""" media="all" />
    </head>
    <body>
        <span class="neg">ERROR 404</span>
        <p>The page is missing or never was written. You can wait and<br />
            see if it becomes available again, or you can restart your computer.
        </p>
        <p> * Send us an e-mail to notify this and try it later.<br />
            * Press CTRL+ALT+DEL to restart your computer. You will<br />
                &nbsp; lose unsaved information in any programs that are running.
        </p>
        Press any link to continue <blink>_</blink>
        <div class="menu">
            <a href="/">index</a>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object notfound extends notfound_Scope0.notfound
              /*
                  -- GENERATED --
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/notfound.scala.html
                  HASH: 40b8205ccb1defcd80a03b5739ecc8d9163e4336
                  MATRIX: 833->0|1000->141|1014->147|1074->187
                  LINES: 32->1|37->6|37->6|37->6
                  -- GENERATED --
              */
          