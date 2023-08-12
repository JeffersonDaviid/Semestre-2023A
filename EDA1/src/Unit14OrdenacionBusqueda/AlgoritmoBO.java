/*
 * @Autor: Jefferson Chileno 
 */

package Unit14OrdenacionBusqueda;

import javax.swing.JOptionPane;

/*

Algoritmo BurbujaMayor(arr: arreglo de enteros)
    n = longitud de arr

    Para i desde 0 hasta n - 1 hacer:
        Para j desde 0 hasta n - i - 2 hacer:
            Si arr[j] > arr[j+1] entonces
                Intercambiar(arr[j], arr[j+1])
            Fin Si
        Fin Para
    Fin Para

Fin Algoritmo


Algoritmo BurbujaMenor(arr: arreglo de enteros)
    n = longitud de arr

    Para i desde 0 hasta n - 1 hacer:
        Para j desde 0 hasta n - i - 2 hacer:
            Si arr[j] < arr[j+1] entonces
                Intercambiar(arr[j], arr[j+1])
            Fin Si
        Fin Para
    Fin Para

Fin Algoritmo


Algoritmo Insercion(arr: arreglo de enteros)
    n = longitud de arr

    Para i desde 1 hasta n - 1 hacer:
        valor_actual = arr[i]
        j = i - 1

        Mientras j >= 0 y arr[j] > valor_actual hacer:
            arr[j + 1] = arr[j]
            j = j - 1
        Fin Mientras

        arr[j + 1] = valor_actual
    Fin Para

Fin Algoritmo


Algoritmo Seleccion(arr: arreglo de enteros)
    n = longitud de arr

    Para i desde 0 hasta n - 1 hacer:
        indice_minimo = i

        Para j desde i + 1 hasta n - 1 hacer:
            Si arr[j] < arr[indice_minimo] entonces
                indice_minimo = j
            Fin Si
        Fin Para

        Si indice_minimo != i entonces
            Intercambiar(arr[i], arr[indice_minimo])
        Fin Si
    Fin Para

Fin Algoritmo

Algoritmo BusquedaSecuencial(arr: arreglo de enteros, valor_buscado: entero)
    n = longitud de arr

    Para i desde 0 hasta n - 1 hacer:
        Si arr[i] == valor_buscado entonces
            Devolver i
        Fin Si
    Fin Para

    Devolver -1  // Si el valor no se encuentra en el arreglo
Fin Algoritmo


 */

public class AlgoritmoBO {
    public static String lsCambiosInternos;

