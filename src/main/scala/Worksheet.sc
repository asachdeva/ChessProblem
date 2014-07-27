
val x = 1
val y = 1
val l = (0 until 2).toList

val a = 0 to 1

getMovesLeftDown(a.reverse.toList, 1, 1, Nil)

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