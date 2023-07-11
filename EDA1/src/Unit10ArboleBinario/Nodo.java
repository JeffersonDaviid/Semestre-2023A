package Unit10ArboleBinario;

public class Nodo {
    private String dato;
    private Nodo izquierdo;
    private Nodo derecha;

    /**
     * Contructor NODO con referencia null
     * 
     * @param dato
     */
    public Nodo(String dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecha = null;
    }

    /**
     * Constructor NODO con parametro de referencia
     * 
     * @param dato
     * @param izquierdo
     * @param derecha
     */
    public Nodo(String dato, Nodo izquierdo, Nodo derecha) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecha = derecha;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

}
