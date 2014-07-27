import org.scalatest.FunSuite

class ModelTest extends FunSuite {
  test("all possible moves for rook on board 2x2") {
    val p = new Rook
    assert(p.getMoves(0, 0, 2, 2) === List((1, 0), (0, 1)))
    assert(p.getMoves(0, 1, 2, 2) === List((1, 1), (0, 0)))
    assert(p.getMoves(1, 0, 2, 2) === List((0, 0), (1, 1)))
    assert(p.getMoves(1, 1, 2, 2) === List((0, 1), (1, 0)))
  }

  test("all possible moves for king on board 2x2") {
    val p = new King()
    assert(p.getMoves(0, 0, 2, 2) === List((0, 1), (1, 1), (1, 0)))
    assert(p.getMoves(0, 1, 2, 2) === List((0, 0), (1, 0), (1, 1)))
    assert(p.getMoves(1, 0, 2, 2) === List((0, 1), (1, 1), (0, 0)))
    assert(p.getMoves(1, 1, 2, 2) === List((0, 0), (1, 0), (0, 1)))
  }

  test("all possible moves for king on board 3x3") {
    val p = new King()
    assert(p.getMoves(1, 1, 3, 3) === List((0,0), (1,0), (2,0), (0,2), (1,2), (2,2), (0,1), (2,1)))
  }
}
