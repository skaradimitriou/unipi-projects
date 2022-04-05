/*
 * (1 μονάδα) Χρησιμοποιείστε λειτουργίες push και pop σε στοίβα τύπου LIFO για τον
 * υπολογισμό της έκφρασης 4 - [(10+3) x (12-6)] . Σε κάθε βήμα, να προσδιορίζετε
 * το περιεχόμενο της στοίβας
 */

#include <stdio.h>
#include <unistd.h>

#define STACK_SIZE 10
#define TRUE 1
#define FALSE 0

typedef int element;

struct myStack {
    element array[STACK_SIZE];
    int top;
};

typedef struct myStack STACK;

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
}

int add(int a, int b) {
    return a + b;
}

int multiply(int a, int b) {
    return a * b;
}

int subtract(int a, int b) {
    return a - b;
}

int main() {
    int element;
    int x1, x2;

    STACK stack; //Declares stack
    stackInit(&stack); //Initializes the stack

    printf("Υπολογισμός παράστασης: 4 - [(10+3) x (12-6)] \n");
    printf("---------------------------- \n");

    printf("\n");
    printf("Step 1: Push 4\n");
    printf("-----------------\n");
    element = 4;
    push(&stack, element); // Pushes 4 to stack

    printStackElements(stack); //prints all the elements in the stack

    sleep(1);

    printf("\n");
    printf("Step 2: Push 10\n");
    printf("-----------------\n");
    element = 10;
    push(&stack, element); // Pushes 10 to stack

    printStackElements(stack);

    sleep(1);

    printf("\n");
    printf("Step 3:  Push 3\n");
    printf("-----------------\n");
    element = 3;
    push(&stack, element); // Pushes 10 to stack

    printStackElements(stack);

    sleep(1);

    printf("\n");
    printf("Step 3a: Add (3 + 10)\n");
    printf("-----------------\n");

    pop(&stack, &x1); //pop 3
    pop(&stack, &x2); //pop 10

    element = add(x1, x2); // Adds 3+10
    printf("3 + 10 = %d\n", element);

    printf("\n");
    printf("Step 3b: Push %d (result) to stack\n", element);
    printf("-----------------\n");

    push(&stack, element); //pushes 13 to stack
    printStackElements(stack); //stack now has [4,13]

    sleep(1);

    printf("\n");
    printf("Step 4: Push 12\n");
    printf("-----------------\n");

    element = 12;
    push(&stack, element);

    printStackElements(stack); //stack now has [4,13,12]

    sleep(1);

    printf("\n");
    printf("Step 5: Push 6\n");
    printf("-----------------\n");
    element = 6;
    push(&stack, element);

    printStackElements(stack); //stack now has [4,13,12,6]

    sleep(1);

    printf("\n");
    printf("Step 6a: Substract (12 - 6)\n");
    printf("-----------------\n");

    pop(&stack, &x1); //pop 6
    pop(&stack, &x2); //pop 12

    element = subtract(x2, x1); // Operation: 12-6 = 6
    printf("12 - 6 = %d\n", element);

    printf("\n");
    printf("Step 6b: Push %d (result) to stack\n", element);
    printf("-----------------\n");

    push(&stack, element); //pushes 6 to stack
    printStackElements(stack); //stack now has [4,13,6]

    sleep(1);

    printf("\n");
    printf("Step 7a: Multiply 13 x 6\n");
    printf("-----------------\n");

    pop(&stack, &x1); //pop 6
    pop(&stack, &x2); //pop 13

    element = multiply(x1, x2); //Operation : 6 x 13 = 78
    printf("13 x 6 = %d\n", element);

    printf("\n");
    printf("Step 7b: Push %d (result) to stack\n", element);
    printf("-----------------\n");

    push(&stack, element); //pushes 78 to stack
    printStackElements(stack); //stack now has [4,78]

    sleep(1);

    printf("\n");
    printf("Step 8a: Substract 4 - 78\n");
    printf("-----------------\n");

    pop(&stack, &x1); // pop 78
    pop(&stack, &x2); //pop 4

    element = subtract(x2, x1); //Operation: 4-78
    printf("4 - 78 = %d\n", element);

    printf("\n");
    printf("Step 8b: Push %d (result) to stack\n", element);
    printf("-----------------\n");

    push(&stack, element); //pushes -74 to stack
    printStackElements(stack); //stack now has [-74]

    return 0;
}
