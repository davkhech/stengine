name := "stengine"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.5.22",
  "com.github.andyglow" %% "websocket-scala-client" % "0.2.4",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
)