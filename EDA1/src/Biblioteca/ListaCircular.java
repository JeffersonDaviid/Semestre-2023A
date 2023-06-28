package Biblioteca;

/** 
 * @autor: JEFFERSON DAVID CHILENO MANOBANDA
 */

import javax.swing.JOptionPane;

/*

----------------------------------------------------------------------------
creacionNodoAlInicioLC()
    P, T <- punteros
    I, L <- campos del nodo
    dato <- string
    opcion <- Entero
    crear (P)
    hacer P^.I <- dato
    hacer P^.L <- P
    hacer T <- P
    Escribir "Desea escribir más nodos: SI=1 o NO=0"
    Leer opcion
    Mientras (opcion = 1)
        crear (Q)
        hacer Q^.I <- dato
        hacer Q^.L <- P
        hacer T^.L <- Q
        hacer P <- Q
        Escribir "Desea escribir más nodos: SI=1 o NO=0"
        leer opcion
    Fin mientras
Fin Algoritmo

----------------------------------------------------------------------------
creacionNodoAlFinalLC()
    P, T <- punteros
    I, L <- campos del nodo
    dato <- string
    opcion <- Entero
    crear (P)
    hacer P^.I <- dato
    hacer P^.L <- P
    hacer T <- P
    Escribir "Desea escribir más nodos: SI=1 o NO=0"
    Leer opcion
    Mientras (opcion = 1)
        crear (Q)
        hacer Q^.I <- dato
        hacer Q^.L <- P
        hacer T^.L <- Q
        hacer T <- Q
        Escribir "Desea escribir más nodos: SI=1 o NO=0"
        leer opcion
    Fin mientras
Fin Algoritmo

----------------------------------------------------------------------------
insertarNodoAlInicioLC(Lista P)
    P, T <- punteros
    I, L <- campos del nodo
    hacer T <- P
    Leer opcion
    Mientras (T^.L != P)
        T <- T^.L
    Fin mientras
    hacer Q^.I <- dato
    hacer Q^.L <- P
    hacer T^.L <- Q
    hacer P <- Q
    Escribir "Desea escribir más nodos: SI=1 o NO=0"
    leer opcion
    Fin mientras
Fin Algoritmo

----------------------------------------------------------------------------
eliminarAlFinal()
    U, T <- punteros
    hacer U = P^.L
    mientras (U^.L != P)
        hacer T <- U
        hacer U <- U^.L
    fin mientras
    hacer T^.L <- P
    hacer U <- NULL
Fin algoritmo


----------------------------------------------------------------------------
recorrerListaCircular()
    U, T <- punteros
    hacer U <- P
    mientras (U^.L != P)
        Escribir "El dato es: " + U^.I 
        hacer U <- U^.L
    fin mientras
    Escribir "El dato es: " + U^.I 
Fin algoritmo


----------------------------------------------------------------------------
mostrarListaCircular()
    U, T <- punteros
    listacircular <- String
    hacer U <- P
    mientras (U^.L != P)
        hacer lista = lista + U^.I  + "-> " 
        hacer U <- U^.L
    fin mientras
    hacer lista = lista + U^.I  + "-> " 
    Mostrar lista
Fin algoritmo
 */
public class ListaCircular {

