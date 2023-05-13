import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ExampleDelegatedProperty {
  var p: String by Delegate()
  var p1: String by Delegate()
  var p2: String by Delegate()
  var p4: String by Delegate()
  val lazyValue by lazy {
    "123"
  }
}

class Delegate: ReadWriteProperty<ExampleDelegatedProperty, String> {
  private var internalValue = ""

  override fun getValue(thisRef: ExampleDelegatedProperty, property: KProperty<*>): String {
    // get from shared preferences
    println("getValue thisRef=$thisRef, property=$property")
    return internalValue
  }

  override fun setValue(thisRef: ExampleDelegatedProperty, property: KProperty<*>, value: String) {
    println("setValue thisRef=$thisRef, property=$property -> value=$value")
    internalValue = value
    // save to shared preferences
  }
  
//  fun setValue(v: String) {
//    TODO()
//  }
//  fun getValue(): String = TODO()
  
}

fun main() {
  val example = ExampleDelegatedProperty()
  println("Set p")
  example.p = "123"
  println(example.p)
}