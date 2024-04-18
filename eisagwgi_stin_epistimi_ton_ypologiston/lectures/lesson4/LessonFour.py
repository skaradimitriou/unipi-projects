# coding=utf-8
# Γράψτε ένα πρόγραμμα σε γλώσσα Python που διαβάζει 10
# ακέραιους αριθμούς από το πληκτρολόγιο και για κάθε αριθμό x
# που διαβάστηκε από το πληκτρολόγιο να αποθηκεύει σε μία λίστα
# την τιμή: 3*x + 4. Στη συνέχεια για τους αριθμούς της λίστας να
# υπολογίζονται: το πλήθος των αρτίων, το πλήθος των περιττών
# καθώς και ο μεγαλύτερος αριθμός. Όλα τα αποτελέσματα θα πρέπει
# να εκτυπωθούν στην οθόνη. Χρησιμοποιήστε σχόλια στο
# πρόγραμμά σας.

# init list & counters
numberList = []
evenCounter = 0
oddCounter = 0

# looping 10 times and inserting the formatted number inside the list
for i in range(0, 10):
    number = int(input('Type your {0} number '.format(i + 1)))
    numberList.append(3 * number + 4)

# calculating the even & odd numbers from the list & getting the max number
for i in numberList:
    if i % 2 == 0:
        evenCounter += 1
    else:
        oddCounter += 1

maxNumber = max(numberList)

# printing the nessessary output lines
print('There are {0} even numbers'.format(evenCounter))
print('There are {0} odd numbers'.format(oddCounter))
print('The maximum value inside the list is {0}'.format(maxNumber))