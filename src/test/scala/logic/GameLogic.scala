package logic

import model.*
import model.Stone.White
import model.Stone.Black

import scala.annotation.tailrec

object GameLogic {
  //T1
  def randomMove(lstOpenCoords: List[Coord2D], rand: MyRandom): (Coord2D, MyRandom) =
    val (index, newRand) = rand.nextInt(lstOpenCoords.length)
    (lstOpenCoords(index), newRand)

  //T2
  def play(board: Board, player: Stone, coordFrom: Coord2D, coordTo: Coord2D, lstOpenCoords: List[Coord2D]): (Option[Board], List[Coord2D]) = {
    // Definir o inimigo corretamente
    val enemy = if (player == Stone.Black) Stone.White else Stone.Black
    val (r1, c1) = coordFrom
    val (r2, c2) = coordTo

    // 1. Validar se a coordFrom tem uma pedra do 'player'
    val isValidStart = board.get(coordFrom).contains(player)

    // 2. Validar se o movimento é ortogonal (em linha reta)
    val isRightDirection = (r1 == r2 && c1 != c2) || (r1 != r2 && c1 == c2)

    // 3. Verificar se a coordTo está vazia
    val isDestEmpty = !board.contains(coordTo)

    // 4. Verificar se a distância do salto é par (2, 4, 6...)
    val isValidDistance = math.abs(r1 - r2) % 2 == 0 && math.abs(c1 - c2) % 2 == 0

    // Se alguma das validações básicas falhar, devolvemos logo None
    if (!isValidStart || !isRightDirection || !isDestEmpty || !isValidDistance) {
      (None, lstOpenCoords)
    } else {
      val dirR = math.signum(r2 - r1)
      val dirC = math.signum(c2 - c1)

      // 6. Função recursiva em cauda para processar múltiplos saltos na mesma direção
      @tailrec
      def checkJumps(currR: Int, currC: Int, captured: List[Coord2D]): Option[List[Coord2D]] = {
        if (currR == r2 && currC == c2) {
          Some(captured)
        } else {
          val enemyPos = (currR + dirR, currC + dirC)
          val landPos = (currR + 2 * dirR, currC + 2 * dirC)
          board.get(enemyPos) match {
            case Some(stone) if stone == enemy =>
              if (landPos == coordTo || !board.contains(landPos)) {
                checkJumps(landPos._1, landPos._2, enemyPos :: captured)
              } else {
                None
              }
            case _ => None
          }
        }
      }

      // 7. Executar a função recursiva e processar o resultado com Pattern Matching
      checkJumps(r1, c1, Nil) match {
        case Some(capturedPieces) =>
          val boardWithoutCaptured = capturedPieces.foldLeft(board)((b, pos) => b - pos)

          val finalBoard = (boardWithoutCaptured - coordFrom) + (coordTo -> player)

          val newOpenCoords = (coordFrom :: capturedPieces) ++ lstOpenCoords.filterNot(_ == coordTo)

          (Some(finalBoard), newOpenCoords)

        case None =>
          (None, lstOpenCoords)
      }
    }
  }

  //T3
  def playRandomly(board: Board, r: MyRandom, player: Stone, lstOpenCoords: List[Coord2D], f: (List[Coord2D], MyRandom) => (Coord2D, MyRandom)): (Option[Board], MyRandom, List[Coord2D], Option[Coord2D]) = {
    val playerPos = board.filter {
      case (_, s) => s == player

    }.keys.toList

    val validMoves = for {
      from <- playerPos
      to <- lstOpenCoords
      (newBoard, newCords) = play(board, player, from, to, lstOpenCoords)
      if newBoard.isDefined
    } yield (from, to, newBoard, newCords)

    validMoves match {
      case Nil =>
        (None, r, lstOpenCoords, None)

      case moves =>
        val validDestinations = moves.map { case (_, to, _, _) => to }.distinct
        val (selectTo, nextRandom) = f(validDestinations, r)
        moves.find { case (_, to, _, _) => to == selectTo } match {
          case Some((_, _, newBoard, newCords)) => (newBoard, nextRandom, newCords, Some(selectTo))

          case None =>
            (None, r, lstOpenCoords, None)
        }
    }
  }
}
