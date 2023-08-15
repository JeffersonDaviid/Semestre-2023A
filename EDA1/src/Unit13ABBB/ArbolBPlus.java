// package Unit13ABBB;

// /**
//  *
//  * @author Jefferson Chileno
//  */
// public class ArbolBPlus {

//     NodoArbolB root;// Definimos el nodo que sera la raiz de nuestro arbol
//     int gradoArbolB; // grado del arbol

//     // Constructor
//     public ArbolBPlus(int gradoArbolB) {
//         this.gradoArbolB = gradoArbolB;
//         root = new NodoArbolB(gradoArbolB);
//     }

//     /**
//      * Metodo que devuelve el nodo minimo | el nodo hoja más a la izquierda
//      * 
//      * @param nodoActual
//      * @return
//      */
//     public NodoArbolB buscarNodoHojaPorClave(int clave) {
//         if (root == null) {
//             return null;
//         }

//         NodoArbolB aux = root;

//         // Mientras no sea una hoja
//         while (aux.esNodoHoja == false && aux.numClavesEnNodo != (gradoArbolB * 2) - 1) {
//             // Se accede al primer hijo

//             for (int i = 0; i < aux.numClavesEnNodo; i++) {

//                 if (clave < aux.lsClaves[i] || clave < aux.lsClaves[i + 1]) {
//                     aux = aux.lsHijos[i];
//                     break;
//                 } else if ((clave < aux.lsClaves[i] && clave > aux.lsClaves[i + 1]) || clave > aux.lsClaves[i]) {
//                     aux = aux.lsHijos[i + 1];
//                     break;
//                 }

//             }

//         }

//         // Devuelve el nodo menor, el que esta mas a la izquierda
//         return aux;
//     }

//     // Si el nodo esta lleno lo debe separar antes de insertar
//     public void insertar(int clave) {
//         NodoArbolB auxRoot = root;
//         NodoArbolB hoja = buscarNodoHojaPorClave(clave);

//         // si la nodo hoja esta lleno hay que dividir primero
//         if (hoja.numClavesEnNodo == ((2 * gradoArbolB) - 1)) {
//             NodoArbolB s = new NodoArbolB(gradoArbolB);
//             root = s;
//             s.esNodoHoja = false;
//             s.numClavesEnNodo = 0;
//             int ii = 0;
//             // Busca la posicion del hijo
//             while (ii < auxRoot.numClavesEnNodo && clave > auxRoot.lsClaves[ii]) {
//                 ii++;
//             }
//             s.lsHijos[ii] = auxRoot;

//             split(s, ii, auxRoot);
//             hoja = buscarNodoHojaPorClave(clave);
//             hoja.numClavesEnNodo++;

//             nonFullInsert(hoja, clave);
//         } else {
//             nonFullInsert(hoja, clave);
//         }
//     }

//     // Caso cuando la raiz se divide
//     // x = | | | | | |
//     // /
//     // |10|20|30|40|50|
//     // i = 0
//     // oldNodoPadreLLeno = |10|20|30|40|50|
//     private void split(NodoArbolB newRoot, int i, NodoArbolB oldNodoPadreLLeno) {
//         // Nodo temporal que sera el hijo i + 1 de newRoot
//         NodoArbolB hijoDerechoTmp = new NodoArbolB(gradoArbolB);
//         hijoDerechoTmp.esNodoHoja = oldNodoPadreLLeno.esNodoHoja;
//         hijoDerechoTmp.numClavesEnNodo = (gradoArbolB - 1);

//         // Copia las ultimas (gradoArbolB - 1) claves del nodo oldNodoPadreLLeno al
//         // inicio del nodo
//         // hijoDerechoTmp |40|50| | | |
//         for (int j = 0; j < gradoArbolB; j++) {
//             hijoDerechoTmp.lsClaves[j] = oldNodoPadreLLeno.lsClaves[(j + gradoArbolB) - 1];
//             oldNodoPadreLLeno.lsClaves[(j + gradoArbolB) - 1] = -99;
//         }

//         // nuevo tamanio de oldNodoPadreLLeno // newRoot = | | | | | |
//         oldNodoPadreLLeno.numClavesEnNodo = gradoArbolB - 1; // |10|20| | | |

//         // +++++Mueve los hijos de newRoot para darle espacio a hijoDerechoTmp
//         for (int j = newRoot.numClavesEnNodo; j > i; j--) {
//             newRoot.lsHijos[(j + 1)] = newRoot.lsHijos[j];
//         }

//         // +++++Reasigna el hijo (i+1) de newRoot // newRoot = | | | | | |
//         newRoot.lsHijos[(i + 1)] = hijoDerechoTmp; // |10|20| | | | |40|50| | | |

