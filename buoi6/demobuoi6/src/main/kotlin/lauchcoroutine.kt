import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() : Unit = runBlocking {
    val job = GlobalScope.launch {
        delay(100)
        println("Hello")
    }

    println("Coroutine Running")
    job.join()
    println("Coroutine End")
}