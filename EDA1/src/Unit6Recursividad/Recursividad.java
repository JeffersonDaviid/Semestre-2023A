package Unit6Recursividad;

public class Recursividad {
    public static String frase = "";

    public static String invertirCadena(String[] cadena, int posicion) {

        if (posicion == 0) {
            frase += cadena[posicion];
            System.out.print(cadena[posicion]);
            return cadena[posicion];
        } else {
            frase += cadena[posicion];
            System.out.print(cadena[posicion]);
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
        invertirCadena(cadena, cadena.length - 1);
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(frase);
    }
}
