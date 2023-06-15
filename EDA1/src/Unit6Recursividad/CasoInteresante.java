package Unit6Recursividad;

import javax.swing.JOptionPane;

/*
// ALGORITMO PARA INVERTIR UNA CADENA

subprograma invertirCadena(cadena):
    si (cadena.tamaño == 0):
        retornar cadena
        sino
            retornar invertirCadenaAux(cadena, longitud(cadena) - 1)
    Fin si
Fin del algoritmo invertirCadena

subprograma invertirCadenaAux(cadena, indice):
    si (indice = 0)
        retornar cadena[indice]
        sino
            retornar cadena[indice] + invertirCadenaAux(cadena, indice - 1)
    Fin si
Fin del Algoritmo invertirCadenaAux




// ALGORMITMO PARA DISMINUIR UN NÚMERO CON RECURSIVIDAD MUTUA

algoritmo A(n):
    si (n > 0)
        imprimir "A: " + n
        llamar a B(n - 1)
    Fin si
Fin algoritmo A

algoritmo B(n):
    si n > 0:
        imprimir "B: " + n
        llamar a A(n - 1)
Fin algoritmo B



// ALGORIRMO PARA DETERMINAR SI UN VALOR ES PAR O IMPAR

Algoritmo esPar(n):
    si (n = 0)
        retornar verdadero
        sino
            retornar esImpar(n - 1)
    Fin si
Fin del programa esPar

Algoritmo esImpar(n):
    si (n = 0)
        retornar falso
        sino:
            retornar esPar(n - 1)
    Fin Si
Fin de algoritmo esImpar

 */

public class CasoInteresante {

    private static String cadenaFinal = "";
    private static String cadenaOriginal = "";
    private static String cadenaInvertida = "";

    /**
     * Algoritmo para determinar si un numero es pa
     * 
     * @param n
     * @return
     */
    public static boolean esPar(int n) {
        // varificar si el valor es cero
        if (n == 0) {
            // retorna true, indicando que es par
            return true;
        } else {
            // por el contrario, si es diferente de 0, podemos preguntar con ayuda del
            // algoritmo esImpar disminuyendo en uno
            return esImpar(n - 1);
        }
    }

    /**
     * Algoritmo para deteminar si un valor es impar
     * 
     * @param n
     * @return
     */
    public static boolean esImpar(int n) {
        // varificar si el valor es cero
        if (n == 0) {
            // retorna false indicando que no es impar
            return false;
        } else {
            // por el contrario, si es diferente de 0, podemos preguntar con ayuda del
            // algoritmo esPar disminuyendo en uno
            return esPar(n - 1);
        }
    }

    /**
     * Algoritmo para disminuir un numero entero
     * 
     * @param n valor entero
     */
    public static void algoritmoA(int n) {
        // verificamos que el valor pueda seguir disminuyendo
        if (n > 0) {
            cadenaFinal += "A: " + n + "\n";
            // como si se puede entonces se disminuye en 1 con la ayuda del algoritmoB
            algoritmoB(n - 1);
        }
    }

    /**
     * Algoritmo para disminuir un número entero
     * 
     * @param n valor entero
     */
    public static void algoritmoB(int n) {
        // verificamos que el valor se pueda seguir disminuyendo
        if (n > 0) {
            cadenaFinal += "B: " + n + "\n";
            // como si se puede entonces se disminuye en 1 con la ayuda del algoritmoA
            algoritmoA(n - 1);
        }
    }

    /**
     * Algorirmo para invertir una cadena
     * 
     * @param cadena
     * @return
     */
    public static String invertirCadena(String cadena) {
        // revisa si la cadena que llega esta vacia
        if (cadena.isEmpty()) {
            // si esta vacia esta vacia, devuelve la cadena
            return cadena;
        } else {
            // si no esta vacía, entonces enviarmos al algoritmo AUX para invertir la cadena
            return invertirCadenaAux(cadena, cadena.length() - 1);
        }
    }

    /**
     * Algorito AUX para invertir una cadena
     * 
     * @param cadena
     * @param indice
     * @return
     */
    public static String invertirCadenaAux(String cadena, int indice) {
        // Si el indice es cero, es porque estamos en el último valor
        if (indice == 0) {
            // retorna el valor en la posicion 0
            return String.valueOf(cadena.charAt(indice));
        } else {
            // si no esta en la posición 0, entonces se puede seguir tomando el ultimo valor
            // de la cadena y disminuyendo la posicion hasta llegar a 1
            return String.valueOf(cadena.charAt(indice)) + invertirCadenaAux(cadena, indice - 1);
        }
    }

    public static void main(String[] args) {
        int opcion, valor;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU\nEscoga la opcion que desee realizar en la cola simple: \n1. Ingresar un dato\n2. Eliminar un dato\n3. Visualizar cola\n4. Salir"));

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    // ---------------------------------------------------------------
                    valor = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese el valor que desea disminuir: "));
                    algoritmoA(valor);
                    JOptionPane.showMessageDialog(null, cadenaFinal);
                    cadenaFinal = "";

                    // -------------------------------------------------------
                    valor = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ingrese el valor que desea determinar la paridad: "));
                    if (esPar(valor)) {
                        JOptionPane.showMessageDialog(null, "El valor " + valor + " es par");
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor " + valor + " es impar");
                    }

                    // ---------------------------------------------------------
                    cadenaOriginal = JOptionPane.showInputDialog(
                            "Ingrese la cadena que desea invertir: ");
                    algoritmoA(valor);
                    cadenaInvertida = invertirCadena(cadenaOriginal);
                    JOptionPane.showMessageDialog(null, "La cadena original es: " + cadenaOriginal
                            + "\nLa cadena invertida es: " + cadenaInvertida);
                    break;
                case 4:

                    opcion = 4;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se ha ingresado una opcion valida");
                    break;

            }
        } while (opcion != 4);
    }
}