#include <iostream>

using namespace std;

int main()
{
    const long long MB = 1024 * 1024;
    const long long GB = MB * 1024;

    // Tamaño de memoria a asignar en MB
    long long memory_size_MB = 1000;
    long long memory_size_bytes = memory_size_MB * MB;

    char *memory = nullptr;

    try
    {
        // Intentamos asignar memoria
        memory = new char[memory_size_bytes];
        cout << "Se asignaron " << memory_size_MB << " MB de memoria." << endl;

        // Llenamos la memoria con datos (esto es opcional)
        for (long long i = 0; i < memory_size_bytes; i++)
        {
            memory[i] = 'A';
        }

        // Mantenemos el programa en ejecución para que la memoria no sea liberada automáticamente
        while (true)
        {
        }

        // Si quisieras liberar la memoria, lo harías así:
        // delete[] memory;
    }
    catch (bad_alloc &e)
    {
        cerr << "Error al asignar memoria: " << e.what() << endl;
    }

    return 0;
}
