package logic

import model.*
import model.Stone.White
import model.Stone.Black

object GameLogic {
  def randomMove(lstOpenCoords: List[Coord2D], rand: MyRandom): (Coord2D, MyRandom) =
    val (index, newRand) = rand.nextInt(lstOpenCoords.length)
    (lstOpenCoords(index), newRand)

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
      val DirC = math.signum(c2 - c1)

      // 4. Se for válido:
      //    - Remover a(s) pedra(s) inimiga(s) capturada(s) do ParMap[cite: 49, 50].
      //    - Mover a pedra do jogador para a coordTo[cite: 59].
      //    - Atualizar a lista de coordenadas livres (lstOpenCoords)[cite: 60].
      //    - Retornar (Some(novoTabuleiro), novaListaLivre)[cite: 59, 60].
      def isValidPath(from: Coord2D, to: Coord2D,)
      // 5. Se inválido: retornar (None, lstOpenCoords)[cite: 59].
    }
  }
}
