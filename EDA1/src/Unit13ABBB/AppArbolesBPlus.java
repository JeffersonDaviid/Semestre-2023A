package Unit13ABBB;

/**
 *
 * @author Jefferson Chileno
 */
public class AppArbolesBPlus {
    public static void main(String[] args) {
        // grado minimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 3;
        // Se crea el arbol B segun t
        ArbolBPlus arbolBPlus = new ArbolBPlus(t);

        // Valores a ingresar primera ronda
        int[] valoresUno = { 20, 10, 50, 30, 40 };
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ARBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolBPlus.insertar(valoresUno[i]);
        }

        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolBPlus.showBTree();
        System.out.println("");

        // Valores a ingresar segunda ronda
        System.out.println("Insertando... valor 60");
        arbolBPlus.insertar(60);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolBPlus.showBTree();
        System.out.println("");

        // Valores a ingresar tercera ronda
        System.out.println("Insertando... valor 80");
        arbolBPlus.insertar(80);
        System.out.println("Insertando... valor 70");
        arbolBPlus.insertar(70);
        System.out.println("Insertando... valor 90");
        arbolBPlus.insertar(90);
        // Mostrando arbol B por pantalla en preorder
        System.out.println("ESTADO ARBOL B");
        arbolBPlus.showBTree();

        System.out.println("\n-- FIN --");
    }
}
