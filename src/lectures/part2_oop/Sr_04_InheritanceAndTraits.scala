package lectures.part2_oop

object Sr_04_InheritanceAndTraits extends App {

  //==================================================
  // Inheriting simple class
  // Access modifiers - Public, Protected, Private
  //==================================================

  class Animal {
    private def aSecret = println("I'm accessible only in Animal class." +
      "A Private Method.")

    protected def confidential = println("I'm accessible in Animal and" +
      " all sub-classes of mine. A Protected Method.")


    def makeNoise = {
      this.aSecret
      println("tak tak tak")
      println("I'm accessible from anywhere. A Public method.")
    }
  }

  // Scala supports single class inheritance just like other languages.
  class Cat extends Animal {
    def printSomething = super.confidential
  }

  val cat = new Cat
  cat.makeNoise
  cat.printSomething

  //==================================================
  // Constructors
  //==================================================

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  //Auxiliary constructor
  class Adult(name: String, age: Int, idCard: String)
    extends Person(name, age)

  //Auxiliary constructor of Super class
  class Infant(name: String) extends Person(name)

  //==================================================
  // Overriding
  //==================================================

  class Dog extends Animal {
    override def makeNoise = {
      //Calling super class method (If required).
      //super.makeNoise
      println("bho bho")
    }

    val dog = new Dog
    dog.makeNoise
  }


}
