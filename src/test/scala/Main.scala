import model.*
import ui.*

object Main {
  val cols = 6
  val rows = 6

  def main(args: Array[String]): Unit = {
    // 1 definir as coordenadas para a remocaoo inicial (Tarefa 1)
    val r1 = (0, 0)
    val r2 = (0, 1)
    
    // 2 chamar a função de inicializacao do teu objeto Board
    // Esta função já trata a criacao do tabuleiro completo e a validação das remocoes.
    val (boardOpt, initialEmpty) = Board.initKonaneBoard(rows, cols, r1, r2)

    // 3 processar o resultado com Pattern Matching
    boardOpt match {
      case Some(initialBoard) =>
        println(s"--- Tabuleiro de Konane Inicializado ---")
        println(s"Peças removidas com sucesso: $initialEmpty")

        //chamar o visualizador
        BoardPrinter.displayBoard(initialBoard, rows, cols)

      case None =>
        //caso a logica de validação do objeto Board devolva None
        println("Erro: Não foi possível inicializar o tabuleiro.")
        println("Verifica se as coordenadas são adjacentes, de cores diferentes e se estão no centro ou cantos.")
    }
  }
}
//AAAAAAAA
