class Game(boardSize: (Int, Int), p: List[Any]) {
  type Board = List[Piece]
  val (w, h) = boardSize

  lazy val boards: Set[Board] = {
    val result = placePieces(p)
    // FIXME Remove duplicates
    if (result.size == 0) result
    else result.take(result.size / 2)
  }

  def placePieces(k: List[Any]): Set[List[Piece]] = k match {
    case Nil => Set(List())
    case x :: xs => for {
      pieces <- placePieces(xs)
      col <- 0 until w
      row <- 0 until h
      piece = getPieceFor(x, row, col)
      if (isSafe(piece, pieces))
    } yield piece :: pieces
  }

  def isSafe(piece: Piece, others: List[Piece]) = others forall (!isAttacked(piece, _))

  def isAttacked(p0: Piece, p1: Piece) = p0.isAttacking(p1) || p1.isAttacking(p0)

  def getPieceFor(p: Any, x: Int, y: Int) = p match {
    case Rook => Rook(x, y)
    case Queen => Queen(x, y)
    case King => King(x, y)
    case Bishop => Bishop(x, y)
    case Knight => Knight(x, y)
  }

  def show() {
    val nrOfSolutions = boards.size
    val pieces = p.groupBy(w => w).mapValues(_.size).mkString(", ")
    println(s"Number of solutions for $pieces on board $w*$h => $nrOfSolutions")
    boards map printBoard
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
