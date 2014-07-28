class Game(boardWidth: Int, boardHeight: Int, pieces: List[Piece]) {
  type Board = List[List[Any]]


  lazy val boards: List[Board] = {
    val tailSize = boardWidth * boardHeight - pieces.size
    val allPermutations: List[List[Any]] = (pieces ::: List.fill(tailSize) {
      Empty.apply()
    }).permutations.toList

    toMatrix(allPermutations)
  }

  def getUniqueConfigurations(): List[Board] = {
    for {
      b <- boards
      if isUniqueConfiguration(b)
    } yield b
  }

  protected def isUniqueConfiguration(board: Board): Boolean = {
    for {
      x <- 0 until boardWidth
      y <- 0 until boardHeight
    } {
      board(x)(y) match {
        case p: Piece => {
          for {
            (a, b) <- p.getMoves(x, y, boardWidth, boardHeight)
            if !board(a)(b).isInstanceOf[Empty]
          }
            return false
        }
        case e: Empty =>
      }
    }

    true
  }

  def printUniqueConfigurationBoards() {
    for {
      uc <- getUniqueConfigurations()
    } printBoard(uc)
  }

  private def toMatrix(allPermutations: List[List[Any]]): List[List[List[Any]]] = {
    (for {
      each <- allPermutations
    } yield each.grouped(boardWidth).toList)
  }

  private def printBoard(board: Board) {
    for {
      b <- board
    } println(b.mkString(" - "))
    println()
  }
}
