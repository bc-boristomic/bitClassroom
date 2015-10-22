name := """bitClassroom"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  filters,
  "org.easytesting" % "fest-assert" % "1.4" % Test,
  "mysql" % "mysql-connector-java" % "5.1.36",
  "joda-time" % "joda-time" % "2.8.2",
  "org.apache.directory.studio" % "org.apache.commons.io" % "2.4",
  "junit" % "junit" % "4.11",
  "org.apache.commons" % "commons-email" % "1.3.3",
  "com.cloudinary" % "cloudinary" % "1.0.14",
  "com.typesafe.play" %% "play-mailer" % "2.4.1",
  "it.innove" % "play2-pdf" % "1.3.0",
  "com.microsoft.azure" % "azure-storage" % "4.0.0"



)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
