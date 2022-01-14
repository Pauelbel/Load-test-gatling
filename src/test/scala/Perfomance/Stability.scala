package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.controller.inject.open


class Stability extends Simulation {

  setUp(
    CommonScenario().inject(
      rampUsersPerSec(0) to 5.toInt during 30, //разгон 5ч/с 30 мин
      constantUsersPerSec(5.toInt) during 30 //полка 5ч/с 5 мин
    )
  ).protocols(httpProtocol)
    .maxDuration(35) //длительность теста = разгон + полка

}
