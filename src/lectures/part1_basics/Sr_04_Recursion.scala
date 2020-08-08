package lectures.part1_basics

import scala.annotation.tailrec

object Sr_04_Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing for " + n + ". Need to compute " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed for " + n)
      result
    }
  }

  println(factorial(5))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelp(acc: BigInt, n: Int): BigInt = {
      if (n <= 1) acc
      else {
        println("Computing for " + n + ". Need to compute " + (n - 1))
        factHelp(acc * n, n - 1)
      }
    }

    factHelp(1, n)
  }

  println(anotherFactorial(5000))


  //********************************************************
  // Use Tail recursion when possible
  //********************************************************

  //********************************************************
  // Exercises
  //********************************************************
  //1. Concatenate a String n times
  //2. isPrime Using Tail Recursion
  //3. Fibonacci Using Tail Recursion

  def concatenate(str: String, n: Int): String = {
    def concatHelp(acc: String, t: Int): String = {
      if (t == 0) acc
      else concatHelp(acc + str, t - 1)
    }

    concatHelp("", n)
  }

  println(concatenate("a", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelp(t: Int): Boolean = {
      if (t == 1) true
      else if (n % t == 0) false
      else isPrimeHelp(t - 1)
    }

    isPrimeHelp(n / 2)
  }

  println(isPrime(4))
  println(isPrime(17))
  println(isPrime(37 * 17))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibHelp(prev1: Int, prev2: Int, iteration_num: Int): Int = {
      if (n == iteration_num) prev1 + prev2
      else
        fibHelp(prev2, prev1 + prev2, iteration_num + 1)
    }

    if (n <= 2)
      1
    else
      fibHelp(1, 1, 3)
  }

  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
  println(fibonacci(6))
  println(fibonacci(7))
  println(fibonacci(8))
  println(fibonacci(9))
  println(fibonacci(10))

}
