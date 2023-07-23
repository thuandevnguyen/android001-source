package channels

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val channel = Channel<Int>(
        capacity = 2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    launch {
        repeat(10) {
            println("--> Sending $it")
            channel.send(it)
            delay(10)
            println("<-- Sent $it $channel")
        }
        channel.close()
    }

    launch {
        for (element in channel) {
            println("[###] Received $element from $channel")
            delay(33)
        }
    }
}
