object Basics extends App {
  val fizz: Int = 3 // val makes things 'immutable'
  // fizz = 5 // is invalid

  // Standard types
  val isTrue = true
  val e = 2.73
  val name = "Cristhian"
  var lastname = "Motoche"

  // String
  var fullname = s"$name $lastname"
  println(fullname)

  // Expressions
  // structures that are reduced into values
  val five = 2 + 3

  // In scala every expression is reduced into a value
  // if-expression
  val ifExp =
    if (e > 1) e
    else e * 2
  println(ifExp) // Returns 'e'

  // ^^ We're not assigning values to variables but
  // tying values to definitions

  // Code Blocks
  val doingStuff = {
    // I can do many things inside a code block
    // Define values
    val localVal = 123

    // The value of a code block is the last evaluated expression
    localVal + 321
  }
  println(doingStuff) // Returns 444


  // Functions
  def lol(x: Int, y: String, z: Boolean): String =
    if (z) s"$x Number"
    else s"$y String"
  println(lol(123, "Hello", true))
  println(lol(123, "Hello", false))

  // Recursive funs
  def fact(n: Int): Int =
    if (n <= 1 ) 1
    else fact(n - 1) * n
  println(fact(5))

  // In scala we don't use loops or iteration. We use RECURSION!

  // The Unit type
  // Like 'void' in other languages
  // println is part of the SIDE EFFECTS functions that return a unit
  println(println("vvv This is the Unit of println"))
  // Defining a unit
  val myUnit = ()
  println(myUnit)
  println("^^^ this is a unit")
}
