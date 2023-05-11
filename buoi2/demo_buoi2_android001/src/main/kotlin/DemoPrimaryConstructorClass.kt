// i chỉ là tham số của primary constructor ko phải là property
// j là read only property
// k là read-write property
class DemoPrimaryConstructorClass constructor(i: Int, val j: Int, var k: Int) {
  // age là property
  val age = i + 1
  
  init {
    println(i)
  }
}