package simulador;

import java.util.ArrayList;
import java.util.Collections;

public class BufferMensagem {

    private ArrayList<Processo> processos;
    private final int tamanho;

    public BufferMensagem(int tamanho) {
        processos = new ArrayList<>();
        this.tamanho = tamanho;
    }

    public boolean isFull(){
        return (processos.size() == tamanho);
    }

    public boolean isEmpty(){
        return processos.isEmpty();
    }

    public synchronized void adicionaMensagem(Processo processo){ //Adiciona um processo na fila(Arraylist)
        while(isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        processos.add(processo);
        this.notify();
    }



    public synchronized void adicionaMensagemOrdenada(Processo processo){ //Adiciona um process na fila já ordenando a fila por tamanho de processo
        while(isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        processos.add(processo);
        Collections.sort(processos);
        this.notify();
    }

    public synchronized Processo removeMensagem(){ //Remove um processo da fila
        while(isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Processo processo = processos.remove(0);
        this.notify();
        return processo;
    }

    public int TamanhoFila(){
        return processos.size();
    } // Pega o tamanho total da Fila

    public int TodaFila(int count){
       int total = 0;
       Processo processo;
        for (int i = 0; i < processos.size() ; i++) {
            processo = processos.get(i);
            total = total + processo.getTempoCriou() - count ;
        }
       return total;
    }

}