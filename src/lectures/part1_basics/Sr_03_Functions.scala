package lectures.part1_basics

object Sr_03_Functions extends App {

  //Return types are optional for functions
  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Value =", 50))

  def aParameterlessFunction() = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) //Parenthesis can be omitted

  //Return types are compulsory for recursive functions
  def aReapedFucntion(a: String, b: Int): String = {
    if (b == 1) a
    else
      a + aReapedFucntion(a, b - 1)
  }

  println(aReapedFucntion("a", 3))

  //********************************************************
  // When loops needed, use recursion in
  // Functional Programming.
  //********************************************************

  //********************************************************
  // Referentially Transparent Functions.
  // i.e. Functions with no side effects.
  //********************************************************

  def aFunctionWithSideEffects(a: String) = println(a)

  aFunctionWithSideEffects("abc")

  //********************************************************
  // Nested functions
  //********************************************************

  def aBigFunction(n: Int) = {
    def aSmallFunction(a: Int, b: Int) = a + b

    aSmallFunction(n, n + 1)
  }

  println(aBigFunction(10))

  //********************************************************
  // Exercises
  //********************************************************
  //1. A Greeting Function with 2 parameters (name, age)
  //2. Factorial Function
  //3. A Fibonacci Number.
  //    fib(1) = 1
  //    fib(2) = 1
  //    fib(n) = fib(n-1) + fib(n-2)
  //4. A Function to test if a number is prime ?

  def greet(name: String, age: Int) =
    "Hi, my name is : " + name + ". My age is : " + age

  println(greet("ABC", 22))


  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(4))

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(fibonacci(4))

  def isPrime(n: Int): Boolean = {
    def checkDivisibility(t: Int): Boolean = {
      if (t <= 1) true
      else ((n % t != 0) && (checkDivisibility(t - 1)))
    }

    checkDivisibility(n / 2)
  }

  println(isPrime(41))
  println(isPrime(52))
  println(isPrime(37 * 17))


}
