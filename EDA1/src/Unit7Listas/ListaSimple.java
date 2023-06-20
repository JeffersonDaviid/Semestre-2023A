package Unit7Listas;

import javax.swing.JOptionPane;

public class ListaSimple {
    private static String lista = "";

    public static void mostrarLista(Nodo primerNodo) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return;
        }

        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != null || nodoAux == null) {
            lista += nodoAux.getDato() + "-> ";
            nodoAux = nodoAux.getSiguiente();
        }
        lista += nodoAux.getDato() + "-> NULL";
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }

    public static Nodo crearNodoAlInicio() {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo primero = new Nodo(info);

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            Nodo Q = new Nodo(info, primero);
            primero = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }

        return primero;

    }

    public static Nodo crearNodoAlFinal() {
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
        return primero;
    }

    public static void buscarNodoEnLista(Nodo primerNodo, String datoSolicitado) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "No se puede buscar en lista vacía");
            return;
        }

        Nodo nodoAux = primerNodo;
        boolean isFind = false;
        int position = 0;
        while (nodoAux != null && isFind == false) {
            position++;
            if ((nodoAux.getDato().equals(datoSolicitado)))
                isFind = true;

            nodoAux = nodoAux.getSiguiente();
        }

        JOptionPane.showMessageDialog(null,
                isFind ? "El dato '" + datoSolicitado + "' se encuentra en el nodo #" + position
                        : "El dato '" + datoSolicitado + "' no se encuentra en la lista simple");

    }

    public static Nodo eliminarAlFinal(Nodo primerNodo) {
        if (primerNodo == null || primerNodo.getSiguiente() == null)
            return null;

        Nodo nodoPenultimo = primerNodo;
        Nodo nodoUltimo = primerNodo.getSiguiente();

        while (nodoUltimo.getSiguiente() != null) {
            nodoPenultimo = nodoUltimo;
            nodoUltimo = nodoUltimo.getSiguiente();
        }
        nodoPenultimo.setSiguiente(null);

        return primerNodo;
    }

    public static Nodo eliminarAlInicio(Nodo primerNodo) {
        if (primerNodo == null || primerNodo.getSiguiente() == null)
            return null;

        primerNodo = primerNodo.getSiguiente();

        return primerNodo;
    }

    public static void main(String[] args) {
        int option = -1;
        Nodo nodoPermanente = null;
        do {

            switch (option = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Seleccione la opcion:\n1. Crear lista con nodos al inicio\n2. Crear lista con nodo al final\n3. Mostrar lista\n4. Buscar elemento en lista\n5. Insertar nodo al inicio\n6. Insertar nodo al final\n7. Eliminar nodo al inicio\n8. Eliminar nodo al final\n0. Salir"))) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;
                case 1:
                    nodoPermanente = crearNodoAlInicio();
                    break;
                case 2:
                    nodoPermanente = crearNodoAlFinal();
                    break;
                case 3:
                    mostrarLista(nodoPermanente);
                    break;
                case 4:
                    buscarNodoEnLista(nodoPermanente,
                            JOptionPane.showInputDialog(null, "Ingrese el dato que desea buscar en la lista simple: "));
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    nodoPermanente = eliminarAlInicio(nodoPermanente);
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    break;
                case 8:
                    nodoPermanente = eliminarAlFinal(nodoPermanente);
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es válida");
                    break;

            }
        } while (option != 0);
    }
}