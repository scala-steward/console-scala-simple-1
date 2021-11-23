lazy val consoleScalaSimple = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "console-scala-simple",
    Compile / mainClass := Some("org.eclipse.che.examples.HelloWorld"),
    libraryDependencies ++= List(
      Dependencies.zio,
      Dependencies.zioTest % Test,
      Dependencies.zioTestSbt % Test,
    ),
  )

lazy val commonSettings: List[Def.Setting[_]] = DecentScala.decentScalaSettings ++ List(
  organization := "org.eclipse.che.examples",
  homepage := Some(url("https://github.com/sideeffffect/console-scala-simple")),
  licenses := List("MIT" -> url("https://opensource.org/licenses/MIT")),
  developers := List(
    Developer(
      "john.doe",
      "John Doe",
      "john.doe@redhat.com",
      url("https://www.eclipse.org/che/"),
    ),
  ),
  crossScalaVersions -= DecentScala.decentScalaVersion211,
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  mimaReportBinaryIssues := {},
)

addCommandAlias("ci", "; check; +publishLocal")
