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
      println(throwable.suppressedExceptions)
    }
  )
  
  scope.launch {
    println("START 1")
    throw RuntimeException("Broken 1!!")
  }
  
  scope.launch {
    println("START 2")
    throw RuntimeException("Broken 2!!")
  }
  
  scope.launch {
    delay(100)
    println("DONE 3")
  }
  
  scope.launch {
    delay(100)
    println("DONE 4")
  }
  
  delay(1000)
}
