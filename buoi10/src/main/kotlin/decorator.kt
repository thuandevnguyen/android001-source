interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

class DefaultCoffee : Coffee {
    override fun getCost(): Double = 1.0

    override fun getDescription(): String = "Coffee"

}

open class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun getCost(): Double {
        return decoratedCoffee.getCost()
    }

    override fun getDescription(): String {
        return decoratedCoffee.getDescription()
    }

}

class CoffeeMilk(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.5
    }

    override fun getDescription(): String {
        return super.getDescription() + "Milk"
    }
}

class CoffeeTea(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 2.0
    }

    override fun getDescription(): String {
        return super.getDescription() + "Tea"
    }
}

fun main() {
    val coffee: Coffee = DefaultCoffee()
    println("Coffee Default Cost ${coffee.getCost()} And Description ${coffee.getDescription()}")

    val milkCoffee : Coffee = CoffeeMilk(coffee)

    println("MilkCoffee Cost ${milkCoffee.getCost()} And Description ${milkCoffee.getDescription()}")

    val teaCoffee : Coffee = CoffeeTea(coffee)

    println("MilkCoffee Cost ${teaCoffee.getCost()} And Description ${teaCoffee.getDescription()}")

}