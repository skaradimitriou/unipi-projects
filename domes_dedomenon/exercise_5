#include <stdio.h>
#include <stdlib.h>

typedef int answer;

struct Node {
    int data;
    struct Node *next;
};

struct Node *top = NULL;

void push(answer x);

void pop();

void topPosition();

int main() {
    int answer, i;
    while (1) {
        printf("Press 1 to push");
        printf("\nPress 2 to pop");
        printf("\nPress 3 to top");
        printf("\nPress 4 to exit");

        printf("\nEnter your choice:");
        scanf("%d", &i);

        if (i == 1) {
            printf("\nGive me your number to push:");
            scanf("%d", &answer);

            push(answer);

            printf("The number: %d added successfully!\n", answer);
        } else if (i == 2) {
            pop();
        } else if (i == 3) {
            topPosition();
        } else if (i == 4) {
            printf("\nGoodbye! ");
            return 0;
        } else {
            printf("Please enter an integer value in range 1-3\n");
        }
    }
}


void push(answer x) {
    struct Node *temp = (struct Node *) malloc(10 * sizeof(struct Node *));
    temp->data = x;
    temp->next = top;
    top = temp;
}

void pop() {
    struct Node *temp;
    if (top == NULL) {
        printf("You dont have something to delete\n");
        return;
    }
    temp = top;
    top = top->next;
    printf("You pop number:%d\n", temp->data);
    free(temp);
}

void topPosition() {
    if (top == NULL) {
        printf("Top is NULL\n");
        return;
    }
    printf("Top data is : %d\n", top->data);
}
