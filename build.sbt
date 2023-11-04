ThisBuild / version := "1.0"

ThisBuild / scalaVersion := "2.13.12"

libraryDependencies += "io.github.hexagonnico" % "vecmatlib" % "2.3"

lazy val root = (project in file(".")).settings(
  name := "CmplxLib"
)

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test
crossPaths := false

// Publishing
ThisBuild / organization := "io.github.hexagonnico"
ThisBuild / organizationName := "cmplxlib"
ThisBuild / organizationHomepage := Some(url("https://github.com/HexagonNico/CmplxLib"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/HexagonNico/CmplxLib"),
    "git@github.com:HexagonNico/CmplxLib.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "HexagonNico",
    name = "Nicholas Amigoni",
    email = "nico.hex6@gmail.com",
    url = url("https://hexagonnico.github.io")
  )
)

ThisBuild / description := "A Scala library for complex numbers, complex vectors, and complex matrices"
ThisBuild / licenses := List(
  "Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")
)
ThisBuild / homepage := Some(url("https://github.com/HexagonNico/CmplxLib"))

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
