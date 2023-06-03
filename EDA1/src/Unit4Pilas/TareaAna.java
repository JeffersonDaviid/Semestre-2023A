/**
 * @autor: JEFFERSON DAVID CHILENO MANOBANDA
 * @date: 27/06/2023
 */

package Unit4Pilas;

/*
    EL objetivo es ayudar a Ana una investigadora que creo el CHAT GPT a crear un algoritmo que le
    permita enviar una mensaje cifrado en una PILA y cuando ella lo abra le permita ver que decia y 
    ANA envia un mensaje "mama GPT es una herramienta engañosa y muchas personas no lo saben "

    Para ello envío ya los datos quemados tal cual y luego invoco a mostrar que me permitirá imprimer el mensaje de Ana 
 */

public class TareaAna {

    // Funcion que se encarga de cifrar un texto
    public static String cifrarMensaje(String mensaje) {
        Pila pila = new Pila(mensaje.length());
        String mensajeCifrado = "";

        // Cifrar el mensaje invirtiendo su orden y agregando caracteres adicionales
        for (int i = mensaje.length() - 1; i >= 0; i--) {
            pila.apilar(mensaje.charAt(i));
        }
        // Cifrar el mensaje añaniendo signo # despues de cada letra
        while (!pila.estaVacia()) {
            mensajeCifrado += pila.desapilar();
            mensajeCifrado += "#";
        }

        return mensajeCifrado;
    }

    public static String mostrarMensajeCifrado(String mensajeCifrado) {
        Pila pila = new Pila(mensajeCifrado.length());
        String mensajeDescifrado = "";

        // Descifrar el mensaje eliminando los caracteres adicionales y restaurando el
        // orden original
        String[] caracteres = mensajeCifrado.split("#");

        // ingresando datos a la pila en orden invertido
        for (int i = caracteres.length - 1; i >= 0; i--) {
            for (char c : caracteres[i].toCharArray()) {
                pila.apilar(c);
            }
        }

        // sacamos los elementos de la pila
        while (!pila.estaVacia()) {
            mensajeDescifrado += pila.desapilar();
        }

        return mensajeDescifrado;
    }

    public static void main(String[] args) {
        // Mensaje a enviar
        String mensajeOriginal = "mama GPT es una herramienta engañosa y muchas personas no lo saben";

        // Cifrar mensaje
        String mensajeCifrado = cifrarMensaje(mensajeOriginal);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);

        // Mostrar mensaje descifrado
        String mensajeDescifrado = mostrarMensajeCifrado(mensajeCifrado);
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
    }

}
