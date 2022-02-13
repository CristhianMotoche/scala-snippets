object Excecptions extends App {
  try {
    val foo: String = null
    foo.length
  } catch {
    // Uses pattern matching (maybe due to case classes) to check the exception
    case (e: Exception) => println("You did something silly. Check it out!")
  } finally {
    println("I'll run no matter what")
  }
}
