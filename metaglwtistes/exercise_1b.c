/*
 * ΠΡΟΣΟΧΗ: Όπου αριστερή παρένθεση το τελευταίο ψηφίο του Αριθμού Μητρώου ενός εκ
 * των φοιτητών/φοιτητριών της ομάδας (επιλέξτε). Όπου δεξιά παρένθεση το τελευταίο ψηφίο
 * του Αριθμού Μητρώου ενός άλλου εκ των φοιτητών/φοιτητριών της ομάδας (επιλέξτε) ή αν
 * δεν υπάρχει άλλο άτομο θα είναι το προτελευταίο ψηφίο του ίδιου Αριθμού Μητρώου.
 *
 */

#include <stdio.h>
#include <string.h>

#define STACK_SIZE 30
#define TRUE 1
#define FALSE 0

/*
 * Stathis AM: 21024 => last char => '4' instead of opening parenthesis
 * Vaggelis AM: 21036 => last char => '6' instead of closing parenthesis
 */

struct myStack {
    char array[STACK_SIZE];
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

int push(STACK *s, char x) {
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

int pop(STACK *s) {
    if (checkIfStackIsEmpty(*s)) {
        return FALSE;
    } else {
        s->top--; //meionw to top kata 1
        return TRUE;
    }
}

void checkIfBalanced(STACK stack) {
    if (stack.top + 1 == 0) {
        //balanced case
        printf("---------\n");
        printf("Status: Finished...\n");
        printf("YES, The expression is balanced!\n");
    } else {
        //unbalanced case
        printf("This stack has %d elements: \n", stack.top + 1);

        for (int i = 0; i <= stack.top; i++) {
            printf("| %c ", stack.array[i]);
        }

        printf("\n");
        printf("---------\n");
        printf("Status: Finished...\n");
        printf("NO, The expression is not balanced!\n");
    }
}

int evaluateExpression(STACK *s, char expression[40]) {
    printf("----------\n");
    printf("Evaluating expression: %s\n", expression);
    printf("\n");

    int len = strlen(expression);
    for (int i = 0; i < len; i++) {
        printf("Current char => '%c'\n", expression[i]);
        printf("Status: Searching...\n");

        if (expression[i] == '4') {
            push(s, expression[i]);
            printf("Pushed: '%c' to stack\n", expression[i]);
        } else if (expression[i] == '6') {
            if (checkIfStackIsEmpty(*s)) {
                printf("---------\n");
                printf("No, the expression is not balanced\n");
                printf("-----------------\n");
                return 0;
            }

            if (s->array[s->top] == '4') {
                pop(s);
                printf("Popped: '%c' from stack\n", expression[i]);
            }
        }

        if (i + 1 < len) {
            printf("----------\n");
            printf("The remaining chars in expression are: \n");

            for (int j = i + 1; j < len; j++) {
                j + 1 < len ? printf(" %c,", expression[j]) : printf(" %c", expression[j]);
            }

            printf("\n");
            printf("\n");
        }
    }

    printf("Checking if your expression is balanced....\n");
    printf("\n");
    checkIfBalanced(*s);
    printf("\n");
    printf("\n");
}

void showExerciseDetails() {
    printf("University of Piraeus (UoP) \n");
    printf("---------------------------- \n");
    printf("Exercise A \n");
    printf("\n");
}

void showInstructions() {
    printf("How can I help you: \n");
    printf("1. Give your expression for evaluation: \n");
    printf("2. Exit \n");
}

int main() {
    int choice;
    char expression[30];

    STACK stack;
    stackInit(&stack);

    showExerciseDetails();

    while (1) {
        showInstructions();
        scanf("%d", &choice);

        switch (choice) {
            case 1: {
                printf("Enter your expression:\n");
                scanf("%s", expression);

                printf("Your expression is: %s\n", expression);
                printf("\n");

                evaluateExpression(&stack, expression);
                break;
            }
            case 2 : {
                printf("Exiting Program...\n");
                return 0;
            }
            default: {
                printf("Wrong input number. Try again \n");
                break;
            }
        }
    }
}