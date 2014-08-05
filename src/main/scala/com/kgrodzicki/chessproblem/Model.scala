package com.kgrodzicki.chessproblem

sealed trait Piece {
  def x: Int

  def y: Int

  def isAttacking(p: Piece): Boolean
}

case class Rook(x: Int, y: Int) extends Piece {
  override def isAttacking(p: Piece) = p.x == x || p.y == y

  override def toString = "R"
}

case class King(x: Int, y: Int) extends Piece {
  override def isAttacking(p: Piece) = {
    val moves = List((x, y), (x - 1, y - 1), (x, y - 1), (x + 1, y - 1), (x - 1, y),
      (x + 1, y), (x - 1, y + 1), (x, y + 1), (x + 1, y + 1))
    moves.contains((p.x, p.y))
  }

  override def toString = "K"
}

case class Queen(x: Int, y: Int) extends Piece {
  override def isAttacking(p: Piece) = p.x == x || p.y == y || math.abs(p.x - x) == math.abs(p.y - y)

  override def toString = "Q"
}

case class Bishop(x: Int, y: Int) extends Piece {
  def isAttacking(p: Piece) = math.abs(p.x - x) == math.abs(p.y - y)

  override def toString = "B"
}

case class Knight(x: Int, y: Int) extends Piece {
  override def isAttacking(p: Piece) = {
    val moves = List((x + 1, y - 2), (x + 2, y - 1), (x + 2, y + 1), (x + 1, y + 2),
      (x - 1, y + 2), (x - 2, y + 1), (x - 2, y - 1), (x - 1, y - 2))
    moves.contains((p.x, p.y))
  }

  override def toString = "N"
}

object PieceFactory {
  def build(p: (Int, Int) => Piece, x: Int, y: Int) = p match {
    case Rook => Rook(x, y)
    case Queen => Queen(x, y)
    case King => King(x, y)
    case Bishop => Bishop(x, y)
    case Knight => Knight(x, y)
    case _ => throw new IllegalArgumentException(s"No Piece for $p")
  }
}

