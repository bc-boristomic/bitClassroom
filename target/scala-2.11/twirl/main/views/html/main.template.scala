
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

     object main_Scope1 {
import helpers.SessionHelper
import models.user.User
import utility.UserConstants

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(title: String)(content: Html)(implicit currentUser: User = SessionHelper.currentUser(ctx())):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.95*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
            <!-- support for all characters -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- TITLE IS ADDED FROM EVERY PAGE -->
        <title>"""),_display_(/*15.17*/title),format.raw/*15.22*/("""</title>

            <!-- main theme for site css bootstrap -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*18.54*/routes/*18.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*18.110*/("""" />

            <!-- css for validation and other main stylesheat -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*21.54*/routes/*21.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*21.101*/("""" />

        <link rel="stylesheet" media="screen" href=""""),_display_(/*23.54*/routes/*23.60*/.Assets.versioned("stylesheets/aplication.css")),format.raw/*23.107*/("""" />
            <!-- custom icon -->
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*25.59*/routes/*25.65*/.Assets.versioned("images/logo.png")),format.raw/*25.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*26.54*/routes/*26.60*/.Assets.versioned("stylesheets/tablesorter.min.css")),format.raw/*26.112*/(""""/>
        <script src=""""),_display_(/*27.23*/routes/*27.29*/.Assets.versioned("javascripts/jquery-2.1.4.js")),format.raw/*27.77*/("""" type="text/javascript"></script>


    </head>
        <!-- END OF HEAD TAG -->

    <body>
            <!-- HEADER WITH IMAGE ONLY -->
        <header class="header-panel">
            <img src=""""),_display_(/*36.24*/routes/*36.30*/.Assets.versioned("images/header/headphoto.jpg")),format.raw/*36.78*/("""" class="center-block img-responsive" />
        </header>
            <!-- END OF HEADER IMAGE -->


            <!-- COLAPSABLE NAVIGATION BAR -->
        <div class="col-lg-offset-1 col-lg-10" >
            <nav class="navbar navbar-inverse" style="background-color : #d9534f">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/"><strong>bitClassroom</strong></a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <li><a href="/about">About</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            """),_display_(/*60.30*/if(currentUser != null && currentUser.getRoles.size() > 0 && currentUser.getRoles != null)/*60.120*/ {_display_(Seq[Any](format.raw/*60.122*/("""
                                """),_display_(/*61.34*/for(role <- currentUser.getRoles) yield /*61.67*/ {_display_(Seq[Any](format.raw/*61.69*/("""
                                    """),_display_(/*62.38*/if(role.getId.equals(UserConstants.ADMIN))/*62.80*/ {_display_(Seq[Any](format.raw/*62.82*/("""
                                        """),format.raw/*63.41*/("""<li><a href="/admin">Admin panel</a></li>
                                    """)))}),format.raw/*64.38*/("""
                                    """),_display_(/*65.38*/if(role.getId.equals(UserConstants.TEACHER))/*65.82*/ {_display_(Seq[Any](format.raw/*65.84*/("""
                                        """),format.raw/*66.41*/("""<li><a href="/allMessage">Messages</a></li>
                                        <li class="dropdown ">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                Go to classroom<span class="caret"></span></a>
                                            <ul class="dropdown-menu" role="menu" style="background-color : #d9534f">
                                                <li><a href="/user/courses">Courses</a></li>
                                                <li class="divider"></li>
                                                <li><a href="/post/new">Add post</a></li>
                                                <li class="divider"></li>
                                                <li><a href="/daily/report">Write daily report</a></li>

                                            </ul>
                                        </li>
                                    """)))}),format.raw/*79.38*/("""
                                    """),_display_(/*80.38*/if(role.getId.equals(UserConstants.MENTOR))/*80.81*/ {_display_(Seq[Any](format.raw/*80.83*/("""

                                        """),format.raw/*82.41*/("""<li><a href="/allMessage">Messages</a></li>
                                    """)))}),format.raw/*83.38*/("""
                                    """),_display_(/*84.38*/if(role.getId.equals(UserConstants.STUDENT))/*84.82*/ {_display_(Seq[Any](format.raw/*84.84*/("""
                                        """),format.raw/*85.41*/("""<li><a href="/post/new">Add post</a></li>
                                        <li><a href="/allMessage">Messages</a></li>
                                        <li class="dropdown active">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                Course <span class="caret"></span></a>
                                            <ul class="dropdown-menu" role="menu" style="background-color : #d9534f">
                                                <li><a href="/user/courses">Join course</a></li>
                                                <li class="divider"></li>
                                                <li><a href="/user/message">Students</a></li>
                                            </ul>
                                        </li>


                                    """)))}),format.raw/*98.38*/("""
                                """)))}),format.raw/*99.34*/("""
                            """)))}),format.raw/*100.30*/("""

                            """),_display_(/*102.30*/if(currentUser == null)/*102.53*/ {_display_(Seq[Any](format.raw/*102.55*/("""
                                """),format.raw/*103.33*/("""<li class="active"><a href="/login">Sign in</a></li>
                            """)))}),format.raw/*104.30*/("""
                            """),_display_(/*105.30*/if(currentUser != null)/*105.53*/ {_display_(Seq[Any](format.raw/*105.55*/("""
                                """),format.raw/*106.33*/("""<li class="dropdown active">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                        """),_display_(/*108.42*/currentUser/*108.53*/.getFirstName()),format.raw/*108.68*/(""" """),format.raw/*108.69*/("""<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu" style="background-color : #d9534f">
                                        <li><a href="/user/editprofile">Edit profile</a></li>
                                        <li class="divider"></li>
                                        <li><a href="/logout">Sign out</a></li>
                                    </ul>
                                </li>
                            """)))}),format.raw/*115.30*/("""

                        """),format.raw/*117.25*/("""</ul>
                    </div>
                </div>
            </nav>
        </div>
            <!-- END OF NAVIGATION BAR -->


        <div class="col-lg-12">
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*127.14*/if(flash.containsKey("success"))/*127.46*/ {_display_(Seq[Any](format.raw/*127.48*/("""
                """),format.raw/*128.17*/("""<div class="alert alert-success alert-dismissable" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*130.22*/flash/*130.27*/.get("success")),format.raw/*130.42*/("""
                """),format.raw/*131.17*/("""</div>
            """)))}),format.raw/*132.14*/("""
            """),format.raw/*133.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*135.14*/if(flash.containsKey("warning"))/*135.46*/ {_display_(Seq[Any](format.raw/*135.48*/("""
                """),format.raw/*136.17*/("""<div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*138.22*/flash/*138.27*/.get("warning")),format.raw/*138.42*/("""
                """),format.raw/*139.17*/("""</div>
            """)))}),format.raw/*140.14*/("""
            """),format.raw/*141.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*143.14*/if(flash.containsKey("info"))/*143.43*/ {_display_(Seq[Any](format.raw/*143.45*/("""
                """),format.raw/*144.17*/("""<div class="alert alert-info alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*146.22*/flash/*146.27*/.get("info")),format.raw/*146.39*/("""
                """),format.raw/*147.17*/("""</div>
            """)))}),format.raw/*148.14*/("""
            """),format.raw/*149.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*151.14*/if(flash.containsKey("danger"))/*151.45*/ {_display_(Seq[Any](format.raw/*151.47*/("""
                """),format.raw/*152.17*/("""<div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*154.22*/flash/*154.27*/.get("danger")),format.raw/*154.41*/("""
                """),format.raw/*155.17*/("""</div>
            """)))}),format.raw/*156.14*/("""
            """),format.raw/*157.13*/("""</div>
        </div>

            <!-- CONTAINER WITH ALL CONTENT FOR MAIN HTML -->
        <div class="container">
            <br><br><br>
        """),_display_(/*163.10*/content),format.raw/*163.17*/("""
        """),format.raw/*164.9*/("""</div>
            <!-- END OF CONTAINER WITH CONTENT -->


            <!-- FOOTER ALWAYS FIXED AT BOTTOM OF PAGE -->
        <div class="row top50">
            <footer class="panel-footer navbar-fixed-bottom"><div class="text-center">Copyright &copy;
                2015 bitClassroom &#64; BITCamp</div></footer>
        </div>
            <!-- END OF FOOTER -->


            <!-- JAVASCRIPT SCRIPTS, FIRST JQUERY IS LOADED -->
        <script src=""""),_display_(/*177.23*/routes/*177.29*/.Assets.versioned("javascripts/jquery-2.1.4.js")),format.raw/*177.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*178.23*/routes/*178.29*/.Assets.versioned("/javascripts/tablesorter.min.js")),format.raw/*178.81*/(""""></script>
        <script src=""""),_display_(/*179.23*/routes/*179.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*179.78*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*180.23*/routes/*180.29*/.Assets.versioned("javascripts/main.js")),format.raw/*180.69*/("""" type="text/javascript"></script>


        <script type="text/javascript">

           $(document).ready(function()"""),format.raw/*185.40*/("""{"""),format.raw/*185.41*/("""
            """),format.raw/*186.13*/("""$('#sort').DataTable();
            """),format.raw/*187.13*/("""}"""),format.raw/*187.14*/(""");
        </script>

    </body>
</html>"""))
      }
    }
  }

  def render(title:String,content:Html,currentUser:User): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(currentUser)

  def f:((String) => (Html) => (User) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (currentUser) => apply(title)(content)(currentUser)

  def ref: this.type = this

}


}
}

