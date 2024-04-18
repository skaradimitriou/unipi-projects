# coding=utf-8
# Γράψτε ένα πρόγραμμα σε γλώσσα Python που να έχει σαν
# δεδομένο την πλειάδα (‘a’, ‘a’, ‘b’, ‘c’, ‘a’, ‘c’) και στη συνέχεια να
# δημιουργεί μία λίστα που να περιέχει μόνο τα στοιχεία που
# εμφανίζονται στην πλειάδα πάνω από μία φορά. Τα στοιχεία της
# λίστα θα πρέπει να είναι μοναδικά. Όλα τα αποτελέσματα θα
# πρέπει να εκτυπωθούν στην οθόνη. Χρησιμοποιήστε σχόλια στο
# πρόγραμμά σας.

inputTurple = ('a', 'a','b','c','a','c')

print(inputTurple)

cleanList = list(inputTurple)

cleanList.sort()
print(cleanList)


num = 0
while num == cleanList[num+1]:
    cleanList.remove(num)

print(getD)