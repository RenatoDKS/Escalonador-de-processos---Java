package simulador;

public class Processo implements Comparable<Processo> {


    public int getid() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getTempoCriou() {
        return tempoCriou;
    }

    public void setTempoCriou(int tempoCriou) {
        this.tempoCriou = tempoCriou;
    }

    public int getTempoCPU() {
        return tempoCPU;
    }

    public void setTempoCPU(int tempoCPU) {
        this.tempoCPU = tempoCPU;
    }

    private int id;
    private int tempoCriou;
    private int tempoCPU;

    /**
     *
     * @param id Identificador do processo
     * @param tempoCriou tempo em que ele foi criado e inserido na fila
     * @param tempoCPU Tempo em que o processo fica na CPU / Tamanho do processo
     */

    public Processo(int id, int tempoCriou, int tempoCPU) {
        this.id = id;
        this.tempoCriou = tempoCriou;
        this.tempoCPU = tempoCPU;
    }

    @Override
    public int compareTo(Processo o) { // Método de comparação de tamanho dos processos para eles serem ordenados na fila
        return (this.getTempoCPU() < o.getTempoCPU() ? -1 :
                (this.getTempoCPU() == o.getTempoCPU() ? 0 : 1));
    }
}