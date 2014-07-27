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

case class King() extends Piece {
  override def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)] = {
    (for {
      xdx <- x - 1 until x + boardWidth
      if xdx >= 0 && xdx < boardWidth && y - 1 >= 0
    } yield (xdx, y - 1)).toList ++
      (for {
        xdx <- x - 1 until x + boardWidth
        if xdx >= 0 && xdx < boardWidth && y + 1 < boardHeight
      } yield (xdx, y + 1)).toList ++
      (for {
        xdx <- x - 1 until x + boardWidth
        if xdx >= 0 && xdx < boardWidth && xdx != x
      } yield (xdx, y)).toList
  }

  override def toString = "K"
}


