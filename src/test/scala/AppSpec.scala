import App._
import org.scalatest._

class AppSpec extends FunSuite {
  test("get all possible permutations for board 2x2 with one king piece") {
    assert(boards === List(List(List("k", emptySquare), List(emptySquare, emptySquare)), List(List(emptySquare, "k"), List(emptySquare, emptySquare)), List(List(emptySquare, emptySquare), List("k", emptySquare)), List(List(emptySquare, emptySquare), List(emptySquare, "k"))))
  }
}
