package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.controller.inject.open



// по результатам тестов максимальной производительности (sla на response time 3 сек)
 

class Stability extends Simulation {

  setUp(
    CommonScenario().inject(
      rampConcurrentUsers(0) to 30 during 60, // от 0 до 30 пользователей за 600 секунд
      constantConcurrentUsers(30) during 1800 // удерживать 30 пользователей с течение часа
    )
  ).protocols(httpProtocol)
   .throttle(                      // ограничение по рпс
     reachRps(40) in (60),        // поднять рпс до 40 за 60 секунд
     holdFor(1800)                 // удерживать рпс 1800 секунд
    ).maxDuration(3000)
}
  
  
  
  
  