package lectures.part2_oop

object Sr_11_PackagingAndExports extends App {

  //Packaging = Bunch of definitions grouped under same name.

  //Package members are accessible by their simple name.
  val writer = new Writer(fName = "abc", lName = "xyz", yearOfBirth = 1068)

  //You need to import required package for using class, trait, or other definition from that package.
  //Another option is using fully qualified name.

  //packages are ordered hierarchically. It maps to folder structure in the file system.

  //Package object - Very scala specific code organizing structure.
  //Originated from a problem that sometimes, we may want to override some methods/constants outside of everything else.
  //Can be used for defining some universal constants/methods

  // How to create PAckage Objects?
  // Right click Package, where we want package object and click Package Object.
  //Package Objects can only be one per package.
  //package.scala is the name of file in which package objects are defined within a package.

  sayHello
  println(PI)

  //2. Imports
  //We can club imports using below syntax.
  //import playground.{ ScalaPlayground, WithMainMethod }

  //import everything fro ma package.
  //import playground._

  //3. Name aliasing
  //import playground.{ScalaPlayground = SP}
  //import playground.{ ScalaPlayground => SP, WithMainMethod => WMM }

  //Aliasing is useful when importing same entity from two different packages with same name
  //For ex -
  import java.util.{ Date => utilDate }
  import java.sql.{ Date => sqlDate }

  //4. Default imports
  //Java
  import java.lang.{ String, Object, Exception }
  //Scala
  import scala.{ Int }
  import scala.Predef.{ println, ??? }

}
