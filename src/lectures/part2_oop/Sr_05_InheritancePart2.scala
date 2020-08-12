package lectures.part2_oop

object Sr_05_InheritancePart2 extends App {

  //Keyword "sealed" prevents Animal being extended outside this file.
  sealed class Animal {
    //final prevents sub class to inherit the method/value
    final val canBreathe = true
    val creatureType: String = "Wild"

    def eat = println("num num num")

    def makeNoise = {
      println("tak tak tak")
    }
  }

  //==================================================
  // Overriding
  //==================================================

  class Dog(override val creatureType: String = "Domestic",
            override val eat: Unit = println("Default eat method")
           ) extends Animal {
    override val makeNoise: Unit = {
      //Calling Super class methods if required.
      super.makeNoise
      println("bho bho")
    }

    //Below will not work as it is final in super class
    //override val canBreathe = false
  }

  println("Dog 1")
  val dog1 = new Dog
  dog1.makeNoise
  dog1.eat
  println(dog1.creatureType)
  println(dog1.canBreathe)

  println("Dog 2")
  val dog2 = new Dog(creatureType = "Pet")
  dog2.makeNoise
  dog2.eat
  println(dog2.creatureType)
  println(dog1.canBreathe)

  println("Dog 3")
  val dog3 = new Dog(eat = println("Mach mach"))
  dog3.makeNoise
  dog3.eat
  println(dog3.creatureType)
  println(dog1.canBreathe)

  //final at class level prevents it from being inherited.
  final class ABC {
    def print = println("Hi from ABC class")
  }

  //Below will not work as class ABC is final
  //class ABC1 extends ABC
  //Numerical Classes, String class are final in scala and cannot be inherited.

}
