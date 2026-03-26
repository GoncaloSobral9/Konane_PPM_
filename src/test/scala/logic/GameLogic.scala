package logic

import model.*
import model.Stone.White
import model.Stone.Black

object GameLogic {
  def randomMove(lstOpenCoords: List[Coord2D], rand: MyRandom): (Coord2D, MyRandom) =
    val (index, newRand) = rand.nextInt(lstOpenCoords.length)
    (lstOpenCoords(index), newRand)

  def play(board: Board, player: Stone, coordFrom: Coord2D, coordTo: Coord2D, lstOpenCoords: List[Coord2D]): (Option[Board], List[Coord2D]) = {
    val enemy = if player!=Stone.White then White else Black

    // 1. Validar se a coordFrom tem uma pedra do 'player'[cite: 59].
    val isValidStart = board.get(coordFrom).contains(player)
    // 2. Validar se o movimento é um salto (distância de 2, 4, 6...) sobre pedras inimigas[cite: 47, 48].
    def getDirection(from: Coord2D, to: Coord2D): Option[(Int,Int)]=
      (to._1 -from._1, to._2 - from._2) match
        case ()
    // 3. Verificar se a coordTo está vazia[cite: 49].
    val isDestEmpty = !board.contains(coordTo)
    // 4. Se for válido:
    //    - Remover a(s) pedra(s) inimiga(s) capturada(s) do ParMap[cite: 49, 50].
    //    - Mover a pedra do jogador para a coordTo[cite: 59].
    //    - Atualizar a lista de coordenadas livres (lstOpenCoords)[cite: 60].
    //    - Retornar (Some(novoTabuleiro), novaListaLivre)[cite: 59, 60].
    // 5. Se inválido: retornar (None, lstOpenCoords)[cite: 59].
  }
}
