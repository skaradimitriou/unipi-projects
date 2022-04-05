/*
 * (3 μονάδες) Σε μια συλλογή στοιχείων, κάθε στοιχείο περιέχει πληροφορίες για τους
φοιτητές του μεταπτυχιακού, όπως αριθμό μητρώου, επώνυμο, όνομα, πατρώνυμο,
διεύθυνση κατοικίας, αριθμό σταθερού τηλεφώνου, αριθμό κινητού τηλεφώνου και
επιλεγμένο μάθημα πρώτου εξαμήνου.
▪ Να γραφεί κώδικας C για την αναπαράσταση ενός εγγραφήματος φοιτητή.
 */

#include <strings.h>
#include "stdio.h"

struct student{
    char am[10];
    char surname[30];
    char firstName[20];
    char fathersName[20];
    char address[20];
    char landlinePhoneNo[20];
    char mobilePhoneNo[20];
    char selectedLessonName[30];
};

int main(){
    struct student myStudent;

    strcpy(myStudent.am,"mpplXXXXX");
    strcpy(myStudent.surname,"Karadimitriou");
    strcpy(myStudent.firstName,"Stathis");
    strcpy(myStudent.fathersName,"XXXXXXX");
    strcpy(myStudent.address,"streetNo 1");
    strcpy(myStudent.landlinePhoneNo,"210 XXXXXXX");
    strcpy(myStudent.mobilePhoneNo,"698888777");
    strcpy(myStudent.selectedLessonName,"DATA_STRUCTURES");

    printf("\n");
    printf("Student Info\n");
    printf("--------------\n");

    printf("Student Fullname: %s %s του %s\n",myStudent.firstName,myStudent.surname,myStudent.fathersName);
    printf("AM: %s\n",myStudent.am);
    printf("Selected Lesson: %s\n",myStudent.selectedLessonName);
    printf("Address: %s\n",myStudent.address);
    printf("Contact Info: Landline Phone -> %s, Mobile Phone -> %s\n",myStudent.landlinePhoneNo,myStudent.mobilePhoneNo);

    return 0;
}
