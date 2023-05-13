class Person2(val name: String) {
  var age: Int = 0
  var about: String = ""
  fun setup() {}
}

// copy: trả về 1 object mới
// apply: trae về object call apply

fun newPerson2(): Person2 {
  val person2 = Person2("John")
  
  person2.setup()
  person2.age = 20
  person2.about = "Good"
  
  return person2
}

fun newPerson2UsingApply(): Person2 = Person2("John").apply {
  setup()
  age = 20
  about = "Good"
}