fun String.splitToInt(): List<Int> = Regex("""\d+""")
  .findAll(this)
  .map { it.value.toInt() }
  .toList()
  .also { println("splitToInt: $it") }

fun main() {
  val ints = "1,2,3".splitToInt()
}