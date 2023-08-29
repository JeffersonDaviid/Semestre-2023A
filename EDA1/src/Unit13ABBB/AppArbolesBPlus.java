package Unit13ABBB;

import javax.swing.JOptionPane;

/**
 *
 * @author Jefferson Chileno
 */
public class AppArbolesBPlus {
    public static void main(String[] args) {
        // grado minimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int gradoArbol = 2;
        // Se crea el arbol B segun gradoArbol
        ArbolBPlus arbolBPlus = new ArbolBPlus(gradoArbol);

        int[] valoresUno = { 20, 10, 50, 30, 40, 60, 70, 90, 100, 105 };
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolBPlus.insertar(valoresUno[i]);
        }

        System.out.println("\nARBOL B+");
        arbolBPlus.imprimirArbolBPlus(arbolBPlus);
        System.out.println("\n-- FIN --");

        JOptionPane.showMessageDialog(null, arbolBPlus.dataPrint);
    }

}
