import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

fun main() {
  ShapeFactory.getShape("CIRCLE").draw()
  ShapeFactory.getShape("SQUARE").draw()
  ShapeFactory.getShape("RECTANGLE").draw()
  
  val scope: CoroutineScope = CoroutineScope(context = Dispatchers.IO)
  val channel: Channel<Int> = Channel<Int>(capacity = 1)
  
  scope.launch {
    channel.send(1)
  }
  scope.launch {
    val i = channel.receive()
  }
  
  Shape("CIRCLE").draw()
  Shape("SQUARE").draw()
  Shape("RECTANGLE").draw()
  
  Circle2.Factory.buildShape2().draw()
  Rectangle2.Factory.buildShape2().draw()
  Square2.Factory.buildShape2().draw()
}