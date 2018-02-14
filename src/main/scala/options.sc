def markAnswer(a : String) : Option[Boolean] = {

  if (a.nonEmpty){
    Some(a.contains("dog"))
  }else{
    None
  }
}
//had to use Q's 1-3 to run code
val scoreForQ1 : Option[Boolean] = markAnswer("dog")
val scoreForQ2: Option[Boolean] = markAnswer("cat")
val scoreForQ3 : Option[Boolean] = markAnswer("")

if (scoreForQ1.isDefined){
  val score = scoreForQ1.getOrElse(false)
  println(score)
}

scoreForQ1.map(b => println(b))

scoreForQ1.fold(false)(b => {
  println(b)
  b
}
)

scoreForQ1 match {
  case None => ???
  case Some(x) => x
}

//////////////////////////////////////////////////////////////////////////////


def find(list : List[Int], fn : Int => Boolean) : Option[Int] = {

  list match {
    case head :: _ if fn(head) => Some(head)
    case Nil => None
    case _ :: tail => find(tail, fn)

  }


  find(List(1, 2, 3), _ == 1)
  find(List(1, 2, 3), _ == 4)
  find(Nil, _ == 2)

////////////////////////////////////////////////////////////////
def find[A](list : List[A], fn : A => Boolean) : Option[A] = {

  list match {
    case head :: _ if fn(head) => Some(head)
    case Nil => None
    case _ :: tail => find(tail, fn)
  }


  find[Int](List(1, 2, 3), _ == 4)
  find[Int](List(1, 2, 3), _ == 3)

  find[String](List("Adam", "Chris"), _ == "Chris")

  find[(Int, String)](List((1, "Adam"), (2, "Chris")), _._2 == "Chris")

  find[Any](List(1, 2, "Chris"), _ == 2)
}
/////////////////////////////////////////////////////////////////

  def intMap(list: List[Int], f: Int => Int): List[Int] = {
    list match {
      case Nil => list
      case head :: tail => f(head) :: intMap(tail, f)
    }
  }
    /////////////////////////////////////////////////////////
