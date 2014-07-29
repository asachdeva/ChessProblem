import org.scalatest._

class GameTest extends FunSuite {
  val game2x2 = new Game((2, 2), List(Rook, Rook))

  test("get all possible permutations for board 2x2 with two Rooks") {
    assert(game2x2.boards.size == 2)
  }

  test("find unique configurations where pieces don't threaten each other on 2x2") {
    assert(game2x2.boards.toList(0)(0).x === 1)
    assert(game2x2.boards.toList(0)(0).y === 1)
    assert(game2x2.boards.toList(0)(1).x === 0)
    assert(game2x2.boards.toList(0)(1).y === 0)

    assert(game2x2.boards.toList(1)(0).x === 0)
    assert(game2x2.boards.toList(1)(0).y === 1)
    assert(game2x2.boards.toList(1)(1).x === 1)
    assert(game2x2.boards.toList(1)(1).y === 0)
  }
}
