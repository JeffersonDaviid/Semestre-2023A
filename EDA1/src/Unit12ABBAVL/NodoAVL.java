package Unit12ABBAVL;

import javax.swing.JOptionPane;

class NodoAVL {
    private NodoAVL Der; // Variable que referencia al hijo derecho del nodo.
    private NodoAVL Izq; // Variable que referencia al hijo izquierdo del nodo.
    private int info; // Valor almacenado en el nodo.

    private int Fe; // Factor de equilibrio del nodo (diferencia entre alturas de los subárboles
                    // izquierdo y derecho).

    // Constructor vacío.
    public NodoAVL() {
    }

    // Constructor con parámetro para inicializar el nodo con un valor.
    public NodoAVL(int inf) {
        this.Der = null;
        this.Izq = null;
        this.info = inf;
    }

    // Método para obtener el hijo derecho del nodo.
    public NodoAVL getDer() {
        return Der;
    }

    // Método para obtener el factor de equilibrio del nodo.
    public int getFe() {
        return Fe;
    }

    // Método para establecer el factor de equilibrio del nodo.
    public void setFe(int Fe) {
        this.Fe = Fe;
    }

    // Método para establecer el hijo derecho del nodo.
    public void setDer(NodoAVL Der) {
        this.Der = Der;
    }

    // Método para obtener el hijo izquierdo del nodo.
    public NodoAVL getIzq() {
        return Izq;
    }

    // Método para establecer el hijo izquierdo del nodo.
    public void setIzq(NodoAVL Izq) {
        this.Izq = Izq;
    }

    // Método para obtener el valor almacenado en el nodo.
    public int getInfo() {
        return info;
    }

    // Método para establecer el valor almacenado en el nodo.
    public void setInfo(int info) {
        this.info = info;
    }

    // Método para insertar un nuevo nodo en el subárbol del nodo actual.
    // El método inserta el nodo manteniendo el árbol ordenado (nodos menores a la
    // izquierda y mayores a la derecha).
    public void insertarNodo(int inf) {
        if (inf < this.info) {
            if (this.Izq == null) {
                this.Izq = new NodoAVL(inf);
            } else {
                this.Izq.insertarNodo(inf);
            }
        } else {
            if (inf > this.info) {
                if (this.Der == null) {
                    this.Der = new NodoAVL(inf);
                } else {
                    this.Der.insertarNodo(inf);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nodo ya insertado");
            }
        }
    }
}
