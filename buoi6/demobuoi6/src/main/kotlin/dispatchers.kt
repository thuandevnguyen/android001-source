import java.util.concurrent.Executors
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyDispatcher : CoroutineDispatcher() {
  private val threadPool = Executors.newFixedThreadPool(10)
  
  override fun dispatch(context: CoroutineContext, block: Runnable) {
    println(
      """Dispatching...
      |       block = $block
      |       context = $context
    """.trimMargin()
    )
    threadPool.execute(block)
  }
  
  override fun toString(): String = "MyDispatcher(threadPool=$threadPool)"
}

suspend fun printCurrentDispatcher() {
  val d = currentCoroutineContext()[ContinuationInterceptor.Key]
  println("Current dispatcher is $d")
}

fun main(): Unit = runBlocking {
  val scope = CoroutineScope(MyDispatcher() + Job())
  
  scope.launch {
    printCurrentDispatcher()
    println("[1] -- ")
    delay(100)
    
    printCurrentDispatcher()
    println("[2] -- ")
    delay(100)
    
    printCurrentDispatcher()
    println("[3] -- ")
  }
  
  delay(500)
}