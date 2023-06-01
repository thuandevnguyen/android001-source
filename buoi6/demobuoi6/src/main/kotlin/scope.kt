import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val scope = CoroutineScope(context = Dispatchers.IO + Job())
  
  scope.launch {
    launch {
      launch {
        launch {
        
        }
      }
    }
  }
  
  (0 until 100).forEach { index ->
    scope.launch {
      println("Coroutine $index starting...")
      
      try {
        delay(500)
        println("Coroutine $index done delay")
      } catch (e: CancellationException) {
        println("Coroutine $index cancelled")
        throw e
      }
    }
  }
  
  delay(100)
  println("Cancelling....")
  scope.cancel()
  delay(100)
  println("DONE")
}