import org.scalatest.FunSuite

class RookTest extends FunSuite {
  test("returns possible moves for board 2x2") {
    val r = new Rook
    assert(r.getMoves(0, 0, 2, 2) === List((1, 0), (0, 1)))
    assert(r.getMoves(0, 1, 2, 2) === List((1, 1), (0, 0)))
    assert(r.getMoves(1, 0, 2, 2) === List((0, 0), (1, 1)))
    assert(r.getMoves(1, 1, 2, 2) === List((0, 1), (1, 0)))
  }
}
