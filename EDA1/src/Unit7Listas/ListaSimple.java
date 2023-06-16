package Unit7Listas;

import javax.swing.JOptionPane;

public class ListaSimple {
    private static String lista = "";

    public static void mostrarLista(Nodo primerNodo) {
        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != null) {
            lista += nodoAux.getDato() + "-> ";
            nodoAux = nodoAux.getSiguiente();
        }
        lista += nodoAux.getDato() + "-> NULL";
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }

    public static void crearNodoAlInicio() {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo primero = new Nodo(info);

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            Nodo Q = new Nodo(info, primero);
            primero = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }

        mostrarLista(primero);

    }

    public static void crearNodoAlFinal() {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo primero = new Nodo(info);
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            Nodo nodoAux = primero;
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            Nodo nuevoNodo = new Nodo(info);
            nodoAux.setSiguiente(nuevoNodo);
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }
        mostrarLista(primero);
        info = JOptionPane.showInputDialog(null, "Ingrese el dato que desea buscar en la lista");
        buscarNodoEnLista(primero, info);
    }

    public static void buscarNodoEnLista(Nodo primerNodo, String datoSolicitado) {
        Nodo nodoAux = primerNodo;
        boolean isFind = false;
        int position = 0;
        while (nodoAux.getSiguiente() != null && isFind == false) {
            position++;
            if (datoSolicitado.equals(nodoAux.getDato()))
                isFind = true;

            nodoAux = nodoAux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, "El dato '" + datoSolicitado + "' se encuentra en el nodo #" + position);
    }

    public static void main(String[] args) {
        // crearNodoAlInicio();
        crearNodoAlFinal();
    }
}