import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun foo1(): Flow<Int> = flow {
    emit(10)
    emit(100)
}

fun main() = runBlocking {
    // Launch a concurrent coroutine to check if the main thread is blocked
//    launch {
//        println(Thread.currentThread().name)
//        for (k in 1..3) {
//            delay(900)
//            println("I'm not blocked $k")
//        }
//    }
//    val test = foo1().collect {
//        println(it)
//    }
//
//    // Collect the flow
//    val time = measureTimeMillis {
//        foo1().collect { value -> println(value) }
//    }
    println("Hello s")
}