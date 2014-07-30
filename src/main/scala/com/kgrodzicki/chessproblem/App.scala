package com.kgrodzicki.chessproblem

class App(boardSize: (Int, Int), p: List[Any]) {
  type Board = List[Piece]
  val (w, h) = boardSize

  lazy val boards: Set[Board] = placePieces(p)

  def placePieces(k: List[Any]): Set[List[Piece]] = k match {
    case Nil => Set(List())
    case x :: xs => for {
      pieces <- placePieces(xs)
      col <- 0 until w
      row <- 0 until h
      piece = build(x, row, col)
      if (isSafe(piece, pieces))
    } yield (piece :: pieces).sortBy(t => (t.x, t.y))
  }

  def isSafe(piece: Piece, others: List[Piece]) = others forall (!isAttacked(piece, _))

  def isAttacked(p0: Piece, p1: Piece) = p0.isAttacking(p1) || p1.isAttacking(p0)

  def build(p: Any, x: Int, y: Int) = p match {
    case Rook => Rook(x, y)
    case Queen => Queen(x, y)
    case King => King(x, y)
    case Bishop => Bishop(x, y)
    case Knight => Knight(x, y)
  }

  def show() {
    val nrOfSolutions = boards.size
    val pieces = p.groupBy(w => w).mapValues(_.size).map { case (k, v) => s"$k=$v"}.mkString(", ")
    println(s"$nrOfSolutions solutions for $pieces on board $w*$h")
    // prints n boards
    boards.take(10).map(printBoard(_))
  }

  private def printBoard(board: Board) {
    for (y <- 0 until h) {
      for (x <- 0 until w) {
        board.find(p => p.x == x && p.y == y) match {
          case Some(piece) => print(s"$piece ")
          case None => print(". ")
        }
      }
      println()
    }
    println()
  }
}
