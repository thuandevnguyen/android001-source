import kotlin.random.Random

fun randomNullableInt(): Int? {
  val i = Random.nextInt(10)
  return if (i < 5) i else null
}

fun randomNullableIntUsingLet(): Int? = Random
  .nextInt(10)
  .let { if (it < 5) it else null }

fun main() {
  val numbers = listOf("one", "two", "three", "four", "five")
  numbers
    .map { it.length } // List<Int>: [3, 3, 5, 4, 4]
    .filter { it > 3 } // List<Int>: [5, 4, 4]
    .let(::println)
  
  randomNullableIntUsingLet()
    ?.let { println("Value is $it") }
  
  val value = randomNullableIntUsingLet()
  if (value != null) {
    println("Value is $value")
  }
  
  // tham so cua lambda la val
  val unit = Example().let {
    println(it)
    doSomethingWithExample(it)
    it.i = -1
    Example()
  }
}

fun doSomethingWithExample(it: Example) {
  TODO("Not yet implemented")
}

class Example {
  var i = 0
}