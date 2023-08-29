package Unit12ABBAVLPersonal;

import javax.swing.JOptionPane;

class NodoAVL {
    private NodoAVL zDer; // Variable que referencia al hijo derecho del nodo.
    private NodoAVL aIzq; // Variable que referencia al hijo izquierdo del nodo.
    private int info; // Valor almacenado en el nodo.

    private int Fe; // Factor de equilibrio del nodo (diferencia entre alturas de los subárboles
                    // izquierdo y derecho).

    // Constructor vacío.
    public NodoAVL() {
    }

    // Constructor con parámetro para inicializar el nodo con un valor.
    public NodoAVL(int inf) {
        this.zDer = null;
        this.aIzq = null;
        this.info = inf;
    }

    // Método para obtener el hijo derecho del nodo.
    public NodoAVL getDer() {
        return zDer;
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
        this.zDer = Der;
    }

    // Método para obtener el hijo izquierdo del nodo.
    public NodoAVL getIzq() {
        return aIzq;
    }

    // Método para establecer el hijo izquierdo del nodo.
    public void setIzq(NodoAVL Izq) {
        this.aIzq = Izq;
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

    // public void insertarNodo(int inf) {
    // if (inf < this.info) {
    // if (this.aIzq == null) {
    // this.aIzq = new NodoAVL(inf);
    // } else {
    // this.aIzq.insertarNodo(inf);
    // }
    // } else {
    // if (inf > this.info) {
    // if (this.zDer == null) {
    // this.zDer = new NodoAVL(inf);
    // } else {
    // this.zDer.insertarNodo(inf);
    // }
    // } else {
    // JOptionPane.showMessageDialog(null, "Nodo ya insertado");
    // }
    // }
    // }
}
