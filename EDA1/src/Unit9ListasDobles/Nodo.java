package Unit9ListasDobles;

public class Nodo {
    private String dato;
    private Nodo anterior;
    private Nodo posterior;

    /**
     * Contructor NODO con referencia null
     * 
     * @param dato
     */
    public Nodo(String dato) {
        this.dato = dato;
        this.anterior = null;
        this.posterior = null;
    }

    /**
     * Constructor NODO con parametro de referencia
     * 
     * @param dato
     * @param anterior
     * @param posterior
     */
    public Nodo(String dato, Nodo anterior, Nodo posterior) {
        this.dato = dato;
        this.anterior = anterior;
        this.posterior = posterior;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getPosterior() {
        return posterior;
    }

    public void setPosterior(Nodo posterior) {
        this.posterior = posterior;
    }

}
