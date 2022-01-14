package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._
import perf.Feeders._

object CommonScenario{
  def apply() = new CommonScenario().scn
}

class CommonScenario {

  val groupMainPage = group("group Main page"){
   exec(Actions.getMainPage)
     .exec(Actions.getMainPage2)
     .exec(Actions.getMainPage3)
 }
  val scn: ScenarioBuilder = scenario("scenario1")
    .feed(login)
    .feed(depart)
    .feed(arrive)

    .exec(groupMainPage)
    //.pause(1,2)
    .exec(Actions.postLogin)
    //.pause(1,2)
    .exec(Actions.goFlights)
    //.pause(1,2)
    .exec(Actions.chooseFlight)
    //.pause(1,2)
    .exec(Actions.chooseTime)
    //.pause(1,2)
    .exec(Actions.pay)
    //.pause(1,2)
    .exec(Actions.getMainPage)
    .pause(1,3)

}
