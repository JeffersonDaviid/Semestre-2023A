package Biblioteca;

/** 
 *   @autor: CHILENO MANOBANDA JEFFERSON DAVID
 */

/* 

    Algoritmo crearNodoInicioLista()
        Hacer P, Q variables apuntadores
        Hacer INFO, LIGA campos del nodo lista
        Hacer Opción variable tipo entero
        Crear (P)
        Leer P^.INFO
        Hacer P^.LIGA = null
        Seleccionar “Crear más nodos? Si:1, No:0"
        Mientras (Opción = 1)
            Crear (Q)
            Leer Q^.INFO
            Hacer Q^.LIGA = P y P = Q
            Seleccionar “Crear más nodos? Si:1, No:0"
            Leer Opción
        Fin Mientras
    Fin crearNodoInicioLista()


    Algoritmo crearNodoFinalLista()
        Hacer P, Q, T variables apuntadores
        Hacer INFO LIGA campos del nodo lista
        Hacer P apuntará a inicio de la lista
        Crear(P)
        Leer P^.INFO
        Hacer P^.LIGA = null y T = P
        Mientras (Opción = 1)
            Crear(Q)
            Leer Q^. INFO
            Hacer Q^.LIGA = NULL, T*.LIGA = Q y T = Q
            Escribir “Desea ingresar más nodos? Si:1, No:0”
            Leer Opción
        Fin Mientras
    Fin crearNodoFinalLista()


     Algoritmo insertarNodoInicio()
        Hacer P, Q variables apuntadores
        Hacer INFO LIGA campos del nodo lista
        Hacer Dato información que se almacenará en el nodo
        Crear (Q)
        Hacer Q^.INFO = Dato, Q^.LIGA = P y P=Q
    Fin insertarNodoInicio()


    Algoritmo insertarNodoFinal()
        Hacer P, Q, T variables apuntadores
        Hacer INFO LIGA campos del nodo lista
        Hacer Dato información que se almacenará en el nodo
        Hacer T = P
        Mientras (T^.LIGA != null) //Permite recorrer hasta el final de lista
            Hacer T = T^.LIGA
        Fin mientras
        Crear (Q)
        Hacer Q^.INFO<-- Dato, Q^.LIGA<--Null y T^.LIGA<--Q
    Fin insertarNodoFinal()


    Algoritmo recorrer()
        Hacer P, Q variables apuntadores
        Hacer INFO, LIGA campos del nodo lista
        Hacer Q = P
        Mientras (Q != null)
            Escribir Q^.INFO
            Hacer Q = Q^.LIGA
        Fin Mientras
    Fin recorrer()


    Algoritmo buscar(dato)
        Hacer P, Q variables apuntadores
        Hacer INFO, LIGA campos del nodo lista
        Hacer Q = P
        Mientras ((Q = null) y (Q^.INFO != X))
            Hacer Q = Q^.LIGA
        Fin mientras
        Si (Q = null) entonces
            Escribir "El elemento no se encuentra en la lista"
        sino
            Escribir "El elemento sí se encuentra en la lista"
        Fin si
    Fin buscar(dato)


    Algoritmo eliminarNodoInicio()
        Hacer P, Q variables apuntadores
        Hacer INFO, LIGA campos del nodo lista
        Hacer Q = P
        Si (Q^.LIGA = null) entonces
            Hacer P = null
        sino
            Hacer P = Q^.LIGA
        Fin si
    Fin eliminarNodoInicio()

    Algoritmo eliminarNodoFinal()
        Hacer P, Q variables apuntadores
        Hacer INFO, LIGA campos del nodo lista
        Si (P == null) entonces
            Escribir "La lista está vacía"
            Fin eliminarNodoFinal()
        Fin si
        Si (P^.LIGA() == null) entonces
            Hacer P = null
            Fin eliminarNodoFinal()
        Fin si
        Hacer Q = P
        Mientras (Q^.LIGA() != null) entonces
            HAcer Q = Q^.LIGA
        Fin mientras
        Cambia Q^.LIGA a null
    Fin eliminarNodoFinal()

 */

import javax.swing.JOptionPane;

public class ListaSimple {
    private static String lista = "";

