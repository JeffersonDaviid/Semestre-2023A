#include <iostream>

using namespace std;

/**
 * Algoritmo de ordenamiento
 */
void bubbleSort()
{
    int numeros[] = {1, 3, 2, 0, 7, 20, 10};
    int aux = 0;
    bool flagChange = true;

    while (flagChange == true)
    {
        for (int posicion = 0; posicion < 7 - 1; posicion++)
        {
            aux = numeros[posicion];
            flagChange = false;
            if (numeros[posicion] >= numeros[posicion + 1])
            {
                numeros[posicion + 1] = aux;
                flagChange = true;
                cout << "hola como estas";
            }
        }

        for (auto &&valor : numeros)
            cout << valor << ",";
    }
}

int main()
{
    bubbleSort();
    return 0;
}