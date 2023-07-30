package Unit11ArbolBinarioBusqueda;

import javax.swing.JOptionPane;

// AUTOR: JEFFERSON CHILENO 
public class ArbolBusqueda {

    public static Node crearArbolDeBusqueda() {
        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo: "));
        Node arbol = new Node(dato);
        int option = 0;

        option = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea añadir más nodos?\n1. Si\n0. No"));

        while (option != 0) {
            insertarNodo(arbol);

            option = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea añadir más nodos?\n1. Si\n0. No"));
        }

        return arbol;
    }

    public static Node insertarNodo(Node ABB) {
        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo"));
        Node hijo = new Node(dato);
        Node aux = ABB;

        while (aux.getRight() != null || aux.getLeft() != null) {
            if (dato > aux.getInfo()) {
                if (aux.getRight() == null)
                    break;
                aux = aux.getRight();
            } else if (dato <= aux.getInfo()) {
                if (aux.getLeft() == null)
                    break;
                aux = aux.getLeft();
            }
        }

        if (dato == aux.getInfo())
            JOptionPane.showMessageDialog(null,
                    "El dato " + dato + " ya se encuentra en el Arbol Binario de Búsqueda");

        if (dato > aux.getInfo()) {
            aux.setRight(hijo);
        }
        if (dato < aux.getInfo()) {
            aux.setLeft(hijo);
        }

        return ABB;
    }

    public static void BusquedaABB(Node ABB, int dato) {
        Node aux = ABB;

        if (ABB == null) {
            JOptionPane.showMessageDialog(null, "ABB vacío");
            return;
        }
        // Recorrer el arbol
        while ((aux.getRight() != null || aux.getLeft() != null) && aux.getInfo() != dato) {
            if (dato > aux.getInfo()) {
                if (aux.getRight() == null)
                    break;
                aux = aux.getRight();
            } else if (dato < aux.getInfo()) {
                if (aux.getLeft() == null)
                    break;
                aux = aux.getLeft();
            }
        }

        if (dato == aux.getInfo()) {
            JOptionPane.showMessageDialog(null, "El nodo con dato '" + dato + "' ha sido encontrado");
        } else {
            JOptionPane.showMessageDialog(null, "El nodo con dato '" + dato + "' no ha sido encontrado");
        }
    }

    // EL INSERTAR CON RECURSIVIDAD NO ME SALIO
    public static Node insertarNodoABB(Node ABB) {
        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo"));
        Node hijo = new Node(dato);

        if (hijo.getInfo() > ABB.getInfo()) {
            return insertarNodoABB(ABB.getRight());
        } else if (hijo.getInfo() <= ABB.getInfo()) {
            return insertarNodoABB(ABB.getLeft());
        }
        return null;
    }

    public static void main(String[] args) {
        Node ABB = null;

        int option = -1;
        do {

            switch (option = Integer
                    .parseInt(JOptionPane.showInputDialog(null,
                            "\tARBOLES BINARIOS DE BÚSQUDA\n1. CREAR ARBOL\n2. INSERTAR NODO \n3. RECORRIDO PREORDEN\n4. RECORRIDO INORDEN\n5. RECORRIDO POSTORDEN\n6. BUSQUEDA\n\n\n0. Salir"))) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta la proxima!");
                    break;

                case 1:
                    ABB = crearArbolDeBusqueda();
                    break;
                case 2:
                    insertarNodo(ABB);
                    break;
                case 3:
                    RecorridoPreorden(ABB);
                    break;
                case 4:
                    RecorridoInOrden(ABB);
                    break;
                case 5:
                    RecorridoPostOrden(ABB);
                    break;
                case 6:
                    int dato = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese el nodo que desea buscar: "));
                    BusquedaABB(ABB, dato);
                    break;
                case 7:

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es válida");
                    break;

            }
        } while (option != 0);

    }

    public static void RecorridoPreorden(Node ABB) {
        AyudantePreorden(ABB);
    }

    public static void AyudantePreorden(Node ABB) {
        if (ABB != null) {
            JOptionPane.showMessageDialog(null, ABB.getInfo());
            AyudantePreorden(ABB.getLeft());
            AyudantePreorden(ABB.getRight());
        }
    }

    public static void RecorridoInOrden(Node ABB) {
        AyudantePreorden(ABB);
    }

    public static void AyudanteInOrden(Node ABB) {
        if (ABB != null) {
            AyudanteInOrden(ABB.getLeft());
            JOptionPane.showMessageDialog(null, ABB.getInfo());
            AyudanteInOrden(ABB.getRight());
        }
    }

    public static void RecorridoPostOrden(Node ABB) {
        AyudantePostOrden(ABB);
    }

    public static void AyudantePostOrden(Node ABB) {
        if (ABB != null) {
            AyudantePostOrden(ABB.getLeft());
            AyudantePostOrden(ABB.getRight());
            JOptionPane.showMessageDialog(null, ABB.getInfo());
        }
    }
}