    public static void mostrarLista(Nodo primerNodo) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return;
        }
        // puntero que recorrera toda la lista
        Nodo nodoAux = primerNodo;
        while (nodoAux.getSiguiente() != null || nodoAux == null) {
            // concatenamos los elementos
            lista += nodoAux.getDato() + "-> ";
            nodoAux = nodoAux.getSiguiente();
        }
        // concatenamos los elementos
        lista += nodoAux.getDato() + "-> NULL";
        JOptionPane.showMessageDialog(null, lista);
        lista = "";
    }

    public static void mostrarListaFormaRecursiva(Nodo primerNodo) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return;
        }
        if (primerNodo.getSiguiente() == null)
            System.err.print(primerNodo.getDato() + " -> NULL\n");
        else {
            System.out.print(primerNodo.getDato() + " ->");
            mostrarListaFormaRecursiva(primerNodo.getSiguiente());
        }

    }

    public static Nodo crearNodoAlInicio() {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo primero = new Nodo(info);

        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            // el nuevo nodo esta ligado al primer elemento de la lista
            Nodo Q = new Nodo(info, primero);
            // cambiamos la posicion del puntero cabecera
            primero = Q;
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }

        return primero;

    }

    public static Nodo crearNodoAlFinal() {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo primero = new Nodo(info);
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        while (option == 1) {
            Nodo nodoAux = primero;
            // guardamos la posicion del nodo ultimo
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
            Nodo nuevoNodo = new Nodo(info);
            // ligar el ultimo nodo con el nodo que acabamos de crear
            nodoAux.setSiguiente(nuevoNodo);
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea escribir más nodos: SI=1 o NO=0"));
        }
        return primero;
    }

    public static void buscarNodoEnLista(Nodo primerNodo, String datoSolicitado) {
        if (primerNodo == null) {
            JOptionPane.showMessageDialog(null, "No se puede buscar en lista vacía");
            return;
        }
        // puntero aux que va a recorrer la lista
        Nodo nodoAux = primerNodo;
        boolean isFind = false;
        int position = 0;
        while (nodoAux != null && isFind == false) {
            // vamos a interar y aumenta la iteracion que muetra la posición del nodo
            position++;
            if ((nodoAux.getDato().equals(datoSolicitado)))
                isFind = true;

            nodoAux = nodoAux.getSiguiente();
        }

        // mostramos en pantalla dependiendo si se encontro o no el dato en la lista
        JOptionPane.showMessageDialog(null,
                isFind ? "El dato '" + datoSolicitado + "' se encuentra en el nodo #" + position
                        : "El dato '" + datoSolicitado + "' no se encuentra en la lista simple");

    }

    public static Nodo eliminarAlFinal(Nodo primerNodo) {
        // verficamos que la lista no este vacia o sea un unico elemento
        if (primerNodo == null || primerNodo.getSiguiente() == null)
            return null;

        Nodo nodoPenultimo = primerNodo;
        Nodo nodoUltimo = primerNodo.getSiguiente();
        // avanzamos de tal forma que siempre tendremos disponible el nodo penultimo con
        // el que vamos a trabajar
        while (nodoUltimo.getSiguiente() != null) {
            nodoPenultimo = nodoUltimo;
            nodoUltimo = nodoUltimo.getSiguiente();
        }
        nodoPenultimo.setSiguiente(null);

        return primerNodo;
    }

    public static Nodo eliminarAlInicio(Nodo primerNodo) {
        // verficamos que la lista no este vacia o sea un unico elemento
        if (primerNodo == null || primerNodo.getSiguiente() == null)
            return null;
        // eliminamos y cambimos la posicion del primer nodo
        primerNodo = primerNodo.getSiguiente();

        return primerNodo;
    }

    public static Nodo insertarAlInicio(Nodo primerNodo) {
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        // Crear un nodo que apunte al primer nodo de la lista simple
        Nodo nuevoNodo = new Nodo(info, primerNodo);

        return nuevoNodo;
    }

    public static Nodo insertarAlFinal(Nodo primerNodo) {
        Nodo nodoUltimo;
        String info = JOptionPane.showInputDialog(null, "Ingrese la info del nodo");
        Nodo nuevoNodo = new Nodo(info);
        nodoUltimo = primerNodo;
        // guardamos la posición del ultimo nodo
        while (nodoUltimo.getSiguiente() != null)
            nodoUltimo = nodoUltimo.getSiguiente();

        nodoUltimo.setSiguiente(nuevoNodo);
        nodoUltimo = nuevoNodo;

        return primerNodo;
    }

    public static void main(String[] args) {
        int option = -1;
        Nodo nodoPermanente = null;
        do {

            switch (option = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "Seleccione la opcion:\n1. Crear lista con nodos al inicio\n2. Crear lista con nodo al final\n3. Mostrar lista\n4. Buscar elemento en lista\n5. Insertar nodo al inicio\n6. Insertar nodo al final\n7. Eliminar nodo al inicio\n8. Eliminar nodo al final\n0. Salir"))) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;
                case 1:
                    nodoPermanente = crearNodoAlInicio();
                    break;
                case 2:
                    nodoPermanente = crearNodoAlFinal();
                    break;
                case 3:
                    mostrarLista(nodoPermanente);
                    mostrarListaFormaRecursiva(nodoPermanente);
                    break;
                case 4:
                    buscarNodoEnLista(nodoPermanente,
                            JOptionPane.showInputDialog(null, "Ingrese el dato que desea buscar en la lista simple: "));
                    break;
                case 5:
                    nodoPermanente = insertarAlInicio(nodoPermanente);
                    break;
                case 6:
                    nodoPermanente = insertarAlFinal(nodoPermanente);
                    break;
                case 7:
                    nodoPermanente = eliminarAlInicio(nodoPermanente);
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    break;
                case 8:
                    nodoPermanente = eliminarAlFinal(nodoPermanente);
                    JOptionPane.showMessageDialog(null, "El elemento ha sido eliminado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es válida");
                    break;

            }
        } while (option != 0);
    }
}