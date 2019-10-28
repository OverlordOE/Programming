#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(0));
    int ranNum();
    void procCalc();
    int liftAr[500];
    int numOut[5] = {0,0,0,0,0};
    int temp;

    for (int i = 0; i < 500; i++ ){
        int temp = ranNum();
        liftAr[i] = temp;
        numOut[temp]++;
        printf("%d: etage %d\n", i, temp);
    }

    procCalc(numOut);
    return 0;
}

int ranNum() {
    int number;
    number = rand() % 5;
    return number;
}

void procCalc(int myArray[]) {
    double procent;
    
    for (int i = 0; i < 5; i++) {
        procent = myArray[i]/5.0;
        printf("Procent etage %d: %f\n", i, procent);
    }
}