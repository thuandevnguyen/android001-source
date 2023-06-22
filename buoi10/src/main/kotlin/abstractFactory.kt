// AbstractObject
interface Shape2 {
  fun draw()
}


// ConcreteObject
class Circle2 : Shape2 {
  override fun draw() {
    println("$this draw...")
  }
  
  companion object Factory : Shape2Factory {
    override fun buildShape2(): Shape2 = Circle2()
  }
}

class Square2 : Shape2 {
  override fun draw() {
    println("$this draw...")
  }
  
  companion object Factory : Shape2Factory {
    override fun buildShape2(): Shape2 = Square2()
  }
}

class Rectangle2 : Shape2 {
  override fun draw() {
    println("$this draw...")
  }
  
  
  companion object Factory : Shape2Factory {
    override fun buildShape2(): Shape2 = Rectangle2()
  }
}

// AbstractFactory
interface Shape2Factory {
  fun buildShape2(): Shape2
}