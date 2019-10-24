package simulador;

import simulador.BufferMensagem;

public class Consumidor implements Runnable {

    CPU cpu;
    BufferMensagem bm;
    Clock clock;
    int op;
    float esperaMedia, esperaMedia2;
    /**
     *
     * @param bm Passa a fila pro consumidor
     * @param clock Passa o clock pro consumidor
     * @param cpu Passa a CPU que ta sendo usada para o consumidor
     * @param op Passa o que o usuário Digitou no menu para o consumidor
     */

    public Consumidor (BufferMensagem bm, Clock clock, CPU cpu, int op) {
        this.bm = bm;
        this.clock = clock;
        this.cpu = cpu;
        this.op = op;
    }


    @Override
    public void run() {

        switch (op){
            case 1:

            case 2:
                while(true) {
                    if(cpu.disp == 0) { //Tanto no FIFO quando no STJ faz o consumo do processo e passa para a CPU tratar já calculando o tempo de espera que o precesso ficou na fila
                        synchronized (bm) {
                            Processo processo = bm.removeMensagem();
                            synchronized (clock) {
                                cpu.aloca(processo, clock.getContagem());
                                esperaMedia2 = clock.getContagem() - cpu.processo.getTempoCriou();
                                System.out.println("Espera do processo: " + cpu.processo.getid() + " é " + esperaMedia2);
                                esperaMedia += cpu.processo.getTempoCriou() - clock.getContagem();

                            }
                        }
                    }

                    if(clock.getContagem() == cpu.tempoFim){ //Passado o tempo que a CPU trata o processa ele é liberado e contabiliza o Throuput
                        synchronized (clock) {
                            System.out.println("Consumiu processo " + cpu.processo.getid() + " no tempo: " + clock.getContagem());
                            cpu.libera();
                            if(cpu.numeroProcessos == 10){
                                System.out.println(cpu.numeroProcessos + " Processo(s) finalizados pela CPU");
                                esperaMedia = esperaMedia / 10;
                                esperaMedia = Math.abs(esperaMedia);
                                System.out.println("Tempo de espera médio: " + esperaMedia);
                                System.exit(0);
                            }else {
                                System.out.println(cpu.numeroProcessos + " Processo(s) finalizados pela CPU");
                            }


                        }
                    }
                }

            case 3:
                while(true) { //Faz a mesma coisa só que o tempo que a CPU trata o processo é o tempo de quantum, o que aumenta o tempo de espera médio
                    if(cpu.disp == 0) {
                        synchronized (bm) {
                            Processo processo = bm.removeMensagem();
                            synchronized (clock) {
                                cpu.alocaRR(processo, clock.getContagem());
                                esperaMedia2 = clock.getContagem() - cpu.processo.getTempoCriou();
                                System.out.println("Espera do processo: " + cpu.processo.getid() + " é " + esperaMedia2);
                                esperaMedia += cpu.processo.getTempoCriou() - clock.getContagem();
                            }
                        }
                    }

                    if(clock.getContagem() == cpu.tempoFim){
                        synchronized (clock) {
                            System.out.println("Consumiu processo " + cpu.processo.getid() + " no tempo: " + clock.getContagem() + " tamanho restante: " + cpu.processo.getTempoCPU());
                            Processo processo = cpu.liberaRR(clock.getContagem());
                            if(cpu.numeroProcessos == 10){
                                System.out.println(cpu.numeroProcessos + " Processo(s) finalizados pela CPU");
                                esperaMedia = esperaMedia / 10;
                                esperaMedia = Math.abs(esperaMedia);
                                System.out.println("Tempo de espera médio: " + esperaMedia);
                                System.exit(0);
                            }else {
                                System.out.println(cpu.numeroProcessos + " Processo(s) finalizados pela CPU");
                            }

                        }
                        synchronized (bm) {
                                if (cpu.processo.getTempoCPU() > 0) {
                                    System.out.println("readicionando processo: " + cpu.processo.getid() + " na fila");

                                    bm.adicionaMensagem(cpu.processo);
                                }
                        }
                    }
                }
        }

    }

}