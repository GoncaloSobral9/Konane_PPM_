import model.*
import ui.*

object Main {
  val cols = 6
  val rows = 6

  def main(args: Array[String]): Unit = {
    // 1 definir as coordenadas para a remoção inicial (Tarefa 1)
    val r1 = (2, 2)
    val r2 = (2, 3)
    
    // 2 chamar a função de inicialização do teu objeto Board
    // Esta função já trata a criação do tabuleiro completo e a validação das remoções.
    val (boardOpt, initialEmpty) = Board.initKonaneBoard(rows, cols, r1, r2)

    // 3 processar o resultado com Pattern Matching
    boardOpt match {
      case Some(initialBoard) =>
        println(s"--- Tabuleiro de Kōnane Inicializado ---")
        println(s"Peças removidas com sucesso: $initialEmpty")

        //chamar o visualizador que criaste na T4
        BoardPrinter.displayBoard(initialBoard, rows, cols)

      case None =>
        //caso a lógica de validação no teu objeto Board devolva None
        println("Erro: Não foi possível inicializar o tabuleiro.")
        println("Verifica se as coordenadas são adjacentes, de cores diferentes e se estão no centro ou cantos.")
    }
  }
}
//AAAAAAAA
