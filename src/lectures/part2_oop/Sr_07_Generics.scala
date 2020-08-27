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

  //Below will not work as it is invariant list.
  //val animalList_2: InVariantList[Animal] = new InVariantList[Cat]

  //3. Hell no. Contra variance.
  class ContraVarianceList[-A]

  val contravariantList: ContraVarianceList[Cat] = new ContraVarianceList[Animal]
  //Where is this used ?
  //Very special cases
  //For ex -
  class Trainer[-A]
  val catTrainer: Trainer[Cat] = new Trainer[Animal]

  //Bounded Types
  //Allows generic classes to be used only for specific set of classes.

  //Below only accepts type parameters which are sub-types of Animal
  class Cage[A <: Dog](val animal: A)
  val cage = new Cage(new Dog)

  //When to use Bounded Types ?
  //When we want to do operation like - Adding a Dog to List of Cats, should yield a List on Animals.
  //For Ex.
  class MyList_V2[+A] {
    //With below, we get error like - covariant type A occurs in contravariant position in type A of value a
    //def add(a : A) = ???

    //Solution
    def add[B >: A](a: B): MyList_V2[B] = ???
  }

}

