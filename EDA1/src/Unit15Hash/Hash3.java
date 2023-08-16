/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit15Hash;

import java.util.Arrays; //reemplace este por el ingreso o llenado de una arreglo

import javax.swing.JOptionPane;

public class Hash3 {
    private String[] arreglo;
    private int tamanio;

    public Hash3(String a) {
        super();
        try {
            tamanio = Integer.parseInt(
                    JOptionPane.showInputDialog("INGRESE EL NUMERO DE CLAVES QUE VAN A SER UBICADAS EN LA TABLA HASH"));
            this.arreglo = new String[tamanio];
            Arrays.fill(this.arreglo, "vacio");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SOLO SE PUEDEN INGRESAR NUMEROS");
        }
    }

    public Hash3(int tamanio) {
        super();
        this.tamanio = tamanio;
        this.arreglo = new String[tamanio];
        Arrays.fill(this.arreglo, "vacio");
    }

    public Hash3() {
        super();
    }

    public String[] getVector() {
        return arreglo;
    }

    public void setVector(String[] vector) {
        this.arreglo = vector;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void ingresarClaves() {
        int i = 1, opc;
        do {
            this.arreglo[i - 1] = JOptionPane.showInputDialog("Ingrese una clave");
            opc = JOptionPane.showConfirmDialog(null, "Desea ingresar otra clave");
            i++;
        } while (opc == JOptionPane.YES_OPTION && (i <= this.arreglo.length));
        if (i > this.arreglo.length) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar más claves");
        }
    }

