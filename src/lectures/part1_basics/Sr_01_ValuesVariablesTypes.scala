package lectures.part1_basics

object Sr_01_ValuesVariablesTypes extends App {

  //********************************************************
  //VALS ARE IMMUTABLE
  //********************************************************
  val x: Int = 42
  println(x)


  val str =


    "5968956"


  val s = ""

  //Won't compile.
  //x = 3

  //********************************************************
  //TYPE INFERENCE
  //********************************************************
  val y = 43
  println(y)

  //********************************************************
  //Semicolons are optional
  //********************************************************
  val aString = "Some String"
  val aBoolean: Boolean = true

  //val aString = "Some String";val aBoolean: Boolean = true

  //********************************************************
  //Data Types and sizes
  //********************************************************

  //1 Byte
  val aChar: Char = 'a'
  val aByte: Byte = 127
  //8 bit signed value. Range from -128 to 127

  //2 Byte
  val aShort: Short = 4959
  //16 bit signed value. Range -32768 to 32767

  //4 Byte
  val aInt: Int = x
  //32 bit signed value. Range -2147483648 to 2147483647

  //4 Byte
  val aFloat: Float = 2.5f
  //32 bit IEEE 754 single-precision float

  //8 Byte
  val aLong: Long = 564564756756756L
  //64 bit signed value. -9223372036854775808 to 9223372036854775807

  //8 Byte
  val aDouble: Double = 3.4
  //64 bit IEEE 754 double-precision float

  //********************************************************
  //Variables
  //********************************************************
  var aVariable: Int = 4
  aVariable = 5


}
