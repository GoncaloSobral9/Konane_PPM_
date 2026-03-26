package logic
import model.*
object GameLogic {
  def randomMove(lstOpenCoords: List[Coord2D], rand: MyRandom):(Coord2D, MyRandom) = {
    val (index, newRand) = rand.nextInt(lstOpenCoords.length)
    (lstOpenCoords(index), newRand)
  }
}
