package Unit12ABBAVLPersonal;

import javax.swing.JOptionPane;

public class ArbolAVL {

    // Atributos de la clase ArbolAVL
    private NodoAVL raiz; // La raíz del árbol AVL.

    // Constructor sin parámetros: Inicializa un árbol AVL vacío.
    public ArbolAVL() {
        this.raiz = null;

    }

    // Constructor con parámetro raiz: Inicializa un árbol AVL con la raíz
    // especificada.
    public ArbolAVL(NodoAVL raiz) {
        this.raiz = raiz;
    }

    // Método para obtener la raíz del árbol AVL.
    public NodoAVL getRaiz() {
        return raiz;
    }

    // Método para establecer la raíz del árbol AVL.
    public void setRaiz(NodoAVL raiz) {
        this.raiz = raiz;
    }

    // Método para insertar un valor en el árbol AVL.
    // El método se encarga de mantener el árbol balanceado después de la inserción.
    public void insertar(int valor) {
        Logical h = new Logical(false);
        this.raiz = insertarAvl(this.raiz, valor, h);
    }

    // Método privado para realizar la inserción de un valor en el árbol AVL.
    // Este método es usado internamente por el método insertar.
    private NodoAVL insertarAvl(NodoAVL raizAux, int dato, Logical h) {

        NodoAVL nodo1;
        if (raizAux == null) {
            raizAux = new NodoAVL(dato);
            h.setLogical(true);
        } else if (dato < raizAux.getInfo()) {
            NodoAVL ramaIz;
            ramaIz = insertarAvl(raizAux.getIzq(), dato, h);
            raizAux.setIzq(ramaIz);
            if (h.valorBoolean()) {
                switch (raizAux.getFe()) {
                    case 1:
                        raizAux.setFe(0);
                        h.setLogical(false);
                        break;
                    case 0:
                        raizAux.setFe(-1);
                        break;
                    case -1:
                        nodo1 = raizAux.getIzq();
                        if (nodo1.getFe() == -1) {
                            raizAux = rotacionII(raizAux, nodo1);
                        } else {
                            raizAux = rotacionID(raizAux, nodo1);
                            h.setLogical(false);
                        }
                }
            }
        } else if (dato > raizAux.getInfo()) {
            NodoAVL ramaDe;
            ramaDe = insertarAvl(raizAux.getDer(), dato, h);
            raizAux.setDer(ramaDe);
            if (h.valorBoolean()) {
                switch (raizAux.getFe()) {
                    case 1:
                        nodo1 = raizAux.getDer();
                        if (nodo1.getFe() == +1) {
                            raizAux = rotacionDD(raizAux, nodo1);
                        } else {
                            raizAux = rotacionDI(raizAux, nodo1);
                            h.setLogical(false);
                        }
                        break;
                    case 0:
                        raizAux.setFe(+1);
                        break;
                    case -1:
                        raizAux.setFe(0);
                        h.setLogical(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No puede haber claves repetidas ");
        }
        return raizAux;
    }

    // Clase interna Logical: Utilizada para representar un valor lógico que puede
    // ser modificado por referencia.
    // En este caso, se utiliza para llevar información sobre si ocurrió una
    // rotación durante la inserción.
    public class Logical {
        boolean v;

        public Logical(boolean f) {
            v = f;
        }

        public void setLogical(boolean f) {
            v = f;
        }

        public boolean valorBoolean() {
            return v;
        }
    }

    // Método para realizar una rotación simple izquierda-izquierda (II) para el
    // balanceo del árbol AVL.
    // Es un tipo de rotación utilizada durante la inserción para mantener el
    // balance del árbol.
    private NodoAVL rotacionII(NodoAVL nodo1, NodoAVL nodo2) {
        nodo1.setIzq(nodo2.getDer());
        nodo2.setDer(nodo1);
        if (nodo2.getFe() == -1) {
            nodo1.setFe(0);
            nodo2.setFe(0);
        } else {
            nodo1.setFe(-1);
            nodo2.setFe(1);
        }
        return nodo2;
    }

    // Método para realizar una rotación simple derecha-derecha (DD) para el
    // balanceo del árbol AVL.
    // Es otro tipo de rotación utilizada durante la inserción para mantener el
    // balance del árbol.
    private NodoAVL rotacionDD(NodoAVL nodo1, NodoAVL nodo2) {
        nodo1.setDer(nodo2.getIzq());
        nodo2.setIzq(nodo1);
        if (nodo2.getFe() == +1) {
            nodo1.setFe(0);
            nodo2.setFe(0);
        } else {
            nodo1.setFe(+1);
            nodo2.setFe(-1);
        }
        return nodo2;
    }

    // Método para realizar una rotación doble izquierda-derecha (ID) para el
    // balanceo del árbol AVL.
    // Es otro tipo de rotación utilizada durante la inserción para mantener el
    // balance del árbol.
    private NodoAVL rotacionID(NodoAVL nodo1, NodoAVL nodo2) {
        NodoAVL n3;
        n3 = nodo2.getDer();
        nodo1.setIzq(n3.getDer());
        n3.setDer(nodo1);
        nodo2.setDer(n3.getIzq());
        n3.setIzq(nodo2);
        if (n3.getFe() == +1) {
            nodo2.setFe(-1);
        } else {
            nodo2.setFe(0);
        }
        if (n3.getFe() == -1) {
            nodo1.setFe(1);
        } else {
            nodo1.setFe(0);
            n3.setFe(0);
        }
        return n3;
    }

    // Método para realizar una rotación doble derecha-izquierda (DI) para el
    // balanceo del árbol AVL.
    // Es otro tipo de rotación utilizada durante la inserción para mantener el
    // balance del árbol.
    private NodoAVL rotacionDI(NodoAVL nodo1, NodoAVL nodo2) {
        NodoAVL nodo3;
        nodo3 = nodo2.getIzq();
        nodo1.setDer(nodo3.getIzq());
        nodo3.setIzq(nodo1);
        nodo2.setIzq(nodo3.getDer());
        nodo3.setDer(nodo2);
        if (nodo3.getFe() == +1) {
            nodo1.setFe(-1);
        } else {
            nodo1.setFe(0);
        }
        if (nodo3.getFe() == -1) {
            nodo2.setFe(1);
        } else {
            nodo2.setFe(0);
            nodo3.setFe(0);
        }
        return nodo3;
    }

    // Método para contar el número de nodos en el árbol AVL.
    public int numNodos(NodoAVL raiz) {
        // Método recursivo que cuenta el número de nodos en todo el árbol.
        if (raiz == null) {
            return 0;
        } else {
            return 1 + numNodos(raiz.getIzq()) + numNodos(raiz.getDer());
        }
    }

    // Método para eliminar un valor del árbol AVL.
    // El método se encarga de mantener el árbol balanceado después de la
    // eliminación.
    public void eliminar(int valor) {
        Logical flag = new Logical(false);
        this.raiz = borrarAvl(this.raiz, valor, flag);
    }

    // Método privado para realizar la eliminación de un valor del árbol AVL.
    // Este método es usado internamente por el método eliminar.
    private NodoAVL borrarAvl(NodoAVL nuevaRaiz, int clave, Logical cambiaAltura) {

        if (nuevaRaiz == null) {
            JOptionPane.showMessageDialog(null, " Nodo no encontrado ");
        } else if (clave < nuevaRaiz.getInfo()) {
            NodoAVL iz;
            iz = borrarAvl(nuevaRaiz.getIzq(), clave, cambiaAltura);
            nuevaRaiz.setIzq(iz);
            if (cambiaAltura.valorBoolean()) { //
                nuevaRaiz = equilibrar1(nuevaRaiz, cambiaAltura);
            }
        } else if (clave > nuevaRaiz.getInfo()) {
            NodoAVL dr;
            dr = borrarAvl(nuevaRaiz.getDer(), clave, cambiaAltura);
            nuevaRaiz.setDer(dr);
            if (cambiaAltura.valorBoolean())
                nuevaRaiz = equilibrar2(nuevaRaiz, cambiaAltura);
        } else // Nodo encontrado
        {
            NodoAVL nodoQ;
            nodoQ = nuevaRaiz;
            if (nodoQ.getIzq() == null) {
                nuevaRaiz = nodoQ.getDer();
                cambiaAltura.setLogical(true);
            } else if (nodoQ.getDer() == null) {
                nuevaRaiz = nodoQ.getIzq();
                cambiaAltura.setLogical(true);
            } else {
                NodoAVL nodoIz;
                nodoIz = reemplazar(nuevaRaiz, nuevaRaiz.getIzq(),
                        cambiaAltura);
                nuevaRaiz.setIzq(nodoIz);
                if (cambiaAltura.valorBoolean())
                    nuevaRaiz = equilibrar1(nuevaRaiz, cambiaAltura);
            }
            nodoQ = null;
        }
        return nuevaRaiz;
    }

    // Método privado para encontrar el sucesor de un nodo al eliminar.
    private NodoAVL reemplazar(NodoAVL nodo, NodoAVL nodoAct, Logical cambiaAltura) {
        if (nodoAct.getDer() != null) {
            NodoAVL auxi;
            auxi = reemplazar(nodo, nodoAct.getDer(), cambiaAltura);
            nodoAct.setDer(auxi);
            if (cambiaAltura.valorBoolean())
                nodoAct = equilibrar2(nodoAct, cambiaAltura);
        } else {
            nodo.setInfo(nodoAct.getInfo());
            nodo = nodoAct;
            nodoAct = nodoAct.getIzq();
            nodo = null;
            cambiaAltura.setLogical(true);
        }
        return nodoAct;
    }

    // Método privado para equilibrar el árbol AVL después de una eliminación (caso
    // 1).
    private NodoAVL equilibrar1(NodoAVL nodo1, Logical cambiaAltura) {
        NodoAVL nodo2 = nodo1.getIzq(); // Initialize nodo2 to the left child of nodo1
        switch (nodo1.getFe()) {
            case -1:
                nodo1.setFe(0);
                break;
            case 0:
                nodo1.setFe(1);
                cambiaAltura.setLogical(false);
                break;
            case +1:
                if (nodo2.getFe() >= 0) {
                    if (nodo2.getFe() == 0)
                        cambiaAltura.setLogical(false);
                    nodo1 = rotacionDD(nodo1, nodo2);
                } else
                    nodo1 = rotacionDI(nodo1, nodo2);
                break;
        }
        return nodo1;
    }

    // Método privado para equilibrar el árbol AVL después de una eliminación (caso
    // 2).
    private NodoAVL equilibrar2(NodoAVL nodo1, Logical cambiaAltura) {
        NodoAVL nodo2;
        switch (nodo1.getFe()) {
            case -1:
                nodo2 = nodo1.getIzq();
                if (nodo2.getFe() <= 0) {
                    if (nodo2.getFe() == 0)
                        cambiaAltura.setLogical(false);
                    nodo1 = rotacionII(nodo1, nodo2);
                } else
                    nodo1 = rotacionID(nodo1, nodo2);
                break;
            case 0:
                nodo1.setFe(-1);
                cambiaAltura.setLogical(false);
                break;
            case +1:
                nodo1.setFe(0);
                break;
        }
        return nodo1;
    }

    // Método para buscar un valor en el árbol AVL.
    public void buscarAVL(int clave) {
        NodoAVL aux = new NodoAVL();
        aux = ayudanteBuscar(this.raiz, clave);
    }

    NodoAVL aux = new NodoAVL(); // Instancia de una variable aux de la clase NodoAVL()

    // Método privado para buscar un valor en el árbol AVL.
    // Este método es usado internamente por el método buscarAVL.
    public NodoAVL ayudanteBuscar(NodoAVL nod, int clave) {
        if (nod.getInfo() == clave) {
            JOptionPane.showMessageDialog(null, "Clave encontrada");
            this.aux = nod;
        } else {
            if (clave < nod.getInfo()) {
                if (nod.getIzq() != null) {
                    ayudanteBuscar(nod.getIzq(), clave);
                } else {
                    JOptionPane.showMessageDialog(null, "Clave No encontrada");
                }
            } else {
                if (clave > nod.getInfo()) {
                    if (nod.getDer() != null) {
                        ayudanteBuscar(nod.getDer(), clave);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Clave No encontrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Clave No encontrada");
                }
            }
        }
        return this.aux;
    }

    // Método para realizar un recorrido inorden del árbol AVL.
    // Imprime los valores en orden ascendente.
    public void recorridoInorden() {
        ayudanteInorden(this.raiz);
    }

    // Método privado para realizar el recorrido inorden del árbol AVL.
    // Este método es usado internamente por el método público recorridoInorden.
    public void ayudanteInorden(NodoAVL nod) {
        if (nod == null) {
            return;
        }
        ayudanteInorden(nod.getIzq());
        System.out.println("\t" + nod.getInfo());
        ayudanteInorden(nod.getDer());
    }
}
