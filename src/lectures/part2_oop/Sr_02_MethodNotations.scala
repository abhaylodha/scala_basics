package lectures.part2_oop

object Sr_02_MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age : Int = 0) {

    //In-fix notations
    def likes(movie: String): Boolean = favoriteMovie == movie
    def marriedTo(other: Person) = s"${this.name} married to ${other.name}."
    def learns(topic : String  ) = s"$name learns $topic"
    def learnScala = this learns "Scala"

    def +(other: Person) = s"${this.name} married to ${other.name}."
    def +(str:String):Person = new Person(s"${name} ($str)",favoriteMovie)

    //Pre-fix notations
    //Unary operators work with only +, -, ~ and !

    def unary_! : String = s"${this.name} started disliking ${this.favoriteMovie}"
    def unary_+ : Person = new Person(name,favoriteMovie, age + 1)

    //Post-fix notations
    def isAlive = s"${this.name} is alive"
    def ? = true

    //apply
    def apply(): String = s"Hi, my name is ${this.name}. I like ${this.favoriteMovie}."
    def apply(n :Int) : String = s"$name watched $favoriteMovie $n times."
  }

  val mary = new Person("Mary", "K3G")
  val sam = new Person("Sam", "Mera Naam Joker")

  //In-fix Operator Notations
  println(mary.likes("K3G"))
  println(mary likes "K3G")
  println(mary marriedTo sam)

  //Pre-fix Operator Notations
  println(!mary)
  println(mary.unary_!)

  //Post-fix notations
  println(mary?)
  println(mary.?)
  println(mary isAlive)

  //Apply
  println(mary())
  println(mary.apply())
  println(mary.apply)

  val p2 = mary + "The Rock Star"
  println(p2.name)

  val p3 = +mary
  println(mary.age)
  println(p3.age)

  println(mary learns "Scala")
  println(mary learnScala)

  println(mary(3))

}


//********************************************************
//Exercises
//********************************************************

/**
  * 1. Overload + operator
  *    mary + "The Rockstar" should yield a new person with
  *    name : Mary (The Rockstar) and favourite movie as same one.
  *
  * 2. Add an age to the person class
  *    Add unary + operator should yield a new person with age + 1.
  *    i.e. +mary => should increment the age.
  *
  * 3. Add "learns" method to Person class
  *    i.e. "mary learns Scala"
  *    Add a learnsScala method, calls learns method with "Scala"
  *    Use it in postfix notation.
  *
  * 4. Overload apply method.
  *    mary.apply(2) should yield "MAry watched K3G 2 times."
  *
  *
  */
