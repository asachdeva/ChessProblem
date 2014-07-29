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

  test("isAttacked for Rook") {
    assert(game2x2.isAttacked(Rook(0, 0), Rook(0, 0)) == true)
    assert(game2x2.isAttacked(Rook(0, 0), Rook(1, 0)) == true)
    assert(game2x2.isAttacked(Rook(0, 0), Rook(0, 1)) == true)

    assert(game2x2.isAttacked(Rook(0, 0), Rook(1, 1)) == false)
  }

  test("isAttacked for Queen") {
    assert(game2x2.isAttacked(Queen(0, 0), Queen(2, 0)) == true)
    assert(game2x2.isAttacked(Queen(2, 2), Queen(2, 0)) == true)
    assert(game2x2.isAttacked(Queen(1, 1), Queen(2, 0)) == true)

    assert(game2x2.isAttacked(Queen(0, 1), Queen(2, 0)) == false)
    assert(game2x2.isAttacked(Queen(1, 2), Queen(2, 0)) == false)
  }

  test("isAttacked for Rook and Queen") {
    assert(game2x2.isAttacked(Rook(0, 0), Queen(2, 0)) == true)
    assert(game2x2.isAttacked(Rook(2, 2), Queen(2, 0)) == true)
    assert(game2x2.isAttacked(Rook(1, 1), Queen(2, 0)) == true)

    assert(game2x2.isAttacked(Rook(0, 1), Queen(2, 0)) == false)
    assert(game2x2.isAttacked(Rook(1, 2), Queen(2, 0)) == false)

    assert(game2x2.isAttacked(Queen(0, 0), Rook(2, 0)) == true)
    assert(game2x2.isAttacked(Queen(2, 2), Rook(2, 0)) == true)
    assert(game2x2.isAttacked(Queen(1, 1), Rook(2, 0)) == true)

    assert(game2x2.isAttacked(Queen(0, 1), Rook(2, 0)) == false)
    assert(game2x2.isAttacked(Queen(1, 2), Rook(2, 0)) == false)
  }

  test("isAttacked for Bishop") {
    assert(game2x2.isAttacked(Bishop(0, 0), Rook(2, 0)) == true)
    assert(game2x2.isAttacked(Bishop(0, 2), Rook(2, 0)) == true)

    assert(game2x2.isAttacked(Bishop(0, 1), Rook(2, 0)) == false)
  }

  test("isAttacked for Knight") {
    assert(game2x2.isAttacked(Knight(2, 3), Rook(3, 1)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(4, 2)) == true)

    assert(game2x2.isAttacked(Knight(2, 3), Rook(4, 4)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(3, 5)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(1, 5)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(0, 4)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(0, 2)) == true)
    assert(game2x2.isAttacked(Knight(2, 3), Rook(1, 1)) == true)
  }

  test("isAttacked for King") {
    assert(game2x2.isAttacked(King(1, 1), Knight(0, 0)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(1, 0)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(2, 0)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(0, 1)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(2, 1)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(0, 2)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(1, 2)) == true)
    assert(game2x2.isAttacked(King(1, 1), Knight(2, 2)) == true)

    assert(game2x2.isAttacked(King(1, 1), Knight(3, 3)) == false)
  }
}
