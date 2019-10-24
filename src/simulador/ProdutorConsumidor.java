package simulador;

import java.util.Scanner;

/**
 * author: Renato Silveira de Lima - Ronaldo Alves
 *
 */

public class ProdutorConsumidor {

    public static void main(String[] args) {


        int quantum = 2;

        Clock clock = new Clock();
        Contador contador = new Contador(clock);
        BufferMensagem bm = new BufferMensagem(1000000);
        CPU cpu = new CPU(clock, quantum);

        int op;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite qual método será aplicado \n");
        System.out.println("1 - First Come First Served \n" +
                           "2 - Shortest Job First \n" +
                           "3 - Round Robin \n");
        op = s.nextInt();

        Thread t1_FIFO = new Thread(new Produtor(bm, clock, op)); //Cria a Thread Produtor
        Thread t2_FIFO = new Thread(new Consumidor(bm, clock, cpu, op)); //Cria a Thread Consumidor
        Thread threadClock = new Thread(contador); //Cria a Thread Clock


        switch (op) {
            case 1:

                threadClock.start();
                t1_FIFO.start();
                t2_FIFO.start();
                break;
            case 2:

                threadClock.start();
                t1_FIFO.start();
                t2_FIFO.start();
                break;

            case 3:

                threadClock.start();
                t1_FIFO.start();
                t2_FIFO.start();
                break;


        }
    }
}