import App._
import org.scalatest._

class AppSpec extends FunSuite {
  test("get all possible permutations for board 2x2 with two Rooks") {
    assert(boards === List(List(List("R", "R"), List("x", "x")), List(List("R", "x"), List("R", "x")), List(List("R", "x"), List("x", "R")), List(List("x", "R"), List("R", "x")), List(List("x", "R"), List("x", "R")), List(List("x", "x"), List("R", "R"))))
  }

  test("find unique configurations where pieces don't threaten each other") {
    assert(getUniqueConfigurations() === List(List(List("R", "x"), List("x", "R")), List(List("x", "R"), List("R", "x"))))
    printUniqueConfigurationBoards()
  }

  test("returns moves for a rook") {
    assert(getMoves(0, 0) === List((1, 0), (0, 1)))
  }
}
