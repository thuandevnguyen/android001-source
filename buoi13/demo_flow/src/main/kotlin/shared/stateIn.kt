package shared

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

fun main() = runBlocking {
    val flow = flow {
        println("Flow started")
        emit(1)
        emit(1)
        emit(1)
        emit(1)
        emit(1)
        delay(5000)
        emit(2)
        emit(2)
        emit(2)
        emit(2)
        emit(2)
        emit(2)
    }
    val scope = CoroutineScope(Dispatchers.Default)

    // Create a shared flow from the original flow.
    val stateFlow = flow.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = 0
    )
    println("[*] Current value: ${stateFlow.value}")

    // Subscriber 1 will receive 0 (initial value), 1, 2
    scope.launch {
        stateFlow.collect { value -> println("[1] Collected $value") }
    }

    // Wait for 1 second
    delay(1000)
    println("[**] Current value: ${stateFlow.value}")

    // Subscriber 2 will receive 1, 2
    scope.launch {
        stateFlow.collect { value -> println("[2] Collected $value") }
    }

    delay(7000)
    println("[***] Current value: ${stateFlow.value}")
}
