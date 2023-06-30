import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
//    demo1()
//    demo2()
//    flatmapDemo()
    demoMerge()
    Thread.sleep(10000L)
}

private fun demoMerge() {
    val source1 = Observable.just("A", "B").concatMap { number ->
        val randomTime = Random().nextInt(10).toLong()
        return@concatMap Observable.just(number)
            .delay(randomTime, TimeUnit.MILLISECONDS)
    }
    val source2 = Observable.range(1, 6).concatMap { number ->
        val randomTime = Random().nextInt(10).toLong()
        return@concatMap Observable.just(number)
            .delay(randomTime, TimeUnit.MILLISECONDS)
    }

    source1.subscribe {
        println("Source 1 = $it")
    }

    source2.subscribe {
        println("Source 2 = $it")
    }
    Observable.merge(source1, source2).toList().subscribe(
        { i -> println("RECEIVED: $i") },
        { e -> println("RECEIVED ERROR: $e") },
    )

}

private fun demoZip() {
    val source1 = Observable.just("A", "B").concatMap { number ->
        return@concatMap Observable.just(number)
            .delay(2000L, TimeUnit.MILLISECONDS)
    }
    val source2 = Observable.range(1, 6).concatMap { number ->
        return@concatMap Observable.just(number)
            .delay(4000L, TimeUnit.MILLISECONDS)
    }

    source1.subscribe {
        println("Source 1 = $it")
    }

    source2.subscribe {
        println("Source 2 = $it")
    }
    Observable.zip(source1, source2) { value1, value2 ->
        return@zip "$value1 - $value2"
    }.subscribe(
        { i -> println("RECEIVED: $i") },
        { e -> println("RECEIVED ERROR: $e") },
        { println("Done!") }
    )

}

fun flatmapDemo() {
    val observable = Observable.just(1, 2, 3, 4, 5, 6)
    observable.switchMap { number ->
        val randomTime = Random().nextInt(10).toLong()
        Observable.just(number)
            .delay(randomTime, TimeUnit.MILLISECONDS)

    }.subscribe(
        { i -> println("RECEIVED: $i") },
        { e -> println("RECEIVED ERROR: $e") },
        { println("Done!") }
    )
}

private fun demo2() {
    val d = Observable.just(1, 1, 1, 2, 2, 2, 0, 4, 10)
        .distinctUntilChanged()
        .subscribe(
            { i -> println("RECEIVED: $i") },
            { e -> println("RECEIVED ERROR: $e") },
            { println("Done!") }
        )
}

private fun demo1() {
    val source = Observable.just("Alpha", "Beta", "Gamma")
    val observer = object : Observer<String> {
        override fun onSubscribe(d: Disposable) {
            println("onSubscribe")
        }

        override fun onError(e: Throwable) {
            println("onError")
        }

        override fun onComplete() {
            println("onComplete")
        }

        override fun onNext(t: String) {
            println("onNext  $t")
        }

    }
    source.subscribe(observer)
}