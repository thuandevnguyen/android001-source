fun main() {

    // Immutable map
    val map1 = mapOf<String, Int>("a" to 2, "b" to 2)
    val map2: HashMap<String, Int> = hashMapOf("a" to 2, "b" to 2)

    // Mutable map
    val mutableMap = mutableMapOf<String, Int>("a" to 2, "b" to 2)

    val keys = mutableMap.keys
    val values = mutableMap.values
    val entriesMap = mutableMap.entries
    mutableMap["c"] = 10

    for (k in keys) {
        println("Key in Map = $k")
    }

    for (k in values) {
        println("Value in Map = $k")
    }

    for ((key, value) in mutableMap) {
        println("Map = $key And Value $value")
    }

    val mapT = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )

    println(mapT[1])
}