package lectures.part2_oop

object Sr_03_Objects extends App {

  //********************************************************
  // Singleton Object.
  // Instance is created only when object is referred in program.
  //********************************************************

  object Person {
    val N_EYES = 2
    private val privateValue = 500

    def canFly() = false

    //It's printed only when this Singleton object is referred for first time.
    println("Object Person created")

    //For factory pattern, we generally have apply methods here.
    def apply(personName: String = "Sandy"): Person = new Person(personName)

  }

  class Person(val name: String = "") {
    def printSecretNumber = println(Person.privateValue)
  }

  //********************************************************
  // Class and Object wh same name in same scope are
  // called companions
  // Companions can access each other's private members.
  //********************************************************

  val p1 = Person
  val p2 = Person

  val p3 = new Person()
  val p4 = new Person()

  println(p1 == p2)
  println(p3 == p4)

  val p5 = Person()
  println(p5.name)

  val p6 = Person("Amit")
  println(p6.name)

  println(p3.printSecretNumber)

}
