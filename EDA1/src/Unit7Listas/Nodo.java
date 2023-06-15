package Unit7Listas;

public class Nodo {
    private String dato;
    private Nodo siguiente;

    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(String dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
