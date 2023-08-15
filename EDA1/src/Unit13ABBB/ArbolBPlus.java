package Unit13ABBB;

import java.text.BreakIterator;

/**
 *
 * @author Jefferson Chileno
 */
public class ArbolBPlus {

    NodoArbolB root;// Definimos el nodo que sera la raiz de nuestro arbol
    int gradoArbolB; // grado del arbol

    // Constructor
    public ArbolBPlus(int gradoArbolB) {
        this.gradoArbolB = gradoArbolB;
        root = new NodoArbolB(gradoArbolB);
    }

    /**
     * Metodo que devuelve el nodo minimo | el nodo hoja más a la izquierda
     * 
     * @param nodoActual
     * @return
     */
    public NodoArbolB buscarNodoHojaPorClave(int clave) {
        if (root == null) {
            return null;
        }

        NodoArbolB aux = root;

        // Mientras no sea una hoja
        while (aux.esNodoHoja == false && aux.numClavesEnNodo != (gradoArbolB * 2) - 1) {
            // Se accede al primer hijo

            for (int i = 0; i < aux.numClavesEnNodo; i++) {

                if (clave < aux.lsClaves[i] && clave < aux.lsClaves[i + 1]) {
                    aux = aux.lsHijos[i];
                    break;
                } else if ((clave < aux.lsClaves[i] && clave > aux.lsClaves[i + 1]) || clave > aux.lsClaves[i]) {
                    aux = aux.lsHijos[i + 1];
                    break;
                }

            }

        }

        // Devuelve el nodo menor, el que esta mas a la izquierda
        return aux;
    }

    // Busca el valor ingresado oldNodoPadreLLeno muestra el contenido del nodo que
    // contiene el
    // valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    // Search
    private NodoArbolB search(NodoArbolB actual, int clave) {
        int i = 0;// se empieza a buscar siempre en la primera posicion

        // Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.numClavesEnNodo && clave > actual.lsClaves[i]) {
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.numClavesEnNodo && clave == actual.lsClaves[i]) {
            return actual;
        }

        // Si llegamos hasta aqui, entonces hay que buscar los hijos
        // Se revisa primero si tiene hijos
        if (actual.esNodoHoja) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            return search(actual.lsHijos[i], clave);
        }
    }

    // Si el nodo esta lleno lo debe separar antes de insertar
    public void insertar(int clave) {
        NodoArbolB auxRoot = root;
        NodoArbolB hoja = buscarNodoHojaPorClave(clave);

        if (hoja.numClavesEnNodo == ((2 * gradoArbolB) - 1)) {
            NodoArbolB s = new NodoArbolB(gradoArbolB);
            root = s;
            s.esNodoHoja = false;
            s.numClavesEnNodo = 0;
            s.lsHijos[0] = auxRoot;

            split(s, 0, auxRoot);

            nonFullInsert(clave);
        } else {
            nonFullInsert(clave);
        }
    }

    // Caso cuando la raiz se divide
    // x = | | | | | |
    // /
    // |10|20|30|40|50|
    // i = 0
    // oldNodoPadreLLeno = |10|20|30|40|50|
    private void split(NodoArbolB newRoot, int i, NodoArbolB oldNodoPadreLLeno) {
        // Nodo temporal que sera el hijo i + 1 de newRoot
        NodoArbolB hijoDerechoTmp = new NodoArbolB(gradoArbolB);
        hijoDerechoTmp.esNodoHoja = oldNodoPadreLLeno.esNodoHoja;
        hijoDerechoTmp.numClavesEnNodo = (gradoArbolB - 1);

        // Copia las ultimas (gradoArbolB - 1) claves del nodo oldNodoPadreLLeno al
        // inicio del nodo
        // hijoDerechoTmp |40|50| | | |
        for (int j = 0; j < gradoArbolB; j++) {
            hijoDerechoTmp.lsClaves[j] = oldNodoPadreLLeno.lsClaves[(j + gradoArbolB) - 1];
            oldNodoPadreLLeno.lsClaves[(j + gradoArbolB) - 1] = -99;
        }

        // nuevo tamanio de oldNodoPadreLLeno // newRoot = | | | | | |
        oldNodoPadreLLeno.numClavesEnNodo = gradoArbolB - 1; // |10|20| | | |

        // +++++Mueve los hijos de newRoot para darle espacio a hijoDerechoTmp
        for (int j = newRoot.numClavesEnNodo; j > i; j--) {
            newRoot.lsHijos[(j + 1)] = newRoot.lsHijos[j];
        }

        // +++++Reasigna el hijo (i+1) de newRoot // newRoot = | | | | | |
        newRoot.lsHijos[(i + 1)] = hijoDerechoTmp; // |10|20| | | | |40|50| | | |

        // ++++Mueve las claves de newRoot
        for (int j = newRoot.numClavesEnNodo; j > i; j--) {
            newRoot.lsClaves[(j + 1)] = newRoot.lsClaves[j];
        }

        // Agrega la clave situada en la mediana // newRoot = |30| | | | |
        newRoot.lsClaves[i] = hijoDerechoTmp.lsClaves[0]; // / \
        newRoot.numClavesEnNodo++; // |10|20| | | | |40|50| | | |
        System.out.println();
    }

    private void nonFullInsert(int clave) {
        NodoArbolB nodoHoja = buscarNodoHojaPorClave(clave);

        nodoHoja.lsClaves[nodoHoja.numClavesEnNodo] = clave;
        ordenarPorInsercion(nodoHoja.lsClaves, nodoHoja.numClavesEnNodo);
        nodoHoja.numClavesEnNodo++;

    }

    public static void ordenarPorInsercion(int[] listaDesordenada, int tamano) {

        // int[] lista = { 20, 15, 15, 48, 632, 15, 18, 552 };
        for (int i = 1; i <= tamano; i++) {

            for (int j = i; j > 0; j--) {
                int aux = listaDesordenada[j];

                if (aux < listaDesordenada[j - 1]) {
                    listaDesordenada[j] = listaDesordenada[j - 1];
                    listaDesordenada[j - 1] = aux;
                } else
                    break;
            }

        }

    }

    public void showBTree() {
        print(root);
    }

    /**
     * Metodo para imprimir los nodos en forma preorden
     * 
     * @param nodo
     */
    private void print(NodoArbolB nodo) {
        nodo.imprimir();

        // Si no es hoja
        if (!nodo.esNodoHoja) {
            // recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= nodo.numClavesEnNodo; j++) {
                if (nodo.lsHijos[j] != null) {
                    System.out.println();
                    print(nodo.lsHijos[j]);
                }
            }
        }
    }

}
