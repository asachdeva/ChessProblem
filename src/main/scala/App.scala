object App {
  val boardWidth = 2
  val boardHeight = 2
  val pieces = List("k")
  val emptySquare = ""

  val boards = {
    val tailSize = boardWidth * boardHeight - pieces.size
    val allPermutations = (pieces ::: List.fill(tailSize){emptySquare}).permutations
    transformToMatrix(allPermutations)
  }

  private def transformToMatrix(allPermutations: Iterator[List[String]]): List[List[List[String]]] = {
    (for {
      each <- allPermutations
    } yield each.grouped(boardWidth).toList).toList
  }
}
