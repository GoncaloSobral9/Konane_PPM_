package model
import scala.collection.parallel.immutable.ParMap

object Board {
  def initBoard(rows: Int, cols: Int): Board = {
    ParMap.from(
      for{
        r <- 0 until rows
        c <- 0 until cols

        stone = if ((r + c) % 2 == 0) Stone.Black else Stone.White
      } yield (r, c) -> stone
    )
  }
}