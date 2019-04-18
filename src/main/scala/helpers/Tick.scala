package helpers

import play.api.libs.json.{Json, Reads}

case class Tick(price: Double)

object Tick {
  implicit val reads: Reads[Tick] = Json.reads[Tick]
}