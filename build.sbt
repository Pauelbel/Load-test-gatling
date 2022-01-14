import Dependencies._
import sbt.Keys.libraryDependencies

enablePlugins(GatlingPlugin)


lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.6",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "test",
    libraryDependencies ++= gatling
  )

