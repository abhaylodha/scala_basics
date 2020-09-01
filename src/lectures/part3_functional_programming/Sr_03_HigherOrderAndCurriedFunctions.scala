package lectures.part3_functional_programming

object Sr_03_HigherOrderAndCurriedFunctions extends App {

  val superFunction: (Int, (String, (Int => Boolean))) => Int => (Int => Int) = null

  // Higher Order Functions

  // map, flatmap, filter are HOFs

  // Function that applies another function n times over a value. x
  // nTimes (f, n, x) Apply f on x n times.

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0)
      x
    else
      nTimes(f, n - 1, f(x))
  }

  def plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 5, 1))

  //In below, instead of applying f to x n times, we save it for later and return a lambda function, which can be applied to x later point of time.
  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0)
      (x: Int) => x
    else
      (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  def plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  val superAdder = (x: Int) => (y: Int) => x + y
  val adder3 = superAdder(3)

  println(adder3(6))
  println(superAdder(3)(6))

  def superFormatter(f: String)(v: Double) = f.format(v)
  val standardFormatter: (Double => String) = superFormatter("%4.2f")
  val standardFormatter_V2 = superFormatter("%4.2f") _ //Partially applied function

  val preciseFormatter: (Double => String) = superFormatter("%10.8f")
  val preciseFormatter_V2 = superFormatter("%10.8f") _ //Partially applied function

  println(standardFormatter(Math.PI))
  println(standardFormatter_V2(Math.PI))
  println(preciseFormatter(Math.PI))
  println(preciseFormatter_V2(Math.PI))

}
















