object Generics extends App {
  abstract class NonEmptyList[T](val cons: T) {
    def head(): T
    def tail(): List[T]
  }

  val intList: List[Int] = List(1,2,3)
  println(intList)

  abstract class Maybe[T] {
    def fromJust(): T
    def fromMaybe(default: T): T
  }

  class Just[T] (val value: T) extends Maybe[T] {
    def fromJust(): T = value
    def fromMaybe(default: T): T = value
  }

  class Nothing[T] extends Maybe[T] {
    def fromJust(): T = throw Exception("WTF?")
    def fromMaybe(default: T): T = default
  }

  val mInt: Maybe[Int] = Just(1)
  println(mInt.fromJust())

  val mIntNothing: Maybe[Int] = Nothing()
  println(mIntNothing.fromMaybe(32))
}
