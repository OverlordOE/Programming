#include <stdio.h>
#include <stdlib.h>

void calcFaculty();

int main() {
    int input;
   
    //input krijgen
    do
    {
        printf("Vul hier een heel getal tussen de 1 en 10 in: ");
        scanf("%d", &input);
        calcFaculty(input);
    } while (input < 1 || input > 10);
    
    return 0;
}

void calcFaculty (int input) {
    int output = 1;
    //input bereken en printen
    while (input > 1) {
        output *= input;
        input--;
    } 
    
    if (input <= 1) {printf("de faculteit is: %d\n", output);    }
}