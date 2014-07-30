package com.kgrodzicki.chessproblem

import org.scalatest._

class AppTest extends FunSuite {
  val a = new App((2, 2), List(Rook, Rook))

  test("get all possible permutations for board 2x2 with two Rooks") {
    assert(a.boards.size == 2)
  }

  test("find unique configurations where pieces don't threaten each other on 2x2") {
    assert(a.boards.toList(0)(0).x === 0)
    assert(a.boards.toList(0)(0).y === 0)
    assert(a.boards.toList(0)(1).x === 1)
    assert(a.boards.toList(0)(1).y === 1)

    assert(a.boards.toList(1)(0).x === 0)
    assert(a.boards.toList(1)(0).y === 1)
    assert(a.boards.toList(1)(1).x === 1)
    assert(a.boards.toList(1)(1).y === 0)
  }

  test("isAttacked for Rook") {
    assert(a.isAttacked(Rook(0, 0), Rook(0, 0)) == true)
    assert(a.isAttacked(Rook(0, 0), Rook(1, 0)) == true)
    assert(a.isAttacked(Rook(0, 0), Rook(0, 1)) == true)

    assert(a.isAttacked(Rook(0, 0), Rook(1, 1)) == false)
  }

  test("isAttacked for Queen") {
    assert(a.isAttacked(Queen(0, 0), Queen(2, 0)) == true)
    assert(a.isAttacked(Queen(2, 2), Queen(2, 0)) == true)
    assert(a.isAttacked(Queen(1, 1), Queen(2, 0)) == true)

    assert(a.isAttacked(Queen(0, 1), Queen(2, 0)) == false)
    assert(a.isAttacked(Queen(1, 2), Queen(2, 0)) == false)
  }

  test("isAttacked for Rook and Queen") {
    assert(a.isAttacked(Rook(0, 0), Queen(2, 0)) == true)
    assert(a.isAttacked(Rook(2, 2), Queen(2, 0)) == true)
    assert(a.isAttacked(Rook(1, 1), Queen(2, 0)) == true)

    assert(a.isAttacked(Rook(0, 1), Queen(2, 0)) == false)
    assert(a.isAttacked(Rook(1, 2), Queen(2, 0)) == false)

    assert(a.isAttacked(Queen(0, 0), Rook(2, 0)) == true)
    assert(a.isAttacked(Queen(2, 2), Rook(2, 0)) == true)
    assert(a.isAttacked(Queen(1, 1), Rook(2, 0)) == true)

    assert(a.isAttacked(Queen(0, 1), Rook(2, 0)) == false)
    assert(a.isAttacked(Queen(1, 2), Rook(2, 0)) == false)
  }

  test("isAttacked for Bishop") {
    assert(a.isAttacked(Bishop(0, 0), Rook(2, 0)) == true)
    assert(a.isAttacked(Bishop(0, 2), Rook(2, 0)) == true)

    assert(a.isAttacked(Bishop(0, 1), Rook(2, 0)) == false)
  }

  test("isAttacked for Knight") {
    assert(a.isAttacked(Knight(2, 3), Bishop(3, 1)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(4, 2)) == true)

    assert(a.isAttacked(Knight(2, 3), Bishop(4, 4)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(3, 5)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(1, 5)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(0, 4)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(0, 2)) == true)
    assert(a.isAttacked(Knight(2, 3), Bishop(1, 1)) == true)
  }

  test("isAttacked for King") {
    assert(a.isAttacked(King(1, 1), Knight(0, 0)) == true)
    assert(a.isAttacked(King(1, 1), Knight(1, 0)) == true)
    assert(a.isAttacked(King(1, 1), Knight(2, 0)) == true)
    assert(a.isAttacked(King(1, 1), Knight(0, 1)) == true)
    assert(a.isAttacked(King(1, 1), Knight(2, 1)) == true)
    assert(a.isAttacked(King(1, 1), Knight(0, 2)) == true)
    assert(a.isAttacked(King(1, 1), Knight(1, 2)) == true)
    assert(a.isAttacked(King(1, 1), Knight(2, 2)) == true)
    assert(a.isAttacked(King(1, 1), Knight(1, 1)) == true)

    assert(a.isAttacked(King(1, 1), Knight(3, 3)) == false)
  }
}
