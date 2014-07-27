object App {
  val boardWidth = 2
  val boardHeight = 2
  val pieces = List("R", "R")
  val emptySquare = "x"

  type Board = List[List[String]]

  val boards = {
    val tailSize = boardWidth * boardHeight - pieces.size
    val allPermutations = (pieces ::: List.fill(tailSize) {
      emptySquare
    }).permutations
    transformToMatrix(allPermutations)
  }

  def getUniqueConfigurations(): List[List[List[String]]] = {
    for {
      b <- boards
      if isUniqueConfiguration(b)
    } yield b
  }

  def isUniqueConfiguration(board: Board): Boolean = {
    for {
      x <- 0 until boardWidth
      y <- 0 until boardHeight
      if board(x)(y) != emptySquare
    } {
      for {
        (a, b) <- getMoves(x, y)
        if board(a)(b) != emptySquare
      }
        return false
    }

    true
  }

  def getMoves(x: Int, y: Int): List[(Int, Int)] = {
    (for {
      xdx <- 0 until boardWidth
      if xdx != x
    } yield (xdx, y)).toList ++
      (for {
        ydy <- 0 until boardHeight
        if ydy != y
      } yield (x, ydy)).toList
  }

  def printUniqueConfigurationBoards() {
    for {
      uc <- getUniqueConfigurations()
    } printBoard(uc)
  }

  def printBoard(board: Board) {
    for {
      b <- board
    } println(b.mkString(" - "))
    println()
  }

  private def transformToMatrix(allPermutations: Iterator[List[String]]): List[List[List[String]]] = {
    (for {
      each <- allPermutations
    } yield each.grouped(boardWidth).toList).toList
  }
}
