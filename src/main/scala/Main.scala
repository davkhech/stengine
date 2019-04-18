
import akka.actor.{Actor, ActorSystem, Props}
import exchange.Exchange
import helpers._


object Main extends App {

  private val system = ActorSystem("Exchange")
  private val exchangeActor = system.actorOf(Props(new Actor(){
    override def receive: Receive = {
      case str: String ⇒ println(str)
    }
  }))

  val exchange = Exchange()
  exchange.connect(exchangeActor)
  exchange.subscribe("XBTUSD")

}
