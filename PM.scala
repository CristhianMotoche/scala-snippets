// PM is an expression

object PM extends App {
  // Switch statements
  val orderCode = 20
  val order = orderCode match {
    case 1 => "Pizza"
    case 2 => "Hamburger"
    case 3 => "Ice cream"
    case _ => s"There isn't a $orderCode option"
  }
  println(order)

  // Case class decomposition
  case class Person(name: String, age: Int)
  val cris = Person("Cris", 27)
  val personGreeting = cris match {
    case Person(n, a) => s"Hello! I'm $n and I'm $a years old"
    case _ => "Hi!"
  }
  println(personGreeting)

  // Deconstruct tuples
  val aTuple = ("Sonata Arctica", "Metal")
  val bandDesc = aTuple match {
    case (band, genre) => s"$band plays $genre"
    case _ => "I don't know"
  }
  println(bandDesc)

  // Decompose lists
  val aList = List(1,2,3)
  val listDesc = aList match {
    case List(_, 2, _) => "List contains a 2 in the middle"
    case _ => "Unknown"
  }
  println(listDesc)
}
