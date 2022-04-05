/*
 * (2 μονάδες) Να υλοποιηθεί μια στοίβα LIFO με χρήση πίνακα και της γλώσσας C.
 */

#include <stdio.h>

#define STACK_SIZE 10
#define TRUE 1
#define FALSE 0

typedef int element;

struct myStack {
    element array[STACK_SIZE];
    int top; 
};

typedef struct myStack STACK; // define this so you can write STACK instead of struct myStack

void stackInit(STACK *s) {
    s->top = -1;
}

int checkIfStackIsEmpty(STACK s) {
    return s.top == -1;
}

int checkIfStackIsFull(STACK s) {
    return s.top == STACK_SIZE - 1;
}

int push(STACK *s, element x) {
    if (checkIfStackIsFull(*s)) {
        return FALSE;
    } else {
        s->top++; //move the pointer to next list
        s->array[s->top] = x; //add the element x to the pointer poisition
        return TRUE;
    }
}

/*
 * If stack is empty, this operation is not applicable
 * If its not empty, pop the element
 */

int pop(STACK *s, element *x) {
    if (checkIfStackIsEmpty(*s)) {
        return FALSE;
    } else {
        *x = s->array[s->top]; //save to *x the element that is at the top of list
        s->top--; //meionw to top kata 1
        return TRUE;
    }
}

void printStackElements(STACK stack) {
    printf("This stack has %d elements: \n", stack.top + 1);

    for (int i = 0; i <= stack.top; i++) {
        printf("| %d ", stack.array[i]);
    }
    printf("\n");
    printf("\n");
}

void showInstructions() {
    printf("How can I help you: \n");
    printf("1. Push element to stack \n");
    printf("2. Pop element from stack \n");
    printf("3. Print your stack \n");
    printf("4. Exit \n");
}

int main() {
    int choice, element;
    STACK stack;

    stackInit(&stack);

    printf("\n");
    printf("Stack in C \n");
    printf("---------------------------- \n");

    while (1) {
        showInstructions();

        scanf("%d", &choice);

        switch (choice) {
            case 1: {

                printf("Give an element:\n");
                scanf("%d", &element);

                if (push(&stack, element)) {
                    printf("Push of element %d was successful!\n", element);
                } else {
                    printf("Stack was full. Element: %d wasn't added\n", element);
                }
                break;
            }
            case 2: {
                if (pop(&stack, &element)) {
                    printf("Pop of element %d was successful\n", element);
                } else {
                    printf("Stack was empty.Element: %d wasn't popped\n", element);
                }
                break;
            }
            case 3: {
                printStackElements(stack);
                break;
            }
            case 4 : {
                printf("Exiting Program...\n");
                return 0;
            }
            default:{
                printf("Wrong input number. Try again \n");
                break;
            }
        }
    }
}
