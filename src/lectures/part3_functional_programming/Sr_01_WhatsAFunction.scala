package lectures.part3_functional_programming

object Sr_01_WhatsAFunction extends App {

  // Purpose of Functional Programming - Use functions as a first class elements.
  // i.e. Use Functions as a value.
  // Problem - We came from OO world. where everything is an Class or Objects.
  // JVM was designed around classes
  // Only ways for functional programming was to simulate using Classes and instance of those classes.

  // Scala had to do some clever tricks so that it looks like to be a real functional language.
  // Scala defined defs as instances of Function class.
  // For Ex -
  def doubler(n: Int): Int = n * 2

  // is actually same as below -
  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler2 = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val v1 = doubler(10)
  val v2 = doubler2(10)

  println(v1)
  println(v2)

  // Scala has 22 Function Types like Function1, Function2, Function3..............Function22
  // for a function with one parameter and one result is an instance of Function1[A,B]
  // We can also define function as below -
  val stringToInt = new Function1[String, Int] {
    override def apply(s: String): Int = s.toInt
  }

  println(stringToInt("55") + 6)

  // The Type of stringToInt is Function2[String, Int],
  // It will be shown as (String) => Int. It's a syntactic sugar for Function2
  // i.e. Function2[A,B,R]  === (A,B) => R

  // So it's clear that
  // ALL SCALA FUNCTIONS ARE OBJECTS.

  /**
   * Exercises
   * 1. Define a function which takes 2 strings and concatenates them.
   * 2. In MyList - Transform MyPredicate and MyTransformer into function types.
   * 3. Define a function which takes an argument ans returns another function which takes an Int and returns an Int.
   *    Define the type of a fucntion
   *    How do you implement it ?
   */

}