package simulador;

public class CPU {

    Clock clock;
    Processo processo;
    int tempoFim;
    int disp;
    int quantum;
    int numeroProcessos = 0;



    public synchronized final void libera() { //Libera a CPU depois dela simulador o tratamento de um processo
        disp = 0;
        System.out.println("CPU está liberada");
            numeroProcessos++;
    }


    public synchronized final Processo liberaRR(int cont) { //libera a CPU usando o método Round Robin onde o cada quantum ele libera um processo e pega outro
        disp = 0;
        System.out.println("CPU está liberada");
        if(processo.getTempoCPU() <= 0){
            numeroProcessos++;
        }
        return processo;
        }


    public synchronized final void aloca(Processo processo, int cont) { // aloca um processo dentro da CPU e libera quando passa o tempo equivalente ao tamanho dele
        disp = 1;
        this.processo = processo;
        tempoFim = processo.getTempoCPU() + cont;
        System.out.println("CPU está ocupada com o processo: " + processo.getid());
    }

    public synchronized final void alocaRR(Processo processo, int cont) { //Aloca um processo na CPU que é liberado depois de passado o tempo de quantum
        disp = 1;
        this.processo = processo;
        tempoFim = quantum + cont;
        processo.setTempoCPU(processo.getTempoCPU() - quantum);
        System.out.println("CPU está ocupada com o processo: " + processo.getid());
    }

    /**
     *
     * @param clock Clock atual do sistema
     * @param quantum valor de quantum para o round robin
     */
    public CPU(Clock clock, int quantum){

        this.clock = clock;
        this.quantum = quantum;
    }

}
