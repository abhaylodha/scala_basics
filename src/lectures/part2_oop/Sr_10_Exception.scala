package lectures.part2_oop

object Sr_10_Exception extends App {

  /**
   * JVM specific concept - exception.
   *
   * Exceptions are technical and very sweet name given for a miserable situation when a program crashes.
   *
   */

  val x: String = null

  //Below will crash the program. (i.e. cause exception[NUll Pointer Exception])
  //println(x.length)

  // 1. What are Exceptions ?
  // Exception return Nothing, which is subclass of everything,
  // It can be assigned to any type of class.

  // Throwable classes extends Throwable class
  // Exception and Error are major Throwable subtypes.

  // Exception are related to some issues within program.
  // Eg. NullPointerException

  // Errors are thrown to highlight issues with
  // Eg. Stackoverflow error.

  // 2. Throwing
  //val aValues: Nothing = throw new NullPointerException
  //val aVal1: String = throw new NullPointerException

  // 3. Catching Exception
  def getInt(withException: Boolean): Int = if (withException)
    throw new RuntimeException("No integer to return")
  else
    50

  try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught Runtime Exception")
  } finally {
    //Finally catches everything whether exception occurred or not ?
    println("Finally Exceuted.")
  }

  //Catching something else will not help.
  try {
    getInt(true)
  } catch {
    case e: NullPointerException => println("Caught NPE")

    case e: RuntimeException => println("Caught Runtime Exception")
  } finally {
    //Finally catches everything whether exception occurred or not ?
    println("Finally Exceuted.")
  }

  //In Scala everything is an expression and gets evaluated. Similar is case with try/catch/finally.
  //Lets explore values.

  val v = try {
    getInt(true)
  } catch {
    case e: NullPointerException => {
      println("Caught NPE")
      29
    }

    case e: RuntimeException => {
      println("Caught Runtime Exception")
      20
    }
  } finally {
    //Finally catches everything whether exception occurred or not ?
    //It's optional
    //Does not influence return type.
    //Use it only for side effects.
    println("Finally Exceuted.")
  }

  println(v)

  //4. Define your own exceptions
  //class MyException extends Exception
  class MyException(msg: String) extends Exception(msg)

  val ex = new MyException("My Exception occurred")

  //throw ex

  /**
   * Excercise
   * 1. Crash your program with OutOfMemoryError
   * 2. Crash your program with StackOverFlowError
   * 3. Design PocketCalculator with few methods.
   * 			- add(x,y)
   * 			- subtract(x,y)
   * 			- multiply(x,y)
   * 			- divide(x,y)
   *
   * Throw
   * 		OverException if add(x,y) exceeds Int.MAX_VALUE
   *    UnderFlowException if subtract(x,y) exceed Int.MIN_VALUE
   *    MathCalculation Exception for division by zero.
   */

  //Below will crash JVM with OOM exception.
  //Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
  //val array = Array.ofDim(Int.MaxValue)

  //Below will crash a program with StackOverFlow Error
  //Exception in thread "main" java.lang.StackOverflowError
  /**
   * def weirdMethod: Int = {
   *  weirdMethod
   *  5
   * }
   * println(weirdMethod)
   */

  object PocketCalculator {

    class OverFlowException(msg: String) extends Exception(msg)
    class UnderFlowException(msg: String) extends Exception(msg)
    class MathCalculationException(msg: String) extends Exception(msg)

    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException("Integer limit excceded.")
      if (x < 0 && y < 0 && result > 0) throw new UnderFlowException("Integer limit excceded.")

      result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException("Integer limit excceded.")
      if (x < 0 && y > 0 && result > 0) throw new UnderFlowException("Integer limit excceded.")

      result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException("Integer limit excceded.")
      if (x < 0 && y < 0 && result < 0) throw new OverFlowException("Integer limit excceded.")
      if (x > 0 && y < 0 && result > 0) throw new UnderFlowException("Integer limit excceded.")
      if (x < 0 && y > 0 && result > 0) throw new UnderFlowException("Integer limit excceded.")

      result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException("Divide by Zero.")
      x / y
    }
  }

  println(PocketCalculator.add(5, 6))
  println(PocketCalculator.subtract(5, 6))
  println(PocketCalculator.multiply(5, 6))
  println(PocketCalculator.divide(5, 6))
}
