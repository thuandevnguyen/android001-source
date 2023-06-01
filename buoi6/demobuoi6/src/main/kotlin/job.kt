import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
  val scope = CoroutineScope(Dispatchers.IO + Job())
  println("Job of scope is ${scope.coroutineContext.job}")
  
  val job: Job = scope.launch {
    delay(200)
    println("DONE...")
  }
  
  println("${job.isCompleted} -- ${job.isActive} -- ${job.isCancelled}")
  delay(100)
  println("${job.isCompleted} -- ${job.isActive} -- ${job.isCancelled}")
  job.cancelAndJoin()
  println("${job.isCompleted} -- ${job.isActive} -- ${job.isCancelled}")
}