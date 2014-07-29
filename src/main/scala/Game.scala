class Game(boardSize: (Int, Int), p: List[Any]) {
  type Board = List[Piece]
  val (w, h) = boardSize

  lazy val boards: Set[Board] = {
    val result = placePieces(p)
    // FIXME Remove duplicates
    result.take(result.size / 2)
  }

  def placePieces(k: List[Any]): Set[List[Piece]] = k match {
    case Nil => Set(List())
    case x :: xs => for {
      pieces <- placePieces(xs)
      col <- 0 until w
      row <- 0 until h
      piece = get(x, row, col)
      if (isSafe(piece, pieces))
    } yield piece :: pieces
  }

  def get(p: Any, i: Int, i1: Int) = p match {
    case Rook => Rook(i, i1)
    case Queen => Queen(i, i1)
  }

  def isSafe(piece: Piece, others: List[Piece]) = others forall (!isAttacked(piece, _))

  def isAttacked(r1: Piece, r2: Piece) = (r1, r2) match {
    case (rook1@Rook(_), rook2@Rook(_)) => rook1.cor._1 == rook2.cor._1 || rook1.cor._2 == rook2.cor._2
  }

  def show() {
    val nrOfSolutions = boards.size
    val pieces = p.mkString(" ")
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
