lazy val pomDetails = <url>https://github.com/norbert-radyk/spoiwo/</url>
  <licenses>
    <license>
      <name>MIT-License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/norbert-radyk/spoiwo</url>
    <developerConnection>scm:git:git@github.com:norbert-radyk/spoiwo.git</developerConnection>
    <connection>scm:git:git@github.com:norbert-radyk/spoiwo.git</connection>
  </scm>
  <developers>
    <developer>
      <id>norbert-radyk</id>
      <name>Norbert Radyk</name>
      <email>norbert.radyk@norbitltd.com</email>
    </developer>
  </developers>

lazy val commonSettings = Seq(
  organization := "com.norbitltd",
  scalaVersion := "2.10.5",
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := pomDetails,
  libraryDependencies ++= Seq(
    "org.apache.poi" % "poi" % "3.11",
    "org.apache.poi" % "poi-ooxml" % "3.11",
    "commons-logging" % "commons-logging" % "1.2",
    "joda-time" % "joda-time" % "2.7",
    "org.joda" % "joda-convert" % "1.7",
    "org.scalatest" % "scalatest_2.10" % "2.2.4"
  )
)

lazy val spoiwo = (project in file("."))
  .settings(commonSettings : _*)
  .settings(
    name := "spoiwo",
    version := "1.0.7"
  )

lazy val examples = (project in file("examples"))
  .dependsOn(spoiwo)
  .settings(commonSettings : _*)
  .settings(
    name := "spoiwo-examples",
    version := "1.0.0"
  )
