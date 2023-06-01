import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val scope = CoroutineScope(
    Dispatchers.IO +
        SupervisorJob()
        + CoroutineExceptionHandler { coroutineContext, throwable ->
      println("In $coroutineContext")
      println("Catch $throwable")
    }
  )
  
  scope.launch {
    println("START 1")
    throw RuntimeException("Broken!!")
  }
  
  scope.launch {
    delay(100)
    println("DONE 2")
  }
  
  scope.launch {
    delay(100)
    println("DONE 3")
  }
  
  delay(1000)
}
