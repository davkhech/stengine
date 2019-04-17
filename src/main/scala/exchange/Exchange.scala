package exchange

import akka.actor.{Actor, ActorRef}

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
    websocket ! "{\"op\": \"subscribe\", \"args\": \"trade\"}"
  }

  def buy = {}

  def sell = {}

  private def _placeOrder = ???

  def send = {}

  def getResources = {}

  def close = {}
}
