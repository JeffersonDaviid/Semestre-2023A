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

    // Constructores

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

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < numClavesEnNodo; i++) {
            if (i < numClavesEnNodo - 1) {
                System.out.print(lsClaves[i] + " | ");
            } else {
                System.out.print(lsClaves[i]);
            }
        }
        System.out.print("]");
    }

    /**
     * metodo para determinar si un dato ya se encuentra en el nodo/arbol
     * 
     * @param k dato a buscar
     * @return i: la posicion donde se lo ha encontrado o -1 si no ha sido
     *         encontrado
     */
    public int find(int k) {
        for (int i = 0; i < numClavesEnNodo; i++) {
            if (lsClaves[i] == k) {
                return i;
            }
        }
        return -1;
    }

}
