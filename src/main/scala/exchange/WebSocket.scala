package exchange

import com.github.andyglow.websocket.{Websocket, WebsocketClient, WebsocketHandler}
import com.github.andyglow.websocket.util.Uri
import com.typesafe.scalalogging.Logger

import akka.actor._

import scala.concurrent.{ExecutionContext, Future}


class WebSocket(uri: String) {
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  val logger = Logger(classOf[WebSocket])
  val queue: collection.mutable.Queue[String] = collection.mutable.Queue()
  var client: WebsocketClient[String] = _
  var ws: Websocket = _


  def connect(actor: ActorRef): Unit = {
    client = WebsocketClient(Uri(uri), new WebsocketHandler[String]() {
      def receive: PartialFunction[String, Unit] = {
        case str ⇒
          logger.info(s"<<| $str")
      }
    })
    ws = client.open()
  }

  def close(): Future[Unit] = client.shutdownAsync

  def !(message: String): Unit = ws ! message
}

object WebSocket {
  def apply(uri: String): WebSocket = new WebSocket(uri)
}
