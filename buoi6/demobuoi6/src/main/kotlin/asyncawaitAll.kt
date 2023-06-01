import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = async {
        delay(1000)
        "Result From Job1"
    }

    val job2 = async {
        delay(1000)
        "Result From job2"
    }
    val job3 = async {
        delay(1000)
        "Result From job3"
    }
    val resultAll = awaitAll(job1, job2, job3)
    println("Result All $resultAll")
}
