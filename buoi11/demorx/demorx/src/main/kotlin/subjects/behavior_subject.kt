package subjects

import io.reactivex.rxjava3.subjects.BehaviorSubject

fun main() {
    val subject = BehaviorSubject.createDefault(0)

    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    println("Current value: ${subject.value}")

    // Observer [1] will receive 3 at the time of subscription
    subject.subscribe { value ->
        println("✅[1] Received $value")
    }

    // 4, 5 will be received by the Observer [1]
    subject.onNext(4)
    subject.onNext(5)
    println("Current value: ${subject.value}")

    // Observer [2] will receive 5 at the time of subscription
    subject.subscribe { value ->
        println("\uD83D\uDE4F [2] Received $value")
    }

    // 6, 7 will be received by the Observer [1] and [2]
    subject.onNext(6)
    subject.onNext(7)
    println("Current value: ${subject.value}")
}