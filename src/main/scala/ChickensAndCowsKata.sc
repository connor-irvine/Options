//abstract class animal {
//  val head = 1
//  val legs = ???
//}
//
//class chicken extends animal {
//  override val legs = 2
//}
//
//class cow extends animal {
//  override val legs = 4
//}
//
//
//
//
//def howMany(heads: Int, legs: Int): (Int, Int) = {
//
//}


def howMany(heads: Int, legs: Int) = {

val chicken = ((4 * heads) - legs) / 2
val cow = (legs -(2 * heads)) / 2

if (legs % 2 == 0) {
  if ((chicken >= 0) && (cow >= 0)) {
    (chicken, cow)
  } else {
    "No solution"
  }
}else {
  "No solution"
}
}

println(howMany(3, 10))