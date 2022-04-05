#include <stdio.h>

void retrieve(int i, float *A);

void retrieveAll(float *A);

void updateAll(float *A, float *B, float *C);

void update(float *A, float *B, float *C, int a, int b, int c);

int main() {
    //initialize the arrays
    float A[10] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    float B[10] = {15, 5.25, 25.4, 5.40, 10.1, 15.5, 15.5, 40.9, 50.90, 90.12};
    float C[10] = {2.5, 4.25, 3.4, 9.40, 18.1, 12.5, 11.5, 44.9, 52.90, 93.12};
    int i, i2, i3;

    while (1) {
        printf("Press 1 to retrieve the value for specific position on A[i]\n");
        printf("Press 2 to retrieve all the values in range 0-9 for A[10]\n");
        printf("Press 3 to update the value for specific position on A[i]\n");
        printf("Press 4 to update all the values in range 0-9 by the same sequence A[i]\n");
        printf("Press 5 to exit\n");

        printf("Enter your choice:");
        scanf("%d", &i);

        if (i == 1) {
            printf("Enter in range 0-9 for which position do you want to see the value:");
            scanf("%d", &i);
            retrieve(i, A);
        } else if (i == 2) {
            retrieveAll(A);
        } else if (i == 3) {
            printf("\nEnter the position i in range 0-9 for A[i]:");
            scanf("%d", &i);

            printf("\nEnter the position i in range 0-9 for B[i]:");
            scanf("%d", &i2);

            printf("\nEnter the position i in range 0-9 for C[i]:");
            scanf("%d", &i3);

            update(A, B, C, i, i2, i3);
        } else if (i == 4) {
            updateAll(A, B, C);
        } else if (i == 5) {
            return 0;
        } else {
            printf("Something went wrong \n Try again!!\n");
        }
    }
}

void retrieve(int i, float *A) {
    if (i >= 0 && i < 10) {
        printf("+++++++++++++++++++++\n");
        printf("Float value: %lf\n", A[i]);
        printf("+++++++++++++++++++++\n");
    } else {
        printf("You need to choose between 1-9\n");
    }
}

void retrieveAll(float *A) {
    for (int i; i < 10; i++) {
        printf("%lf\n", A[i]);
    }
}

void updateAll(float *A, float *B, float *C) {
    for (int i; i < 10; i++) {
        A[i] = B[i] + C[i];
    }
}

void update(float *A, float *B, float *C, int a, int b, int c) {
    if (a >= 0 && a < 10 && b >= 0 && b < 10 && c >= 0 && c < 10) {
        A[a] = B[b] + C[c];
    }
}
