import kotlin.concurrent.thread

fun main() {
    println("Main: Start")

    val thread = thread {
        // Các hoạt động của thread
        for (i in 1..5) {
            println("Thread: $i")
            Thread.sleep(1000) // Tạm dừng thread trong 1 giây
        }
    }

    // Tiếp tục thực thi các công việc khác trong khi thread đang chạy
    for (i in 1..15) {
        println("Main: $i")
        Thread.sleep(100) // Tạm dừng main thread trong 1 giây
    }

    thread.join()

    println("Main: End")
}