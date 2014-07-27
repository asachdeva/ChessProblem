object App {
  val boardWidth = 2
  val boardHeight = 2
  val pieces = List("R", "R")
  val emptySquare = "x"

  val boards = {
    val tailSize = boardWidth * boardHeight - pieces.size
    val allPermutations = (pieces ::: List.fill(tailSize){emptySquare}).permutations
    transformToMatrix(allPermutations)
  }

  def getUniqueConfigurations(): List[List[List[String]]] = {
    for {
      b <- boards
      if b(0)(0) == b(1)(1) || b(1)(0) == b(0)(1)
      if b(0)(0) == "R" || b(1)(0) == "R"
    } yield b
  }

  private def transformToMatrix(allPermutations: Iterator[List[String]]): List[List[List[String]]] = {
    (for {
      each <- allPermutations
    } yield each.grouped(boardWidth).toList).toList
  }

  def printUniqueConfigurationBoards() {
    for {
      uc <- getUniqueConfigurations()
      c <- uc
    } println(c.mkString(""))
  }
}
