import kotlin.concurrent.thread

object Singleton1 {
  init {
    println("$this init")
  }
  
  fun doSomething() = println("$this: Doing something...")
}

class Singleton2 private constructor() {
  init {
    println("$this init")
  }
  
  fun doSomething() = println("$this: Doing something...")
  
  companion object {
    val instance by lazy { Singleton2() }
  }
}

class Singleton3 private constructor(private val name: String) {
  init {
    println("$this init name=$name")
  }
  
  fun doSomething() = println("$this: Doing something...")
  
  override fun toString(): String = "Singleton3(name='$name')"
  
  companion object {
    @Volatile
    private var INSTANCE: Singleton3? = null
    
    // thread 1:  (1)   --> (2)    --> (3)   --> (4) init  --> (5) return
    // thread 2:   (1)    --> (2)..............................(3) ---> (5)
    //                        blocking
    // thread 3:                                                                  (1) done

//    fun getInstance(name: String): Singleton3 {
//      // (1)
//      var instance = INSTANCE
//      if (instance !== null) {
//        return instance
//      }
//
//      // (2)
//      synchronized(this) {
//        // (3)
//
//        instance = INSTANCE
//        if (instance !== null) {
//          return@synchronized
//        }
//
//        // (4)
//        INSTANCE = Singleton3(name)
//        instance = INSTANCE
//      }
//
//      // (5)
//      return instance!!
//    }
    
    fun getInstance(name: String): Singleton3 = INSTANCE ?: synchronized(this) {
      INSTANCE ?: Singleton3(name).also { INSTANCE = it }
    }
  }
}

fun main() {
  thread {
    Singleton3.getInstance("NAME 1")
  }
  thread {
    Singleton3.getInstance("NAME 2")
  }
  thread {
    Thread.sleep(2000)
    Singleton3.getInstance("NAME 3")
  }
  
  Thread.sleep(5000)
  println("DONE")
}