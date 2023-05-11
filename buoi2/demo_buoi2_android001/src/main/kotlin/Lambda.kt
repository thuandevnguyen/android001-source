fun sumFunction(a: Int, b: Int) = a + b

fun isEven(number: Int): Boolean {
  println("calls isEven with $number")
  return number % 2 == 0
}

fun main() {
  // khai báo lambda object
  val sum: (Int, Int) -> Int =
    { a: Int, b: Int -> a + b }
  
  // ::<ten method> -> method reference
  // trả về 1 lambda có type giống với signature của method
  // lúc gọi lambda -> gọi method
  val isEvenLambda: (Int) -> Boolean = ::isEven
  println(isEvenLambda(2))
  
  val sum2: (a: Int, b: Int) -> Int = ::sumFunction
  println(sum2(1, 2))
  
  sumFunction(1, 2)
  // invoke là 1 operator function nên có thay thể bằng dấu ()
  sum(1, 2)
  
  // HOF laf 1 function nhận vào 1 function khác làm tham số hoặc trả về 1 function
  // callApi là 1 HOF vì nhận 2 lambda làm tham số
  callApi(
    onSuccess = { value ->
      // hien thi len UI
    },
    onError = { throwable ->
      // hien thi loi len man hinh
    }
  )
  
  listOf(1, 2, 3, 4).forEach { println("Element: $it") }
  println(listOf(1, 2, 3, 4).filter { it % 2 == 0 })
  listOf(1, 2, 3).map { it + 1 }
  
  executeAction(
    action = {
      println("IN LAMBDA ----------")
    }
  )
}

fun callApi(
  onSuccess: (String) -> Unit,
  onError: (Throwable) -> Unit
) {
  try {
    // call api
    onSuccess("Success")
  } catch (e: Exception) {
    onError(e)
  }
}

// bat dong bo
fun executeAction(action: () -> Unit) {
  Thread(
    Runnable {
      Thread.sleep(5_000)
      println("Will call $action")
      
      action()
      
      println("Done")
    }
  ).start()
}