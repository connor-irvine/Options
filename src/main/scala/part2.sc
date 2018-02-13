//case class User(name : String, gender: Option[String])
//case class Employee(id: Int, override val name : String, override val gender : Option[String] = None) extends User(name, gender)
//
//object UserRepository {
//
//  private val _people = List(
//    User("Adam", Some("Male")),
//    User("Toni", None),
//    Employee(123, "Janis")
//  )
//
//  def findByName(name: String): Option[User] = {
//    _people.find(u => u.name == name)
//  }
//
//
//  def findEmployee(): List[Employee] = {
//    _people.flatMap() {
//      case User(_, _) =>
//        None
//      case e@Employee(_, _, _) =>
//        Some(e)
//    }
//  }
//}

abstract class User(val name: String,
                    val gender: Option[String] = None
                   )

case class Person(override val name : String,
                  override val gender: Option[String] = None
                 ) extends User(name, gender)

case class Employee(id : Int,
                    override val name : String) extends User(
  name,
  None)

object UserRepository {
  //  private val _people = User("Adam", Some("Male")) :: User("Adam", Some("Male")) :: Nil
  private val _people = List(
    Person("Adam", Some("Male")),
    Person("Toni", None),
    Employee(123, "Janis")
  )

  def findByName(name : String) : Option[User] = {
    _people.find(u => u.name == name)
  }

  // List(None, None, Some(Employee(Adam...))
  // flatMap List(Employee("Adam"...))

  def findEmployees() : List[Employee] = {
    _people.flatMap {
      case Person(_, _) =>
        None
      case e @ Employee(_, _) =>
        Some(e)
    }
  }
}

UserRepository.findEmployees()

val filtered = UserRepository.findByName("Adam")
  .flatMap(
    _.gender.map(
      _ == "Male"
    )
  )

val things = List(List(1, 2, 3), List(1, 2, 3))
val x = things.flatMap(( num => num))

val userString = for {
  user <- UserRepository.findByName("Adam")
} yield s"${user.name}"

userString