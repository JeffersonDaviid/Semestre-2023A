// CHILENO MANOBANDA JEFFERSON DAVID

#include <stdio.h>

void main()
{
    float f1 = 1.5;
    float f2 = -1.5;
    float f3 = f1 * f2;

    printf("Los valores en formato hexadecimal son:\n");

    printf("El valor de F1 : %016x\n", *(unsigned int *)&f1);
    printf("El valor de F2 : %016x\n", *(unsigned int *)&f2);
    printf("El valor de F3 : %016x\n", *(unsigned int *)&f3);
}
