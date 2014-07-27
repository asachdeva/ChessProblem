val a = -1 until 2

val x = 1
val y = 1

(for {
  xdx <- x - 1 until x + 3
  if xdx >= 0 && xdx < 3 && xdx != x
} yield (xdx, y)).toList