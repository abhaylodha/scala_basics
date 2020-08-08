package lectures.part1_basics

object Sr_No_05_CallByValueCallByName extends App {

  def callByValue(x: Long) = {
    println("By Value => " + x)
    println("By Value => " + x)
  }

  def callByName(x: => Long) = {
    println("By Name => " + x)
    println("By Name => " + x)
  }

  callByValue(System.nanoTime)
  callByName(System.nanoTime)

  //********************************************************
  // By Name functions delays evaluation of passed function
  //********************************************************

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(10,infinite)

}
