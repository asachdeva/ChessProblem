package com.kgrodzicki.chessproblem

import org.scalatest.FunSuite

class PieceFactoryTest extends FunSuite {

  test("factory builds an case class from type") {
    assert(PieceFactory.build(Rook, 0,0) == Rook(0,0))
    assert(PieceFactory.build(King, 0,0) == King(0,0))
    assert(PieceFactory.build(Queen, 0,0) == Queen(0,0))
    assert(PieceFactory.build(Bishop, 0,0) == Bishop(0,0))
    assert(PieceFactory.build(Knight, 0,0) == Knight(0,0))

    intercept[IllegalArgumentException] {
      PieceFactory.build(Int, 0,0)
    }
  }
}
