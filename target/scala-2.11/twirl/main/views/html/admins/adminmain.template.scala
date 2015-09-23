
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
                  DATE: Wed Sep 23 19:50:14 CEST 2015
                  SOURCE: /home/boris/Desktop/backupProject-2760526d3667371690d592920007b0ee39f1bccd/bitClassroom/app/views/admins/adminmain.scala.html
                  HASH: b34493cbe8655079934f9bb494b1c7634a82ffea
                  MATRIX: 855->56|1043->149|1071->151|1367->420|1393->425|1538->543|1553->549|1625->599|1710->657|1725->663|1799->715|1885->774|1900->780|1968->826|2064->895|2079->901|2149->950|2218->992|2233->998|2296->1040|2437->1154|2452->1160|2510->1196|6685->5344|6705->5355|6741->5370|6770->5371|7581->6154|7623->6186|7664->6188|7710->6205|7912->6379|7927->6384|7964->6399|8010->6416|8062->6436|8104->6449|8203->6520|8245->6552|8286->6554|8332->6571|8534->6745|8549->6750|8586->6765|8632->6782|8684->6802|8726->6815|8825->6886|8864->6915|8905->6917|8951->6934|9150->7105|9165->7110|9199->7122|9245->7139|9297->7159|9339->7172|9438->7243|9479->7274|9520->7276|9566->7293|9767->7466|9782->7471|9818->7485|9864->7502|9916->7522|9958->7535|10112->7661|10141->7668|10178->7677|10668->8139|10684->8145|10752->8191|10814->8225|10830->8231|10904->8283|10970->8321|10986->8327|11057->8376|11123->8414|11139->8420|11210->8469|11295->8526|11311->8532|11376->8575|11438->8609|11454->8615|11516->8655|11601->8712|11617->8718|11688->8767|11750->8801|11766->8807|11828->8847|11951->8941|11981->8942|12023->8955|12088->8991|12118->8992|12192->9037|12222->9038|12272->9059|12308->9066|12338->9067|12388->9088|12457->9129|12473->9135|12525->9165|12602->9213|12632->9214|12690->9243|12720->9244|12770->9265|12844->9310|12874->9311|12918->9326|12948->9327
                  LINES: 31->3|36->3|38->5|46->13|46->13|49->16|49->16|49->16|50->17|50->17|50->17|53->20|53->20|53->20|56->23|56->23|56->23|57->24|57->24|57->24|60->27|60->27|60->27|130->97|130->97|130->97|130->97|150->117|150->117|150->117|151->118|153->120|153->120|153->120|154->121|155->122|156->123|158->125|158->125|158->125|159->126|161->128|161->128|161->128|162->129|163->130|164->131|166->133|166->133|166->133|167->134|169->136|169->136|169->136|170->137|171->138|172->139|174->141|174->141|174->141|175->142|177->144|177->144|177->144|178->145|179->146|180->147|185->152|185->152|186->153|199->166|199->166|199->166|200->167|200->167|200->167|201->168|201->168|201->168|202->169|202->169|202->169|203->170|203->170|203->170|204->171|204->171|204->171|205->172|205->172|205->172|206->173|206->173|206->173|211->178|211->178|212->179|213->180|213->180|215->182|215->182|216->183|216->183|216->183|217->184|218->185|218->185|218->185|220->187|220->187|220->187|220->187|221->188|222->189|222->189|224->191|224->191
                  -- GENERATED --
              */
          