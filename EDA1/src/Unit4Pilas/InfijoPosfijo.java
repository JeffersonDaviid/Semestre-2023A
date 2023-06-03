// JEFFERSON DAVID CHILENO MANOBANDA

package Unit4Pilas;

import java.util.Scanner;

public class InfijoPosfijo {

    // funcion de tipo static para que pertenezca a la clase y no al objeto
    public static void evaluar(String infijo) {
        String postfija = convertir(infijo);
        System.out.println("LA ESPRESION POSFIJA ES: " + postfija);
    }

    // funcion para convertir de infijo a posfijo
    private static String convertir(String infijo) {
        String postfijo = "";
        Pila pila = new Pila(infijo.length());

        // recorremos la expresion infija
        for (int i = 0; i < infijo.length(); i++) {
            char letra = infijo.charAt(i);

            // preguntamos si el valor que estamos leyendo es un operador
            if (esOperador(letra)) {
                if (pila.estaVacia()) {
                    pila.apilar(letra);
                } else {
                    // guardamos el valor que cada operador tiene dependiendo si esta en la pila o
                    // en la expresion
                    int pe = prioridadEnExpresion(letra);
                    int pp = prioridadEnPila((char) pila.elementoTope());

                    // si es que el valor del operador leido es mayor que el operador que esta en el
                    // tope de la pila entonces apilamos este operador
                    if (pe > pp) {
                        pila.apilar(letra);
                    } else {
                        // si el valor del operador leido NO es mayor que el operador que esta en el
                        // tope de la pila entonces enviamos a la cadena posfijo el operador que esta en
                        // el tope de la pila
                        postfijo += pila.desapilar();
                        pila.apilar(letra);
                    }
                }

            } else {
                // si el valor leido NO es un operador entonces se envia a la expresion posfija
                postfijo += letra;
            }

        }
        // Si dado el caso en que ya no haya elementos por leer y quedan operadores en
        // la pila entonces las sacamos una por una (el valor que esta en el tope) y la
        // enviamos a la expresion posfija
        while (!pila.estaVacia()) {
            postfijo += pila.desapilar();
        }
        return postfijo;
    }

    // funcion que retorna el valor de un operador si este no se encuentra en la
    // pila
    private static int prioridadEnExpresion(char operador) {
        if (operador == '^')
            return 4;
        if (operador == '*' || operador == '/')
            return 2;
        if (operador == '+' || operador == '-')
            return 1;
        if (operador == '(')
            return 5;
        return 0;
    }

    // funcion que retorna el valor de un operador si este se encuentra en la pila
    private static int prioridadEnPila(char operador) {
        if (operador == '^')
            return 3;
        if (operador == '*' || operador == '/')
            return 2;
        if (operador == '+' || operador == '-')
            return 1;
        if (operador == '(')
            return 0;
        return 0;
    }

    private static boolean esOperador(char letra) {
        if (letra == '^' || letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '('
                || letra == ')')
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITE LA EXPRESION A EVALUAR: ");
        String infijo = sc.nextLine();
        evaluar(infijo);

        sc.close();
    }
}
