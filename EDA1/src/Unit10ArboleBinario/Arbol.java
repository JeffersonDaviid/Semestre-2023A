package Unit10ArboleBinario;

/** 
 * AUTORES: JEFFERSON CHILENO - STALIN YUNGAN
 */

import javax.swing.JOptionPane;

/*
ALGORITMO crearNodoArbol()
    dato <- string
    crear raiz <- Nodo
    raiz^.dato <- dato
Fin del algoritmo

ALGORITMO insertarNodoArbol (Nodo Arbol)
    opcion <- entero
    imprimir "Desea ingresar nodo por:\n1. Izquierda \n2. Derecha  \n0. volver a menu principal"
    leer opcion
    Si (opcion = 1)
        imprimir "Ingrese el dato del nodo"
        crear (Hoja) <- Nodo
        hoja^.dato <- dato
        hoja^.izquieda <- null       
        hoja^.derecha <- null       
        Arbol^.izquierda <- hoja
        insertar(Arbol^.izquierda)
    Si  (opcion = 2)
        imprimir "Ingrese el dato del nodo"
        crear (Hoja) <- Nodo
        hoja^.dato <- dato
        hoja^.izquieda <- null       
        hoja^.derecha <- null       
        Arbol^.derecha <- hoja
        insertar(Arbol^.derecha)
    Si no 
        return
Fin del algoritmo 
    
 */

public class Arbol {

    // ALGORITMO INICIAL
    public static Nodo insertarNodo(Nodo arbol) {
        int opcion = 0;
        String dato = "";
        Nodo Aux = arbol;

        if (arbol == null) {
            dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo raiz");
            Nodo hoja = new Nodo(dato);
            arbol = hoja;
        }
        do {
            dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo por la izquierda");
            Nodo hoja = new Nodo(dato);
            Aux.setIzquierdo(hoja);
            Aux = hoja;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea añadir más nodos\n1. Si\n0. No"));
            dato = "";
        } while (opcion != 0);
        Aux = arbol;
        do {
            dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo por la derecha");
            Nodo hoja = new Nodo(dato);
            Aux.setDerecha(hoja);
            Aux = hoja;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea añadir más nodos\n1. Si\n0. No"));
            dato = "";
        } while (opcion != 0);

        return arbol;
    }

    /**
     * ALGORITMO PARA INGRESAR DATOS EN LA IZQUIERDA O DERECHA DEL NUEVO NODO QUE SE
     * ESTA CREANDO
     * 
     * @param arbolRaiz
     * @return
     */
    public static Nodo insertar(Nodo arbolRaiz) {
        int opcion = Integer
                .parseInt(JOptionPane.showInputDialog(null,
                        "Desea ingresar nodo por:\n1. Izquierda \n2. Derecha  \n0. volver a menu principal"));
        if (opcion == 1) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo");
            Nodo hoja = new Nodo(dato);
            arbolRaiz.setIzquierdo(hoja);
            insertar(arbolRaiz.getIzquierdo());
        } else if (opcion == 2) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo");
            Nodo hoja = new Nodo(dato);
            arbolRaiz.setDerecha(hoja);
            insertar(arbolRaiz.getDerecha());
        } else
            return arbolRaiz;

        return arbolRaiz;

    }

    public static Nodo crearArbolBinario() {
        String dato = JOptionPane.showInputDialog(null, "Ingrese el dato del nodo raiz");
        Nodo raiz = new Nodo(dato);
        return raiz;
    }

    public static void main(String[] args) {
        Nodo raiz = null;
        // Nodo raiz = null;

        int option = -1;
        do {

            switch (option = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "\tARBOLES BINARIOS\n1. CREAR ARBOL BINARIO\n2. INSERTAR NODO \n3. RECORRIDO PREORDEN\n4. RECORRIDO INORDEN\n5. RECORRIDO POSTORDEN\n\n\n0. Salir"))) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;

                case 1:
                    raiz = crearArbolBinario();
                    break;
                case 2:
                    insertar(raiz);
                    break;
                case 3:
                    recorridoPreorden(raiz);
                    break;
                case 4:
                    recorridoInOrden(raiz);
                    break;
                case 5:
                    recorridoPostOrden(raiz);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es válida");
                    break;

            }
        } while (option != 0);
    }

    /*
     * ALGORITMO recorridoPreorden:
     * 
     * SI nodo != nulo ENTONCES
     * Escribir DAto
     * visitar nodo Izquierdo
     * visitar nodo Derecho
     * FIN SI
     * FIN DEL ALGORITMO recorridoPreorden
     */
    public static void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            JOptionPane.showMessageDialog(null, nodo.getDato());
            recorridoPreorden(nodo.getIzquierdo());
            recorridoPreorden(nodo.getDerecha());
        }
    }

    /*
     * ALGORITMO recorridoPreorden:
     * 
     * SI nodo != nulo ENTONCES
     * visitar nodo Izquierdo
     * Escribir DAto
     * visitar nodo Derecho
     * FIN SI
     * FIN DEL ALGORITMO recorridoPreorden
     */
    public static void recorridoInOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrden(nodo.getIzquierdo());
            JOptionPane.showMessageDialog(null, nodo.getDato());
            recorridoInOrden(nodo.getDerecha());
        }
    }

    /*
     * ALGORITMO recorridoPreorden:
     * 
     * SI nodo != nulo ENTONCES
     * visitar nodo Izquierdo
     * visitar nodo Derecho
     * Escribir DAto
     * FIN SI
     * FIN DEL ALGORITMO recorridoPreorden
     */
    public static void recorridoPostOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoPostOrden(nodo.getIzquierdo());
            recorridoPostOrden(nodo.getDerecha());
            JOptionPane.showMessageDialog(null, nodo.getDato());
        }
    }
}
