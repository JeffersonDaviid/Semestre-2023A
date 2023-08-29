package Unit12ABBAVL;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Instancia de un nuevo objeto ArbolAVL
        ArbolAVL arb = new ArbolAVL();
        int opcion;
        do {
            // Mostrar el menú al usuario y obtener la opción seleccionada
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja la opción que "
                    + "desea realizar en el árbol:"
                    + "\n1.-Crear un árbol"
                    + "\n2.-Insertar un nodo"
                    + "\n3.-Buscar"
                    + "\n4.-Borrar un nodo"
                    + "\n5.-Salida",
                    "MENU", JOptionPane.INFORMATION_MESSAGE));

            switch (opcion) {
                case 1:
                    // Opción 1: Crear un árbol y agregar nodos
                    int sw = 0;
                    do {
                        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                        // Insertar el valor ingresado en el árbol AVL
                        arb.insertar(valor);
                        sw = JOptionPane.showConfirmDialog(null, "Desea seguir ingresando más nodos");
                    } while (sw == JOptionPane.YES_OPTION);
                    System.out.println("\t ARBOL AVL");
                    // Mostrar el árbol AVL recorriéndolo en orden (inorden)
                    arb.recorridoInorden();
                    break;
                case 2:
                    // Opción 2: Insertar un nodo en el árbol
                    int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                    // Insertar el valor ingresado en el árbol AVL
                    arb.insertar(valor);
                    System.out.println("\t NUEVO ARBOL AVL");
                    // Mostrar el árbol AVL recorriéndolo en orden (inorden)
                    arb.recorridoInorden();
                    break;
                case 3:
                    // Opción 3: Buscar un valor en el árbol AVL
                    arb.buscarAVL(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la clave a buscar")));
                    break;
                case 4:
                    // Opción 4: Borrar un nodo del árbol AVL
                    arb.eliminar(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la clave a borrar")));
                    System.out.println("\tNUEVO ARBOL AVL");
                    // Mostrar el árbol AVL recorriéndolo en orden (inorden)
                    arb.recorridoInorden();
                    break;
                case 5:
                    // Opción 5: Salir del programa
                    opcion = 5;
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }
}
