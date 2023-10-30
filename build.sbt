ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

libraryDependencies += "io.github.hexagonnico" % "vecmatlib" % "2.2"

lazy val root = (project in file(".")).settings(
  name := "CmplxLib"
)
