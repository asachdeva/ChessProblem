import org.scalatest._

class GameTest extends FunSuite {
  val game2x2 = new Game(2, 2, List(new Rook(), new Rook()))

  test("get all possible permutations for board 2x2 with two Rooks") {
    assert(game2x2.boards.size == 2)
  }

  test("find unique configurations where pieces don't threaten each other on 2x2") {
    assert(game2x2.boards.mkString("") == "List(R, x, x, R)List(x, R, R, x)")
  }
}
