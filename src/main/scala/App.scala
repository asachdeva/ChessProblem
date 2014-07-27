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
    boards
  }

  private def transformToMatrix(allPermutations: Iterator[List[String]]): List[List[List[String]]] = {
    (for {
      each <- allPermutations
    } yield each.grouped(boardWidth).toList).toList
  }

  def printBoard() {
    for {
      uc <- getUniqueConfigurations()
      c <- uc
    } println(c.mkString(""))
  }
}
