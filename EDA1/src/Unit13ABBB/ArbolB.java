package Unit13ABBB;

/**
 *
 * @author Jefferson Chileno
 */
public class ArbolB {

    NodoArbolB root;// Definimos el nodo que sera la raiz de nuestro arbol
    int gradoArbolB; // grado del arbol

    // Constructor
    public ArbolB(int gradoArbolB) {
        this.gradoArbolB = gradoArbolB;
        root = new NodoArbolB(gradoArbolB);
    }

    public int buscarClaveMayor() {
        int claveMaxima = getClaveMayor(this.root);

        return claveMaxima;
    }

    private int getClaveMayor(NodoArbolB current) {
        if (current == null) {
            return 0;// Si es cero no existe
        }

        // Mientras no sea una hoja
        while (!current.esNodoHoja) {
            // Se accede al hijo mas a la derecha
            current = current.lsHijos[current.numClavesEnNodo];
        }

        // luego de pasar el while tendremos que nuestro nodo actual es una hoja

        return claveMayorPorNodo(current);
    }

    private int claveMayorPorNodo(NodoArbolB current) {
        // Devuelve el valor mayor, el que esta mas a la derecha
        return current.lsClaves[current.numClavesEnNodo - 1];
    }

    public void mostrarClavesNodoMinimo() {
        NodoArbolB temp = buscarNodoMinimo(root);

        if (temp == null) {
            System.out.println("Sin minimo");
        } else {
            temp.imprimir();
        }
    }

    public NodoArbolB buscarNodoMinimo(NodoArbolB nodoActual) {
        if (root == null) {
            return null;
        }

        NodoArbolB aux = root;

        // Mientras no sea una hoja
        while (!aux.esNodoHoja) {
            // Se accede al primer hijo
            aux = aux.lsHijos[0];
        }

        // Devuelve el nodo menor, el que esta mas a la izquierda
        return aux;
    }

    // Busca el valor ingresado y muestra el contenido del nodo que contiene el
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

    public void insertar(int clave) {
        NodoArbolB auxRoot = root;

        // Si el nodo esta lleno lo debe separar antes de insertar
        if (auxRoot.numClavesEnNodo == ((2 * gradoArbolB) - 1)) {
            NodoArbolB s = new NodoArbolB(gradoArbolB);
            root = s;
            s.esNodoHoja = false;
            s.numClavesEnNodo = 0;
            s.lsHijos[0] = auxRoot;
            split(s, 0, auxRoot);
            nonFullInsert(s, clave);
        } else {
            nonFullInsert(auxRoot, clave);
        }
    }

    // Caso cuando la raiz se divide
    // x = | | | | | |
    // /
    // |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        // Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(gradoArbolB);
        z.esNodoHoja = y.esNodoHoja;
        z.numClavesEnNodo = (gradoArbolB - 1);

        // Copia las ultimas (gradoArbolB - 1) claves del nodo y al inicio del nodo z //
        // z =
        // |40|50| | | |
        for (int j = 0; j < (gradoArbolB - 1); j++) {
            z.lsClaves[j] = y.lsClaves[(j + gradoArbolB)];
        }

        // Si no es hoja hay que reasignar los nodos hijos
        if (!y.esNodoHoja) {
            for (int k = 0; k < gradoArbolB; k++) {
                z.lsHijos[k] = y.lsHijos[(k + gradoArbolB)];
            }
        }

        // nuevo tamanio de y // x = | | | | | |
        y.numClavesEnNodo = (gradoArbolB - 1); // / \
        // |10|20| | | |
        // Mueve los hijos de x para darle espacio a z
        for (int j = x.numClavesEnNodo; j > i; j--) {
            x.lsHijos[(j + 1)] = x.lsHijos[j];
        }
        // Reasigna el hijo (i+1) de x // x = | | | | | |
        x.lsHijos[(i + 1)] = z; // / \
                                // |10|20| | | | |40|50| | | |
        // Mueve las claves de x
        for (int j = x.numClavesEnNodo; j > i; j--) {
            x.lsClaves[(j + 1)] = x.lsClaves[j];
        }

        // Agrega la clave situada en la mediana // x = |30| | | | |
        x.lsClaves[i] = y.lsClaves[(gradoArbolB - 1)]; // / \
        x.numClavesEnNodo++; // |10|20| | | | |40|50| | | |
    }

    private void nonFullInsert(NodoArbolB x, int clave) {
        // Si es una hoja
        if (x.esNodoHoja) {
            int i = x.numClavesEnNodo; // cantidad de valores del nodo
            // busca la posicion i donde asignar el valor
            while (i >= 1 && clave < x.lsClaves[i - 1]) {
                x.lsClaves[i] = x.lsClaves[i - 1];// Desplaza los valores mayores a clave
                i--;
            }

            x.lsClaves[i] = clave;// asigna el valor al nodo
            x.numClavesEnNodo++; // aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posicion del hijo
            while (j < x.numClavesEnNodo && clave > x.lsClaves[j]) {
                j++;
            }

            // Si el nodo hijo esta lleno lo separa
            if (x.lsHijos[j].numClavesEnNodo == (2 * gradoArbolB - 1)) {
                split(x, j, x.lsHijos[j]);

                if (clave > x.lsClaves[j]) {
                    j++;
                }
            }

            nonFullInsert(x.lsHijos[j], clave);
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
