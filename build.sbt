ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

libraryDependencies += "io.github.hexagonnico" % "vecmatlib" % "2.2"

lazy val root = (project in file(".")).settings(
  name := "CmplxLib"
)

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test
crossPaths := false