#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
    char am[10];
    char surname[30];
    char firstName[20];
    char fathersName[20];
    char address[20];
    char landlinePhoneNo[20];
    char mobilePhoneNo[20];
    char selectedLessonName[30];
    struct student *next;
};

typedef struct student STUDENT;

struct student *head;

void addStudent(char am[10],
                char surname[30],
                char firstName[20],
                char fathersName[20],
                char address[20],
                char landlinePhoneNo[20],
                char mobilePhoneNo[20],
                char selectedLessonName[30]) {
    struct student *ptr;
    ptr = malloc(sizeof(STUDENT));

    if (!ptr) {
        printf("Adunamia desmeusis mnimis");
        return;
    }

    strcpy(ptr->am, am);
    strcpy(ptr->surname, surname);
    strcpy(ptr->firstName, firstName);
    strcpy(ptr->fathersName, fathersName);
    strcpy(ptr->address, address);
    strcpy(ptr->landlinePhoneNo, landlinePhoneNo);
    strcpy(ptr->mobilePhoneNo, mobilePhoneNo);
    strcpy(ptr->selectedLessonName, selectedLessonName);

    if (head == NULL) {
        ptr->next = NULL;
        head = ptr;
    } else {
        ptr->next = head;
        head = ptr;
    }
}

void getSelectedLessonStudents(char selectedLesson[30]) {
    struct student *temp;
    temp = head;

    if (temp == NULL) {
        return;
    } else {
        printf("Student Info\n");
        printf("--------------\n");

        while (temp != NULL) {
            if (strcmp(temp->selectedLessonName,selectedLesson) == 0){
                printf("Student Fullname: %s %s του %s\n",temp->firstName,temp->surname,temp->fathersName);
                printf("AM: %s\n",temp->am);
                printf("Selected Lesson: %s\n",temp->selectedLessonName);
                printf("Address: %s\n",temp->address);
                printf("Contact Info: Landline Phone -> %s, Mobile Phone -> %s\n",temp->landlinePhoneNo,temp->mobilePhoneNo);

                printf("--------------\n");

                printf("\n");
            }
            temp = temp->next;
        }
    }
}

int main() {
    int choice;
    char selectedLesson[30];
    printf("\n");

    addStudent("MPPL21024","Karadimitriou","Stathis","Anastasios","Spata","210XXXXXXX","69XXXXXXXX","DataStructures");
    addStudent("MPPLXXXX","Kolios","Kostas","XXXX","Perama","210XXXXXXX","69XXXXXXXX","DataStructures");
    addStudent("MPPLXXXX","Surname","Name","XXXX","Somewhere","210XXXXXXX","69XXXXXXXX","Math");
    addStudent("MPPLXXXX","Kormazos","Vaggelis","XXXXX","Athens","210XXXXXXX","69XXXXXXXX","DataStructures");

    while (1) {
        printf("Main menu:\n");
        printf("1. Get enrolled students per lessonName\n");
        printf("2: Exit\n");

        printf("\n");

        printf("Give your option:\n");
        scanf("%d", &choice);

        switch (choice) {
            case 1: {
                printf("Give a lesson:\n");
                printf("Available Lessons (DataStructures, Math)\n");
                scanf("%s", selectedLesson);

                getSelectedLessonStudents(selectedLesson);
                break;
            }

            case 2: {
                printf("Program exited successfully");
                return 0;
            }

            default: {
                printf("Unknown command");
                break;
            }
        }
    }
}
