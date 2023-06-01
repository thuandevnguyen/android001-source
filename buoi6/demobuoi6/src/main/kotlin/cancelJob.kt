import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job = launch {
        try {
            repeat(1000) { index ->
                println("Repeat from $index")
                delay(500)
            }
        } finally {
           withContext(NonCancellable) {
               println("Finally Cancel")
               delay(100L)
               println("=== End Finally Cancel ===")
           }
        }
    }
    delay(1400)
    println("Waiting before cancel")
    println("Job status After ${job.isActive}")
    job.cancel()
    println("Job status Before ${job.isActive}")
    println("Cancel Job ===>")
}