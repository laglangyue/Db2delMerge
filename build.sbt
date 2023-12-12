ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "Db2.del-Merge",
    // https://mvnrepository.com/artifact/org.apache.commons/commons-csv
    libraryDependencies += "org.apache.commons" % "commons-csv" % "1.10.0"
    )
