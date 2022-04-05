/*2. (1 μονάδα) Να υπολογιστεί η διεύθυνση κάθε στοιχείου ενός πίνακα
Α(1:3,1:2,3:3,1:3). Θεωρείστε ότι ο πίνακας έχει βασική διεύθυνση b=100 και μήκος
συνιστώσας L=6, ενώ τα άνω και κάτω όρια των δεικτών του είναι όπως παραπάνω.*/

#include <stdio.h>

int main() {
    int L = 6, B = 100;
    int u4 = 3, u3 = 3, u2 = 2, u1 = 3;
    int l4 = 1, l3 = 3, l2 = 1, l1 = 1;
    int c4, c3, c2, c1, c0;
    int length;
    int a[l1 - u1][l2 - u2][l3 - u3][l4 - u4];

    c4 = L;
    c3 = (u4 - l4 + 1) * c4;
    c2 = (u3 - l3 + 1) * c3;
    c1 = (u2 - l2 + 1) * c2;
    c0 = B - c1 * l1 - c2 * l2 - c3 * l3 - c4 * l4;
    printf("c4=%d\nc3=%d\nc2=%d\nc1=%d\nc0=%d\n", c4, c3, c2, c1, c0);
    length = L * (u1 - l1 + 1) * (u2 - l2 + 1) * (u3 - l3 + 1) * (u4 - l4 + 1);
    printf("Length=%d\n", length);

    for (int i = l1; i <= u1; i++) {
        for (int j = l2; j <= u2; j++) {
            for (int k = l3; k <= u3; k++) {
                for (int l = l4; l <= u4; l++) {
                    a[i][j][k][l] = c0 + c1 * i + c2 * j + c3 * k + c4 * l;
                    printf("addr(a[%d][%d][%d][%d]) = %d\n", i, j, k, l, a[i][j][k][l]);
                }
            }
        }
    }
    return 0;
}
