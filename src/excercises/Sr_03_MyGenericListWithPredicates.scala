package excercises

object Sr_03_MyGenericListWithPredicates extends App {

  /**
   * Create a generic types Linked List, such that
   * head - returns first element of the list
   * tail - returns the remainder of the list
   * isEmpty - returns true if the list is empty, else false.
   * add(int) - returns a new list with element added.
   * override toString - for String representation of the list.
   *
   * Extras :
   * 1. Add a generic trait MyPredicate[T] with a little method : test(T) => Boolean
   * 2. Add a generic trait MyTransformer[A, B] to Convert from A type to B type.
   *    With a little method : transform(A) => B
   * 3. Add following function to List
   *     A. map((myTransformer) => List)
   *     B. filter(myPredicate => List)
   *     C. flatMap(myTransFormer from A to List[B] => List[B])
   *
   * For Ex -
   * If class EvenPredicate extends MyPredicate[Int], then test method will return if argument is even or not ?
   * IF class StringToInt extends MyTransformer[String, Int], then transform method will transform List[A] to List[B]
   *
   * [1, 2, 3].map(n=>n * 2) should yield [2, 4, 6]
   * [1, 2, 3].filter(n => n%2==0) should yield [2]
   * [1, 2, 3].
   */

  trait MyPredicate[+T] {
    def test(a: T => Boolean): Boolean
  }

  trait MyFilter[+T] extends MyPredicate[T] {
    def filter(test: T => Boolean): MyGenericList[T]
  }

  trait MyFlattener[+T] {
    def flatMap[B](flattenFunc: T => MyGenericList[B]): MyGenericList[B]
  }

  trait MyTransformer[+A] {
    def map[B](a: A => B): MyGenericList[B]
  }

  abstract class MyGenericList[+A]
    extends MyFilter[A]
    with MyTransformer[A]
    with MyFlattener[A] {
    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](elem: B): MyGenericList[B]
    def elementToString: String
    override def toString = s"[$elementToString]"
  }

  object Empty extends MyGenericList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyGenericList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](elem: B): MyGenericList[B] = new Cons(elem, Empty)
    def test(predicate: Nothing => Boolean) = true
    def filter(test: Nothing => Boolean): MyGenericList[Nothing] = Empty
    def map[B](transform: Nothing => B): Nothing = throw new NoSuchElementException
    def flatMap[B](flattenFunc: Nothing => MyGenericList[B]): Nothing = throw new NoSuchElementException
    override def elementToString: String = s""
  }

  class Cons[+A](e: A, tailElem: MyGenericList[A]) extends MyGenericList[A] {
    def head: A = e

    def tail: MyGenericList[A] = this.tailElem

    def isEmpty: Boolean = false

    def add[B >: A](elem: B): MyGenericList[B] = new Cons(elem, this)

    def test(predicate: A => Boolean) = predicate(e)
    def filter(test: A => Boolean): MyGenericList[A] = tailElem match {
      case Empty => if (test(e)) new Cons(e, Empty) else Empty
      case _ => if (test(e)) new Cons(e, tailElem.filter(test)) else tailElem.filter(test)
    }

    def map[B](transform: A => B): MyGenericList[B] = tailElem match {
      case Empty => new Cons(transform(e), Empty)
      case _ => new Cons(transform(e), tailElem.map(transform))
    }

    def flatMap[B](flattenFunc: A => MyGenericList[B]): MyGenericList[B] = {
      def merge(acc: MyGenericList[B], a: MyGenericList[B]): MyGenericList[B] = {
        a.tail match {
          case Empty => acc.add(a.head)
          case _ => merge(acc.add(a.head), a.tail)
        }
      }

      def flatten(acc: MyGenericList[B], a: MyGenericList[MyGenericList[B]]): MyGenericList[B] = {
        a.tail match {
          case Empty => merge(acc, a.head)
          case _ => {
            println(s"merge($acc, $a.head), $a.tail")
            val result = flatten(merge(acc, a.head), a.tail)
            println(s"result = $result")
            result
          }
        }
      }
      flatten(Empty, this.map(flattenFunc))
    }

    override def elementToString: String = tailElem match {
      case Empty => s"$e"
      case _ => s"$e, ${tailElem.elementToString}"
    }
  }

  val l = Empty
  val l1 = l.add(5)
  val l2 = l1.add(5)
  val l3 = l2.add(10)
  println(l3.toString)

  val l5 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(s"$l5")
  println(s"${l5.add(5)}")
  println(s"${l5.tail}")
  println(s"${l5.tail.head}")

  val l6 = l5.map(a => a * 5)
  val l7 = l5.filter(a => a % 2 == 0)

  println("l5 : " + l5)
  println("l6 : " + l6)
  println("l7 : " + l7)

  val t: MyGenericList[String] = Empty
  val originalList = new Cons("a,b,c", new Cons("d,e", new Cons("f,g", new Cons("h", Empty))))
  val stringList = originalList
    .flatMap(i => i.split(",").foldLeft(t)((lst, item) => {
      println(s"Adding $item")
      lst.add(item)
    }))

  println(originalList)
  println(stringList)
}

