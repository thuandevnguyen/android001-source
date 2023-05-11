class UserManager {
  companion object {
    const val USER_KEY = "user_key"
    const val ID = "123"
    
    const val i = 0
    const val s = "Hello"
    fun method() {}
  }
}

object UserManagerSingleton {
  fun work() {
    println("$this work")
  }
}

fun main() {
  // ngắn ~ static ben java
  UserManager.i
  UserManager.s
  UserManager.method()
  
  // dài
  UserManager.Companion.i
  UserManager.Companion.s
  UserManager.Companion.method()
  
  UserManagerSingleton.work()
}