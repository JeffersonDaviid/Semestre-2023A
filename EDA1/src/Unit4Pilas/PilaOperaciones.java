package Unit4Pilas;

import javax.swing.JOptionPane;

/*

--------------- OPERACIONES AUXILIARES -------------

   ALGORITMO PilaVacia (P,T,B)
      Si (T = 0)
         entonces 
            B -> V
      Si no
         B -> F
      Fin Si
   Fin Algoritmo


   ALGORITMO PilaLlena (P,T,B)
      Si (T = Max)
         entonces 
            B -> V
      Si no
         B -> F
      Fin Si
   Fin Algoritmo
         


------------- OPERACIONES BASICAS -------------
   ALGORITMO PUSH PILA
   
   Llamar a Pila Llena (T, P, B, MAX)
      si (B=V)
      entonces
         imprimir "desbordamiento"
      sino
         T <- T+1
         P[T] <- V
      Fin Si
   Fin Algoritmo
   

   ALGORITMO POP PILA

   Llamar a Pila Vacia (T, P, B, MAX)
      si (B=V)
      entonces
         imprimir "subdesbordamiento"
      sino
         P[T] <- 0
         T <- T-1
      Fin Si
   Fin Algoritmo
 */

public class PilaOperaciones {

   // Declaracion
   int[] Pila1;
   int TOPE;
   int MAX;

   // Constructor
   public PilaOperaciones(int MAX) {
      this.TOPE = 0;
      this.MAX = MAX;
      this.Pila1 = new int[this.MAX + 1];

   }

   // funcion que retorna el tope de la pila
   public int Tope() {
      return TOPE;
   }

   public void VaciarPila() {
      // verificamos si la pila esta vacia
      if (this.isPilaVacia()) {
         JOptionPane.showMessageDialog(null, "LA PILA ESTA VACIA");
      }
      // cambiamos el "puntero hacia la parte más baja de la pila"
      this.TOPE = 0;
   }

   // retornamos true si es que el max coincide con el puntero del tope, sino
   // retorna false
   public boolean isPilaLlena() {
      return this.MAX == this.TOPE;
   }

   // retornamos true si es que el puntero "tope" coincide con
   public boolean isPilaVacia() {
      return this.TOPE == 0;
   }

   // INSERTAR PILA
   public void insertarPila() {
      if (this.isPilaLlena()) {
         JOptionPane.showMessageDialog(null, "LA PILA ESTA LLENA");
      } else {
         int DATO;
         DATO = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL DATO"));

         this.TOPE++;
         this.Pila1[this.TOPE] = DATO;

         JOptionPane.showMessageDialog(null, "EL DATO " + DATO + " SE INSERTO EN LA PILA");
      }

   }

   // ELIMINAR LA PILA
   public void eliminarPila() {
      if (this.isPilaVacia()) {

      } else {
         // guardamos el dato que esta al tope de la pila para mostrar al usuario
         int DATO = this.Pila1[this.TOPE];
         // reducimos el puntero tope
         this.TOPE--;

         JOptionPane.showMessageDialog(null, "EL DATO " + DATO + "SE ALIMINO DE LA PILA");
      }
   }

   // MOSTRAR LA PILA
   public void mostrarPila() {
      if (isPilaVacia()) {

         JOptionPane.showMessageDialog(null, "LA PILA NO TIENE DATOS A MOSTRAR");

      } else {
         String dato = "";
         // acumulamos todos los valores de la pila para mostrar al usuario
         for (int i = 0; i <= this.TOPE; i++) {
            dato = dato + this.Pila1[i] + "\n";
         }
         JOptionPane.showMessageDialog(null,
               "EL TOTAL  ES: " + this.TOPE + "\n LOS DATOS DE LA PILA SON:\n " + dato + " MOSTRAR");
      }
   }

   // creamos una pila
   public static PilaOperaciones P;

   public static void main(String[] args) {
      // peticion para el tamaño de la pila
      int MAX = Integer.parseInt(JOptionPane.showInputDialog("INGRESAR EL TAMAÑO DE LA PILA"));
      // iniciamos la pila
      P = new PilaOperaciones(MAX);
      MenuPila();
   }

   public static void MenuPila() {
      int option;
      do {

         option = Integer.parseInt(JOptionPane.showInputDialog(null,
               "\n1. INGRESAR DATOS EN LA PILA\n2. ELIMINAR DATOS EN LA PILA\n3. MOSTRAR DATOS EN LA PILA\n4. VACIAR DATOS EN LA PILA\n5. SALIR\n                      ...............\nINGREAR LA OPCION DEL 1 AL 5",
               "MENU PILA", JOptionPane.QUESTION_MESSAGE));

         switch (option) {
            case 1:
               P.insertarPila();
               break;
            case 2:
               P.eliminarPila();
               break;
            case 3:
               P.mostrarPila();
               break;
            case 4:
               P.VaciarPila();
               break;
            case 5:
               option = 5;
               break;
            default:
               JOptionPane.showInputDialog(null, "INGRESE UNA OPCION VALIDA");
         }

      } while (option != 5);
   }

}
