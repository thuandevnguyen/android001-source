import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() : Unit = runBlocking {
    // Khởi tạo 1 coroutine bằng hàm async

    val deferred = GlobalScope.async {
        delay(1000)
        "Hello Async Coroutine"
    }

    val result = deferred.await()

    println("Result is $result")

    launch {
        delay(1000)
        println("Hello  coroutine ")
    }
}