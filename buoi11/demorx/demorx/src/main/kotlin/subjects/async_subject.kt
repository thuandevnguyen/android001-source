package subjects

import io.reactivex.rxjava3.subjects.AsyncSubject

fun main() {
    val subject = AsyncSubject.create<Int>()

    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)

    // Receive 7 and onComplete
    subject.subscribe { value ->
        println("✅[1] Received $value")
    }

    subject.onNext(4)
    subject.onNext(5)

    // Receive 7 and onComplete
    subject.subscribe { value ->
        println("\uD83C\uDF89 [2] Received $value")
    }

    subject.onNext(6)
    subject.onNext(7)

    println("before onComplete")
    subject.onComplete()
}