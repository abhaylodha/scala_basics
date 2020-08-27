package excercises

object Sr_02_MyGenericList extends App {

  /**
   * Create a generic types Linked List, such that
   * head - returns first element of the list
   * tail - returns the remainder of the list
   * isEmpty - returns true if the list is empty, else false.
   * add(int) - returns a new lsit with element added.
   * override toString - for String representation of the list.
   *
   */

  abstract class MyGenericList[+A] {
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

    def add[B >: Nothing](elem: B): MyGenericList[B] = new Cons(elem, this)

    override def elementToString: String = s""
  }

  class Cons[+A](e: A, tailElem: MyGenericList[A]) extends MyGenericList[A] {
    def head: A = e

    def tail: MyGenericList[A] = this.tailElem

    def isEmpty: Boolean = false

    def add[B >: A](elem: B): MyGenericList[B] = new Cons(elem, this)

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
}

