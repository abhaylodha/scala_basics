package excercises

object Sr_03_MyListWithPredicates extends App {

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

  trait MyPredicate[-T] {
    def test(e: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform[B](e: A): B
  }

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
    def map[B](transformer: MyTransformer[A, B]): MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    def ++[B >: A](list: MyList[B]): MyList[B]
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
    def test(predicate: Nothing => Boolean) = true
    def filter(test: Nothing => Boolean): MyList[Nothing] = Empty
    def map[B](transform: Nothing => B): Nothing = throw new NoSuchElementException
    def flatMap[B](flattenFunc: Nothing => MyList[B]): Nothing = throw new NoSuchElementException
    override def elementToString: String = s""
    def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  }

  class Cons[+A](e: A, tailElem: MyList[A]) extends MyList[A] {
    def head: A = e

    def tail: MyList[A] = this.tailElem

    def isEmpty: Boolean = false

    def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)

    def test(predicate: A => Boolean) = predicate(e)
    def filter(predicate: MyPredicate[A]): MyList[A] = {
      if (predicate.test(head))
        new Cons(head, tailElem.filter(predicate))
      else
        tailElem.filter(predicate)
    }

    def map[B](transformer: MyTransformer[A, B]): MyList[B] =
      new Cons(transformer.transform(e), tailElem.map(transformer))

    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(head, tailElem ++ list)

    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
      transformer.transform(head) //++ tail.flatMap(transformer)

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

  val l5 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(s"$l5")
  println(s"${l5.add(5)}")
  println(s"${l5.tail}")
  println(s"${l5.tail.head}")

}