    public static String ordenarPorBurbujaMayor(int[] listaDesordenada) {
        lsCambiosInternos = "Lista Original: ";
        for (int valor : listaDesordenada)
            lsCambiosInternos += " | " + valor;
        lsCambiosInternos += "\n";

        for (int i = listaDesordenada.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (listaDesordenada[j] > listaDesordenada[j + 1]) {
                    int auxSiguiente = listaDesordenada[j + 1];
                    listaDesordenada[j + 1] = listaDesordenada[j];
                    listaDesordenada[j] = auxSiguiente;
                    // // ver cambios internos
                    // System.out.print("Vuelta #" + i + ": ");
                    // lsCambiosInternos += "Vuelta #" + i + ": ";
                    // for (int valor : listaDesordenada)
                    // lsCambiosInternos += " | " + valor;
                    // lsCambiosInternos += "\n";
                }
            }
            // ver pasadas finales
            lsCambiosInternos += "Vuelta #" + i + ":   ";
            for (int valor : listaDesordenada)
                lsCambiosInternos += " | " + valor;
            lsCambiosInternos += "\n";
        }
        return lsCambiosInternos;
    }

    public static void ordenarPorBurbujaMayorOtro(int[] listaDesordenada) {
        boolean flagChange = false;
        int longitudLista = listaDesordenada.length;
        int numVueltas = 0;
        do {
            flagChange = false;
            numVueltas++;
            for (int i = 0; i < longitudLista - 1; i++) {

                if (listaDesordenada[i] > listaDesordenada[i + 1]) {
                    int auxSiguiente = listaDesordenada[i + 1];
                    listaDesordenada[i + 1] = listaDesordenada[i];
                    listaDesordenada[i] = auxSiguiente;
                    flagChange = true;
                    // // ver cambios internos
                    // System.out.print("Vuelta #" + numVueltas + ": ");
                    // mostrarLista(listaDesordenada);
                }
            }
            // ver pasadas finales
            System.out.print("Vuelta #" + numVueltas + ":  ");
            mostrarLista(listaDesordenada);
            longitudLista--;
        } while (flagChange);
    }

    public static String ordenarPorBurbujaMenor(int[] listaDesordenada) {
        lsCambiosInternos = "Lista Original: ";
        for (int valor : listaDesordenada)
            lsCambiosInternos += " | " + valor;
        lsCambiosInternos += "\n";

        for (int i = 1; i < listaDesordenada.length; i++) {
            for (int j = listaDesordenada.length - 1; j >= i; j--) {

                if (listaDesordenada[j] < listaDesordenada[j - 1]) {
                    int auxSiguiente = listaDesordenada[j - 1];
                    listaDesordenada[j - 1] = listaDesordenada[j];
                    listaDesordenada[j] = auxSiguiente;
                    // ver cambios internos
                    System.out.print("Vuelta #" + i + ": ");
                    lsCambiosInternos += "Vuelta #" + i + ": ";
                    for (int valor : listaDesordenada)
                        lsCambiosInternos += " | " + valor;
                    lsCambiosInternos += "\n";
                }
            }
            // ver pasadas finales
            lsCambiosInternos += "Vuelta #" + i + ":   ";
            for (int valor : listaDesordenada)
                lsCambiosInternos += " | " + valor;
            lsCambiosInternos += "\n";
        }
        return lsCambiosInternos;
    }

    public static String ordenarPorInsercion(int[] listaDesordenada) {
        lsCambiosInternos = "Lista Original: ";
        for (int valor : listaDesordenada)
            lsCambiosInternos += " | " + valor;
        lsCambiosInternos += "\n";

        // int[] lista = { 20, 15, 15, 48, 632, 15, 18, 552 };
        for (int i = 1; i < listaDesordenada.length; i++) {

            for (int j = i; j > 0; j--) {
                int aux = listaDesordenada[j];

                if (aux < listaDesordenada[j - 1]) {
                    listaDesordenada[j] = listaDesordenada[j - 1];
                    listaDesordenada[j - 1] = aux;
                    // // ver cambios internos
                    // System.out.print("Vuelta #" + i + ": ");
                    // lsCambiosInternos += "Vuelta #" + i + ": ";
                    // for (int valor : listaDesordenada)
                    // lsCambiosInternos += " | " + valor;
                    // lsCambiosInternos += "\n";
                } else
                    break;
            }
            // ver pasadas finales
            lsCambiosInternos += "Vuelta #" + i + ":   ";
            for (int valor : listaDesordenada)
                lsCambiosInternos += " | " + valor;
            lsCambiosInternos += "\n";
        }
        return lsCambiosInternos;
    }

    public static String ordenarPorSeleccion(int[] listaDesordenada) {
        lsCambiosInternos = "Lista Original: ";
        for (int valor : listaDesordenada)
            lsCambiosInternos += " | " + valor;
        lsCambiosInternos += "\n";
        int aux = 0, posicion = 0;

        for (int i = 0; i < listaDesordenada.length - 1; i++) {
            boolean flagLowerNumberFind = false;
            aux = listaDesordenada[i];
            for (int j = i + 1; j < listaDesordenada.length; j++) {
                if (listaDesordenada[j] < aux) {

                    aux = listaDesordenada[j];
                    posicion = j;
                    flagLowerNumberFind = true;

                }
                if (flagLowerNumberFind == true) {
                    listaDesordenada[posicion] = listaDesordenada[i];
                    listaDesordenada[i] = aux;
                }
                // ver pasadas finales
                lsCambiosInternos += "Vuelta #" + i + ": ";
                for (int valor : listaDesordenada)
                    lsCambiosInternos += " | " + valor;
                lsCambiosInternos += "\n";
            }

        }
        return lsCambiosInternos;
    }

    public static void busquedaSecuencial(int[] lista, int dato) {
        boolean flagFindData = false;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == dato) {
                JOptionPane.showMessageDialog(null,
                        "El dato '" + dato + "' ha sido encontrado en la posición " + (i + 1),
                        "Búsqueda exitosa", 1);
                flagFindData = true;
                break;
            }
        }
        if (flagFindData == false) {
            JOptionPane.showMessageDialog(null, "El dato '" + dato + "' no ha sido encontrado en la lista",
                    "Búsqueda Fallida", 0);
        }

    }

    public static void main(String[] args) {
        int[] lista = { -20, 1, 75, 10, 9, 8, 7, 6 };
        mostrarLista(lista);
        System.out.println("ordenado:");
        ordenarPorSeleccion(lista);
        // mostrarLista(lista);

        int[] lista2 = { -20, 1, 75, 10, 9, 8, 7, 6 };
        ordenarPorBurbujaMayor(lista2);
        System.out.println();
        System.out.println();

        mostrarLista(lista2);

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escoja la opcion que desea realizar"
                            + "\n1.-Ingresar lista"
                            + "\n2.-Ordenación"
                            + "\n3.-Búsqueda"
                            + "\n\n0.-Salir",
                    "MENU",
                    JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    String listaNumeros = JOptionPane.showInputDialog(null,
                            "Ingrese la lista separando con UN espacio entre cada número");

                    listaNumeros = listaNumeros.trim().replaceAll("\\s+", ",");

                    String[] listaDesordenadaString = listaNumeros.split(",");
                    int[] listaDesordenada = new int[listaDesordenadaString.length];
                    for (int i = 0; i < listaDesordenada.length; i++) {
                        listaDesordenada[i] = Integer.parseInt(listaDesordenadaString[i]);
                    }
                    lista = listaDesordenada;
                    mostrarLista(listaDesordenada);

                    break;
                case 2:
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Escoja la opcion que desea realizar"
                                    + "\n1.-Ordenar por Burbuja Mayor"
                                    + "\n2.-Ordenar por Burbuja Menor"
                                    + "\n3.-Ordenar por Inserción"
                                    + "\n4.-Ordenar por Selección",
                            "MENU",
                            JOptionPane.INFORMATION_MESSAGE));

                    switch (opcion) {
                        case 1:
                            JOptionPane.showMessageDialog(null, ordenarPorBurbujaMayor(lista),
                                    "Lista ordenada con Burbuja Mayor", 1);
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, ordenarPorBurbujaMenor(lista),
                                    "Lista ordenada con Burbuja Menor", 1);

                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, ordenarPorInsercion(lista),
                                    "Lista ordenada con Inserción", 1);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, ordenarPorSeleccion(lista),
                                    "Lista ordenada con Selección", 1);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                    break;

                case 3:
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese el dato que desea buscar en la lista",
                            "MENU",
                            JOptionPane.INFORMATION_MESSAGE));
                    busquedaSecuencial(lista, opcion2);
                    break;
                case 0:
                    opcion = 0;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        } while (opcion != 0);

    }

    /**
     * Funcion para mostrar los elementos de una lista de enteros
     * 
     * @param lista lista de enteros
     */
    public static void mostrarLista(int[] lista) {
        for (int valor : lista) {
            System.out.print(valor + " | ");
        }
        System.out.println();
    }

}
