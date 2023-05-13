interface Base {
  fun print()
}

class BaseImpl1(private val x: Int) : Base {
  override fun print() = println(x)
}

class BaseImpl2: Base {
  override fun print() {
    println("1233")
  }
}

class Derived(b: Base) : Base by b

fun main() {
  val b = BaseImpl2()
  Derived(b).print() // prints 10
}
