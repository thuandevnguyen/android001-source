package cancelable

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flowOf(1,10,100)
        .onCompletion {
            println("onCompletion")
            if(it is CancellationException) {
                println("onCompletion CancellationException")
            }
        }
        .cancellable()
        .collect {
            println(it)
            if (it == 10) {
                cancel()
            }
        }
}
private fun foo1() = flow {
    emit(1)
    emit(10)
    emit(100)
}