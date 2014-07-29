sealed abstract class Piece(cor: (Int, Int)) {
  val (x, y) = cor
}

case class Rook(cor: (Int, Int)) extends Piece(cor) {
  override def toString = "R"
}

case class King(cor: (Int, Int)) extends Piece(cor) {
  override def toString = "K"
}

case class Queen(cor: (Int, Int)) extends Piece(cor) {
  override def toString = "Q"
}

case class Bishop(cor: (Int, Int)) extends Piece(cor) {
  override def toString = "B"
}

case class Knight(cor: (Int, Int)) extends Piece(cor) {
  override def toString = "Kn"
}




