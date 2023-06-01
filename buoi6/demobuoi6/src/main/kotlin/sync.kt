import kotlin.random.Random

fun main() {
    val syncs = SyncSingle()
    syncs.start()
}

class SyncSingle() {
    private var list1 = mutableListOf<Int>()
    private var list2 = mutableListOf<Int>()

    private val lock1 = Any()
    private val lock2 = Any()

    private fun addToFirstList() {
        synchronized(lock1) {
            Thread.sleep(1)
            list1.add(Random.nextInt(100))
        }

    }

    private fun addToSecondList() {
        synchronized(lock2) {
            Thread.sleep(1)
            list2.add(Random.nextInt(100))
        }
    }

    private fun process() {
        for (i in 0..999) {
            addToFirstList()
            addToSecondList()
        }
    }

    fun start() {
        val thread1 = Thread {
            process()
        }

        val thread2 = Thread {
            process()
        }

        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()
        println("Count Sync Size List1 = ${list1.size} ==> SizeList2 = ${list2.size}")
    }
}