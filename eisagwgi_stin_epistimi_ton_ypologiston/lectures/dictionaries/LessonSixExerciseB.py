# Υποθέστε ότι έχετε ένα λεξικό που το κάθε ζεύγος του αντιστοιχεί
# στον αριθμό μητρώου ενός φοιτητή και στο βαθμό του σε ένα
# μάθημα. Γράψτε ένα πρόγραμμα σε python που να γεμίζει το λεξικό
# με τα στοιχεία 10 φοιτητών και στη συνέχεια να χρησιμοποιεί μια
# συνάρτηση που να δέχεται σαν παράμετρο το λεξικό και να τυπώνει
# μια (ψεύδο)γραφική αναπαράσταση με τους βαθμούς όπως στο
# παρακάτω σχήμα:
# ΑΜ93122: 8 - ********
# ΑΜ27017: 4.5 - ****

studentDictionary = {}

for i in range(0, 10):
    studentCode = input('Enter the Student code: ')
    grade = input('How much did the Student score?: ')
    studentDictionary[studentCode] = grade


def createOutputStyling(dictionary):
    for i in dictionary:
        asterisks = dictionary[i].replace(dictionary[i], "*" * int(dictionary[i]))
        print('{0}: {1} - {2}'.format(i, dictionary[i], asterisks))

createOutputStyling(studentDictionary)
