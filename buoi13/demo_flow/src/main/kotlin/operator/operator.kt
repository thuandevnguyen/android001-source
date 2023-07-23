package operator

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() {
    runBlocking {
//       flowOf(1,2,3,4,5)
//           .transform {
//               emit( it * 2)
//               emit( it * 3)
//           }.collect {
//               println(it)
//           }
//        flowOf(1, 1, 2, 2, 3, 3, 4, 5)
//            .distinctUntilChanged()
//            .collect {
//                println("Collect from onEach $it")
//            }

//        val numbers1 = (1..3).asFlow().onEach {
//            delay(300)
//        }
//
//        //2 -> 600
//
//
//        val string2 = flowOf("one", "two", "three").onEach {
//            delay(400)
//        }
//        val startTime = System.currentTimeMillis()
//
//        numbers1.combine(string2) { a, b -> "$a -> $b" }
//            .collect {
//                println("Value $it at ${System.currentTimeMillis() - startTime} ms from start")
//            }

//        val trigger1 = flow<Int> {
//            repeat(15) {
//                emit(it + 1)
//            }
//        }
//
//        trigger1.collect {
//            println("trigger1 $it")
//        }
//        val string2 = flowOf("one", "two", "three").onEach {
//            delay(2000)
//        }
//        string2.collect {
//            println("string2 ==> $it")
//        }
//
//        trigger1.combine(string2) { a, b -> "$a -> $b" }
//            .collect {
//                println("Value $it ")
//            }

//        val startTime = System.currentTimeMillis()
//        (1..3)
//            .asFlow()
//            .onEach { delay(100) }
//            .flatMapLatest { receiveFlow(it) }
//            .collect {
//                println("Value $it at ${System.currentTimeMillis() - startTime} ms from start")
//            }
        val list : List<String> = listOf("a","b","c").asFlow().toList()
    }
}

fun receiveFlow(value: Int): Flow<String> = flow {
    emit("Fist value $value")
    delay(500)
    emit("Second value $value")
}