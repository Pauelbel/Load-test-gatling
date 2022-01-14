
import io.gatling.core.Predef._
import io.gatling.http.Predef._

package object perf {

  val httpProtocol = http
    .baseUrl("http://www.load-test.ru:1080")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:95.0) Gecko/20100101 Firefox/95.0")
    .disableFollowRedirect
    //.header("userAgent","mobile")
}
