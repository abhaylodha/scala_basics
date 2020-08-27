package lectures.part2_oop

object Sr_08_AnonymousClasses extends App {
  abstract class Animal {
    def eat = println("num num num")
  }

  //Anonymous Class
  val funnyAnimal = new Animal {
    override def eat = println("Funny animal eating")
  }

  println(funnyAnimal.getClass)
  funnyAnimal.eat

  //Anonymous works for Abstract Classes, traits and normal classes except finalized classes/methods.
  /*final*/ class Person(name: String) {
    /*final*/ def sayHi = println(s"Hi, I'm $name")
    def test = println("Test Print")
  }

  val abc = new Person("Abc") {
    override def sayHi = println(s"Hi, I'm Abc. How can I help you ?")
  }

  abc.sayHi
  abc.test
}
