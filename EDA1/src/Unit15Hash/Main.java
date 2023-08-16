package Unit15Hash;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcion, opcion1;
        Hash3 vectorClaves = new Hash3();
        Hash3 vectorGuardar = new Hash3();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "MENU INICIAL:\n1.CREAR TABLA HASH (ARREGLO)\n2.SELECCIONAR METODOS HASH\n3.Salida", "Menu",
                    JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    vectorClaves = new Hash3("TABLA HASH(ARREGLO) CON CLAVES");
                    vectorGuardar = new Hash3(vectorClaves.getTamanio());
                    vectorClaves.ingresarClaves();
                    break;
                case 2:
                    opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "SELECCIONE QUE DESEA REALIZAR:\n1.Hash Módulo\n2.Hash cuadrado\n3.Hash por peglamiento\n4.Hash por truncamiento",
                            "MENU", JOptionPane.INFORMATION_MESSAGE));
                    switch (opcion1) {
                        case 1:
                            vectorGuardar.hashModulo(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 2:
                            vectorGuardar.hashCuadrado(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 3:
                            vectorGuardar.hashPlegamento(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        case 4:
                            vectorGuardar.hashTruncamiento(vectorClaves, vectorGuardar);
                            JOptionPane.showMessageDialog(null, vectorGuardar.salida(vectorGuardar));
                            break;
                        default:
                            break;
                    }
                default:
                    break;

            }

        } while (opcion != 3);
    }
}
