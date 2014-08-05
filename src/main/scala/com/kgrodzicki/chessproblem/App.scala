package com.kgrodzicki.chessproblem

class App(boardWidth: Int, boardHeight: Int, pieces: List[(Int, Int) => Piece]) {
  type Board = List[Piece]

  val boards: Set[Board] = placePieces(pieces)

  def placePieces(k: List[(Int, Int) => Piece]): Set[List[Piece]] = k match {
    case Nil => Set(List())
    case x :: xs => for {
      pieces <- placePieces(xs)
      column <- 0 until boardWidth
      row <- 0 until boardHeight
      piece = PieceFactory.build(x, row, column)
      if (isSafe(piece, pieces))
    } yield (piece :: pieces).sortBy(r => (r.x, r.y))
  }

  def isSafe(piece: Piece, others: List[Piece]) = others forall (!isAttacked(piece, _))

  def isAttacked(p0: Piece, p1: Piece) = p0.isAttacking(p1) || p1.isAttacking(p0)

  def show() {
    val nrOfSolutions = boards.size
    val nrOfPieces = pieces.groupBy(_.getClass().getSimpleName()).mapValues(_.size).map { case (k, v) => s"$k=$v"}.mkString(", ")
    println(s"$nrOfSolutions solutions for $nrOfPieces on board $boardWidth*$boardHeight")
    // prints n unique boards
    boards.take(10).map(printBoard(_))
  }

  private def printBoard(board: Board) {
    for (y <- 0 until boardHeight) {
      for (x <- 0 until boardWidth) {
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
