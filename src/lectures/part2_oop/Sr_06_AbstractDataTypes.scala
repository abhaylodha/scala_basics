package lectures.part2_oop


object Sr_06_AbstractDataTypes extends App {

  //********************************************
  // Abstract - Class with unimplemented members
  //********************************************
  abstract class Animal {
    val creatureType: String

    def makeNoise

    def eat: Unit = println("num num num")
  }

  //Abstract classes cannot be instantiated.
  //val a = new Animal()

  //Concrete class
  class Dog extends Animal {
    //override
    override val creatureType: String = "Canine"

    def makeNoise = println("num num num")
  }

  //traits
  //Traits can be mixed in to support multiple inheritance.
  trait Carnivore {
    def eat(animal: Animal) = println(s"Crocodile eats " +
      s"${animal.creatureType}")

    def eat = println("Crocodile eats something")

  }

  trait ColdBlooded {
    val coldBlooded = true
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Wild"

    def makeNoise = println("Crocodile doesn't make any noise")

    override def eat = super.eat
  }

  val c = new Crocodile
  println(c.creatureType)
  c.makeNoise
  c.eat
  c.eat(new Dog)


  val croc: ColdBlooded = new Crocodile
  println(s"It is ${croc.coldBlooded} that Crocodile is cold blooded.")

  //************************************************
  //traits Vs abstract classes
  //************************************************
  // 1. Traits cannot have constructor parameters
  // 2. Can extend only one class, but multiple traits
  // 3. Traits reveal behaviours. e.g. Carnivore
  //    Classes reveal things. e.g. Animal

}
