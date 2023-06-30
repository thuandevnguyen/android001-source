package subjects

import io.reactivex.rxjava3.subjects.PublishSubject

fun main() {
    val subject = PublishSubject.create<Int>()

    // 1, 2, 3 will be ignored
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)

    val d1 = subject.subscribe { value ->
        println("\uD83E\uDD76 [1] Received $value")
    }

    // 4, 5 will be received by the Observer [1]
    subject.onNext(4)
    subject.onNext(5)

    val d2 = subject.subscribe { value ->
        println("\uD83E\uDD70 [2] Received $value")
    }

    // 6, 7 will be received by the Observer [1] and [2]
    subject.onNext(6)
    subject.onNext(7)

    // dispose the first Observer
    d1.dispose()

    // 8, 9 will be received by the Observer [2]
    subject.onNext(8)
    subject.onNext(9)

    // dispose the second Observer
    d2.dispose()

    // 10 will not be received by any Observer (ignored)
    subject.onNext(10)
}