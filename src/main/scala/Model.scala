sealed abstract class Piece(cor: (Int, Int)) {
  val (x, y) = cor

  def isAttacking(p: Piece): Boolean
}

case class Rook(cor: (Int, Int)) extends Piece(cor) {
  def isAttacking(p: Piece) = p.x == x || p.y == y

  override def toString = "R"
}

case class King(cor: (Int, Int)) extends Piece(cor) {
  def isAttacking(p: Piece) = {
    val moves = List((x-1, y-1), (x, y-1), (x+1, y-1), (x-1, y), (x+1, y), (x-1, y+1),(x, y+1), (x+1, y+1))
    moves.contains((p.x, p.y))
  }

  override def toString = "K"
}

case class Queen(cor: (Int, Int)) extends Piece(cor) {
  def isAttacking(p: Piece) = p.x == x || p.y == y || math.abs(p.x - x) == math.abs(p.y - y)

  override def toString = "Q"
}

case class Bishop(cor: (Int, Int)) extends Piece(cor) {
  def isAttacking(p: Piece) = math.abs(p.x - x) == math.abs(p.y - y)

  override def toString = "B"
}

case class Knight(cor: (Int, Int)) extends Piece(cor) {
  def isAttacking(p: Piece) = {
    val moves = List((x + 1, y - 2), (x + 2, y - 1), (x + 2, y + 1), (x + 1, y + 2), (x - 1, y + 2), (x - 2, y + 1), (x - 2, y - 1), (x - 1, y - 2))
    moves.contains((p.x, p.y))
  }

  override def toString = "Kn"
}




