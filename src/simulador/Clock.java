package simulador;

public class Clock {

    private volatile int contagem; //volatile indica que haverá várias modificações

    public synchronized final int getContagem() {
        return contagem;
    }

    public synchronized final void incrementa() {

        this.contagem++;
        System.out.println("-------------------------------------------------------------");
        System.out.println("Clock " + getContagem());
    }

}

