import kotlin.random.Random

fun String.nullIfEmpty(): String? = if (isEmpty()) null else this
fun String.nullIfEmptyUsingTakeIf(): String? = takeIf { isNotEmpty() }

fun main() {
  val i = Random.nextInt()
  
  val j = if (i > 100) i else null
  val jj = i.takeIf { it > 100 }
  
  // takeIf { f(it) } === takeUnless { !f(it) }
  
  val aValue: Int
  "1234".let {
    aValue = 2
  }
  // block { } phair dduwojc goi chinh xac 1 lan
  // neen compiler biet aValue dc khoi tao
  println(aValue)
}