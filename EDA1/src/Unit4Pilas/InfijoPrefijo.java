package Unit4Pilas;

import java.util.Stack;

public class InfijoPrefijo {

    public static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // funcion para obtener la precedencia del operador
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    public static String infijoAPrefijo(String expresionInfija) {
        StringBuilder expresionPrefija = new StringBuilder();
        Stack<Character> pilaOperadores = new Stack<>();

        // con el for iniciado en la posición final de la cadena simulamos la lectura de
        // derecha a izquierda
        for (int i = expresionInfija.length() - 1; i >= 0; i--) {
            char caracter = expresionInfija.charAt(i);

            if (Character.isDigit(caracter)) {
                expresionPrefija.insert(0, caracter);
            } else if (caracter == '(') {
                while (!pilaOperadores.isEmpty() && pilaOperadores.peek() != ')') {
                    char operador = pilaOperadores.pop();
                    expresionPrefija.insert(0, operador);
                }
                pilaOperadores.pop(); // Desapilar el paréntesis de cierre
            } else if (esOperador(caracter)) {
                while (!pilaOperadores.isEmpty() && precedencia(pilaOperadores.peek()) > precedencia(caracter)) {
                    char operador = pilaOperadores.pop();
                    expresionPrefija.insert(0, operador);
                }
                pilaOperadores.push(caracter);
            } else if (caracter == ')') {
                pilaOperadores.push(caracter);
            }
        }
        // si algun elemento no salio de la pila de operadores, aqui sacamos todos
        while (!pilaOperadores.isEmpty()) {
            char operador = pilaOperadores.pop();
            expresionPrefija.insert(0, operador);
        }

        return expresionPrefija.toString();
    }

    public static void main(String[] args) {
        String expresionInfija = "1*(2+3)/(4-5)";
        String expresionPrefija = infijoAPrefijo(expresionInfija);

        System.out.println("Expresión infija: " + expresionInfija);
        System.out.println("Expresión prefija: " + expresionPrefija);
    }
}
