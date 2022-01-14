package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  private val headers_0 = Map(
    "Cache-Control" -> "max-age=0",
    "Proxy-Connection" -> "keep-alive"
  )

  private val headers_1 = Map("Proxy-Connection" -> "keep-alive")

  private val headers_3 = Map(
    "Cache-Control" -> "max-age=0",
    "Origin" -> "http://www.load-test.ru:1080",
    "Proxy-Connection" -> "keep-alive"
  )


  val getMainPage = http("open mainPage")
    .get("/webtours/")
    .headers(headers_0)
    .check(status is 200)
    .check(css("""frame[src='/cgi-bin/welcome.pl?signOff=true']""").exists)


    val getMainPage2 = http("open mainPage2")
    .get("/cgi-bin/welcome.pl?signOff=true")
    .headers(headers_1)
    .check(status is 200)
    .check(css("""frame[src='/WebTours/home.html']""").exists)


  val getMainPage3 = http("open mainPage3")
    .get("/cgi-bin/nav.pl?in=home")
    .headers(headers_1)
    .check(status is 200)
    .check(css("""input[name='userSession']""", """value""").find.saveAs("userSession"))


  val postLogin = http("post Login")
    .post("/cgi-bin/login.pl")
    .headers(headers_3)
    .formParam("userSession", "${userSession}")
    .formParam("username", "${username}")
    .formParam("password", "${password}")
    .formParam("login.x", "57")
    .formParam("login.y", "8")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)


  val postLogin2 = http("post Login2")
    .get("/cgi-bin/nav.pl?page=menu&in=home")
    .headers(headers_1)
    .check(status is 200)
    .check(regex("""Search Flights Button""").exists)


  val postLogin3 = http("post Login3")
    .get("/cgi-bin/login.pl?intro=true")
    .headers(headers_1)
    .check(status is 200)
    .check(regex("""Using the menu to the left""").exists)


  val goFlights = http("goFlights")
    .get("/cgi-bin/welcome.pl?page=search")
    .headers(headers_1)
    .check(status is 200)
    .check(regex("""User has returned to the search page""").exists)

  val checkFlights = http("checkFlights")
    .get("/cgi-bin/reservations.pl?page=welcome")
    .header("userSession","#{userSession}")
    .check(status is 200)


  val chooseFlight = http("chooseFlight")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_3)
    .formParam("advanceDiscount", "0")
    .formParam("depart", "${depart}")
    .formParam("departDate", "01/04/2022")
    .formParam("arrive", "${arrive}")
    .formParam("returnDate", "01/05/2022")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "47")
    .formParam("findFlights.y", "14")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status is 200)
    .check(regex("""Flight departing from""").exists)
    .check(css("""input[checked='checked']""", """value""").find.saveAs("outboundFlight"))



  val chooseTime = http("chooseTime")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight","${outboundFlight}")
    .formParam("numPassengers","1")
    .formParam("advanceDiscount","0")
    .formParam("seatType","Coach")
    .formParam("seatPref","None")
    .formParam("reserveFlights.x", "70")
    .formParam("reserveFlights.y", "10")
    .check(status is 200)
    .check(regex("""Payment Details""").exists)


  val pay = http("pay")
    .post("/cgi-bin/reservations.pl")
    .headers(headers_3)
    .formParam("firstName","rr")
    .formParam("lastName","rr")
    .formParam("address1","")
    .formParam("address2","")
    .formParam("pass1","rr rr")
    .formParam("creditCard","")
    .formParam("expDate","")
    .formParam("oldCCOption","")
    .formParam("numPassengers","1")
    .formParam("seatType","Coach")
    .formParam("seatPref","None")
    .formParam("outboundFlight","${outboundFlight}")
    .formParam("advanceDiscount","0")
    .formParam("returnFlight","")
    .formParam("JSFormSubmit","off")
    .formParam("buyFlights.x", "53")
    .formParam("buyFlights.y", "9")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)
    .check(regex("""Thank you for booking through Web Tours""").exists)


}
