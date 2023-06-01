import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MyContext(val name: String) : AbstractCoroutineContextElement(Key) {
  companion object Key : CoroutineContext.Key<MyContext>
  
  override fun toString(): String = "MyContext(name='$name')"
}

suspend fun printMyContext() {
  val myContext1 = currentCoroutineContext()[MyContext]
  println("MyContext is $myContext1")
}

fun main(): Unit = runBlocking {
  printMyContext()
  
  withContext(MyContext(name = "Context 1")){
    delay(100)
    printMyContext()
    
    withContext(MyContext(name = "Context 2")) {
      delay(100)
      printMyContext()
      
      withContext(MyContext(name = "Context 3") + MyContext(name = "Context 4")) {
        delay(100)
        printMyContext()
      }
    }
  }
}