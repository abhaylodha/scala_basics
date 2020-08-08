package lectures.part2_oop

object Sr_01_OOPBasics extends App {

  val person = new Person("ABC", 26)

  println(person.name)
  println(person.x)
  person.greet("XYZ")
  person.greet

  val default_person = new Person
  println(default_person.name)
  println(default_person.x)
  default_person.greet("XYZ")
  default_person.greet

}

//name is class parameter as well as member
//age is class parameter, but not members
//phone is a a parameter.
//Parameters can only be used within class and not as members.
class Person(val name: String, age: Int, phone: String = "9890758583") { //Constructor

  val x = 2 //Fields

  println(1 + 2)

  //method
  def greet(name: String) =
    println(s"$name says - Hi, ${this.name}. Your age ${this.age}."+
      s" Your phone #${phone}.")

  def greet() = println(s"Hello $name")

  //multiple constructors
  def this() = this("default_name", 20)
}
