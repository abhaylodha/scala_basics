package lectures.part2_oop

import java.time.LocalDate

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
    println(s"$name says - Hi, ${this.name}. Your age ${this.age}." +
      s" Your phone #${phone}.")

  def greet() = println(s"Hello $name")

  //multiple constructors
  def this() = this("default_name", 20)

  val w1 = new Writer("Abc", "Xyz", 1998)
  val w2 = new Writer("Abc", "Xyz", 1998)
  println(s"Writer Age : ${w1.fullName}")

  val n = new Novel("My Life", 2015, w1)
  println(s"It is ${n.isWrittenBy(w1)} that '${n.name}' has been written by '${w1.fullName}' when he was ${n.authorAge} years old.")
  println(s"It is ${n.isWrittenBy(w2)} that '${n.name}' has been written by '${w2.fullName}' when he was ${n.authorAge} years old.")

  val n1 = n.copy(2018)
  println(s"It is ${n1.isWrittenBy(w1)} that '${n.name}' has been re-written by '${w1.fullName}' when he was ${n1.authorAge} years old.")

  val counter1 = new Counter
  counter1.print
  val counter2 = counter1.increment(5)
  counter2.print
  val counter3 = counter2.increment
  counter3.print
  val counter4 = counter3.decrement(3)
  counter4.print
  val counter5 = counter4.decrement
  counter5.print

}

//********************************************************
//Exercises
//********************************************************

/**
 * Novel and Writer
 * Writer : fName, lName, year
 * Methods
 *       - fullName
 * Novel : name, year of release, author
 * Methods
 *       - authorAge
 *       - isWrittenBy(author)
 *       - copy(new year of release)  = new instance of Novel
 *
 */

class Writer(val fName: String, val lName: String, val yearOfBirth: Int) {
  def fullName = s"$fName $lName"
}

class Novel(val name: String, val year: Int, val author: Writer) {
  def authorAge = year - author.yearOfBirth

  //Equality check of objects.
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/**
 * Counter class
 *  - Receives an Int value
 * Methods :
 *  - Current Count
 *  - Increment, returns new counter
 *  - Decrement, returns new counter
 *  - Increment by n, returns new counter
 *  - Decrement by n, returns new counter
 *
 */

class Counter(counterVal: Int = 0) {
  def getCount = counterVal
  def increment(byVal: Int): Counter = {
    println(s"Incrementing by $byVal")
    new Counter(counterVal + byVal)
  }
  def decrement(byVal: Int): Counter = {
    println(s"Decrementing by $byVal")

    new Counter(counterVal - byVal)
  }
  def increment: Counter = increment(1)
  def decrement: Counter = decrement(1)

  def print = println(s"Counter value = $counterVal")
}
