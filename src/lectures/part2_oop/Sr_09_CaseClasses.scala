package lectures.part2_oop

object Sr_09_CaseClasses extends App {

  /**
   * Case classes help to create companion object for a  class and add lot of defaults in one go.
   * It helps to reduce boilerplate code.
   * 
   * Common methods -
   * equals, hashCode, toString
   *
   */

  case class Person(name: String, age: Int)

  //1. Class parameters are promoted to fields

  val p1 = new Person("Abc", 55)
  println(p1.name)

  //2. Sensible toString
  println(p1.toString())
  println(p1)

  //3. equals and hashcode are implemented out of the box.
  val p2 = new Person("Abc", 55)

  println(p1 == p2)

  //4. Case classes have convenient copy methods.
  println(p1.copy())
  println(p1.copy(age = 45))

  //5. Case classes have companion objects
  val person = Person
  val p3 = Person.apply(name = "abc", age=38)

  println(person)
  println(p3)

  // 6. Case classes are serializable
  //Akka deals with sending serializable messages over the network and uses case classes heavily.
  
  //7. Case classes have extractor pattern
  //i.e. case classes can be used in pattern matching.
  
  
  //Case Objects
  //Same as case classes except, they don't get companion objects
  
  case object Maharashtra {
    def name = "Maharashtra : The Land of Great Marathas"
  }
  
  //Exercises
  //Expand MyList to use case classes and case objects
  
  
}