package perf

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._

object Feeders {

  val login: BatchableFeederBuilder[String] = csv("login.csv").circular.eager
  val depart: BatchableFeederBuilder[String] = csv("depart.csv").random.eager
  val arrive: BatchableFeederBuilder[String] = csv("arrive.csv").random.eager



}
