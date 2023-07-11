package Unit11ArbolBinarioBusqueda;

public class Nodo {
    private int dato;
    private Nodo izquierdo;
    private Nodo derecha;

    /**
     * Contructor NODO con referencia null
     * 
     * @param dato
     */
    public Nodo(int dato) {
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
    public Nodo(int dato, Nodo izquierdo, Nodo derecha) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecha = derecha;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
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
