package Unit11ArbolBinarioBusqueda;

import javax.swing.*;

/*
ALGORITMO PARA BUSQUEDA EN ABB 
 1. Si (APNODO = NULL)
    entonces
    1.1 Si INFOR < APNODO*.INFO)
        entonces
            Regresar a Búsqueda_v1_ABB con APNODO*.IZQ e INFOR
            (Llamada recursiva)
    sino
        1.1.1 Si (INFOR > NODO*.INFO)
                entonces
                    Regresar a Búsqueda_v1_ABB con APNODO*.DER e INFOR
                    (Llamada recursiva)
                sino
                    Escribir “La información se encuentra en el árbol”
        1.1.2 (Fin del condicional del paso 1.1.1)
    1.2 (Fin del condicional del paso 1.1)
    sino
        Escribir “La información no se encuentra en el árbol”
2. (Fin del condicional del paso 1)
 */

public class ArbolBB {

    private Nodo2 raiz;

    public ArbolBB() {
        super();
        this.raiz = null;
    }

    public Nodo2 getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo2 raiz) {
        this.raiz = raiz;
    }

    public void insertarNodo(int valorInsertar) {
        if (this.raiz == null) {
            this.raiz = new Nodo2(valorInsertar);
        } else {
            this.raiz.insertar(valorInsertar);
        }
    }

    public void buscarABB(int clave) {
        Nodo2 aux2 = new Nodo2();
        aux2 = ayudanteBuscar(this.raiz, clave);
        System.out.println(aux2.getInfo());
    }

    Nodo2 aux = new Nodo2();

    public Nodo2 ayudanteBuscar(Nodo2 nod, int clave) {
        if (nod.getInfo() == clave) {
            JOptionPane.showMessageDialog(null, "Clave encontrada, sus datos son:" + nod.getInfo());
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
                        JOptionPane.showMessageDialog(null, "Clave No encontrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Clave No encontrada");
                }
            }
        }
        return this.aux;
    }

    // Yungan
    public void borrarABB(int clave) {
        Nodo2 nodBorrar = ayudanteBuscar(this.raiz, clave);
        if (nodBorrar != null) {
            if (nodBorrar.getIzq() == null && nodBorrar.getDer() == null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIzq() != null) {
                    if (padre.getIzq().getInfo() == nodBorrar.getInfo()) {
                        padre.setIzq(null);
                    }
                }
                if (padre.getDer() != null) {
                    if (padre.getDer().getInfo() == nodBorrar.getInfo()) {
                        padre.setDer(null);
                    }
                }
                borrarNodo(this.raiz, padre);
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIzq() == null && nodBorrar.getDer() != null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIzq() != null) {
                    if (padre.getIzq().getInfo() == nodBorrar.getInfo()) {
                        padre.setIzq(nodBorrar.getDer());
                    }
                }
                if (padre.getDer() != null) {
                    if (padre.getDer().getInfo() == nodBorrar.getInfo()) {
                        padre.setDer(nodBorrar.getDer());
                    }
                }
                borrarNodo(this.raiz, padre);
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIzq() != null && nodBorrar.getDer() == null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIzq().getInfo() == nodBorrar.getInfo()) {
                    padre.setIzq(nodBorrar.getIzq());
                }
                if (padre.getDer().getInfo() == nodBorrar.getInfo()) {
                    padre.setDer(nodBorrar.getIzq());
                }
                borrarNodo(this.raiz, padre);
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIzq() != null && nodBorrar.getDer() != null) {
                this.aux = null;
                Nodo2 sucesor = buscarSucesor(nodBorrar.getDer());
                this.aux = null;
                borrarABB(sucesor.getInfo());
                borrarNodoCaso3(this.raiz, nodBorrar, sucesor.getInfo());
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
        }
    }

    private void borrarNodo(Nodo2 raiz, Nodo2 padre) {
        if (padre.getInfo() == this.raiz.getInfo()) {
            Nodo2 sucesor = buscarSucesor(padre.getDer());
            this.raiz = sucesor;
        } else {
            if (padre.getInfo() == raiz.getInfo()) {
                raiz = padre;
            } else {
                if (padre.getInfo() < raiz.getInfo()) {
                    borrarNodo(raiz.getIzq(), padre);
                }
                if (padre.getInfo() > raiz.getInfo()) {
                    borrarNodo(raiz.getDer(), padre);
                }
            }
        }
    }

    private void borrarNodoCaso3(Nodo2 raiz, Nodo2 nodBorrar, int sucesor) {
        if (raiz.getInfo() == nodBorrar.getInfo()) {
            raiz.setInfo(sucesor);
        } else {
            if (nodBorrar.getInfo() < raiz.getInfo()) {
                borrarNodoCaso3(raiz.getIzq(), nodBorrar, sucesor);
            }
            if (nodBorrar.getInfo() > raiz.getInfo()) {
                borrarNodoCaso3(raiz.getDer(), nodBorrar, sucesor);
            }
        }
    }

    /**
     * Algoritmo para encontrar el padre de un nodo
     * 
     * @param raiz:
     * @param clave
     * @return
     */
    private Nodo2 buscarPadre(Nodo2 raiz, Nodo2 clave) {
        // Si la el dato se encuentra en la raiz
        if (this.raiz.getInfo() == clave.getInfo()) {
            // movemos el puntero a la raiz
            this.aux = this.raiz;
        } else {
            // Si no es la raiz

            // Si la info del nodo es menor que la info del nodo padre actual
            if (clave.getInfo() < raiz.getInfo()) {
                // Si la info de nodo izquierdo con respecto al nodo actual es igual a la info
                // del nodo que estamos buscando
                if (raiz.getIzq().getInfo() == clave.getInfo()) {
                    // movemos el puntero hacia este padre actual
                    this.aux = raiz;
                } else {
                    // Si no es igual entonces debemos seguir adentrandonos en el ABB
                    buscarPadre(raiz.getIzq(), clave);
                }
            } else {
                // Si la info del nodo es mayor que la info del nodo padre actual

                // Si la info de nodo derecho con respecto al nodo actual es igual a la info
                // del nodo que estamos buscando
                if (raiz.getDer().getInfo() == clave.getInfo()) {
                    // movemos el puntero hacia este padre actual
                    this.aux = raiz;
                } else {
                    // Si no es igual entonces debemos seguir adentrandonos en el ABB
                    buscarPadre(raiz.getDer(), clave);
                }
            }
        }
        // Por ultimo retornamos el nodo aux que seria el nodo padre encontrado
        return this.aux;
    }

    /**
     * Algoritmo para buscar el sucesor del nodo que es el nodo menor de toda la
     * subramificacion derecha del nodo padre actual
     * 
     * @param sucesor
     * @return
     */
    private Nodo2 buscarSucesor(Nodo2 sucesor) {
        // Verifica si el hijo izquierdo del nodo de entrada no es nulo
        if (sucesor.getIzq() != null) {
            // Si el hijo izquierdo no es nulo, llama recursivamente al método
            // buscarSucesor() en el hijo izquierdo
            buscarSucesor(sucesor.getIzq());
        } else {
            // Si el hijo izquierdo es nulo, establece el atributo auxiliar de la clase en
            // el nodo más a la izquierda (es decir, el sucesor)
            this.aux = sucesor;
        }
        // Devuelve el atributo auxiliar de la clase, que contiene el sucesor del nodo
        // de entrada
        return this.aux;
    }

    /**
     * Lo que hacemos es una funcion aparte solo por la tener problemas con la
     * recursividad
     */
    public void recorridoInorden() {
        ayudanteInorden(this.raiz);
    }

    /**
     * Algoritmo para recorre en forma inorden de forma recursiva
     * 
     * @param nod
     */
    public void ayudanteInorden(Nodo2 nod) {
        // Si el nodo actual es null, terminamos la recursividad
        if (nod == null) {
            return;
        }
        // Seguimos la logica de entrar al nodo izquierdo
        ayudanteInorden(nod.getIzq());
        // Posteriormente imprimimos la info del nodo actual
        System.out.println("\t" + nod.getInfo());
        // y por ultimo entramos al nodo derecho
        ayudanteInorden(nod.getDer());
    }

}