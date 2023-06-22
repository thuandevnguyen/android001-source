public interface Shape {
  fun draw()
}

public fun Shape(type: String): Shape {
  return when(type) {
    "CIRCLE" -> Circle()
    "SQUARE" -> Square()
    "RECTANGLE" -> Rectangle()
    else -> error("Unsupported type: $type")
  }
}

object ShapeFactory {
  fun getShape(type: String): Shape {
    return when(type) {
      "CIRCLE" -> Circle()
      "SQUARE" -> Square()
      "RECTANGLE" -> Rectangle()
      else -> error("Unsupported type: $type")
    }
  }
}

private class Circle: Shape {
  override fun draw() {
    println("$this draw...")
  }
}

private class Square: Shape {
  override fun draw() {
    println("$this draw...")
  }
}

private class Rectangle: Shape {
  override fun draw() {
    println("$this draw...")
  }
}