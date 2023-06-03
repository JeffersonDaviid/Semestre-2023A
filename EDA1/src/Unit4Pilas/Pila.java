package Unit4Pilas;

public class Pila {

   // Declaracion
   private int n;
   private int TOPE; // tamaño máximo en la pila
   private Object pila[];

   // Constructor
   public Pila(int n) {
      this.n = n;
      this.TOPE = 0;
      pila = new Object[n];
   }

   // retornamos true si es que el max coincide con el puntero del tope, sino
   // retorna false
   public boolean estaLlena() {
      return TOPE == n;
   }

   // retornamos true si es que el puntero "tope" coincide con
   public boolean estaVacia() {
      return TOPE == 0;
   }

   // Funcion para insertar datos en la pila
   public boolean apilar(Object dato) {
      if (estaLlena()) {
         return false;
      } else {
         pila[TOPE] = dato;
         TOPE++;
         return true;
      }
   }

   // funcion para quitar elementos de la pila
   public Object desapilar() {
      if (estaVacia()) {
         return null;
      } else {
         TOPE--;
         return pila[TOPE];
      }
   }

   // funcion para saber cual es el valor en el tope de la pila
   public Object elementoTope() {
      return pila[TOPE - 1];
   }

}
