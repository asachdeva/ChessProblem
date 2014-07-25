object App {
  val boardSize = (2, 2)
  val pieces = List("k")

  val boards = {
    val tailSize = boardSize._1 * boardSize._2 - pieces.size
    pieces ::: List.fill(tailSize){""}.toList
  }
}