/**/
object main extends main_Scope0.main_Scope1.main
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:16 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/main.scala.html
                  HASH: 9bff7d5e4a30bc6a886e9f0350eadfe1c47ef52b
                  MATRIX: 862->91|1050->184|1080->188|1384->465|1410->470|1558->591|1573->597|1645->647|1800->775|1815->781|1878->822|1966->883|1981->889|2050->936|2175->1034|2190->1040|2248->1076|2332->1133|2347->1139|2421->1191|2475->1218|2490->1224|2559->1272|2794->1480|2809->1486|2878->1534|4188->2817|4288->2907|4329->2909|4391->2944|4440->2977|4480->2979|4546->3018|4597->3060|4637->3062|4707->3104|4818->3184|4884->3223|4937->3267|4977->3269|5047->3311|6120->4353|6186->4392|6238->4435|6278->4437|6350->4481|6463->4563|6529->4602|6582->4646|6622->4648|6692->4690|7676->5643|7742->5678|7805->5709|7866->5742|7899->5765|7940->5767|8003->5801|8118->5884|8177->5915|8210->5938|8251->5940|8314->5974|8546->6178|8567->6189|8604->6204|8634->6205|9164->6703|9221->6731|9490->6972|9532->7004|9573->7006|9620->7024|9824->7200|9839->7205|9876->7220|9923->7238|9976->7259|10019->7273|10120->7346|10162->7378|10203->7380|10250->7398|10454->7574|10469->7579|10506->7594|10553->7612|10606->7633|10649->7647|10750->7720|10789->7749|10830->7751|10877->7769|11078->7942|11093->7947|11127->7959|11174->7977|11227->7998|11270->8012|11371->8085|11412->8116|11453->8118|11500->8136|11703->8311|11718->8316|11754->8330|11801->8348|11854->8369|11897->8383|12082->8540|12111->8547|12149->8557|12645->9025|12661->9031|12731->9079|12817->9137|12833->9143|12907->9195|12970->9230|12986->9236|13057->9285|13143->9343|13159->9349|13221->9389|13372->9511|13402->9512|13445->9526|13511->9563|13541->9564
                  LINES: 32->5|37->5|39->7|47->15|47->15|50->18|50->18|50->18|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|58->26|58->26|58->26|59->27|59->27|59->27|68->36|68->36|68->36|92->60|92->60|92->60|93->61|93->61|93->61|94->62|94->62|94->62|95->63|96->64|97->65|97->65|97->65|98->66|111->79|112->80|112->80|112->80|114->82|115->83|116->84|116->84|116->84|117->85|130->98|131->99|132->100|134->102|134->102|134->102|135->103|136->104|137->105|137->105|137->105|138->106|140->108|140->108|140->108|140->108|147->115|149->117|159->127|159->127|159->127|160->128|162->130|162->130|162->130|163->131|164->132|165->133|167->135|167->135|167->135|168->136|170->138|170->138|170->138|171->139|172->140|173->141|175->143|175->143|175->143|176->144|178->146|178->146|178->146|179->147|180->148|181->149|183->151|183->151|183->151|184->152|186->154|186->154|186->154|187->155|188->156|189->157|195->163|195->163|196->164|209->177|209->177|209->177|210->178|210->178|210->178|211->179|211->179|211->179|212->180|212->180|212->180|217->185|217->185|218->186|219->187|219->187
                  -- GENERATED --
              */
          