// Project info
name := "CmplxLib"
organization := "io.github.scalamath"
version := "2.0"
description := "A Scala library for complex numbers, complex vectors, and complex matrices"
// Project scala version
scalaVersion := "2.13.12"

// VecMatLib dependency
libraryDependencies += "io.github.scalamath" % "vecmatlib" % "3.0"

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test
// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test

// Opt out of Scala-version source directory convention
// Needed to run Java Junit tests
crossPaths := false

// Show deprecation warnings
scalacOptions ++= Seq("-unchecked", "-deprecation")