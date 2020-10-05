package excercises

import scala.annotation.tailrec

/**
 * For 3 candles
 * Total		Candles		Half remains
 * 0			3  			0
 * 3  			1  			1
 * 4  			0  			2
 * 4  			1  			0
 * 5  			0  			1
 * For 3 Candles, total candles we can burn are : 5
 *
 * For 5 candles
 * Total		Candles		Half remains
 * 0			5  		0
 * 5  			2  		1
 * 7  			1  		1
 * 8  			0  		2
 * 8  			1  		0
 * 9  			0  		1
 * For 5 Candles, total candles we can burn are : 9
 *
 * For 10 candles
 * Total		Candles		Half remains
 * 0			10  		0
 * 10  			5  		0
 * 15  			2  		1
 * 17  			1  		1
 * 18  			0  		2
 * 18  			1  		0
 * 19  			0  		1
 * For 10 Candles, total candles we can burn are : 19
 *
 * For 47 candles
 * Total		Candles		Half remains
 * 0			47	  	0
 * 47  			23  		1
 * 70  			11  		2
 * 81  			6  		1
 * 87  			3  		1
 * 90  			1  		2
 * 91  			1  		1
 * 92  			0  		2
 * 92  			1  		0
 * 93  			0  		1
 * For 47 Candles, total candles we can burn are : 93
 *
 */
object Sr_00_CandleBurningPuzzle extends App {

  def getBurnCount(candles: Int) = {
    @tailrec
    def burnCount(_total: Int, _candles: Int, _halfReamins: Int): Int = {

      val (total, candles, halfRemains) = (_total + _candles,
        (_candles / 2) + (_halfReamins / 2),
        (_halfReamins % 2) + (_candles % 2))

      println(s"$total  		$candles  		$halfRemains")
      if (candles < 1 && halfRemains < 2)
        total
      else {
        burnCount(total, candles, halfRemains)
      }
    }
    println(s"For $candles candles")
    println("Total		Candles		Half remains")
    println(s"0		$candles  		0")

    burnCount(0, candles, 0)
  }
  println("For 3 Candles, total candles we can burn are : " + getBurnCount(3))
  println("For 5 Candles, total candles we can burn are : " + getBurnCount(5))
  println("For 10 Candles, total candles we can burn are : " + getBurnCount(10))
  println("For 47 Candles, total candles we can burn are : " + getBurnCount(47))

}