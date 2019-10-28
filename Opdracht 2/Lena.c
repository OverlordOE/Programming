/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 *  Klas: TI1D
 *  OPdracht: Opdracht 2, poging 1
 */

#include <stdio.h>
#include <stdlib.h>
#include "lenaArray.h"

double totalGrey;
double average;

void analyzeLena();

int main () {
    analyzeLena(0,512,0,512);
    analyzeLena(100,400,100,400);
    return 0;
}

void analyzeLena(int beginY, int endY, int beginX, int endX) {
    FILE *f  = fopen("Lena_klein.txt", "w"); // open file for later use
    if (f == NULL) {printf("error opening file"); exit(1);} // print error if file is not found

    for (int i = beginY; i < endY; i++) // print each row
    {
        for (int j = beginX; j < endX; j++) // for each row print all columns
        {
            totalGrey += lena[i][j];
            // print ASCII value and store it in a file
            if (lena[i][j] < 50) {printf("@"); fprintf(f, "@");}
                else if (lena[i][j] < 70) {printf("%%"); fprintf(f, "%%");}
                else if (lena[i][j] < 90) {printf("#"); fprintf(f, "#");}
                else if (lena[i][j] < 110) {printf("*"); fprintf(f, "*");}
                else if (lena[i][j] < 130) {printf("+"); fprintf(f, "+");}
                else if (lena[i][j] < 150) {printf("="); fprintf(f, "=");}
                else if (lena[i][j] < 170) {printf("-"); fprintf(f, "-");}
                else if (lena[i][j] < 190) {printf(":"); fprintf(f, ":");}
                else if (lena[i][j] < 210) {printf("."); fprintf(f, ".");}
                else {printf(" "); fprintf(f, " ");}
        }
        // enter after each column
        printf("\n");
        fprintf(f, "\n");
    }

    fclose(f); // close file
    // calculate average
    average = totalGrey/((endX-beginX)*(endY-beginY));
    printf("Average grey value is: %f\n", average);
    totalGrey = 0;
}