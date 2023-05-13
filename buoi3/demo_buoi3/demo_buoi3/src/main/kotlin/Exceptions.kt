import java.io.File

// fatal error
// internet, server, local file
sealed interface AppError{
  object NoInternet: AppError
  object ServerError: AppError
}

fun main() {
  File("Demo").outputStream().use {
    // use it
  }
  
  try {
    println("before")
    //throw Exception("Hi There!", RuntimeException())
  } catch (e: Exception) {
    println("Catch: $e")
  } finally {
    println("Finally block")
  }
  
  val a: Int? = try {
    "1234".toInt()
  } catch (e: NumberFormatException) {
    null
  } finally {
  
  }
  
  val person = Person3("Hello")
  val s: String = person.name ?: throw IllegalArgumentException("Name required")
  s.length // 's' is known to be non-nullable at this point
  
  // Nothing la sub-type cua moi type
  val value: String = throw RuntimeException("Broken!!")
  
  val result = runCatching {
    "23223@@@".toInt()
  }
  result.fold(
    onSuccess = {
      println(it)
    },
    onFailure = {
    
    }
  )
}

class Person3(val name: String?)