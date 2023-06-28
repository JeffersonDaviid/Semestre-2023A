package Biblioteca;

public class Recursividad {
    public static String frase = "";

    public static String invertirCadena(String cadena, int posicion) {
        // public static String invertirCadena(String[] cadena, int posicion) {

        if (posicion == 0) {
            frase += cadena.charAt(posicion);
            return frase;
        } else {
            frase += cadena.charAt(posicion);
            return invertirCadena(cadena, posicion - 1);
        }
    }

    public static void main(String[] args) {
        String[] cadena = new String[5];
        cadena[0] = "0";
        cadena[1] = "1";
        cadena[2] = "2";
        cadena[3] = "3";
        cadena[4] = "4";

        // invertirCadena(cadena, cadena.length - 1);
        String cadena2 = "AMOR";
        System.out.println(invertirCadena(cadena2, cadena.length - 2));

        System.out.println(cadena2);

        System.out.println();
        System.out.println();
        System.out.println();

        // System.out.println(frase);
    }
}
