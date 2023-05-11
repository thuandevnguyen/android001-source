// primary constructor
class Person constructor(
  val firstName: String,
  val lastName: String
) {
  // thứ tự thực hiện:
  // khởi tạo các property trong primary constructor
  // khởi tạo các property trước init block
  // init block
  val age = 10
  
  init {
    println("init block: $firstName $lastName $age")
  }
  
  // secondary constructor phải luôn gọi primary constructor ở phần khai báo
  // primary constructor thực thi trước -> secondary constructor body
  constructor(
    firstName: String
  ) : this(firstName, "Default lastName") {
    println("secondary constructor 1 block: $firstName $lastName $age")
  }
  
  constructor() : this("Default firstname", "Default lastName") {
    println("secondary constructor 2 block: $firstName $lastName $age")
  }
}

fun main() {
  Person()
}