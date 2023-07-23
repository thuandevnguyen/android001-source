package exception

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.Exception


fun createFlowException() = flow {
    for (i in 3 downTo -3) {
        emit(i)
    }
}

fun main() = runBlocking {
    flowOf(1,2,3,4)
        .onEach { value ->
            println("Emitting $value")
        }
        .catch {
            println("Catch $it")
        }
        .launchIn(this)

    println("Done")
}