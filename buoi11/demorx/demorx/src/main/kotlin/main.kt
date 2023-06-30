import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
//    demo1()
    demo2()
}

private fun demo2() {
    val d = Observable.just(5,2,0,4,10)
        .map { i -> 10 / i }
        .subscribe(
            { i -> println("RECEIVED: $i") },
            { e -> println("RECEIVED ERROR: $e") },
            { println("Done!")}
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