import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {
    println("---just---")
    // Just
    Observable.just(1, 2, 3)
        .subscribe { value ->
            println(value)
        }


    println("-".repeat(80))
    println("---defer---")
    // Deferring Observable creation
    val deferredObservable = Observable.defer {
        println("Creating Observable...")
        Observable.just(1, 2, 3)
    }
    println("Before subscribing...")
    deferredObservable.subscribe { value ->
        println(value)
    }


    println("-".repeat(80))
    println("---fromIterable---")
    // From Iterable
    val list = listOf(1, 2, 3)
    Observable.fromIterable(list)
        .subscribe { value ->
            println(value)
        }


    println("-".repeat(80))
    println("---range---")
    // Range
    Observable.range(1, 5)
        .subscribe { value ->
            println(value)
        }


    println("-".repeat(80))
    println("---interval---")
    // Interval
    Observable.interval(1, TimeUnit.SECONDS)
        .take(5)
        .subscribe { value ->
            println(value)
        }


    println("-".repeat(80))
    println("---timer---")
    // Timer
    Observable.timer(1, TimeUnit.SECONDS)
        .subscribe { value ->
            println(value)
        }


    println("-".repeat(80))
    println("---fromCallable---")
    // FromCallable
    println("Before subscribing...")
    Observable
        .fromCallable {
            println("Creating value...")
            // Logic để tạo ra giá trị
            "Hello"
        }
        .subscribe { value ->
            // Xử lý giá trị
            println(value)
        }


    val observable1 = Observable
        .fromIterable(listOf(1, 2, 3))
        .concatMap { e -> Observable.just(e).delay(170, TimeUnit.MILLISECONDS) }

    val observable2 = Observable
        .fromIterable(listOf("A", "B", "C"))
        .concatMap { e -> Observable.just(e).delay(100, TimeUnit.MILLISECONDS) }


    println("-".repeat(80))
    println("---concat---")
    // Concat: Kết hợp các Observable theo thứ tự
    Observable
        .concat(observable1, observable2)
        .subscribe { value ->
            // Xử lý giá trị
            println(value)
        }
    Thread.sleep(1000)


    println("-".repeat(80))
    println("---zip---")
    // Zip: Gộp các giá trị tương ứng từ các Observable (theo index)
    Observable
        .zip(observable1, observable2) { value1, value2 ->
            "$value1 <-> $value2"
        }
        .subscribe { value ->
            // Xử lý giá trị
            println(value)
        }
    Thread.sleep(1000)


    println("-".repeat(80))
    println("---combineLatest---")
    // CombineLatest: Kết hợp các giá trị mới nhất từ các Observable
    Observable
        .combineLatest(observable1, observable2) { value1, value2 ->
            "$value1 <-> $value2"
        }
        .subscribe { value ->
            // Xử lý giá trị
            println(value)
        }
    Thread.sleep(1000)


    println("-".repeat(80))
    println("---merge---")
    // Merge: Kết hợp các Observable thành một Observable
    Observable
        .merge(observable1, observable2)
        .subscribe { value ->
            // Xử lý giá trị
            println(value)
        }
    Thread.sleep(1000)
}