
import akka.actor.{Actor, ActorSystem, Props}
import exchange.Exchange


object Main extends App {

  private val system = ActorSystem("Exchange")
  private val exchangeActor = system.actorOf(Props(new Actor(){
    override def receive: Receive = {
      case str: String ⇒ println(str)
    }
  }))

  val exchange = new Exchange()
  exchange.connect(exchangeActor)
  exchange.subscribe("XBTUSD")

}
