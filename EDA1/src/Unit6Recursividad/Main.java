//Algoritmos
/*
AlgoritmoTorresDeHanoi(numero, origen, destino, auxiliar)
    contador <- variable de tipo entero
    Hacer contador <- 0
    Si (numero = 1) entonces
        Mostrar "Mover un disco del" origen  "al"  destino
    SiNo
        Llamar a crearTorreHanoi(numero - 1, origen, auxiliar, destino)
        Mostrar "Mover un disco del" origen "al" destino
        Llamar a crearTorreHanoi(numero - 1, auxiliar, destino, origen)
    FinSi
    Hacer contador <- (2^numero - 1)
    Devolver contador
FinAlgoritmo
 */
//***********************************************************************************************
/*
AlgoritmoPotencia(base, exponente)
    potencia <- variable de tipo entero
    Hacer potencia <- 0
    Si (exponente = 0) entonces
        Hacer potencia <- 1
    Sino
        Si (exponente = 1) entonces
            Hacer potencia <- base
        Sino
            Si (exponente > 1) entonces
                potencia = base * crearPotencia(base, exponente - 1)
            FinSi
        FinSi
    FinSi
    Devolver potencia
FinAlgoritmo
 */

//Implementación
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Recursividad recursividad = new Recursividad();
        int opcion, num; // Creamos las variables que vamos a utilizar
        do {
            // Pedimos al usuario que ingrese una opción y mostramos un mensaje
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU RECURSIVIDAD - CASOS MAEMATICOS \n " +
                    "1. Torres de Hanoi\n" + "2. Salir"));
            switch (opcion) {
                case 1: // Ejecutamos el método de las Torres de Hanoi
                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de discos")); // Pedimos
                                                                                                              // al
                                                                                                              // usuario
                                                                                                              // el
                                                                                                              // número
                                                                                                              // de
                                                                                                              // discos
                    JOptionPane.showMessageDialog(null, "Para mover " + num + " discos se usaron " +
                            recursividad.ejercutarTorreHanoi(num, "ORIGEN", "DESTINO", "AUXILIAR") + " pasos"); // Llamamos
                                                                                                                // a
                                                                                                                // nuestro
                                                                                                                // método
                                                                                                                // ejecutarTorreHanoi
                case 2: // Salimos del menú
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se ha ingresado una opcion valida");
            }
        } while (opcion != 2);
    }
}