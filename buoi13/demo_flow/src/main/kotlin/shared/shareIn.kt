package shared

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

fun main() = runBlocking {
    val flow = flow {
        println("Flow started")
        emit(1)
        delay(5000)
        emit(2)
    }
    val scope = CoroutineScope(Dispatchers.Default)

    // Create a shared flow from the original flow.
    val sharedFlow = flow.shareIn(
        scope = scope,
        started = SharingStarted.Lazily,
        replay = 1
    )

    // Subscriber 1 will receive 1 and 2
    scope.launch {
        sharedFlow.collect { value -> println("[1] Collected $value") }
    }

    // Wait for 1 second
    delay(1000)

    // Subscriber 2 will receive 1 (replay) and 2
    scope.launch {
        sharedFlow.collect { value -> println("[2] Collected $value") }
    }

    delay(6000)
    scope.cancel()
}
