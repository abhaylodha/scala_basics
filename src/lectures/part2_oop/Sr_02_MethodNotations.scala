package lectures.part2_oop

object Sr_02_MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String) {

    //In-fix notations
    def likes(movie: String): Boolean = favoriteMovie == movie
    def marriedTo(other: Person) = s"${this.name} married to ${other.name}."
    def +(other: Person) = s"${this.name} married to ${other.name}."

    //Pre-fix notations
    //Unary operators work with only +, -, ~ and !

    def unary_! : String = s"${this.name} started disliking ${this.favoriteMovie}"

    //Post-fix notations
    def isAlive = s"${this.name} is alive"
    def ? = true

    //apply
    def apply(): String = s"Hi, my name is ${this.name}. I like ${this.favoriteMovie}."
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

}
