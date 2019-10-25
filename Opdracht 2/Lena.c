/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 *  Klas: TI1D
 *  OPdracht: Opdracht 2, poging 1
 */

#include <stdio.h>
#include <stdlib.h>
#include "lenaArray.h"

void analyzeLena();

int main () {
    analyzeLena(0,512,160,380);
    analyzeLena(0,512,0,512);
    analyzeLena(100,400,100,400);
    return 0;
}

void analyzeLena(int beginY, int endY, int beginX, int endX) {
    double totalGrey;
    double average;


    for (int i = beginY; i < endY; i++)
    {
        for (int j = beginX; j < endX; j++)
        {
            totalGrey += lena[i][j];
            if (lena[i][j] < 50) {printf(" ");}
            else if (lena[i][j] < 70) {printf(".");}
            else if (lena[i][j] < 90) {printf(":");}
            else if (lena[i][j] < 110) {printf("-");}
            else if (lena[i][j] < 130) {printf("=");}
            else if (lena[i][j] < 150) {printf("+");}
            else if (lena[i][j] < 170) {printf("*");}
            else if (lena[i][j] < 190) {printf("#");}
            else if (lena[i][j] < 210) {printf("%%");}
            else {printf("@");}
        }
        printf("\n");
    }
    average = totalGrey/((endX-beginX)*(endY-beginY));
    printf("Average grey value is: %f\n", average);
    totalGrey = 0;
}