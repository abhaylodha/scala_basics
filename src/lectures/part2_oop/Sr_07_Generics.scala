package lectures.part2_oop

object Sr_07_Generics extends App {

  //Declare generic types as below
  class MyList[A]

  //Use generic types as below
  val a = new MyList[Int]

  //Can have as many type parameters as you want.
  class MyMap[KeyType, ValueType]

  val b = new MyMap[String, Int]

  //Also works with traits.
  trait MyTrait[A]

  //Note - Objects cannot be type parameterised

  //Generic Method
  object MyList { //Companion object for MyList[A]
    def empty[T]: MyList[T] = new MyList[T]

  }

  val emptyListOfIntegers = MyList.empty[Int]

  //Variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // Question
  // If Cat extends Animal, does List[Cat] extends List[Animal] ?
  // 3 Answers :
  // 1. Yes - List[Cat] extends List[Animal].
  // CoVariant List
  class CoVariantList[+A]

  val animal: Animal = new Animal
  val animalList: CoVariantList[Animal] = new CoVariantList[Cat]
  // Will this be ok ?
  // animalList.add(new Dog)
  // A-In theory, it will be ok, but it will pollute the
  // list of Cats after adding dogs. It's a hard question.

  // 2. No - List[Cat] and List[Animals] are separate things.
  // InVariant List
  class InVariantList[A]

  val animalList_2: InVariantList[Animal] = new InVariantList[Cat]


}
