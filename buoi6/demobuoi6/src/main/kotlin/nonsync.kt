fun main() {
    val nonSync = NonSync()
    nonSync.count()
}

class NonSync() {
    private var counter: Int = 0

    fun count() {
        val thread1 = Thread {
            repeat(10000) {
                counter++
            }
        }

        val thread2 = Thread {
            repeat(10000) {
                counter++
            }
        }

        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()
        println("Count NonSync Counter => $counter")
    }
}