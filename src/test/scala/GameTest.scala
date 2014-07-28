import org.scalatest._

class GameTest extends FunSuite {
  val game2x2 = new Game(2, 2, List(new Rook(), new Rook()))

  test("get all possible permutations for board 2x2 with two Rooks") {
    assert(game2x2.boards.size == 6)
  }

  test("find unique configurations where pieces don't threaten each other on 2x2") {
    assert(game2x2.getUniqueConfigurations().toString() === "List(List(List(R, x), List(x, R)), List(List(x, R), List(R, x)))")
  }

  test("find unique configurations for 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight") {
    val game7x7 = new Game(7, 7, List(new King(), new King(), new Queen(), new Queen(), new Bishop(), new Bishop(), new Knight()))
  }
}
