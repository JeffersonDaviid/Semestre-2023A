package Unit5Colas;

public class Cola {
    private int frente;
    private int fin;
    private int max;
    private int[] cola;

    public Cola(int tamano) {

        this.frente = 0;
        this.fin = 0;
        this.max = tamano;
        cola = new int[tamano];
    }

    public boolean estaVacia() {
        if (frente == 0)
            return true;
        return false;
    }

    public boolean estaLlena() {
        if (fin == this.max)
            return true;
        return false;
    }

}
