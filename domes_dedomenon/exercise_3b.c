#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student {
    char am[10];
    char surcourse[30];
    char firstName[20];
    char fathersName[20];
    char address[20];
    char landlinePhoneNo[20];
    char mobilePhoneNo[15];
    char selectedLessonName[30];
};

int main() {
    struct student s1 = {"MPPL21001", "JOHN", "GIANNOU", "JOHN", "MANIS 20", "2104050815", "6945243319",
                         "C_FOR_BEGINNERS"};
    struct student s2 = {"MPPL21002", "KOSTAS", "MITROU", "JOHN", "AKADIMIAS 2", "2104050150", "6949243500", "PYTHON"};
    struct student s3 = {"MPPL21003", "DIMITRIS", "DIMITRIOU", "GEORGE", "SINA 18", "2104260810", "6985243513",
                         "C_FOR_BEGINNERS"};
    struct student s4 = {"MPPL21004", "NICK", "KARANIKOS", "STATHIS", "TSAKALOF 6", "2104053610", "69888243593",
                         "PYTHON"};
    struct student s5 = {"MPPL21005", "CHRISTOS", "SOLOPOULOS", "KOSTAS", "SKOUFA 55", "2104508466", "6980043813",
                         "DATA_STRUCTURES"};
    struct student s6 = {"MPPL21006", "JOHN", "ZIGOULIS", "JOHN", "SOULIOU 20", "21040504536", "6981243555", "PYTHON"};
    struct student s7 = {"MPPL21007", "KOSTAS", "PAPAKOSTAS", "JOHN", "SOULIOU 25", "21047770810", "6981284517",
                         "C_FOR_BEGINNERS"};
    struct student s8 = {"MPPL21008", "DIMITRIS", "AGGELOPOULOS", "GEORGE", "SOLOMOU 55", "21444055610", "6955243611",
                         "PYTHON"};
    struct student s9 = {"MPPL21009", "NICK", "ALEXIOU", "STATHIS", "IPPOKRATOUS 120", "2104011210", "6981247713",
                         "DATA_STRUCTURES"};
    struct student s10 = {"MPPL21010", "IASON", "PAPADOPOULOS", "KOSTAS", "SOULIOU 30", "2108866999", "6981246613",
                          "DATA_STRUCTURES"};

    //Input the struct in an Array.
    struct student students[] = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};

    //Print the Students.
    for (int i = 0; i < sizeof(students) / sizeof(students[0]); i++) {
        printf("Student Name: %s %s, AM: %s, Lives in: %s,\nContact Info: %s, %s,Selected Lesson: %s.\n \n",
               students[i].firstName, students[i].surcourse, students[i].am,
               students[i].address, students[i].landlinePhoneNo, students[i].mobilePhoneNo,
               students[i].selectedLessonName);
    }

    //Print a message for which course will search.
    char course[30];
    printf("Write the course to see the enrolled students:\n");
    scanf("%s", course);

    //Search and print for students who has choose this lesson.
    for (int i = 0; i < sizeof(students) / sizeof(students[0]); i++) {
        if (strcmp(students[i].selectedLessonName, course) == 0) {
            printf("%s\n", students[i].firstName);
        }
    }
    return 0;
}