//         // +++++Mueve las claves de newRoot
//         for (int j = newRoot.numClavesEnNodo; j > i; j--) {
//             newRoot.lsClaves[(j + 1)] = newRoot.lsClaves[j];
//         }

//         // Agrega la clave situada en la mediana // newRoot = |30| | | | |
//         newRoot.lsClaves[i] = hijoDerechoTmp.lsClaves[0]; // / \
//         newRoot.numClavesEnNodo++; // |10|20| | | | |40|50| | | |
//         System.out.println();
//     }

//     private void nonFullInsert(NodoArbolB nodoHoja, int clave) {

//         // Si es una hoja
//         if (nodoHoja.esNodoHoja == true) {
//             nodoHoja.lsClaves[nodoHoja.numClavesEnNodo] = clave;
//             ordenarPorInsercion(nodoHoja.lsClaves, nodoHoja.numClavesEnNodo);
//             nodoHoja.numClavesEnNodo++;

//         } else {
//             int j = 0;
//             // Busca la posicion del hijo
//             while (j < nodoHoja.numClavesEnNodo && clave > nodoHoja.lsClaves[j]) {
//                 j++;
//             }

//             // Si el nodo hijo esta lleno lo separa
//             if (nodoHoja.lsHijos[j].numClavesEnNodo == (2 * gradoArbolB - 1)) {
//                 split(nodoHoja, j, nodoHoja.lsHijos[j]);

//                 if (clave > nodoHoja.lsClaves[j]) {
//                     j++;
//                 }
//             }

//             nonFullInsert(nodoHoja.lsHijos[j], clave);
//         }

//     }

//     public static void ordenarPorInsercion(int[] listaDesordenada, int tamano) {

//         // int[] lista = { 20, 15, 15, 48, 632, 15, 18, 552 };
//         for (int i = 1; i <= tamano; i++) {

//             for (int j = i; j > 0; j--) {
//                 int aux = listaDesordenada[j];

//                 if (aux < listaDesordenada[j - 1]) {
//                     listaDesordenada[j] = listaDesordenada[j - 1];
//                     listaDesordenada[j - 1] = aux;
//                 } else
//                     break;
//             }

//         }

//     }

//     public void showBTree() {
//         print(root);
//     }

//     /**
//      * Metodo para imprimir los nodos en forma preorden
//      * 
//      * @param nodo
//      */
//     private void print(NodoArbolB nodo) {
//         nodo.imprimir();

//         // Si no es hoja
//         if (!nodo.esNodoHoja) {
//             // recorre los nodos para saber si tiene hijos
//             for (int j = 0; j <= nodo.numClavesEnNodo; j++) {
//                 if (nodo.lsHijos[j] != null) {
//                     System.out.println();
//                     print(nodo.lsHijos[j]);
//                 }
//             }
//         }
//     }

// }

package Unit13ABBB;

public class ArbolBPlus {

    private NodoArbolB raiz;
    private int gradoArbolB;
    private String dataPrint;

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
            while (i >= 0 && clave < nodo.lsClaves[i]) {
                nodo.lsClaves[i + 1] = nodo.lsClaves[i];
                i--;
            }
            nodo.lsClaves[i + 1] = clave;
            nodo.numClavesEnNodo++;
        } else {
            while (i >= 0 && clave < nodo.lsClaves[i]) {
                i--;
            }
            i++;
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

        hijoLleno.numClavesEnNodo = gradoArbolB - 1;

        for (int j = padre.numClavesEnNodo; j >= indiceHijoLleno + 1; j--) {
            padre.lsHijos[j + 1] = padre.lsHijos[j];
        }

        padre.lsHijos[indiceHijoLleno + 1] = nuevoHijo;

        for (int j = padre.numClavesEnNodo - 1; j >= indiceHijoLleno; j--) {
            padre.lsClaves[j + 1] = padre.lsClaves[j];
        }

        padre.lsClaves[indiceHijoLleno] = hijoLleno.lsClaves[gradoArbolB - 1];
        padre.numClavesEnNodo++;
    }

    // Otras funciones del árbol B+ (búsqueda, eliminación, etc.)

    // public static void main(String[] args) {
    // int gradoArbolB = 2; // Cambia el valor según el grado deseado
    // ArbolBPlus arbol = new ArbolBPlus(gradoArbolB);

    // // Inserta claves en el árbol
    // arbol.insertar(10);
    // arbol.insertar(20);
    // arbol.insertar(30);
    // arbol.insertar(40);
    // arbol.insertar(50);
    // }

    public void showBTree() {
        // print(raiz);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(print(raiz));
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
                    dataPrint += "\n" + nodo.lsHijos[j];
                }
            }
        }
        return dataPrint;
    }
}
