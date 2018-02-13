abstract class animal {
  val head = 1
  val legs = ???
}

class chicken extends animal {
  override val legs = 2
}

class cow extends animal {
  override val legs = 4
}




def howMany(heads: Int, legs: Int): (Int, Int) = {

}


howMany(1, 4)