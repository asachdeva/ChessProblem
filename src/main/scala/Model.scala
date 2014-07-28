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

case class Queen() extends Piece {
  override def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)] = {
    (for {
      xdx <- 0 until boardWidth
      if xdx != x
    } yield (xdx, y)).toList ++
      (for {
        ydy <- 0 until boardHeight
        if ydy != y
      } yield (x, ydy)).toList ++
      getMovesRightUp((x until boardWidth).toList, x, y, List()) ++
      getMovesLeftDown((0 to x).reverse.toList, x, y, List()) ++
      getMovesRightDown((x until boardWidth).toList, x, y, List()).filter(p => p._2 < boardHeight) ++
      getMovesLeftUp((0 to x).reverse.toList, x, y, List())
    // TODO refactor
  }

  def getMovesRightUp(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (y - 1 < 0)
        buff
      else {
        val res = (x + 1, y - 1)
        getMovesRightUp(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesLeftDown(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (x - 1 < 0)
        buff
      else {
        val res = (x - 1, y + 1)
        getMovesLeftDown(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesRightDown(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (y + 1 < 0)
        buff
      else {
        val res = (x + 1, y + 1)
        getMovesRightDown(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesLeftUp(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (x - 1 < 0)
        buff
      else {
        val res = (x - 1, y - 1)
        getMovesLeftUp(xs, res._1, res._2, res :: buff)
      }
  }

  override def toString = "Q"
}

case class Bishop() extends Piece {
  override def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)] = {
    getMovesRightUp((x until boardWidth).toList, x, y, List()) ++
      getMovesLeftDown((0 to x).reverse.toList, x, y, List()) ++
      getMovesRightDown((x until boardWidth).toList, x, y, List()).filter(p => p._2 < boardHeight) ++
      getMovesLeftUp((0 to x).reverse.toList, x, y, List())
    // TODO refactor
  }

  def getMovesRightUp(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (y - 1 < 0)
        buff
      else {
        val res = (x + 1, y - 1)
        getMovesRightUp(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesLeftDown(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (x - 1 < 0)
        buff
      else {
        val res = (x - 1, y + 1)
        getMovesLeftDown(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesRightDown(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (y + 1 < 0)
        buff
      else {
        val res = (x + 1, y + 1)
        getMovesRightDown(xs, res._1, res._2, res :: buff)
      }
  }

  def getMovesLeftUp(list: List[Int], x: Int, y: Int, buff: List[(Int, Int)]): List[(Int, Int)] = list match {
    case Nil => buff
    case x :: xs =>
      if (x - 1 < 0)
        buff
      else {
        val res = (x - 1, y - 1)
        getMovesLeftUp(xs, res._1, res._2, res :: buff)
      }
  }

  override def toString = "B"
}

case class Knight() extends Piece {
  override def getMoves(x: Int, y: Int, boardWidth: Int, boardHeight: Int): List[(Int, Int)] = {
    List((x + 2, y - 1), (x + 2, y + 1), (x + 1, y - 2), (x - 1, y - 2), (x + 1, y + 2), (x - 1, y + 2),
      (x - 2, y - 1), (x - 2, y + 1)).filter(x => x._1 >= 0 && x._1 < boardWidth && x._2 >= 0 && x._2 < boardHeight)
  }

  override def toString = "B"
}


