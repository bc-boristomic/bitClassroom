
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminmain_Scope0 {
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

     object adminmain_Scope1 {
import helpers.SessionHelper
import models.user.User

class adminmain extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(title: String)(content: Html)(implicit currentUser: User = SessionHelper.currentUser(ctx())):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.95*/("""

"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
            <!-- support for all characters -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- TITLE IS ADDED FROM EVERY PAGE -->
        <title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>

            <!-- main theme for site css bootstrap -->
        <link rel="stylesheet" media="screen" href=""""),_display_(/*16.54*/routes/*16.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*16.110*/("""" />
        <link rel="stylesheet" media="screen" href=""""),_display_(/*17.54*/routes/*17.60*/.Assets.versioned("stylesheets/tablesorter.min.css")),format.raw/*17.112*/(""""/>


        <link rel="stylesheet" media="screen" href=""""),_display_(/*20.54*/routes/*20.60*/.Assets.versioned("stylesheets/bootstrap.css")),format.raw/*20.106*/("""" />

            <!-- Custom font and icon -->
        <link href=""""),_display_(/*23.22*/routes/*23.28*/.Assets.versioned("stylesheets/font-awesome.css")),format.raw/*23.77*/("""" rel="stylesheet"/>
        <link href=""""),_display_(/*24.22*/routes/*24.28*/.Assets.versioned("stylesheets/style.css")),format.raw/*24.70*/("""" rel="stylesheet" />

            <!-- custom icon -->
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*27.59*/routes/*27.65*/.Assets.versioned("images/logo.png")),format.raw/*27.101*/("""">


    </head>
        <!-- END OF HEAD TAG -->

    <body>
            <!-- COLAPSABLE NAVIGATION BAR -->
        <div class="col-lg-offset-1 col-lg-10">
            <nav class="navbar navbar-default">
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
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                    Users<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="/admin/adduser">Add new user</a></li>
                                    <li><a href="/admin/allusers">See all users</a></li>
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                    Mentorship<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="/admin/mentorship">Assign new mentors</a></li>
                                    <li><a href="/admin/activementors">See active mentors</a></li>
                                </ul>
                            </li>

                            <li class="dropdown ">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                    Classroom<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="/user/courses">See all courses</a></li>
                                    <li><a href="/admin/createcourse">Add new course</a></li>
                                    <li><a href="/post/new"></a></li>
                                    <li class="divider"></li>
                                    <li><a href="/admin/awaitlist">Users awaiting approval <span class="badge" id="notify"></span></a></li>
                                    <li class="divider"></li>
                                    <li><a href="/post/new">Write post</a></li>
                                </ul>
                            </li>
                            <li class="dropdown ">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                    Daily report<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="/admin/createdaily">Add new daily report</a></li>
                                    <li><a href="/listReport ">View daily report</a></li>
                                </ul>
                            </li>


                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/admin/errors">See all errors</a></li>

                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                    """),_display_(/*97.38*/currentUser/*97.49*/.getFirstName()),format.raw/*97.64*/(""" """),format.raw/*97.65*/("""<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#"></a></li>
                                    <li class="divider"></li>
                                    <li><a href="/user/editprofile">Edit profile</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/logout">Sign out</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>
            </nav>
        </div>
            <!-- END OF NAVIGATION BAR -->


        <div class="col-lg-12">
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*117.14*/if(flash.containsKey("success"))/*117.46*/ {_display_(Seq[Any](format.raw/*117.48*/("""
                """),format.raw/*118.17*/("""<div class="alert alert-success alert-dismissable" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*120.22*/flash/*120.27*/.get("success")),format.raw/*120.42*/("""
                """),format.raw/*121.17*/("""</div>
            """)))}),format.raw/*122.14*/("""
            """),format.raw/*123.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*125.14*/if(flash.containsKey("warning"))/*125.46*/ {_display_(Seq[Any](format.raw/*125.48*/("""
                """),format.raw/*126.17*/("""<div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*128.22*/flash/*128.27*/.get("warning")),format.raw/*128.42*/("""
                """),format.raw/*129.17*/("""</div>
            """)))}),format.raw/*130.14*/("""
            """),format.raw/*131.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*133.14*/if(flash.containsKey("info"))/*133.43*/ {_display_(Seq[Any](format.raw/*133.45*/("""
                """),format.raw/*134.17*/("""<div class="alert alert-info alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*136.22*/flash/*136.27*/.get("info")),format.raw/*136.39*/("""
                """),format.raw/*137.17*/("""</div>
            """)))}),format.raw/*138.14*/("""
            """),format.raw/*139.13*/("""</div>
            <div class="col-lg-4 col-lg-offset-4">
            """),_display_(/*141.14*/if(flash.containsKey("danger"))/*141.45*/ {_display_(Seq[Any](format.raw/*141.47*/("""
                """),format.raw/*142.17*/("""<div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    """),_display_(/*144.22*/flash/*144.27*/.get("danger")),format.raw/*144.41*/("""
                """),format.raw/*145.17*/("""</div>
            """)))}),format.raw/*146.14*/("""
            """),format.raw/*147.13*/("""</div>
        </div>

            <!-- CONTAINER WITH ALL CONTENT FOR MAIN HTML -->
        <div class="container">
        """),_display_(/*152.10*/content),format.raw/*152.17*/("""
        """),format.raw/*153.9*/("""</div>
            <!-- END OF CONTAINER WITH CONTENT -->


            <!-- FOOTER ALWAYS FIXED AT BOTTOM OF PAGE -->
<!--        <div class="row top50">
            <footer class="panel-footer navbar-fixed-bottom"><div class="text-center">Copyright &copy;
                2015 bitClassroom &#64; BITCamp</div></footer>
        </div> -->
            <!-- END OF FOOTER -->


            <!-- JAVASCRIPT SCRIPTS, FIRST JQUERY IS LOADED-->
        <script src=""""),_display_(/*166.23*/routes/*166.29*/.Assets.versioned("javascripts/jquery.min.js")),format.raw/*166.75*/(""""></script>
        <script src=""""),_display_(/*167.23*/routes/*167.29*/.Assets.versioned("/javascripts/tablesorter.min.js")),format.raw/*167.81*/(""""></script>
  <!--      <script src=""""),_display_(/*168.27*/routes/*168.33*/.Assets.versioned("javascripts/jquery-1.11.1.js")),format.raw/*168.82*/(""""></script> -->
        <script src=""""),_display_(/*169.23*/routes/*169.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*169.78*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*170.23*/routes/*170.29*/.Assets.versioned("javascripts/bootbox.js")),format.raw/*170.72*/(""""></script>
        <script src=""""),_display_(/*171.23*/routes/*171.29*/.Assets.versioned("javascripts/main.js")),format.raw/*171.69*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*172.23*/routes/*172.29*/.Assets.versioned("javascripts/deleteConfirm.js")),format.raw/*172.78*/(""""></script>
        <script src=""""),_display_(/*173.23*/routes/*173.29*/.Assets.versioned("javascripts/main.js")),format.raw/*173.69*/(""""></script>


        <script type="text/javascript">

           $(document).ready(function()"""),format.raw/*178.40*/("""{"""),format.raw/*178.41*/("""
            """),format.raw/*179.13*/("""$('#sort').DataTable();
            """),format.raw/*180.13*/("""}"""),format.raw/*180.14*/(""");

            $(document).ready(function() """),format.raw/*182.42*/("""{"""),format.raw/*182.43*/("""
                    """),format.raw/*183.21*/("""$.ajax("""),format.raw/*183.28*/("""{"""),format.raw/*183.29*/("""
                    """),format.raw/*184.21*/("""type: "post",
                    url: """"),_display_(/*185.28*/routes/*185.34*/.Application.getNotification()),format.raw/*185.64*/("""",
                    data: ""
                """),format.raw/*187.17*/("""}"""),format.raw/*187.18*/(""").success(function(response) """),format.raw/*187.47*/("""{"""),format.raw/*187.48*/("""
                    """),format.raw/*188.21*/("""$('#notify').html(response);
                """),format.raw/*189.17*/("""}"""),format.raw/*189.18*/(""")

            """),format.raw/*191.13*/("""}"""),format.raw/*191.14*/(""");
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
object adminmain extends adminmain_Scope0.adminmain_Scope1.adminmain
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:17 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/adminmain.scala.html
                  HASH: cdc4cb02bd9f7237128d43f4fe525750e2597217
                  MATRIX: 855->58|1043->151|1073->155|1377->432|1403->437|1551->558|1566->564|1638->614|1724->673|1739->679|1813->731|1902->793|1917->799|1985->845|2084->917|2099->923|2169->972|2239->1015|2254->1021|2317->1063|2461->1180|2476->1186|2534->1222|6779->5440|6799->5451|6835->5466|6864->5467|7695->6270|7737->6302|7778->6304|7825->6322|8029->6498|8044->6503|8081->6518|8128->6536|8181->6557|8224->6571|8325->6644|8367->6676|8408->6678|8455->6696|8659->6872|8674->6877|8711->6892|8758->6910|8811->6931|8854->6945|8955->7018|8994->7047|9035->7049|9082->7067|9283->7240|9298->7245|9332->7257|9379->7275|9432->7296|9475->7310|9576->7383|9617->7414|9658->7416|9705->7434|9908->7609|9923->7614|9959->7628|10006->7646|10059->7667|10102->7681|10261->7812|10290->7819|10328->7829|10831->8304|10847->8310|10915->8356|10978->8391|10994->8397|11068->8449|11135->8488|11151->8494|11222->8543|11289->8582|11305->8588|11376->8637|11462->8695|11478->8701|11543->8744|11606->8779|11622->8785|11684->8825|11770->8883|11786->8889|11857->8938|11920->8973|11936->8979|11998->9019|12126->9118|12156->9119|12199->9133|12265->9170|12295->9171|12371->9218|12401->9219|12452->9241|12488->9248|12518->9249|12569->9271|12639->9313|12655->9319|12707->9349|12786->9399|12816->9400|12874->9429|12904->9430|12955->9452|13030->9498|13060->9499|13106->9516|13136->9517
                  LINES: 31->3|36->3|38->5|46->13|46->13|49->16|49->16|49->16|50->17|50->17|50->17|53->20|53->20|53->20|56->23|56->23|56->23|57->24|57->24|57->24|60->27|60->27|60->27|130->97|130->97|130->97|130->97|150->117|150->117|150->117|151->118|153->120|153->120|153->120|154->121|155->122|156->123|158->125|158->125|158->125|159->126|161->128|161->128|161->128|162->129|163->130|164->131|166->133|166->133|166->133|167->134|169->136|169->136|169->136|170->137|171->138|172->139|174->141|174->141|174->141|175->142|177->144|177->144|177->144|178->145|179->146|180->147|185->152|185->152|186->153|199->166|199->166|199->166|200->167|200->167|200->167|201->168|201->168|201->168|202->169|202->169|202->169|203->170|203->170|203->170|204->171|204->171|204->171|205->172|205->172|205->172|206->173|206->173|206->173|211->178|211->178|212->179|213->180|213->180|215->182|215->182|216->183|216->183|216->183|217->184|218->185|218->185|218->185|220->187|220->187|220->187|220->187|221->188|222->189|222->189|224->191|224->191
                  -- GENERATED --
              */
          