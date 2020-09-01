package lectures.part3_functional_programming

object Sr_02_AnonymousFunctions extends App {

  //Object Oriented way of defining a function
  val doubler = new Function1[Int, Int] {
    override def apply(a: Int): Int = a * 2
  }

  //This can be done using a simple way
  val doubler_v2: (Int) => Int = (x: Int) => x * 2
  val doubler_v3: (Int) => Int = x => x * 2

  println(doubler(4))
  println(doubler_v2(6))
  println(doubler_v3(6))

  //Multiple Parameters in Lambda should be in put in parenthesis
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println(adder(3, 4))

  //No parameter function
  val doSomething: () => Int = () => 55

  println(doSomething) // This will print Function1 Instance details.
  println(doSomething()) //This will evaluate function by calling apply method.

  //Curly braces with Lambda
  val stringToInt = { (a: String) =>
    a.toInt
  }

  //Syntactic Sugar
  val niceIncrementer: Int => Int = _ + 1 // Equivalent to (x: Int) => x + 1
  println(niceIncrementer(4))

  val niceAdder: (Int, Int) => Int = _ + _ //Equivalent to (a,b)=> a + b
  println(niceAdder(6, 7))

  /*
   * Exercises
   * 1. In My List replace all FunctionX calls with Lambda
   * 2. Rewrite adder as an anonymous curried function.
   */

  val curriedAdder: Int => (Int => Int) = new Function1[Int, Int => Int] {
    override def apply(x: Int): Int => Int = y => x + y
  }

  val curriedAdder_V2: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  println(curriedAdder(5)(6))
  println(curriedAdder_V2(5)(6))

}
