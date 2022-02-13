// Common classes
class Pizza (var toppings: Topping*) {
  // fields
  val price: Int = 10
  // methods
  def eat(): Unit = println("Come and get me!!!")
  override def toString = toppings.toString
}

// Inheritance
//                    vvvv   this is a constructor argument (NOT A field)
//                           it's not visible outside of the class definition
class HawaiiPizza (eatable: Boolean) extends Pizza

val hp = new HawaiiPizza(false)
// hp.eatable <- not possible

//                    vvvv   Use 'val' to promote a constructor argument into a field
class PeperoniPizza (val meat: String) extends Pizza

val pp = new PeperoniPizza("Pork")

// Abstract classes
abstract class Sender {
  private val message: String = "Here is your pizza!"
  def drive(): Unit
}

class BikeSender extends Sender {
  def drive(): Unit = println("Let's go bike!")
}

// Interfaces
trait Client {
  def eat(pizza: Pizza): Unit
}

class GoodClient extends BikeSender with Client {
  // override gives an implementation to the given definition
  override def eat(pizza: Pizza): Unit =
    println(s"Mmm ok, I\'ll pay the $$$pizza.price")
}

// Indix notation for methods with one argument
val aPizza = new HawaiiPizza(false)
val aClient = new GoodClient()


// Anonymous classes
// We ask the complier to craete a class for us and then instantiate it
val badClient = new Client {
  override def eat(pizza: Pizza): Unit =
    println(s"Are you crazy!? I'm not paying $pizza.price!!")
}

// Singleton objects
object Nat {
  val zero: Int = 0
  def succ(): Int = zero + 1
}

object Execute extends App {
  println(pp.meat) // possible
  aClient eat aPizza // Valid! Because in scala operators (like +) are methods
}

/*
 * case classes - ligthweight data structures with some boilterplace
 * - sensible equals and hash code
 * - serialization
 * - companion with apply
 * - pattern matching
 */

case class Person(name: String, age: Int)

val joe = Person("Joe", 12) // May be constructed without `new`
