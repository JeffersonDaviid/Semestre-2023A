import javax.swing.JOptionPane;

import Unit4Pilas.Pila;
import Unit4Pilas.PilaOperaciones;

public class RepasoExamen1 {
    public static void main(String[] args) {
        // ejercicio18();

        eliminarRepetidosSucesivos();

    }

    // -----------------------------------------------------------------------------------------------------------
    // MATRICES
    public static void ejercicio18() {
        String dataMatriz = "";
        int[][] matriz = new int[10][10];
        int[] numeroMayorColumna = new int[10];
        int[] numeroMayorFila = new int[10];

        // LLENAR LA MATRIZ CON DATOS ALEATORIOS
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.random() * (75 - 25 + 1) + 25);
                dataMatriz += matriz[i][j] + "   ";
            }
            dataMatriz += "\n";
        }

        for (int i = 0; i < numeroMayorFila.length; i++) {
            numeroMayorColumna[i] = numeroMayorFila[i] = -1;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                // Calcular el numero mayor en cada fila
                if (numeroMayorFila[i] == -1)
                    numeroMayorFila[i] = matriz[i][j];
                if (matriz[i][j] >= numeroMayorFila[i]) {
                    numeroMayorFila[i] = matriz[i][j];
                }

                // Calcular el numero mayor en cada columna
                if (numeroMayorColumna[i] == -1)
                    numeroMayorColumna[i] = matriz[j][i];

                if (matriz[j][i] >= numeroMayorColumna[i]) {
                    numeroMayorColumna[i] = matriz[j][i];
                }
            }

        }

        System.out.println(dataMatriz);

        System.out.println("El numero mas alto en cada columna");
        for (int i = 0; i < numeroMayorColumna.length; i++) {
            System.out.print(numeroMayorColumna[i] + ",   ");
        }
        System.out.println("\nEl numero mas alto en cada fila");
        for (int j = 0; j < numeroMayorFila.length; j++) {
            System.out.print(numeroMayorFila[j] + ",   ");
        }

    }

    // ----------------------------------------------------------------------------------------------------------
    // PILAS

    public   void eliminarRepetidosSucesivos() {
        PilaOperaciones pila1 = new PilaOperaciones(8);
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.insertarPila();
        pila1.mostrarPila();

        for (int i = 0; i <= pila1.Tope(); i++) {
if(  )
        }

        pila1.mostrarPila();

    }
}