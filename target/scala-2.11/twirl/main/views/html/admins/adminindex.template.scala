
package views.html.admins

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminindex_Scope0 {
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

     object adminindex_Scope1 {
import models.user.User

class adminindex extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.14*/("""
    """),_display_(/*3.6*/adminmain("Title")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
        """),format.raw/*4.9*/("""<br> <br> <br>
        <div class="content-wrapper">
            <div class="container">
                <div class="col-lg-12">
                    <div class="alert alert-danger">
                        Welcome back """),_display_(/*9.39*/user/*9.43*/.getFirstName),format.raw/*9.56*/("""
                    """),format.raw/*10.21*/("""</div>

                <div class="table-responsive">

                </div>
            </div>


                <div class="row">
                    <a href="/admin/allusers">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="dashboard-div-wrapper bk-clr-one">
                                <i class="fa fa-venus dashboard-div-icon" ></i>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width : 80 %">
                                    </div>

                                </div>
                                <h4> View users </h4>
                            </div>
                        </div></a>
                    <!-- DODATI KADA BUDE IMALO FUNKCIONALNOST
                    <a href="/post/ ">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="dashboard-div-wrapper bk-clr-two">
                                <i class="fa fa-edit dashboard-div-icon" ></i>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width : 70 %">
                                    </div>

                                </div>
                                <h4>View posts</h4>
                            </div>
                        </div></a>
                        -->
                    <a href="/admin/errors">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="dashboard-div-wrapper bk-clr-three">
                                <i class="fa fa-cogs dashboard-div-icon" ></i>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width : 40 %">
                                    </div>

                                </div>
                                <h4>Error log</h4>
                            </div>
                        </div></a>
                    <a href="/user/courses">
                        <div class="col-md-3 col-sm-3 col-xs-6">
                            <div class="dashboard-div-wrapper bk-clr-four">
                                <i class="fa fa-bell-o dashboard-div-icon" ></i>
                                <div class="progress progress-striped active">
                                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width : 50 %">
                                    </div>

                                </div>
                                <h4>Classroom</h4>
                            </div>
                        </div>
                    </a>
                </div>

                    <!-- DODATI KADA BUDE IMALO FUNKCIONALNOST
                <div class="row">
                    <div class="col-md-6">
                        <div class="notice-board">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Active Panel:
                                    <div class="pull-right" >
                                        <div class="dropdown">
                                            <button class="btn btn-success dropdown-toggle btn-xs" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
                                                <span class="glyphicon glyphicon-cog"></span>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">
                                                    Refresh</a></li>
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="/logout">
                                                    Logout</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">

                                    <ul >

                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-align-left text-success" ></span>
                                                <strong style="color : green"></strong>
                                                <span class="label label-success" >TODO</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a #">
                                            <span class="glyphicon glyphicon-info-sign text-danger" ></span>
                                            <strong style="color : red"></strong>
                                            <span class="label label-default" >TODO</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-comment  text-warning" ></span>
                                                <span class="label label-success" >TODO</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-edit  text-danger" ></span>
                                                <span class="label label-success" >TODO </span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="panel-footer">
                                    <a href="#" class="btn btn-default btn-block"> <i class="glyphicon glyphicon-repeat"></i>
                                        Write Post</a>
                                </div>
                            </div>
                        </div>
                        <hr />

          <div class="text-center alert alert-warning">
            <a href="#" class="btn btn-social btn-facebook">
              <i class="fa fa-facebook"></i>&nbsp; Facebook</a>
            <a href="#" class="btn btn-social btn-google">
              <i class="fa fa-google-plus"></i>&nbsp; Google</a>
            <a href="#" class="btn btn-social btn-twitter">
              <i class="fa fa-twitter"></i>&nbsp; Twitter </a>
            <a href="#" class="btn btn-social btn-linkedin">
              <i class="fa fa-linkedin"></i>&nbsp; Linkedin </a>
          </div>
                    <hr />




          <hr/>
          <div class="Compose-Message">
            <div class="panel panel-success">
              <div class="panel-heading">
                Compose New Message
              </div>
              <div class="panel-body">

                <label>Enter Recipient Name : </label>
                <input type="text" class="form-control" />
                <label>Enter Subject :  </label>
                <input type="text" class="form-control" />
                <label>Enter Message : </label>
                <textarea rows="9" class="form-control"></textarea>
                <hr />
                <a href="#" class="btn btn-warning"><span class="glyphicon glyphicon-envelope"></span>
                  Send Message </a>&nbsp;
              </div>
              <div class="panel-footer text-muted">
                <strong>Note : </strong>Please note that we track all messages so don't send any spams.
              </div>
            </div>
          </div>


            </div>
        </div>
        -->
        </div>
        </div>
    """)))}))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}
}

/**/
object adminindex extends adminindex_Scope0.adminindex_Scope1.adminindex
              /*
                  -- GENERATED --
                  DATE: Thu Sep 24 11:57:16 CEST 2015
                  SOURCE: C:/Users/prile/Desktop/bitClassroom/app/views/admins/adminindex.scala.html
                  HASH: 9f1270164ea16184f4cf40531837c923fe529f31
                  MATRIX: 817->27|924->39|956->46|982->64|1021->66|1057->76|1308->301|1320->305|1353->318|1403->340
                  LINES: 30->2|35->2|36->3|36->3|36->3|37->4|42->9|42->9|42->9|43->10
                  -- GENERATED --
              */
          