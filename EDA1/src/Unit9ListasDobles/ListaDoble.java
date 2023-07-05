package Unit9ListasDobles;

import javax.swing.JOptionPane;

/*
 * 
 * ALGORTIMO INSERTARDELANTE (LISTADOBLE lista)
 * A,D <- Punteros nodos
 * dato <- string
 * T <- Nodo
 * Mientras (T.D != Null)
 *     hacer T <- T.D
 * Fin mientras
 * Crear (Q)
 * hacer Q.dato <- dato
 * hacer Q.A <- T
 * hacer Q.D <- null
 * hacer T.D <- Q
 * hacer T <- Q
 * Fin algoritmo 
 * 
 * 
 * ALGORITMO RECORRER LISTADOBLE (LISTADOBLE lista)
 * T <- Nodo
 * hacer T <- lista
 * Mientras (T != null)
 *      imprimir T.Dato
 *      hacer T <- T.D
 * Fin mientras
 * Fin algoritmo
 */

public class ListaDoble {

    public static Nodo insertarPorDetras(Nodo lista) {
        int opcion = 0;
        String dato = "";
        Nodo aux = lista;

        // Si la lista esta vacia
        if (lista == null) {
            JOptionPane.showMessageDialog(null, "La lista doble esta vacía");
            return null;
        }
        // coloca el puntero en el ultimo elemento
        while (aux.getPosterior() != null)
            aux = aux.getPosterior();

        do {
            dato = JOptionPane.showInputDialog(null, "Ingrese el dato: ");
            Nodo q = new Nodo(dato);
            q.setAnterior(aux);
            aux.setPosterior(q);
            aux = q;
            opcion = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Desea ingresar más nodos?\n1. Si o 0. NO"));
            dato = "";
        } while (opcion != 0);

        return lista;
    }

    public static void recorrerListaDobleIzquierdaDerecha(Nodo lista) {
        Nodo aux = lista;
        while (aux != null) {
            // usarmos condicionales solo para mostrar los datos de manera más ordenada y
            // visual para entender la logica
            if (aux.getAnterior() == null) {
                JOptionPane.showMessageDialog(null,
                        "NULL  <-  " + aux.getDato() + "  ->  " + aux.getPosterior().getDato());
            } else if (aux.getPosterior() == null) {
                JOptionPane.showMessageDialog(null,
                        aux.getAnterior().getDato() + "  <-  " + aux.getDato() + "  ->  NULL");
            } else if (aux.getAnterior() == null && aux.getPosterior() == null) {
                JOptionPane.showMessageDialog(null, "NULL  <-  " + aux.getDato() + "  ->  NULL");
            } else {
                JOptionPane.showMessageDialog(null,
                        aux.getAnterior().getDato() + "  <-  " + aux.getDato() + "  ->  "
                                + aux.getPosterior().getDato());
            }
            aux = aux.getPosterior();
        }
    }

    public static void main(String[] args) {
        Nodo lista = new Nodo("0");

        insertarPorDetras(lista);
        recorrerListaDobleIzquierdaDerecha(lista);
    }
}
