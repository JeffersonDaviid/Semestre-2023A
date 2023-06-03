package Unit5Colas;

import javax.swing.JOptionPane;

/*

ALGORITMO COLAVACIA(cola, f, B)
    Si (f=0)
        entonces
            B <- V
        Si no 
            B <- F
    Fin si
Fin algoritmo

ALGORITMO COLALLENA(cola, f, B, max)
    Si (f=max)
        entonces
            B <- V
        Si no 
            B <- F
    Fin si
Fin algoritmo


ALGORITMO INSERTARCOLASIMPLE(cola, f, F, dato, max)
    Si(F < max)
        entonces
            F <- F +1 
            cola[F] <- dato
        si no
            si (F=1)
                entonces
                    f <- f +1
            Fin si
        Fin si
    si no 
        Imprimir "Desbordamiento"
    Fin si
Fin algoritmo


ALGORITMO ELIMINAR(cola, f, F, dato, max)}
    Si (f != 0)
        entonces 
            dato <- cola[f]
        Si (F = f)
            entonces
                F <- 0
                f <- 0
            Si no
                f <- f + 1
            Fin si
        si no
            imprimir "subdesbordamiento"
        Fin si
    Fin si
fin algoritmo
    


 */

public class ColaSimple {

    // con las variables auxiliares
    private String cola1[];
    private int frente = -1;
    private int FIN = -1;

    public ColaSimple() {
        super();
    }

    public ColaSimple(int dimension) {
        this.cola1 = new String[dimension];
    }

    public String[] getCola() {
        return cola1;
    }

    public void setCola(String[] cola) {
        this.cola1 = cola;
    }

    // Funcion para insertar elemnento a la cola
    public void InsertarCola(String dato) {
        // Si la cola esta llena
        if (this.cola1.length == this.FIN + 1) {
            JOptionPane.showMessageDialog(null, "La cola simple llena\n Existe Desbordamiento");
        } else {
            // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
            this.FIN = this.FIN + 1;
            this.cola1[this.FIN] = dato;
            // si es que el puntero FIN apunta a 0 es porque no hay elementos
            if (this.FIN == 0) {
                // entonces el puntero frente apunta a la misma posición
                this.frente = 0;
            }
        }
    }

    // funcion para eliminar un elemento de la colas
    public void eliminarCola() {
        if (this.frente == -1) {
            JOptionPane.showMessageDialog(null, "Cola vacía\n Se puede producir un subdesbordamiento");
        } else {
            // Si existe un solo elemento
            if (this.frente == this.FIN) {
                // eliminamos el elemento
                this.cola1[this.frente] = null;
                // cambiamos los punteros a una posición nula (para nuestro ejemplo)
                this.frente = -1;
                this.FIN = -1;
            } else {
                // elimino el dato
                this.cola1[this.frente] = null;
                // cambia la posicion del puntero frente
                this.frente = this.frente + 1;
            }
        }
    }

    public String toString() {
        String salida = "";
        for (int i = 0; i < this.cola1.length; i++) {
            salida += this.cola1[i] + " | ";
        }
        return salida;
    }

}
