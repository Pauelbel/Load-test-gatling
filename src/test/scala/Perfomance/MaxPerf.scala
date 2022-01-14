package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.controller.inject.open


class MaxPerf extends Simulation {
  setUp(
    CommonScenario().inject(
      incrementConcurrentUsers(10)        // кол-во пользователей (разом)
       .times(5)                          // Количество ступеней
       .eachLevelLasting(300)             // длительность уровня сек
       .separatedByRampsLasting(0)        // переход между ступенями сек (плавно накинет пользователей)
       .startingFrom(10)                  // старт с кол-ва пользователей
    )
  ).protocols(httpProtocol)
   .maxDuration(2000)                    // максимальная продолжительность теста

}