    public void hashModulo(Hash3 claves, Hash3 nuevo) {
        for (int i = 0; i < this.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (elemento != "vacio") {
                int indiceArreglo = Integer.parseInt(elemento) % (claves.tamanio - 1);
                System.out.println("El indice es:" + indiceArreglo + " Para el elemento " + elemento);
                while (nuevo.arreglo[indiceArreglo] != "vacio") {
                    JOptionPane.showMessageDialog(null, "Ocurrió una colision en el índice " + indiceArreglo);
                    System.out.println("\nOcurrió una colisión en el índice " + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                    System.out
                            .println("el nuevo  índice es: " + indiceArreglo + " para el elemento " + elemento + "\n");
                }
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    public void hashCuadrado(Hash3 claves, Hash3 nuevo) {
        int indiceArreglo = 0, tem;
        String aux;
        for (int i = 0; i < this.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (elemento != "vacio") {
                aux = String.valueOf(Math.pow(Integer.parseInt(elemento), 2));
                char[] aux1 = aux.toCharArray();
                tem = (int) Math.floor((aux1.length - 2) / 2);
                indiceArreglo = Integer.parseInt("" + (aux1[tem]));
                System.out.println("El índice es: " + indiceArreglo + " Para el elemento " + elemento);
                while (nuevo.arreglo[indiceArreglo] != "vacio") {
                    JOptionPane.showMessageDialog(null, "Ocurrió una Colisión en el índice " + (indiceArreglo));
                    System.out.println("\nOcurrio una Colisión en el índice" + indiceArreglo);
                    indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                    System.out.println("El nuevo índice es: " + indiceArreglo + " Para el elemeto " + elemento + "\n");
                }
                nuevo.arreglo[indiceArreglo] = elemento;
            }
        }
    }

    public void hashPlegamento(Hash3 claves, Hash3 nuevo) {
        int indiceArreglo = 0, tem = 0;
        String aux;
        for (int i = 0; i < this.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (elemento != "vacio") {
                aux = String.valueOf((int) Math.pow((Integer.parseInt(elemento)), 2));
                char[] aux1 = aux.toCharArray();
                for (int j = 0; j < (aux1.length - 2); j++) {
                    tem += Integer.parseInt("" + aux1[j]);
                }
                while (tem > this.arreglo.length) {
                    tem %= 10;
                }
                if (tem > this.arreglo.length) {
                    indiceArreglo = tem;
                    System.out.println("El índice es:" + indiceArreglo + " Para el elemento " + elemento);
                    while (this.arreglo[indiceArreglo] != "vacio") {
                        JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice " + indiceArreglo);
                        indiceArreglo = solucionarColision(indiceArreglo, nuevo, claves);
                    }
                    this.arreglo[indiceArreglo] = elemento;
                    tem = 0;
                }
            }
        }
    }

    public void hashTruncamiento(Hash3 claves, Hash3 nuevo) {
        int indiceArrelgo = 0, tem = 0;
        for (int i = 0; i < this.arreglo.length; i++) {
            String elemento = claves.arreglo[i];
            if (elemento != "vacio") {
                char[] aux1 = elemento.toCharArray();
                for (int j = 0; j < (aux1.length); j++) {
                    if ((j % 2) == 1) {
                        tem += Integer.parseInt("" + aux1[j]);
                    }
                }
                while (tem > this.arreglo.length) {
                    tem %= 10;
                }
                if (tem < this.arreglo.length) {
                    indiceArrelgo = tem;
                    System.out.println("El índice es: " + indiceArrelgo + " Para el elemento " + elemento);
                    while (this.arreglo[indiceArrelgo] != "vacio") {
                        JOptionPane.showMessageDialog(null, "Ocurrió una colisión en el índice: " + indiceArrelgo);
                        indiceArrelgo = solucionarColision(indiceArrelgo, nuevo, claves);
                    }
                    this.arreglo[indiceArrelgo] = elemento;
                    tem = 0;
                }
            }
        }
    }

    private int solucionarColision(int anteriorIndice, Hash3 vec, Hash3 claves) {
        int re = 0, i = 1;
        int nuevoIndice = anteriorIndice;
        do {
            re = 0;
            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione método a usar para solucionar la colisión\n 1.Prueba linea\n2. Prueba cuadrática\n3. Doble dirección hash\n4. Arreglos Anidados\n5. Encadenamiento"));
            if (op == 1) {
                do {
                    nuevoIndice = (((Integer.parseInt(vec.arreglo[anteriorIndice])) + 1) % (vec.tamanio - 1)) + 1;
                    i++;
                } while (vec.arreglo[nuevoIndice] != "vacio");
            } else if (op == 2) {
                do {
                    nuevoIndice = ((Integer.parseInt(vec.arreglo[anteriorIndice]) + (int) Math.pow(i, 2))
                            % (vec.tamanio - 1)) + 1;
                    i++;
                } while (vec.arreglo[nuevoIndice] != "vacio");
            } else if (op == 3) {
                do {
                    nuevoIndice = ((anteriorIndice + i) % (vec.tamanio - 1)) + 1;
                    i++;
                } while (vec.arreglo[nuevoIndice] != "vacio");
            } else {
                if (op == 4) {
                    String[][] resultado;
                    resultado = arreglosAnidados(claves);
                    JOptionPane.showMessageDialog(null, salidaAnidados(resultado));
                    System.exit(1);
                } else {
                    if (op == 5) {
                        String[][] resultado;
                        resultado = encadenamiento(claves);
                        JOptionPane.showMessageDialog(null, salidaEncadenamiento(resultado));
                        System.exit(1);
                    } else {
                        re = 1;
                        JOptionPane.showMessageDialog(null,
                                "No se ha ingresado un valor correcto\n Vuelve a ingresarlo");
                    }
                }
            }
        } while (re == 1);
        return nuevoIndice;
    }

    public String[][] arreglosAnidados(Hash3 claves) {
        int indice;
        int j = 0;
        String[][] ma = new String[claves.tamanio][claves.tamanio];
        for (int l = 0; l < claves.tamanio; l++) {
            for (int k = 0; k < claves.tamanio; k++) {
                ma[l][k] = " ";
            }
        }
        for (int i = 0; i < claves.tamanio; i++) {
            if (claves.arreglo[i] != "vacio") {
                indice = (Integer.parseInt(claves.arreglo[i]) % (claves.tamanio - 1)) + 1;
                if (ma[indice][j] == " ") {
                    ma[indice][j] = claves.arreglo[i];
                    j = 0;
                } else {
                    j++;
                    System.out.println("\n\n Se ha generado un nuevo arreglo para la clave " + claves.arreglo[i]
                            + " con el índice" + indice);
                    i--;
                }
            }
        }
        return ma;
    }

    public String[][] encadenamiento(Hash3 claves) {
        int indice;
        int j = 0;
        String[][] ma = new String[claves.tamanio][claves.tamanio];
        for (int l = 0; l < claves.tamanio; l++) {
            for (int k = 0; k < claves.tamanio; k++) {
                ma[l][k] = " ";
            }
        }
        for (int i = 0; i < claves.tamanio; i++) {
            if (claves.arreglo[i] != "vacio") {
                indice = (Integer.parseInt(claves.arreglo[i]) % (claves.tamanio - 1)) + 1;
                if (ma[indice][j] == " " || ma[indice][j] == "null") {
                    ma[indice][j] = claves.arreglo[i];
                    ma[indice][j + 1] = "null";
                    j = 0;
                } else {
                    j++;
                    System.out.println("\n\n Se ha generado un nuevo arreglo para la clave " + claves.arreglo[i]
                            + " con el índice" + indice);
                    i--;
                }
            }
        }
        return ma;
    }

    public String salidaAnidados(String[][] ma) {
        String salida = "----------MATRIZ DE ARREGLOS ANIDADOS------------\n Claves en los nuevos vectores";
        for (int i = 0; i < ma.length; i++) {
            salida += "| " + i + " |";
            for (int j = 0; j < ma.length; j++) {
                if (ma[i][j] != "") {
                    salida += "--->| " + ma[i][j] + " |";
                } else {
                    salida += ma[i][j] + " ";
                }
            }
            salida += "\n";
        }
        return salida;
    }

    public String salidaEncadenamiento(String[][] ma) {
        String salida = "----------ENCADENAMIENTO------------\n Claves en los nuevos vectores";
        for (int i = 0; i < ma.length; i++) {
            salida += "| " + i + " |";
            for (int j = 0; j < ma.length; j++) {
                if (ma[i][j] != "") {
                    salida += "--->| " + ma[i][j] + " |";
                } else {
                    salida += ma[i][j] + " ";
                }
            }
            salida += "\n";
        }
        return salida;
    }

    public String salida(Hash3 vClaves) {
        String salida = "\nVector | Claves\n";
        for (int i = 0; i < 15; i++) {
            salida += "-";
        }
        salida += "\n";
        for (int i = 0; i < vClaves.getTamanio(); i++) {
            salida += "  " + i + " |   " + vClaves.arreglo[i] + "\n";
        }
        for (int i = 0; i < 15; i++) {
            salida += "-";
        }
        return salida;
    }
}
