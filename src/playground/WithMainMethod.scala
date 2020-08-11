package playground

object WithMainMethod {

  // As Scala classes cannot have static members, we need to
  // define main method in object just exactly as mentioned
  // below.
  def main(args: Array[String]) = {
    println("Hello Test")
  }
}
