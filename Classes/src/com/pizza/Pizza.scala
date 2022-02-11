// Common classes
class Pizza (var toppings: Topping*) {
  // fields
  val price: Int = 10
  // methods
  def eat() = printline("Come and get me!!!")
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

pp.meat // possible


// Abstract classes
abstract class Sender {
  private val message: String = "Here is your pizza!"
  def drive(): unit
}

class BikeSender extends Sender {
  def drive(): printline("Let's go bike!")
}

// Interfaces
trait Client {
  def eat(pizza: Pizza): Unit
}

class GoodClient with Client {
  // override gives an implementation to the given definition
  override def eat(pizza: Pizza): Unit =
    printline(s"Mmm ok, I'll pay the $ $pizza.price")
}

// Indix notation for methods with one argument
val aPizza = new HawaiiPizza()
val aClient = new GoodClient()
aClient eat aPizza // Valid! Because in scala operators (like +) are methods


// Anonymous classes
// We ask the complier to craete a class for us and then instantiate it
var badClient = new Client {
  override def eat(pizza: Pizza): Unit =
    printline(s"Are you crazy!? I'm not paying $pizza.price!!")
}
