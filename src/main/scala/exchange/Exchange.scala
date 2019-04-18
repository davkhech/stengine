package exchange

import akka.actor.{Actor, ActorRef}
import helpers.{Command, Converters}

import collection.mutable.{Map ⇒ MutMap}


class Exchange {
  val exchangeUri: String = "wss://testnet.bitmex.com/realtime"
  val resources: MutMap[String, Double] = MutMap().withDefaultValue(0)
  private var websocket: WebSocket = _

  def connect(actor: ActorRef): Unit = {
    websocket = WebSocket(exchangeUri)
    websocket.connect(actor)
  }

  def subscribe(product: String): Unit = {
    val command = Command("subscribe", Seq("trade"))
    websocket ! Converters.commandToJson(command).toString
  }

  def unsubscribe(product: String): Unit = {
    val command = Command("unsubscribe", Seq("trade"))
    websocket ! Converters.commandToJson(command).toString
  }

  def buy = {}

  def sell = {}

  private def _placeOrder = ???

  def send = {}

  def getResources = {}

  def close = {}
}

object Exchange {
  def apply(): Exchange = new Exchange()
}
