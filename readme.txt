Este projeto, desenvolvido no âmbito da Unidade Curricular de Programação Multiparadigma, foca-se
na implementação do jogo tradicional havaiano Konane utilizando a linguagem Scala e o paradigma de
programação funcional. O objetivo desta primeira fase criar a lógica do jogo Konane que seja suportada por
funções puras, imutabilidade e recursividade

A base técnica do trabalho assenta na utilização de tipos de dados imutáveis e coleções paralelas para
otimizar o processamento do tabuleiro. O tabuleiro é definido como um ParMap[Coord2D, Stone], onde as
coordenadas seguem o formato (row, column) e as peças são representadas por um enum contendo as cores Black e
White. Para a geração de números aleatórios, foi implementada uma abordagem funcional e pura através da
classe MyRandom, que evita efeitos secundários ao gerir o estado da semente de forma explícita.

No que diz respeito às funcionalidades obrigatórias (Tarefas T1 a T4), o grupo implementou com sucesso os seguintes componentes:
	Geração de Movimentos (T1): O método randomMove permite selecionar uma coordenada aleatória a partir
	de uma lista de posições livres, essencial para a automação de jogadas.

	Lógica de Jogo e Inicialização (T2): Foi desenvolvido o motor principal de execução de jogadas (play),
	que valida saltos simples e múltiplos, removendo as peças capturadas e atualizando o estado do tabuleiro.
	A inicialização respeita as regras do jogo, criando um padrão alternado e permitindo a remoção inicial de
	duas pedras adjacentes no centro ou nos cantos.

	Jogadas Automáticas (T3): Através de uma função de ordem superior, o sistema consegue realizar jogadas
	aleatórias válidas, demonstrando a flexibilidade do paradigma funcional ao passar comportamentos como argumentos.

	Visualização (T4): Foi criada uma interface textual (TUI) que imprime o estado do tabuleiro na consola,
	utilizando caracteres alfanuméricos para identificar linhas e colunas, facilitando a interação e o
	teste das funcionalidades.