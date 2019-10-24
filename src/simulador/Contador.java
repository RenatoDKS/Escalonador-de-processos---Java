package simulador;

public class Contador implements Runnable {

    Clock clock;

    public Contador(Clock clock){ //Classe que faz com que o clock seja incrementado a cada 1 segundo
        this.clock = clock;
    }

    @Override
    public void run() {


        while(true){
            clock.incrementa();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