    public static Nodo crearLCAlInicio() {
        Nodo auxNodo;
        String info = JOptionPane.showInputDialog(null, "Ingrese el info del nodo");
        Nodo primerNodo = new Nodo(info);
        primerNodo.setSiguiente(primerNodo);
        auxNodo = primerNodo;

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            // el nuevo nodo esta ligado al primer elemento de la lista Circular
            Nodo Q = new Nodo(info, primerNodo);
            // cambiamos la posicion del puntero cabecera
            auxNodo.setSiguiente(Q);
            primerNodo = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }
        return primerNodo;
    }

    public static Nodo crearLCAlFinal() {
        String info = JOptionPane.showInputDialog(null, "Ingrese el info del nodo");
        Nodo primerNodo = new Nodo(info);
        primerNodo.setSiguiente(primerNodo);
        Nodo auxNodo;
        auxNodo = primerNodo;

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            // el nuevo nodo esta ligado al primer elemento de la lista Circular
            Nodo Q = new Nodo(info, primerNodo);
            // cambiamos la posicion del puntero cabecera
            auxNodo.setSiguiente(Q);
            auxNodo = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }
        return primerNodo;
    }

    public static Nodo insertarNodoEnLCAlInicio(Nodo primerNodo) {
        Nodo auxNodo = primerNodo;

        // guardar la posicion del ultimo nodo
        while (auxNodo.getSiguiente() != primerNodo) {
            auxNodo = auxNodo.getSiguiente();
        }

        int option = 0;
        do {
            String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            // el nuevo nodo esta ligado al primer elemento de la lista Circular
            Nodo Q = new Nodo(info, primerNodo);
            // cambiamos la posicion del puntero cabecera
            auxNodo.setSiguiente(Q);
            auxNodo = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        } while (option == 1);

        return primerNodo;
    }

    public static void mostrarLC(Nodo primerNodo) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "Lista circular vacia");
            return;
        }
        String listaCircular = "";
        // puntero que recorrera toda la listaCircular
        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != primerNodo) {
            // concatenamos los elementos
            listaCircular += nodoAux.getDato() + "-> ";
            nodoAux = nodoAux.getSiguiente();
        }
        // concatenamos los elementos
        listaCircular += nodoAux.getDato() + "-> " + nodoAux.getSiguiente().getDato() + " ...";
        JOptionPane.showMessageDialog(null, listaCircular);
    }

    public static void recorrerLC(Nodo primerNodo) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "Lista circular vacia");
            return;
        }
        // puntero que recorrera toda la listaCircular
        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != primerNodo) {
            JOptionPane.showMessageDialog(null, nodoAux.getDato() + "-> ");
            nodoAux = nodoAux.getSiguiente();
        }
        // concatenamos los elementos
        JOptionPane.showMessageDialog(null,
                nodoAux.getDato() + "-> " + nodoAux.getSiguiente().getDato() + " vuelve a repetir");
    }

    public static Nodo eliminarNodoLC(Nodo nodoPrimero) {
        // verficamos que la lista no este vacia o sea un unico elemento
        if (nodoPrimero == null || nodoPrimero.getSiguiente() == nodoPrimero)
            return null;

        Nodo nodoPenultimo = nodoPrimero;
        Nodo nodoUltimo = nodoPrimero.getSiguiente();
        // avanzamos de tal forma que siempre tendremos disponible el nodo penultimo con
        // el que vamos a trabajar
        while (nodoUltimo.getSiguiente() != nodoPrimero) {
            nodoPenultimo = nodoUltimo;
            nodoUltimo = nodoUltimo.getSiguiente();
        }
        nodoPenultimo.setSiguiente(nodoPrimero);
        JOptionPane.showMessageDialog(null,
                "El ultimo nodo con dato '" + nodoUltimo.getDato() + "'' ha sido eliminado ");
        nodoUltimo = null;

        return nodoPrimero;

    }

    public static void main(String[] args) {
        int option = -1;
        Nodo nodoPermanente = null;
        do {

            switch (option = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "1. CREAR LISTA CIRCULAR AL INICIO\n2. CREAR LISTA CIRCULAR AL FINAL \n3. INSERTAR NODO EN UNA LISTA CIRCULAR\n4. RECORRER LISTA CIRCULAR\n5. IMPRIMIR VALORES DE LISTA CIRCULAR\n6. ELIMINAR NODO LISTA CIRCULAR\n\n0. Salir"))) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;
                case 1:
                    nodoPermanente = crearLCAlInicio();
                    break;
                case 2:
                    nodoPermanente = crearLCAlFinal();
                    break;
                case 3:
                    nodoPermanente = insertarNodoEnLCAlInicio(nodoPermanente);
                    break;
                case 4:
                    recorrerLC(nodoPermanente);
                    break;
                case 5:
                    mostrarLC(nodoPermanente);
                    break;
                case 6:
                    nodoPermanente = eliminarNodoLC(nodoPermanente);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es válida");
                    break;

            }
        } while (option != 0);
    }
}
