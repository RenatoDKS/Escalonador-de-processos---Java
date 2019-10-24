# Escalonador-de-processos---Java
Escalonador de Processos em Java desenvolvido por Renato Silveira e Ronaldo Alves na disciplina de Sistemas Operacionais 2

O objetivo deste projeto é a criação de um simulador de algoritmos de escalonamento
de processos. O programa deverá ser desenvolvido em Java e deverá ser capaz de
exibir graficamente a simulação de execução dos algoritmos de escalonamento de
processos em um único CPU. Além disso, o sistema deverá ser capaz de computar o
tempo de espera médio e o throughput médio dos algoritmos.

Para tal, deverão ser utilizadas Java Threads que irão auxiliar no funcionamento do
sistema. Deverão ser implementadas, no mínimo, as seguintes tarefas para serem
utilizadas com Threads:

 Tarefa Produtora: cria um objeto Processo e o insere em uma fila de processos.
 Tarefa Consumidora: retira um Processo da fila e o aloca na CPU.
 Tarefa Contadora: simula o clock da CPU, ditando o tempo decorrido de
execução da CPU.

O maior desafio deste trabalho está na implementação do algoritmo de escalonamento
de processos, bem como a garantia de sincronia entre todos os elementos paralelizados
do código (produção/consumo de processos, clock da CPU, escalonamento e exibição
do funcionamento). Os alunos deverão elaborar estratégias inteligentes para o correto
funcionamento do projeto.

Deverão ser implementados 3 algoritmos de escalonamento, sendo eles:
 First come, first served (FCFS)
 Round Robin (RR): definição do quantum é questão de projeto. Os alunos
deverão tentar defini-lo com base na execução e resultado das métricas de
desempenho.
 Um entre: Shortest Job First (SJF), Shortest Remaining Time Next (SRTN) e
Múltiplas Filas.

Finalmente, os alunos deverão entregar um relatório curto (2 a 4 páginas) onde deverão
descrever brevemente aspectos importantes de implementação, os algoritmos
implementados e um comparativo entre eles de acordo com o tempo de espera médio
e o throughput médio.
