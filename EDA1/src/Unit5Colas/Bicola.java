package Unit5Colas;
// JEFFERSON CHILENO

import javax.swing.JOptionPane;

public class Bicola {
    // con las variables auxiliares
    private String bicola1[];
    private int frente = -1;
    private int FIN = -1;
    private boolean insertarEliminarIzquierdaFlag = true;

    public Bicola() {
        super();
    }

    public Bicola(int dimension) {
        this.bicola1 = new String[dimension];
    }

    public String[] getCola() {
        return bicola1;
    }

    public void setCola(String[] bicola) {
        this.bicola1 = bicola;
    }

    public String toString() {
        String salida = "";
        for (int i = 0; i < this.bicola1.length; i++) {
            salida += this.bicola1[i] + " | ";
        }
        return salida;
    }

    /**
     * 
     * Funcion para insertar elemnento a la bicola
     * 
     * Es igual al algoritmo de insercción de bicola simple
     * 
     * @param dato: valor que va a ingresar a la bicola
     */
    public void insertarConEntradaRestringida(String dato) {
        // Si la bicola esta llena
        if (this.bicola1.length == this.FIN + 1) {
            JOptionPane.showMessageDialog(null, "La bicola esta llena\n Existe Desbordamiento");
        } else {
            // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
            this.FIN = this.FIN + 1;
            this.bicola1[this.FIN] = dato;
            // si es que el puntero FIN apunta a 0 es porque no hay elementos
            if (this.FIN == 0) {
                // entonces el puntero frente apunta a la misma posición
                this.frente = 0;
            }
        }
    }

    /**
     * Funcion para eliminar un elemento de la bicola con entrada restringida
     */
    public void eliminarConEntradaRestringida() {
        if (this.FIN == -1 && this.frente == -1) {
            JOptionPane.showMessageDialog(null, "Bicola vacia\n Se puede producir subdesbordamiento");
        } else {

            // Si existe un solo elemento
            if (this.frente == this.FIN) {
                // eliminamos el elemento
                this.bicola1[this.frente] = null;
                // cambiamos los punteros a una posición nula (para nuestro ejemplo)
                this.frente = -1;
                this.FIN = -1;
            } else {

                if (this.insertarEliminarIzquierdaFlag) {
                    // elimino el dato
                    this.bicola1[this.frente] = null;
                    // cambia la posicion del puntero frente
                    this.frente = this.frente + 1;
                    this.insertarEliminarIzquierdaFlag = false;
                } else {
                    // elimino el dato
                    this.bicola1[this.FIN] = null;
                    // cambia la posicion del puntero frente
                    this.FIN = this.FIN - 1;
                    this.insertarEliminarIzquierdaFlag = true;
                }

            }

            System.out.println("El puntero frente esta en : " + this.frente);
            System.out.println("El puntero fin esta en : " + this.FIN);

        }

    }

    /**
     * Función para insertar un elemento en la bicola con salida restrigida
     * 
     * @param dato: valor que se va a guardar en la bicola
     */
    public void insertarConSalidaRestringida(String dato) {
        // Si la bicola esta llena
        if (this.bicola1.length == this.FIN + 1 && this.frente == 0) {
            JOptionPane.showMessageDialog(null, "La bicola esta llena\n Existe Desbordamiento");
        } else {

            if (this.insertarEliminarIzquierdaFlag) {
                if (this.bicola1[this.frente] == null && this.frente >= 0) {
                    // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
                    this.frente = this.frente - 1;
                    this.bicola1[this.FIN] = dato;
                } else {
                    // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
                    this.FIN = this.FIN + 1;
                    this.bicola1[this.FIN] = dato;
                }
            } else {
                if (this.FIN + 1 == this.bicola1.length) {
                    // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
                    this.frente = this.frente - 1;
                    this.bicola1[this.FIN] = dato;
                } else {
                    // Si no esta llena cambiamos el puntero del FIN a la siguiente posición
                    this.FIN = this.FIN + 1;
                    this.bicola1[this.FIN] = dato;
                }

            }

            if (this.FIN == 0) {
                // entonces el puntero frente apunta a la misma posición
                this.frente = 0;
            }
        }
    }

    /**
     * funcion para eliminar un elemento de la bicola con salida restringida
     * 
     * Es igual al algoritmo de eliminación de bicola simple
     * 
     */
    public void eliminarConSalidaRestringida() {
        if (this.frente == -1) {
            JOptionPane.showMessageDialog(null, "bicola vacía\n Se puede producir un subdesbordamiento");
        } else {
            // Si existe un solo elemento
            if (this.frente == this.FIN) {
                // eliminamos el elemento
                this.bicola1[this.frente] = null;
                // cambiamos los punteros a una posición nula (para nuestro ejemplo)
                this.frente = -1;
                this.FIN = -1;
            } else {
                // elimino el dato
                this.bicola1[this.frente] = null;
                // cambia la posicion del puntero frente
                this.frente = this.frente + 1;
            }
        }
    }

    public static void main(String[] args) {
        int tamano, opcion, opcionBicola;
        tamano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la bicola: "));
        Bicola bicola = new Bicola(tamano);
        opcionBicola = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el tipo de bicola que desea usar:\n\n1. Bicola con entrada restringida\n2. Bicola con salida restringida"));

        if (opcionBicola == 1) {
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "MENU\nEscoga la opcion que desee realizar en la bicola con entrada restringida:\n1. Ingresar un dato\n2. Eliminar un dato\n3. Visualizar bicola\n4. Salir"));

                switch (opcion) {
                    case 1:
                        bicola.insertarConEntradaRestringida(
                                JOptionPane.showInputDialog("Ingrese el nombre a insertar"));
                        JOptionPane.showMessageDialog(null, bicola.toString());
                        break;
                    case 2:
                        bicola.eliminarConEntradaRestringida();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, bicola.toString());
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se ha ingresado una opcion valida");
                        break;
                }
            } while (opcion != 4);
        } else if (opcionBicola == 2) {

            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "MENU\nEscoga la opcion que desee realizar en la bicola con salida restringida: \n1. Ingresar un dato\n2. Eliminar un dato\n3. Visualizar bicola\n4. Salir"));

                switch (opcion) {
                    case 1:
                        bicola.insertarConSalidaRestringida(
                                JOptionPane.showInputDialog("Ingrese el nombre a insertar"));
                        JOptionPane.showMessageDialog(null, bicola.toString());
                        break;
                    case 2:
                        bicola.eliminarConSalidaRestringida();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, bicola.toString());
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No se ha ingresado una opcion valida");
                        break;

                }
            } while (opcion != 4);

        } else {
            JOptionPane.showMessageDialog(null, "La opción no es válida, gracias por usar nuestra app :)");
        }
    }

}
