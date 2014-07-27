

val l = List(List(List("k", "_"), List("_", "_")), List(List("_", "k"), List("_", "_")), List(List("_", "_"), List("k", "_")), List(List("_", "_"), List("_", "k")))
for {
  li <- l
  c <- li
} {
  println(c.mkString(""))
}
