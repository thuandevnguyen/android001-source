fun main() {
    val s1 = Student(1, "Android")
    val s2 = s1

    s1.showInfo()
    s2.showInfo()

    println(s1)
    println("------------")
    println(s2)
    println("------Change------")
    s1.id = 10
    s1.showInfo()
    s2.showInfo()

    val address = Address("Hanoi")
    val person1 = Person(1, "Android", address)
    val person2 = person1.clone()
    println("------Person 1------")
    println(person1)
    println("Person1 = " + getObjectAddress(person1))
    println("------Person 2------")
    println(person2)
    println("Person1 = " + getObjectAddress(person1))

    println("------Change------")
    person1.id = 10
    person1.address.district = "DaNang"
    println(person1)
    println(person2)

    val user = User("Abc", Role.USER)
    val user1 = User("Abc", Role.USER)
    val user2 = User("Abc", Role.USER)
    val user4 = User("Abc", Role.ADMIN)

    val listUser = mutableListOf<User>()
    listUser.add(user)
    listUser.add(user1)
    listUser.add(user2)
    listUser.add(user4)

    val newListUserCopy = listUser.map { it ->
        if (it.role == Role.USER) {
            it.copy("Android")
        } else {
            it
        }
    }
    println(listUser)
    println(newListUserCopy)

}

enum class Role {
    ADMIN,
    USER,
}

data class User(
    val name: String,
    val role: Role
)

fun getObjectAddress(obj: Any): String {
    return obj.javaClass.name + "HashCode" + obj.hashCode()
}

class Person(var id: Int, var name: String, var address: Address) : Cloneable {
    override fun toString(): String {
        return "Person [Id = $id Name = $name Address = $address]"
    }

    public override fun clone(): Person {
        val personCloned = super.clone() as Person
        personCloned.address = address.clone()
        return personCloned
    }
}

class Address(var district: String) : Cloneable {

    public override fun clone(): Address {
        return super.clone() as Address
    }

    override fun toString(): String {
        return "Address [district = $district "
    }
}


class Student(var id: Int, var name: String) {
    fun showInfo() {
        println("Student is Id $id and Name $name")
    }
}