package Unit5Colas;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int tamano, opcion;
        tamano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la cola simple: "));
        ColaSimple cola = new ColaSimple(tamano);

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU\nEscoga la opcion que desee realizar en la cola simple: \n1. Ingresar un dato\n2. Eliminar un dato\n3. Visualizar cola\n4. Salir"));

            switch (opcion) {
                case 1:
                    cola.InsertarCola(JOptionPane.showInputDialog("Ingrese el nombre a insertar"));
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 2:
                    cola.eliminarCola();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 4:
                    opcion = 4;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se ha ingresado una opcion valida");
                    break;

            }
        } while (opcion != 4);
    }
}
