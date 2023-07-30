public class Examen1 {
    public static void main(String[] args) {
        int[][][] produccion = new int[4][3][4];
        int totalEncebollado = 0;
        int totalBandera = 0;
        int totalTerremoto = 0;

        String matriz = "";
        // i = años, J = platos , k = meses

        // Llenar datos en tabla
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    produccion[i][j][k] = (int) (Math.random() * 10 + 25);
                    matriz += produccion[i][j][k] + "  ";
                }
                matriz += "  plato " + j + "    \n";
            }
            matriz += i + "   AÑO    \n\n";
        }
        System.out.println(matriz);

        for (int i = 0; i < produccion.length; i++) {
            for (int j = 0; j < produccion.length; j++) {
                for (int k = 0; k < produccion.length; k++) {

                    // totales en el tercer año
                    if (i == 2) {
                        // total encebollado
                        if (j == 0) {
                            totalEncebollado = totalEncebollado + produccion[i][j][k];
                        } // total bandera
                        if (j == 1) {
                            totalBandera = totalBandera + produccion[i][j][k];
                        } // total terremoto
                        if (j == 2) {
                            totalTerremoto = totalTerremoto + produccion[i][j][k];
                        }
                    }
                }
            }
        }

        System.out.println("EN EL TERCER AÑO SE REGISTRARON: \n");
        System.out.println("El valor total de Encebollado es: " + totalEncebollado);
        System.out.println("El valor total de Bandera es: " + totalBandera);
        System.out.println("El valor total de Terremoto es: " + totalTerremoto);

        // -------------------------------------------------------------------------------
        // PREGUNTA 2

        System.out.println("El F de 5 es: " + Fibo(5));
    }

    public static int Fibo(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 2;
        else {
            return Fibo(n - 1) / Fibo(n - 2);
        }

    }
}
