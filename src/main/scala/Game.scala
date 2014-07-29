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
      piece = getPieceFor(x, row, col)
      if (isSafe(piece, pieces))
    } yield piece :: pieces
  }

  def getPieceFor(p: Any, x: Int, y: Int) = p match {
    case Rook => Rook(x, y)
    case Queen => Queen(x, y)
    case King => King(x, y)
    case Bishop => Bishop(x, y)
    case Knight => Knight(x, y)
  }

  def isSafe(piece: Piece, others: List[Piece]) = others forall (!isAttacked(piece, _))

  def isAttacked(r0: Piece, r1: Piece) = (r0, r1) match {
    case (r0@Rook(_), r1@Rook(_)) => r0.cor._1 == r1.cor._1 || r0.cor._2 == r1.cor._2
    case (q0@Queen(_), q1@Queen(_)) => q0.cor._1 == q1.cor._1 || q0.cor._2 == q1.cor._2 || math.abs(q0.x - q1.x) == math.abs(q0.y - q1.y)
    case (r0@Rook(_), q1@Queen(_)) => r0.cor._1 == q1.cor._1 || r0.cor._2 == q1.cor._2 || math.abs(r0.x - q1.x) == math.abs(r0.y - q1.y)
    case (q1@Queen(_), r0@Rook(_)) => r0.cor._1 == q1.cor._1 || r0.cor._2 == q1.cor._2 || math.abs(r0.x - q1.x) == math.abs(r0.y - q1.y)
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
