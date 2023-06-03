package Unit5Colas;

/*

ALGORITMO insertarEnCC(colac, F, max, dato)
    Si ((F = max) y (F = 1) o F + 1 = F)
        entonces
            imprimir "desbordamiento"
        Si no 
            Si (F = max)
                entonces
                    F <- 1
                Si no
                    F <- F + 1
            Fin si
        Fin si
        hacer colac[F] <- dato
    Fin si
Fin algoritmo


ALGORITMO eliminarEnCC(colac, F, max, dato)
    Si (F = 0)
        entonces
            imprimir "subdesbordamiento"
        Si no 
            hacer dato <- colac[F]
            Si (F = F)
                entonces
                    F <- 0
                    f <- 0
            Si ( F = max)
                entonces
                    F <- 1
            Fin si
        Fin si
    Fin si
Fin algoritmo

 */

import javax.swing.JOptionPane;

public class ColaCircular {
    private String cola[];
    private int frente = -1;
    private int FIN = -1;

    public ColaCircular() {
        super();
    }

    public ColaCircular(int dimension) {
        this.cola = new String[dimension];
    }

    public String[] getCola() {
        return cola;
    }

    public void setCola(String[] cola) {
        this.cola = cola;
    }

    public void llenarCola(String dato) {
        // Si los punteros de la cola: frente apunta a la primera posición de la cola y
        // el fin apunta al max de la cola O que el puntero FIN ya se dio una vuelta y
        // coincide con el puntero frente
        if ((this.frente == 0 && this.cola.length == this.FIN + 1) || (this.FIN + 1 == this.frente)) {
            JOptionPane.showMessageDialog(null, "Cola llena\nSe puede producir un desbordamiento");

        } else {
            // Si la cola esta vacia
            if (this.frente == -1) {
                // cambiarmos los punteros a la primera posición y guardamos el dato en esa
                // posición
                this.FIN = 0;
                this.frente = 0;
                this.cola[this.FIN] = dato;

                // Si la cola no esta vacia
            } else {
                // Si el puntero esta al final de la cola circular
                if (this.cola.length == this.FIN + 1) {
                    // cambiar el puntero
                    this.FIN = 0;
                    this.cola[this.FIN] = dato;

                    // si el puntero NO esta al final de la cola circular
                } else {
                    // avanzamos una posicón y guardamos el dato
                    this.FIN = this.FIN + 1;
                    this.cola[this.FIN] = dato;
                }
            }
        }
    }

    public void borrarDato() {
        // si la cola esta vacia
        if (this.frente == -1) {
            JOptionPane.showMessageDialog(null, "Cola vacía\nSe puede producir un subdesbordamiento");
        } else {
            // Si hay un solo elemento en la cola circular
            if (this.frente == this.FIN) {
                // eliminamos el elemento
                this.cola[this.frente] = null;
                // cambiar el puntero fuera de la cola circular
                this.frente = -1;
                this.FIN = -1;

                // si hay varios datos
            } else {
                // si el puntero frente esta al final de la cola
                if (this.frente == this.cola.length) {
                    // se elimina el valor en esta posición
                    this.cola[this.frente] = null;
                    // cambia el puntero a la primera posición de la cola
                    this.frente = this.frente + 1;

                    // Si no esta en la ultima posición de la cola circular
                } else {
                    // eliminar los elementos de esa posición y movemos una posición adelante
                    this.cola[this.frente] = null;
                    this.frente = this.frente + 1;
                }
            }
        }
    }

    public String toString() {
        String salida = "";
        for (int i = 0; i < this.cola.length; i++) {
            salida += this.cola[i] + " | ";
        }
        return salida;
    }

    public static void main(String[] args) {
        int tamano, opcion;
        tamano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la cola circular: "));
        ColaCircular cola = new ColaCircular(tamano);

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU\nEscoga la opcion que desee realizar en la cola simple: \n1. Ingresar un dato\n2. Eliminar un dato\n3. Visualizar cola\n4. Salir"));

            switch (opcion) {
                case 1:
                    cola.llenarCola(JOptionPane.showInputDialog("Ingrese el nombre a insertar"));
                    JOptionPane.showMessageDialog(null, cola.toString());
                    break;
                case 2:
                    cola.borrarDato();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, cola.toString());
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
