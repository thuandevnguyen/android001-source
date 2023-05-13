fun main() {
    /**
     * Set Khai báo
     */

    // Immutable Set (Read Only)
    val immutableSet = setOf(3, 4, 51, 4)

    // MutableSet
    val hashSet1: HashSet<Person1> = hashSetOf<Person1>()
    val linkedHashSet = linkedSetOf<Int>(3, 54, 5)
    val treeSet = sortedSetOf<Int>(3, 54, 5)

    val person1 = Person1("A", 1)
    val person2 = Person1("A", 2)

    val result1 : Boolean = hashSet1.add(person1)

    val result2 : Boolean = hashSet1.add(person2)

    println("Result 1 = $result1 Result2 = $result2")

}


data class Person1(val name: String, val id: Int)



class Person(val name: String, val id: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

}