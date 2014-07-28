class Game(boardWidth: Int, boardHeight: Int, pieces: List[Piece]) {
  type Board = List[Object]


  val boards: List[Board] = {
    (pieces ::: List.fill(boardWidth * boardHeight - pieces.size){Empty.apply()}).permutations.filter(p => isUniqueConfiguration(p)).toList
  }

  protected def isUniqueConfiguration(board: Board): Boolean = {
    val sb = splitBoard(board)
    for {
      x <- 0 until boardWidth
      y <- 0 until boardHeight
    } {
      sb(x)(y) match {
        case p: Piece => {
          for {
            (a, b) <- p.getMoves(x, y, boardWidth, boardHeight)
            if !sb(a)(b).isInstanceOf[Empty]
          }
            return false
        }
        case e: Empty =>
      }
    }

    true
  }

  private def splitBoard(board: Board) = board.grouped(boardWidth).toList


def printUniqueConfigurationBoards() {
    for {
      uc <- boards
    } printBoard(splitBoard(uc))
  }

private def printBoard(board: Board) {
    for {
      b <- board
    } println(b)
    println()
  }
}
