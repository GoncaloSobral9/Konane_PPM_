package logic

import model.*
import model.Stone.White
import model.Stone.Black

object GameLogic {
  def randomMove(lstOpenCoords: List[Coord2D], rand: MyRandom): (Coord2D, MyRandom) =
    val (index, newRand) = rand.nextInt(lstOpenCoords.length)
    (lstOpenCoords(index), newRand)
    
  def play(board:Board, player: Stone, coordFrom: Coord2D, coordTo: Coord2D, lstOpenCoords: List[Coord2D]): (Option[Board], List[Coord2D]) = {  
    val enemy = if(player!=White)White else Black
    
    val isValidStart = board.get(coordFrom).contains(player)
    val isDestEmpty = !board.contains(coordTo)
    
    
  }
}
