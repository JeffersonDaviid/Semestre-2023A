/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit12ABBAVL;

import javax.swing.JOptionPane;

/**
 *
 * @author Mayrita Carrion
 */
public class App {

    public static void main(String[] args) {
        // aplicación para Arbol AVL
        ArbolAVL arb = new ArbolAVL();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja laopcion que "
                    + "desea realizar en el arbol:"
                    + "\n1.-Crear un arbol"
                    + "\n2.-Insertar un nodo"
                    + "\n3.-Buscar"
                    + "\n4.-Borrar un nodo"
                    + "\n5.-Salida",
                    "MENU", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    int sw = 0;
                    do {
                        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                        arb.insertar(valor);
                        sw = JOptionPane.showConfirmDialog(null, "Desea seguir ingresando más nodos");
                    } while (sw == JOptionPane.YES_OPTION);
                    System.out.println("\t ARBOL AVL");
                    arb.recorridoInorden();
                    break;
                case 2:
                    int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor a insertar "));
                    arb.insertar(valor);
                    System.out.println("\t NUEVO ARBOL AVL");
                    arb.recorridoInorden();
                    break;
                case 3:
                    arb.buscarAVL(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la clave a buscar")));
                    break;
                case 4:
                    arb.eliminar(Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la clave a borrar")));
                    System.out.println("\tNUEVO ARBOL AVL");
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
