package excercises

object Sr_05_MyListWithFunctionalWay extends App {

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

  trait MyFilter[+T] {
    def filter(test: T => Boolean): MyList[T]
  }

  trait MyFlattener[+T] {
    def flatMap[B](flattenFunc: T => MyList[B]): MyList[B]
  }

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A](elem: B): MyList[B]
    def elementToString: String
    override def toString = s"[$elementToString]"

    //Higher Order functions.
    //Function which takes other function as a parameter or returns another function.
    def map[B](transformer: (A) => B): MyList[B]
    def flatMap[B](transformer: (A) => MyList[B]): MyList[B]
    def filter(predicate: A => Boolean): MyList[A]
    def ++[B >: A](list: MyList[B]): MyList[B]
  }

  case object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
    def test(predicate: Nothing => Boolean) = true
    override def elementToString: String = s""
    def map[B](transformer: (Nothing) => B): MyList[B] = Empty
    def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  case class Cons[+A](e: A, tailElem: MyList[A]) extends MyList[A] {
    def head: A = e

    def tail: MyList[A] = this.tailElem

    def isEmpty: Boolean = false

    def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)

    def test(predicate: A => Boolean) = predicate(e)
    def filter(predicate: A => Boolean): MyList[A] = {
      if (predicate(head))
        new Cons(head, tailElem.filter(predicate))
      else
        tailElem.filter(predicate)
    }

    def map[B](transformer: (A) => B): MyList[B] =
      new Cons(transformer(e), tailElem.map(transformer))

    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(head, tailElem ++ list)

    def flatMap[B](transformer: (A) => MyList[B]): MyList[B] =
      transformer(head) ++ tail.flatMap(transformer)

    override def elementToString: String = tailElem match {
      case Empty => s"$e"
      case _ => s"$e, ${tailElem.elementToString}"
    }
  }

  val l = Empty ++ Empty
  val l1 = l.add(5) ++ l.add(5) ++ Empty
  val l2 = l1.add(5)
  val l3 = l2.add(10)
  println(l3.toString)

  val l5 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Cons(6, new Cons(7, Empty)))))))
  println(s"l5 = $l5")
  println(s"${l5.add(5)}")
  println(s"${l5.tail}")
  println(s"${l5.tail.head}")

  val myTransform = new Function1[Int, Int] {
    override def apply(e: Int): Int = e + 5
  }

  val l6 = l5.map(myTransform)
  println(s"l6 = $l6")

  val myPredicate = new Function1[Int, Boolean] {
    override def apply(e: Int): Boolean = e % 3 == 0
  }

  val l7 = l5.filter(myPredicate)
  println(s"l7 = $l7")

  val myTransform2 = new Function1[Int, MyList[Int]] {
    override def apply(n: Int): MyList[Int] = new Cons(n, new Cons(n + 5, Empty))
  }

  val l8 = l5.flatMap(myTransform2)
  println(s"l8 = $l8")

  //Adding case class/object qualifier to the list made it so much powerful,
  //that we can now use it over the network as well as compare two lists easily.

  val copyl5 = l5.copy()

  println(copyl5 == l5)

  val l9 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Cons(6, new Cons(7, Empty)))))))

  println(l9 == l5)

}

