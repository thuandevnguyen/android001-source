fun main() {

    /**
     * Khởi tạo ImmutableList và MutableList
     */

    // Khởi tạo ImmutableList (Read Only)
    val immutableList1: List<Int> = listOf<Int>(1, 2, 3, 3, 4)

    // MutableList
    val arrayList1 = arrayListOf<Int>(1, 2, 3, 45, 5)
    val list2 = mutableListOf<Int>(1, 2, 2, 3, 3, 4)

    // Tạo 1 list rỗng
    val listEmpty = listOf<Int>()
    val listEmpty1: List<Int> = emptyList()

    // Tạo ra ImmutableList chứa null
    val arrayList12 = listOf("a", null)

    // Tạo ra MutableList có phần tử null

    // ArrayList chỉ đinh rõ ràng các loại
    val mutableListNull: MutableList<String?> = arrayListOf("a", null)
    val mutableListNull2: ArrayList<String?> = arrayListOf("a", null)
    val mutableListNull1: MutableCollection<String?> = arrayListOf("a", null)
    val mutableListNull3: ArrayList<String?> = arrayListOf("a", null)

    // ImmutableList (Chỉ đọc)
//    val immutableString = listOf<String>("A", "B", "C")
//    immutableString.forEach {
//        println(it)
//    }

    /**
     * MutableList
     */
//    val listStringMonth = arrayListOf<String>()
//
//    listStringMonth.add("Jan")
//    listStringMonth.add("Feb")
//    listStringMonth.add("Mar")
//
//    listStringMonth.forEach {
//        println(it)
//    }
//
//    listStringMonth.removeAt(listStringMonth.lastIndex)
//    println("==================")
//    listStringMonth.forEach {
//        println(it)
//    }

    val listInt = listOf<Int>(10,20,30,40,50,60)

    val indexValue  = listInt.isEmpty()
    println(indexValue)
}