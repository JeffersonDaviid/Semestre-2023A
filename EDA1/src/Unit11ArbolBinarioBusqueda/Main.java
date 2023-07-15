
package Unit11ArbolBinarioBusqueda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArbolBB arb = new ArbolBB();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escoja la opcion que desea realizar en el arbol:" + ""
                            + "\n1.-Crear un arbol"
                            + "\n2.-Insertar un nodo"
                            + "\n3.-Buscar"
                            + "\n4.-Borrar un nodo"
                            + "\n5.-Salida",
                    "MENU",
                    JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    int sw = 0;
                    do {
                        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                        arb.insertarNodo(valor);
                        sw = JOptionPane.showConfirmDialog(null, "Desea seguir ingresando más nodos");
                    } while (sw == JOptionPane.YES_OPTION);
                    System.out.println("\t ARBOL BINARIO DE BUSQUEDA");
                    arb.recorridoInorden();
                    break;
                case 2:
                    int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                    arb.insertarNodo(valor);
                    System.out.println("\t NUEVO ARBOL BINARIO DE BUSQUEDA");
                    arb.recorridoInorden();
                    break;
                case 3:
                    arb.buscarABB(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la clave a buscar")));
                    break;
                case 4:
                    arb.borrarABB(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la clave a borrar")));
                    System.out.println("\tNUEVO ARBOL");
                    arb.recorridoInorden();
                    break;
                case 5:
                    opcion = 5;
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }

}