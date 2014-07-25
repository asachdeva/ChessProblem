import App._
import org.scalatest._

class AppSpec extends FunSuite {
  test("generate boards") {
    assert(boards === List("k", "", "", ""))
  }
}
