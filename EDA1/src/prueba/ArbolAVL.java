/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javax.swing.JOptionPane;

/**
 *
 * @author Mayrita Carrion
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public ArbolAVL(NodoAVL raiz) {
        this.raiz = raiz;
    }

    public NodoAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAVL raiz) {
        this.raiz = raiz;
    }

    public void insertar(int valor) {

        Logical h = new Logical(false);

        this.raiz = insertarAvl(this.raiz, valor, h);
    }

    /*
     * Algoritmo insertarAvl(raizAux, dato, h)
     * Si raizAux es nulo entonces
     * raizAux = Nuevo NodoAVL con dato
     * h.setLogical(verdadero)
     * Sino si dato < raizAux.getInfo() entonces
     * NodoAVL ramaIz
     * ramaIz = insertarAvl(raizAux.getIzq(), dato, h)
     * raizAux.setIzq(ramaIz)
     * Si h.valorBoolean() entonces
     * Según raizAux.getFe() hacer
     * Caso 1:
     * raizAux.setFe(0)
     * h.setLogical(falso)
     * Caso 0:
     * raizAux.setFe(-1)
     * Caso -1:
     * nodo1 = raizAux.getIzq()
     * Si nodo1.getFe() == -1 entonces
     * raizAux = rotacionII(raizAux, nodo1)
     * Sino
     * raizAux = rotacionID(raizAux, nodo1)
     * h.setLogical(falso)
     * Fin Según
     * Sino si dato > raizAux.getInfo() entonces
     * NodoAVL ramaDe
     * ramaDe = insertarAvl(raizAux.getDer(), dato, h)
     * raizAux.setDer(ramaDe)
     * Si h.valorBoolean() entonces
     * Según raizAux.getFe() hacer
     * Caso 1:
     * nodo1 = raizAux.getDer()
     * Si nodo1.getFe() == +1 entonces
     * raizAux = rotacionDD(raizAux, nodo1)
     * Sino
     * raizAux = rotacionDI(raizAux, nodo1)
     * h.setLogical(falso)
     * Caso 0:
     * raizAux.setFe(+1)
     * Caso -1:
     * raizAux.setFe(0)
     * h.setLogical(falso)
     * Fin Según
     * Sino
     * Mostrar mensaje "No puede haber claves repetidas"
     * Fin si
     * Devolver raizAux
     * Fin insertarAvl
     */
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

    /*
     * Algoritmo Clase Logical
     * Clase Logical
     * Atributo v (boolean)
     * Método constructor Logical(f)
     * v = f
     * Método setLogical(f)
     * v = f
     * Método valorBoolean()
     * Devolver v
     * Fin Clase Logical
     */
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

    /*
     * Algoritmo rotacionII(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.derecha = nodo1
     * Si nodo2.factorEquilibrio es igual a -1 entonces
     * nodo1.factorEquilibrio = 0
     * nodo2.factorEquilibrio = 0
     * Sino
     * nodo1.factorEquilibrio = -1
     * nodo2.factorEquilibrio = 1
     * Fin Si
     * Devolver nodo2
     * Fin Método rotacionII
     */
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

    /*
     * Algoritmo rotacionDD(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.izquierda = nodo1
     * Si nodo2.fe es +1 entonces
     * nodo1.fe = 0
     * nodo2.fe = 0
     * Sino
     * nodo1.fe = +1
     * nodo2.fe = -1
     * Fin si
     * Devolver nodo2
     * Fin rotacionDD
     */
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

    /*
     * Algoritmo rotacionID(nodo1, nodo2)
     * Declarar n3 como NodoAVL
     * n3 = nodo2.derecha
     * nodo1.izquierda = n3.derecha
     * n3.derecha = nodo1
     * nodo2.derecha = n3.izquierda
     * n3.izquierda = nodo2
     * Si n3.fe es +1 entonces
     * nodo2.fe = -1
     * Sino
     * nodo2.fe = 0
     * Fin si
     * Si n3.fe es -1 entonces
     * nodo1.fe = 1
     * Sino
     * nodo1.fe = 0
     * n3.fe = 0
     * Fin si
     * Devolver n3
     * Fin rotacionID
     */
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

    /*
     * Algoritmo rotacionDI(nodo1, nodo2)
     * Declarar nodo3 como NodoAVL
     * nodo3 = nodo2.izquierda
     * nodo1.derecha = nodo3.izquierda
     * nodo3.izquierda = nodo1
     * nodo2.izquierda = nodo3.derecha
     * nodo3.derecha = nodo2
     * Si nodo3.fe es +1 entonces
     * nodo1.fe = -1
     * Sino
     * nodo1.fe = 0
     * Fin si
     * Si nodo3.fe es -1 entonces
     * nodo2.fe = 1
     * Sino
     * nodo2.fe = 0
     * nodo3.fe = 0
     * Fin si
     * Devolver nodo3
     * Fin rotacionDI
     */
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

    /*
     * Algoritmo numNodos(raiz)
     * Si raiz es nula entonces
     * Devolver 0
     * Sino
     * Devolver 1 + numNodos(raiz.izquierda) + numNodos(raiz.derecha)
     * Fin si
     * Fin numNodos
     */
    public int numNodos(NodoAVL raiz) {
        // recursividad para contar el numero de nodos de todo el árbol
        if (raiz == null) {
            return 0;
        } else {
            return 1 + numNodos(raiz.getIzq()) + numNodos(raiz.getDer());
        }
    }

    public void eliminar(int valor) {
        Logical flag = new Logical(false);
        this.raiz = borrarAvl(this.raiz, valor, flag);
    }

    /*
     * Algoritmo rotacionDD(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.izquierda = nodo1
     * Si nodo2.fe es +1 entonces
     * nodo1.fe = 0
     * nodo2.fe = 0
     * Sino
     * nodo1.fe = +1
     * nodo2.fe = -1
     * Fin si
     * Devolver nodo2
     * Fin rotacionDD
     */
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

    /*
     * Algoritmo reemplazar(nodo, nodoAct, cambiaAltura)
     * Si nodoAct.derecha no es nulo entonces
     * NodoAVL auxi
     * auxi = reemplazar(nodo, nodoAct.derecha, cambiaAltura)
     * nodoAct.setDer(auxi)
     * Si cambiaAltura.valorBoolean() entonces
     * nodoAct = equilibrar2(nodoAct, cambiaAltura)
     * Fin si
     * Sino
     * nodo.setInfo(nodoAct.getInfo())
     * nodo = nodoAct
     * nodoAct = nodoAct.izquierda
     * nodo = nulo
     * cambiaAltura.setLogical(verdadero)
     * Fin si
     * Devolver nodoAct
     * Fin reemplazar
     */
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

    /*
     * Algoritmo rotacionDD(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.izquierda = nodo1
     * Si nodo2.fe es +1 entonces
     * nodo1.fe = 0
     * nodo2.fe = 0
     * Sino
     * nodo1.fe = +1
     * nodo2.fe = -1
     * Fin si
     * Devolver nodo2
     * Fin rotacionDD
     */
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

    /*
     * Algoritmo rotacionDD(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.izquierda = nodo1
     * Si nodo2.fe es +1 entonces
     * nodo1.fe = 0
     * nodo2.fe = 0
     * Sino
     * nodo1.fe = +1
     * nodo2.fe = -1
     * Fin si
     * Devolver nodo2
     * Fin rotacionDD
     */
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

    public void buscarAVL(int clave) {
        NodoAVL aux = new NodoAVL();
        aux = ayudanteBuscar(this.raiz, clave);
    }

    NodoAVL aux = new NodoAVL();

    /*
     * Algoritmo rotacionDD(nodo1, nodo2)
     * nodo1.izquierda = nodo2.derecha
     * nodo2.izquierda = nodo1
     * Si nodo2.fe es +1 entonces
     * nodo1.fe = 0
     * nodo2.fe = 0
     * Sino
     * nodo1.fe = +1
     * nodo2.fe = -1
     * Fin si
     * Devolver nodo2
     * Fin rotacionDD
     */
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

    public void recorridoInorden() {
        ayudanteInorden(this.raiz);
    }

    public void ayudanteInorden(NodoAVL nod) {

        if (nod == null) {
            return;
        }

        ayudanteInorden(nod.getIzq());

        System.out.println("\t" + nod.getInfo());

        ayudanteInorden(nod.getDer());
    }

}
