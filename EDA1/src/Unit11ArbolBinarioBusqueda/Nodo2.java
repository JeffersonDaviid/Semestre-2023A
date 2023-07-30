package Unit11ArbolBinarioBusqueda;

import javax.swing.*;

public class Nodo2 {
    private Nodo2 izq;
    private Nodo2 der;
    private int info;

    public Nodo2(int inf) {
        super();
        this.izq = null;
        this.der = null;
        this.info = inf;
    }

    public Nodo2() {
        super();
    }

    public Nodo2 getIzq() {
        return izq;
    }

    public void setIzq(Nodo2 izq) {
        this.izq = izq;
    }

    public Nodo2 getDer() {
        return der;
    }

    public void setDer(Nodo2 der) {
        this.der = der;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void insertar(int valorInsertar) {
        if (valorInsertar < this.info) {
            if (this.izq == null) {
                this.izq = new Nodo2(valorInsertar);
            } else {
                this.izq.insertar(valorInsertar);
            }
        } else {
            if (valorInsertar > this.info) {
                if (this.der == null) {
                    this.der = new Nodo2(valorInsertar);
                } else {
                    this.der.insertar(valorInsertar);
                }
            } else {
                if (valorInsertar == this.info) {
                    JOptionPane.showMessageDialog(null, "El dato ya existe");
                }
            }
        }
    }
}
