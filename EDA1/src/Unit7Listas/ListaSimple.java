package Unit7Listas;

import javax.swing.JOptionPane;

public class ListaSimple {
    private static String lista;
    private Nodo primero;

    public ListaSimple() {
        this.primero = null;
    }

    public static void mostrarLista(Nodo primerNodo) {
        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != null) {
            lista += nodoAux.getDato() + "-> ";
            nodoAux.setSiguiente(nodoAux.getSiguiente());
        }
        lista += nodoAux.getDato() + "-> NULL";
        JOptionPane.showMessageDialog(null, lista);

    }

    public static void crearNodoAlInicio() {

        Nodo primero = new Nodo(" primer dato ");

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            Nodo Q = new Nodo(info, primero);
            primero = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }

        mostrarLista(primero);

    }

    public static void main(String[] args) {
        crearNodoAlInicio();
    }
}