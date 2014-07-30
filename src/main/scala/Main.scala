import com.kgrodzicki.chessproblem._

object Main {
  def main(args: Array[String]) {
    val game = new App((7, 7), List(King, King, Queen, Queen, Bishop, Bishop, Knight))

    game.show()
  }
}
