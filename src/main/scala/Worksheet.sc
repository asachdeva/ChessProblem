import java.util.concurrent.TimeUnit

import com.kgrodzicki.chessproblem._

def time[A](f: => A) = {
  val s = System.nanoTime()
  val ret = f
  val elapsedTime = TimeUnit.SECONDS.convert((System.nanoTime - s), TimeUnit.NANOSECONDS)
  println(s"Execution time: $elapsedTime s")
  ret
}

time(new App(7, 7, List(King, King, Queen, Queen, Bishop, Bishop, Knight)).show())
