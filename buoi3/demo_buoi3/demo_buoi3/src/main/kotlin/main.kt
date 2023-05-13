fun main() {
    val phoneNumber1 = "1234567890"

    val checkPhone = phoneNumber1.isPhoneNumber

    //Backing Property
//    val human = Human()
//
//    println("human Age ${human.age}")
//
//    human.age = 15
//
//    println("human Age ${human.age}")

    val number: Int = 10


//    val apiResponse = ApiResponse(300)
//
//    if (apiResponse.isCode()) {
//        println("Call Api Success")
//    } else {
//        println("Call Api Failed")
//    }
//    val point = Point(10, 20)
//    println(-point)
    val c1 = Complex(1.0, 2.0)
    val c2 = Complex(3.0, 4.0)

//    val sum = c1.addComplex(c2)
    println(c1 + c2)
}

fun Complex.addComplex(other: Complex): Complex {
    return this + other
}

data class Complex(val real: Double, val imag: Double) {
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real + 1 , imag + other.imag + 2)
    }
}

operator fun Point.unaryMinus() = Point(-x, -y)

data class Point(val x: Int, val y: Int)

fun ApiResponse.isCode(): Boolean {
    return false
}

fun Int.isEven(value: Int): Boolean {
    return this % value == 0
}

data class ApiResponse(
    val code: Int
) {
    val isSuccess get() = code == 200
}

class Human {

    private var _age: Int = 20

    var age: Int
        get() {
            return _age
        }
        set(value) {
            _age = value
        }
}


val String.isPhoneNumber: Boolean
    get() = this.matches("^\\d{10}$".toRegex())
