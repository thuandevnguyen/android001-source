class Person(var name: String, var age: Int, var about: String) {
  constructor() : this("", 0, "")
  
  fun moveTo(address: String) { /*...*/
  }
}

val peter: Person = Person(name = "Peter", age = 18, about = "I like turtles")

fun main() {
//  // sử dụng dot notation để truy cập vào các thuộc tính và hàm của object peter
  peter.age = 20
  peter.about = "I like to play guitar"
  peter.moveTo(address = "Boston")

// sử dụng run thay vì peter.name, peter.age, peter.about, peter.moveTo
  val result1 = peter.run {
    age = 20
    about = "I like to play guitar"
    moveTo(address = "Boston")
    1 + 2
  }
  
  val result2 = with(peter) {
    age = 20
    about = "I like to play guitar"
    moveTo(address = "Boston")
    1 + 2
  }
}
