object FP extends App {
  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I'm $age years old")
  }

  val pp = new Person("Peter Parker")
  pp.apply(23)
  pp(23) // INVOES pp.apply

  // Scala in FP
  // - compose funs
  // - pass funs as args
  // - return fns as results
  //
  // FunctionX
  // - All scala funs are instances of FunctionX
  // - From Function1 .. Function22
  //                  arg --vvv  vvv-- return type
  val myFun = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  myFun.apply(23)
  println(myFun(23)) // same as myFun.apply

  //                 arg1 --vvv arg2 --vvv     vvv-- return type
  val strCat = new Function2[String, String, String] {
    override def apply(str1: String, str2: String): String = s"$str1 + $str2"
  }

  println(strCat("Foo", "Bar"))


  // Syntax suggars
  var double: Int => Int = (x: Int) => 2 * x
  double(4)

  /*
   * Int => Int === Function1[Int, Int] -- Not needed since the complier an infer the type
   * (x: Int) => 2 * x
   *    === new Function1[Int, Int] { override def apply(x: Int) = 2 * x }
   *
   *
   */

  // HOF
  val mapList =  List(1,2,3).map(double)
  println(mapList)
  val flatList =  List(1,2,3).flatMap { x => List(x, 2* x) } // Parenthesis can be changed with curly brackets
  println(flatList)
  val filteredList =  List(1,2,3).filter { _ > 2 } // { _ > 2 } === { x => x > 2 }
  println(filteredList)

  val pairs = List(1,2,3).flatMap(n => List('a', 'b', 'c').map(l => s"$n-$l"))
  println(pairs)
  val pairs2 = for {
    n <- List(1,2,3)
    l <- List('a', 'b', 'c')
  } yield s"$n-$l"
  println(pairs2)
}
