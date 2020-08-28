package lectures.part2_oop

object Sr_09_CaseClasses extends App {

  /**
   * Case classes help to create companion object for a  class and add lot of defaults in one go.
   *
   * Common methods -
   * equals, hashCode, toString
   *
   */

  case class Person(name: String, age: Int)

  //1. Class parameters are promoted to fields

  val p = new Person("Abc", 55)
  println(p.name)

  //2. Sensible toString
  println(p.toString())
  println(p)
  
  
}