package subjects

import io.reactivex.rxjava3.subjects.ReplaySubject

fun main() {
    // unbounded buffer
    val subject = ReplaySubject.create<Int>()

    // 1, 2, 3 will be received by all Observers
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)

    // Observer [1] will receive 1, 2, 3 at the time of subscription
    subject.subscribe { value ->
        println("\uD83D\uDC40 [1] Received $value")
    }

    // 4, 5 will be received by the Observer [1]
    subject.onNext(4)
    subject.onNext(5)

    // Observer [2] will receive 1, 2, 3, 4, 5 at the time of subscription
    subject.subscribe { value ->
        println("\uD83D\uDE07 [2] Received $value")
    }

    // 6, 7 will be received by the Observer [1] and [2]
    subject.onNext(6)
    subject.onNext(7)
}