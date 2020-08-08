package lectures.part1_basics

import scala.annotation.tailrec

object Sr_06_DefaultArguments extends App {

  //********************************************************
  // acc is given a default value.
  //********************************************************

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  println(trFact(5))

  //********************************************************
  // Arguments also can be named.
  //********************************************************

  def resizePicture(width: Int = 800, height: Int = 600) = println("Picture formatted")

  resizePicture(height = 500)
  resizePicture(width = 400)
  resizePicture(height = 500, width = 400)
  resizePicture(width = 400, height = 500)

}
