import javax.swing.*;

public class Recursividad {
    private int num; //Creamos la variable num

    public Recursividad() { //Constructor vacío
        super();
    }

    public int getNum() { //Obtenemos la variable num
        return num;
    }

    public void setNum(int num) { //Establecemos un valor a la variable num
        this.num = num;
    }

    //Método para poder elevar un numero a una potencia
    public int crearPotencia(int base, int exponente) { //Establecemos como parámetros la base y el exponente
        int potencia = 0; //Creamos una variable potencia y la inicializamos en 0
        if (exponente == 0) { //Comprobamos si el exponente está elevado a 0
            potencia = 1; //Pasamos el valor de 1 a la potencia si se cumple la condición
        } else {
            if (exponente == 1) { //Comprobamos si el exponente está elevado a 1
                potencia = base; //Pasamos el valor de la misma base si se cumple la condición
            } else {
                if (exponente > 1) { //Comprobamos si el exponente es mayor a 1
                    //Multiplicamos la base por nuestra función potencia para poder obtener un número elevado a cierto exponente y guardamos en
                    //nuestra variable potencia, en este caso se hace el uso de recursividad
                    potencia = base * crearPotencia(base, (exponente - 1));
                }
            }
        }
        return potencia; //Retornamos el resultado de elevar un número a un determinado exponente
    }

    //Método para poder usar torres de Hanoi especificando los pasos que se uso con un determinado número de discos
    public int ejercutarTorreHanoi(int numero, String origen, String destino, String auxiliar) { //Establecemos 4 parámetros para nuestro método
        int contador = 0; //Creamos una variable contadora inicializada en 0
        if (numero == 1) { //Establecemos el paso base cuando hay un solo disco
            JOptionPane.showMessageDialog(null, "Mover un disco del " + origen + " al " + destino); //Mensaje para indicar el movimiento del disco
        } else {
            //Llamamos de forma recursiva a nuestro método de Torre de Hanoi, intercambiando el destino y el auxiliar.
            //Esto se hace para mover todos los discos excepto el más grande al auxiliar y se disminuye los discos en 1.
            ejercutarTorreHanoi(numero - 1, origen, auxiliar, destino);
            //Mensaje para indicar el movimiento de los discos
            JOptionPane.showMessageDialog(null, "Mover un disco del " + origen + " al " + destino);
            //Llamamos de forma recursiva a nuestro método de Torre de Hanoi, intercambiando el origen y el auxiliar.
            //Esto se hace para mover los discos del auxiliar al destino y se disminuye los discos en 1.
            ejercutarTorreHanoi(numero - 1, auxiliar, destino, origen);
        }
        contador = (crearPotencia(2, numero) - 1); //El contador es igual al número de movimientos por eso se usa la fórmula 2^n - 1
        return contador; //Contador se retorna con el número total de pasos.
    }
}
