package Unit13ABBB;

/**
 *
 * @author Jefferson Chileno
 */
public class NodoArbolB {

    int numClavesEnNodo; // numero de claves almacenadas en el nodo
    boolean esNodoHoja; // Si el nodo es hoja (nodo hoja=true; nodo interno=false)
    int lsClaves[]; // almacena las claves en el nodo
    NodoArbolB lsHijos[]; // arreglo con referencias a los lsHijos

    /**
     * Cada nodo puede tener como máximo "2*t - 1" claves.
     * Cada nodo (excepto la raíz) debe tener como mínimo "t - 1" claves.
     * Cada nodo puede tener como máximo "2*t" Hijos.
     * Cada nodo (excepto la raíz) debe tener como mínimo "t" Hijos.
     * 
     * @param t representa el grado del arbol
     */
    public NodoArbolB(int gradoArbolB) {
        numClavesEnNodo = 0;
        esNodoHoja = true;
        lsClaves = new int[((2 * gradoArbolB) - 1)];// num max de claves
        lsHijos = new NodoArbolB[(2 * gradoArbolB)];// num max de Hijos
    }

    public String data;

    public String imprimir() {
        System.out.print("[");
        data += "[";

        for (int i = 0; i < numClavesEnNodo; i++) {
            if (i < numClavesEnNodo - 1) {
                System.out.print(lsClaves[i] + " | ");
                data += lsClaves[i] + " | ";

            } else {
                System.out.print(lsClaves[i]);
                data += lsClaves[i];
            }
        }
        System.out.print("]");
        data += "]";

        return data;
    }

}
