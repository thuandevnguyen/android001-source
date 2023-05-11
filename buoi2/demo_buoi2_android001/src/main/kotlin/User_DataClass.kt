data class User(
  val age: Int,
  val name: String
)

fun main() {
  val u1 = User(age = 10, name = "Name")
  // sử dụng component1 và component2 ở bên dưới
  val (xxx, name) = u1
  
  println(xxx)
  println(name)
}