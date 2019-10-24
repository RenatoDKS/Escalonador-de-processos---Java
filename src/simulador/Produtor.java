package simulador;

import java.util.Random;

public class Produtor implements Runnable {

    int[] vetor = { 7, 3, 1, 4, 3, 1, 7, 3, 5, 2 };


    BufferMensagem bm;
    int op;
    Clock clock;

    /**
     *
     * @param bm Fila de processos
     * @param clock Clock atual do escalonador
     * @param op Valor do Switch Case digitado pelo usuário
     */


    public Produtor (BufferMensagem bm, Clock clock, int op) {
        this.bm = bm;
        this.clock = clock;
        this.op = op;
    }



    Random random = new Random(); /* Variável que cria número aleatório */
    int i = 1; //Contador do numero de processos


    @Override
    public void run() {

    switch (op){
        case 1: // Caso o usuário digite 1, vai para o Produtor da FIFO
            while(i <= 10) {

                synchronized(bm) { //Adiciona os processos na fila de forma sincronizada
                    //int tpmcpu = random.nextInt(9) + 1; //Gera processos de tamanho aleatório
                    int tpmcpu = vetor[i-1]; //Pega os valores do vetor que representa o tamanhho dos processos que serão criados
                    Processo processo = new Processo(i, clock.getContagem(), tpmcpu); //Cria um Novo processo
                    bm.adicionaMensagem(processo); //Adiciona um novo processo na fila
                    System.out.println("Produziu processo: " + i + " no tempo: " + clock.getContagem() + " duração: " + tpmcpu);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        case 2:
            while(i <= 10) {

                synchronized(bm) {
                    //int tpmcpu = random.nextInt(9) + 1;
                    int tpmcpu = vetor[i-1];
                    Processo processo = new Processo(i, clock.getContagem(), tpmcpu);
                    bm.adicionaMensagemOrdenada(processo); //Chama o método que adiciona mensagem na Fila já ordenada
                    System.out.println("Produziu processo: " + i + " no tempo: " + clock.getContagem() + " duração: " + tpmcpu);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        case 3:
            while(i <= 10) {

                synchronized(bm) { //Igual ao case 1
                    int tpmcpu = random.nextInt(9) + 1;
                    //int tpmcpu = vetor[i-1];
                    Processo processo = new Processo(i, clock.getContagem(), tpmcpu);
                    bm.adicionaMensagem(processo);
                    System.out.println("Produziu processo: " + i + " no tempo: " + clock.getContagem() + " tamanho: " + tpmcpu);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
    }

    }

}