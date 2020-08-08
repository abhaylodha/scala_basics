package lectures.part1_basics

object Sr_No_07_StringOperations extends App {

  val str: String = "Hi, I'm learning scala."

  //********************************************************
  // Indexing starts at zero.
  //********************************************************
  println(str.charAt(2))
  println(str.substring(0, 3))
  println(str.split(" ").toList)
  println(str.startsWith("Hi"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aString: String = "2"
  val aNumber: Int = aString.toInt

  println(aNumber)
  println('a' +: aString :+ 'z')
  println(str.reverse)
  println(str.take(2))


  //********************************************************
  // Scala specific String interpolation
  //********************************************************

  //S-Interpolators

  val name = "ABC"
  val age = 22
  val msg = s"Hi, my name is ${name}. I am $age years old."
  val msg2 = s"Hi, my name is ${name}. I will be turning ${age + 1} next year."

  println(msg)
  println(msg2)

  //F-Interpolators
  val speed = 1.2f
  val myth = f"$name can eat at the speed of : $speed%2.3f per minute"
  println(myth)

  //Raw-Interpolators
  println(raw"Here new line character \n will not cause to print a new line.")

}
