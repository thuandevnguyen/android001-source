interface Observer {
    fun update(message: String)
}

class Subject {
    private val observers = mutableListOf<Observer>()

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObserver(message: String) {
        for (observer in observers) {
            observer.update(message = message)
        }
    }
}

class ConCreteObserver(private val name: String) : Observer {
    override fun update(message: String) {
        println("NameConcrete $name and Message $message")
    }
}

fun main() {
    val subject = Subject()

    val observer1 = ConCreteObserver("Sub 1")
    val observer2 = ConCreteObserver("Sub 2")

    subject.attach(observer1)
    subject.attach(observer2)

    subject.notifyObserver("Hello Android 001")

    subject.detach(observer2)

    subject.notifyObserver("Hello Android")

}