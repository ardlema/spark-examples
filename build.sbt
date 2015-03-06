name := "spark-examples"

organization := "org.ardlema"

version := "0.0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test" withSources() withJavadoc(),
  "org.scalacheck" %% "scalacheck" % "1.12.1" % "test" withSources() withJavadoc(),
  "org.apache.spark" % "spark-core_2.10" % "1.2.1"
)

initialCommands := "import org.ardlema.sparkexamples._"

