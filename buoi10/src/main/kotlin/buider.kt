fun main() {
    val mail = MailBuilder()
        .setReceived(listOf("Hello@gmail.com"))
        .setTitle("Hello Kotlin")
        .build()
    println(mail)
}


class MailBuilder {
    private var received = listOf<String>()
    private var title: String = ""

    fun build(): Mail {
        if (received.isEmpty()) {
            throw java.lang.RuntimeException("Can not null")
        }
        return Mail(received, title)
    }

    fun setTitle(title: String): MailBuilder {
        this.title = title
        return this
    }

    fun setReceived(receive: List<String>): MailBuilder {
        this.received = receive
        return this
    }
}

data class Mail(
    val receive: List<String> = emptyList(),
    val title: String,
)