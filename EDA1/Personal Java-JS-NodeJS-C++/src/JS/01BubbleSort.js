/**
 * Bubble Sort es el algoritmo de clasificación más simple que funciona intercambiando repetidamente los elementos adyacentes si están en el orden incorrecto. Este algoritmo no es adecuado para grandes conjuntos de datos, ya que su complejidad de tiempo promedio y en el peor de los casos es bastante alta.
 */

const bubbleSortJeffersonChileno = (array) => {
   console.log('Array sin ordenar: ' + array);
   longitud = array.length;
   flagChange = 0;
   iteraciones = 0;

   do {
      flagChange = 0;
      for (index = 0; index < longitud - 1; index++) {
         if (array[index] > array[index + 1]) {
            // aux = array[index + 1];
            // array[index + 1] = array[index];
            // array[index] = aux;

            // esto copie de internet - JS
            [array[index], array[index + 1]] = [array[index + 1], array[index]];
            flagChange++;
         }
         iteraciones++;
      }
      longitud--;
   } while (flagChange != 0);

   console.log('Array ordenado en: ' + iteraciones + ' iteraciones ' + array);
};

function bubbleSortOptimizadoInternet(array) {
   const n = array.length;
   iteraciones = 0;
   console.log('Array sin ordenar: ' + array);

   for (let i = 0; i < n - 1; i++) {
      let swapped = false;
      for (let j = 0; j < n - i - 1; j++) {
         if (array[j] > array[j + 1]) {
            swapped = true;
            [array[j], array[j + 1]] = [array[j + 1], array[j]];
         }
         iteraciones++;
      }
      if (!swapped) {
         break;
      }
   }

   console.log('Array ordenado en: ' + iteraciones + ' iteraciones ' + array);
}

array = [0, 1, 3, 2, 0, 15, 7, 20, 3, 10];

console.log('Jefferson: ');
bubbleSortJeffersonChileno(array);
console.log('Internet: ');
bubbleSortOptimizadoInternet(array);
