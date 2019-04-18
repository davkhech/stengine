package helpers

import play.api.libs.json._

object Converters {

  def commandToJson(command: Command): JsValue = {
    implicit val tjs = new Writes[Command] {
      override def writes(o: Command): JsValue = Json.obj(
        "op" → command.operation, "args" → command.arguments
      )
    }
    Json.toJson(command)
  }

  def orderToJson(order: Order): JsValue = {
    implicit val tjs = new Writes[Order] {
      override def writes(o: Order): JsValue = Json.obj(
        "product" → o.product, "side" → o.side, "quantity" → o.quantity, "price" → o.price
      )
    }
    Json.toJson(order)
  }

  def jsonToTick(jsonString: String): JsResult[Tick] = Json.parse(jsonString).validate[Tick]
}
