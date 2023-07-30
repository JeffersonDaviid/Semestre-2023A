package Unit10ArboleBinario;

import javax.swing.JOptionPane;

public class Arboles {
    private Nodo APNODO;

    public Arboles() {
        this.APNODO = null;
    }

    public Nodo getAPNODO() {
        return APNODO;
    }

    public void setAPNODO(Nodo APNODO) {
        this.APNODO = APNODO;
    }

    public void RecorridoPreorden() {
        AyudantePreorden(this.APNODO);
    }

    public void AyudantePreorden(Nodo nodo) {
        if (nodo != null) {
            JOptionPane.showMessageDialog(null, nodo.getDato());
            AyudantePreorden(nodo.getIzquierdo());
            AyudantePreorden(nodo.getDerecha());
        }
    }

    public void RecorridoInOrden() {
        AyudantePreorden(this.APNODO);
    }

    public void AyudanteInOrden(Nodo nodo) {
        if (nodo != null) {
            AyudanteInOrden(nodo.getIzquierdo());
            JOptionPane.showMessageDialog(null, nodo.getDato());
            AyudanteInOrden(nodo.getDerecha());
        }
    }

    public void RecorridoPostOrden() {
        AyudantePostOrden(this.APNODO);
    }

    public void AyudantePostOrden(Nodo nodo) {
        if (nodo != null) {
            AyudantePostOrden(nodo.getIzquierdo());
            AyudantePostOrden(nodo.getDerecha());
            JOptionPane.showMessageDialog(null, nodo.getDato());
        }
    }
}
