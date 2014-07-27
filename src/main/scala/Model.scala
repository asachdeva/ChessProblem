case class Empty() {
  override def toString = "x"
}

abstract class Piece {
  def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)]
}

case class Rook() extends Piece {
  override def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)] = {
    (for {
      xdx <- 0 until boardWidth
      if xdx != x
    } yield (xdx, y)).toList ++
      (for {
        ydy <- 0 until boardHeight
        if ydy != y
      } yield (x, ydy)).toList
  }
  override def toString = "R"
}


