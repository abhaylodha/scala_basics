package lectures.part1_basics

object Sr_02_Expressions extends App {

  //********************************************************
  //Expressions
  //********************************************************
  val x = 1 + 2 //Expression
  print(x)

  //********************************************************
  // BODMAS Rule
  //********************************************************

  print(2 + 4 * 3)

  //********************************************************
  // Assignment = += -= *= /= %= >>= <<= &= ^= |=
  // Arithmetic operators + - / * % & | ^ << >>
  // >>> (Right shift with zero extension)
  //********************************************************
  var a = 50
  a += 5 //55

  //********************************************************
  // Boolean operators : == != > >= < <=
  //********************************************************

  //********************************************************
  // Logical Operators
  // ! Unary negation
  // & Binary and
  // | Binary or
  // && Short Circuit Binary and
  // || Short Circuit Binary or
  //********************************************************

  def t1 = {
    println("t1 called")
    true
  }

  def t2 = {
    println("t2 called")
    true
  }

  println("First evaluation")
  println(t1 || t2)
  println("Second evaluation")
  println(t1 | t2)

  //********************************************************
  // Instructions Vs Expressions
  //********************************************************
  // Instructions are executed. i.e. Do something like in imperative languages.
  // Expressions are evaluated and returns a value.

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println("aConditionedValue: " + aConditionedValue)

  //********************************************************
  //Loops
  //********************************************************

  //Never write such loop again in scala. It's imperative one.
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //********************************************************
  //Everything is expression in Scala
  //********************************************************
  val aWeirdValue = (i = 10) // A Unit value. Same as void

  println(aWeirdValue)

  //********************************************************
  //Codeblocks
  //********************************************************

  val aCodeBlock = {
    val x = 2
    val y = 20
    if (x > y) x else y
  }

  println(aCodeBlock)

  //********************************************************
  // Exercises
  //********************************************************

  // What is difference between "A String" and println("A String")
  // println has side effect as it prints something to console.
  // Means updated something outside it's scope.

  // What's value of below

  val aVal = {
    2 > 3
  }

  val anotherVal = {
    if (aVal) 239 else 729
  }


}
