import model.*
import logic.*
import ui.*
import scala.collection.parallel.immutable.ParMap
import scala.collection.parallel.CollectionConverters.*

class Main {
  val cols = 6
  val rows = 6

  def main(args: Array[String]): Unit = {
    // 1. Definir as coordenadas para a remoção inicial (Tarefa 1)
    // No Kōnane 6x6, as casas (2,2) e (2,3) são adjacentes, centrais e de cores diferentes.
    val r1 = (2, 2)
    val r2 = (2, 3)
    
    // 2. Chamar a função de inicialização do teu objeto Board
    // Esta função já trata a criação do tabuleiro completo e a validação das remoções.
    val (boardOpt, initialEmpty) = Board.initKonaneBoard(rows, cols, r1, r2)

    // 3. Processar o resultado com Pattern Matching
    boardOpt match {
      case Some(initialBoard) =>
        println(s"--- Tabuleiro de Kōnane Inicializado ---")
        println(s"Peças removidas com sucesso: $initialEmpty")

        // Chamar o visualizador que criaste na T4
        BoardPrinter.displayBoard(initialBoard, rows, cols)

      case None =>
        // Caso a lógica de validação no teu objeto Board devolva None
        println("Erro: Não foi possível inicializar o tabuleiro.")
        println("Verifica se as coordenadas são adjacentes, de cores diferentes e se estão no centro ou cantos.")
    }
  }
}

//AAAAAAAA
