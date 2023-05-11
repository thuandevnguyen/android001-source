// sealed interface gần như 1 mở rộng của enum.
//
// nó giới hạn những class implement nó
// chỉ các class, object, ... trong cùng module này mới implements PaymentMethod
// -> compiler nó biết được mọi case.
sealed interface PaymentMethod {
  data class CreditCard(val cardNumber: String) : PaymentMethod
  data class DebitCard(val cardNumber: String) : PaymentMethod
  data class Paypal(val cardNumber: String, val abc: String) : PaymentMethod
  
  sealed interface Child : PaymentMethod {
    object Child1 : Child
    object Child2 : Child
  }
  
  object Child3 : PaymentMethod
}

enum class Gender(val isMale: Boolean) {
  MALE(isMale = true),
  FEMALE(isMale = false)
}

fun paymentMethod(): PaymentMethod = PaymentMethod.CreditCard("XXXXX")

fun main() {
  
  // sealed interface thường dùng để model union type - sum type (hoặc)
  //
  // nghĩa là paymentMethod() trả về 1 PaymentMethod, paymentMethod đó
  // hoặc là CreditCard hoặc là DebitCard hoặc là Paypal hoặc là Child1 hoặc là Child2 hoặc là Child3
  when (paymentMethod()) {
    is PaymentMethod.CreditCard -> println("credit")
    is PaymentMethod.DebitCard -> TODO()
    is PaymentMethod.Paypal -> TODO()
    PaymentMethod.Child.Child1 -> TODO()
    PaymentMethod.Child.Child2 -> TODO()
    PaymentMethod.Child3 -> TODO()
  }
}