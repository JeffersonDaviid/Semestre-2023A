
package Unit13ABBB;

public class ArbolBPlus {

    private NodoArbolB raiz;
    private int gradoArbolB;
    public static String dataPrint;

    public ArbolBPlus(int gradoArbolB) {
        this.gradoArbolB = gradoArbolB;
        raiz = new NodoArbolB(gradoArbolB);
    }

    public void insertar(int clave) {
        if (raiz.numClavesEnNodo == (2 * gradoArbolB - 1)) {
            NodoArbolB nuevaRaiz = new NodoArbolB(gradoArbolB);
            nuevaRaiz.esNodoHoja = false;
            nuevaRaiz.lsHijos[0] = raiz;
            split(nuevaRaiz, 0, raiz);
            raiz = nuevaRaiz;
        }
        nonFullInsert(raiz, clave);
    }

    private void nonFullInsert(NodoArbolB nodo, int clave) {
        int i = nodo.numClavesEnNodo - 1;

        if (nodo.esNodoHoja) {

            // Inserta el la posicion que le corresponde || ordena el array
            while (i >= 0 && clave < nodo.lsClaves[i]) {
                nodo.lsClaves[i + 1] = nodo.lsClaves[i];
                i--;
            }
            nodo.lsClaves[i + 1] = clave;
            nodo.numClavesEnNodo++;
        } else {
            // buscamos la posicion donde se tiene que dividir el nuevo nodo
            while (i >= 0 && clave < nodo.lsClaves[i]) {
                i--;
            }
            i++;

            // se verifica si el nodo esta lleno
            if (nodo.lsHijos[i].numClavesEnNodo == (2 * gradoArbolB - 1)) {
                split(nodo, i, nodo.lsHijos[i]);
                if (clave > nodo.lsClaves[i]) {
                    i++;
                }
            }
            nonFullInsert(nodo.lsHijos[i], clave);
        }
    }

    private void split(NodoArbolB padre, int indiceHijoLleno, NodoArbolB hijoLleno) {
        NodoArbolB nuevoHijo = new NodoArbolB(gradoArbolB);
        nuevoHijo.esNodoHoja = hijoLleno.esNodoHoja;
        nuevoHijo.numClavesEnNodo = gradoArbolB - 1;

        // el nuevo hijo se copia las claves mayores desde la mitad o (grado-1)/2
        for (int j = 0; j < gradoArbolB - 1; j++) {
            nuevoHijo.lsClaves[j] = hijoLleno.lsClaves[j + gradoArbolB];
            hijoLleno.lsClaves[j + gradoArbolB] = 0; // Restablecer valores en el hijo lleno
        }

        if (!hijoLleno.esNodoHoja) {
            for (int j = 0; j < gradoArbolB; j++) {
                nuevoHijo.lsHijos[j] = hijoLleno.lsHijos[j + gradoArbolB];
                hijoLleno.lsHijos[j + gradoArbolB] = null; // Restablecer referencias en el hijo lleno
            }
        }

        // luego de quitarle las claves al hijo lleno se reasigna su valor
        hijoLleno.numClavesEnNodo = gradoArbolB - 1;

        for (int j = padre.numClavesEnNodo; j >= indiceHijoLleno + 1; j--) {
            padre.lsHijos[j + 1] = padre.lsHijos[j];
        }
        // ubicacion del nuevo nodo hoja
        padre.lsHijos[indiceHijoLleno + 1] = nuevoHijo;

        for (int j = padre.numClavesEnNodo - 1; j >= indiceHijoLleno; j--) {
            padre.lsClaves[j + 1] = padre.lsClaves[j];
        }

        // se copia el valor del medio al nuevo padre
        padre.lsClaves[indiceHijoLleno] = hijoLleno.lsClaves[gradoArbolB - 1];
        padre.numClavesEnNodo++;
    }

    public void showBTree() {
        print(raiz);
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println();
        // System.out.println(print(raiz));
    }

    /**
     * Metodo para imprimir los nodos en forma preorden
     * 
     * @param nodo
     */
    private String print(NodoArbolB nodo) {
        nodo.imprimir();

        // dataPrint += nodo.imprimir();

        // Si no es hoja
        if (!nodo.esNodoHoja) {
            // recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= nodo.numClavesEnNodo; j++) {
                if (nodo.lsHijos[j] != null) {
                    System.out.println();
                    print(nodo.lsHijos[j]);
                    // dataPrint += "\n" + nodo.lsHijos[j];
                }
            }
        }
        return dataPrint;
    }

    public static void imprimirArbolBPlus(ArbolBPlus arbol) {
        imprimirNodo(arbol.raiz, "", true);
    }

    public static void imprimirNodo(NodoArbolB nodo, String prefijo, boolean esUltimo) {
        System.out.print(prefijo);
        dataPrint += prefijo;

        if (esUltimo) {
            System.out.print("└── ");
            prefijo += "    ";

            dataPrint += "└── ";
            dataPrint += prefijo;

        } else {
            System.out.print("├── ");
            prefijo += "│   ";

            dataPrint += "├── ";
            dataPrint += prefijo;
        }

        for (int i = 0; i < nodo.numClavesEnNodo; i++) {
            System.out.print(nodo.lsClaves[i]);

            dataPrint += nodo.lsClaves[i];

            if (i < nodo.numClavesEnNodo - 1) {
                System.out.print(", ");

                dataPrint += ", ";
            }
        }
        System.out.println();
        dataPrint += "\n";

        if (!nodo.esNodoHoja) {
            for (int i = 0; i <= nodo.numClavesEnNodo; i++) {
                NodoArbolB hijo = nodo.lsHijos[i];
                if (hijo != null) {
                    imprimirNodo(hijo, prefijo, i == nodo.numClavesEnNodo);
                }
            }
        }
    }

}
