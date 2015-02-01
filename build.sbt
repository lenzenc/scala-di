name := "scala-di"

version := "1.0"

scalaVersion := "2.11.4"

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases",
  "Sonatype Releases"  at "http://oss.sonatype.org/content/repositories/releases",
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.7",
  "org.slf4j" % "log4j-over-slf4j" % "1.7.7",
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "com.typesafe.slick" % "slick_2.11" % "2.1.0",
  "com.typesafe"%"config"%"1.2.1",
  "org.specs2"%%"specs2"%"2.4"%"test",
  "com.h2database" % "h2" % "1.4.183",
  "com.jolbox"%"bonecp"%"0.8.0.RELEASE",
  "io.spray" %% "spray-can" % "1.3.2",
  "io.spray" %% "spray-routing" % "1.3.2",
  "io.spray" %% "spray-testkit" % "1.3.2",
  "io.spray"%%"spray-json"%"1.3.1",
  "joda-time" % "joda-time" % "2.6",
  "org.joda" % "joda-convert" % "1.7"
)

(testOptions in Test) += Tests.Argument(TestFrameworks.Specs2, "html", "console")

Revolver.settings
    