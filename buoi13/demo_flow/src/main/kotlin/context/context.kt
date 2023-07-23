package context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.IO)

fun main() = runBlocking<Unit> {
//
//    foo().onEach {
//        println("onEach ${currentCoroutineContext()}")
//    }.collect { value -> println(value) }

    (0..5).asFlow()
        .map { it * 2 }
        .onEach {
            println("onEach map ${currentCoroutineContext()}")
        }
        .flowOn(Dispatchers.IO)
        .filter { it != 1 }
        .onEach {
            println("onEach filter ${currentCoroutineContext()}")
        }
        .flowOn(Dispatchers.IO)
        .flowOn(Dispatchers.Default)
        .collect {
            println(it)
        }
}
