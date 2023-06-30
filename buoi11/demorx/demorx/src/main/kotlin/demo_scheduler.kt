import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    demo2()
    Thread.sleep(5000L)

}

private fun demo2() {
    Single.fromCallable {
        getDataInternet()
    }.subscribeOn(Schedulers.io())
        .doAfterSuccess {
            println(" doOnEach 1 Thread Run ${Thread.currentThread().name} Value ${it}")
        }
        .observeOn(Schedulers.newThread())
        .doAfterSuccess {
            println(" doOnEach 2 Thread Run ${Thread.currentThread().name} Value ${it}")
        }
        .subscribe(::println)
}

private fun getDataInternet(): String {
    Thread.sleep(500L)
    return "Data From Internet"
}

private fun demo1() {
    Observable.just(1, 2, 3)
        .subscribeOn(Schedulers.io())
        .doOnEach {
            if (it.isOnNext) {
                println(" doOnEach 1 Thread Run ${Thread.currentThread().name} Value ${it.value}")
            }
        }
        .observeOn(Schedulers.computation())
        .doOnEach {
            if (it.isOnNext) {
                println(" doOnEach 2 Thread Run ${Thread.currentThread().name} Value ${it.value}")
            }
        }
        .map {
            it * 2
        }.doOnEach {
            if (it.isOnNext) {
                println(" doOnEach 3 Thread Run ${Thread.currentThread().name} Value ${it.value}")
            }
        }
        .blockingSubscribe(::println)
}