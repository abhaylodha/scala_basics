package playground

//Main method (Entry Point) is defined in App trait.
object ScalaPlayground extends App{

  println("Hello, Scala!")

  val a2 = new A2(5)
  println(a2.v)


}

class A2(val v : Int) extends AnyVal{

}

