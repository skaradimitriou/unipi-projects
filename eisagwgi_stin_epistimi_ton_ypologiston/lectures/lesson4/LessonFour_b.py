# coding=utf-8
# Γράψτε ένα πρόγραμμα σε γλώσσα Python που θα ζητάει από το
# χρήστη μια ακολουθία από 5 ακέραιους αριθμούς. Το πρόγραμμα
# πρέπει να υπολογίζει το μέσο όρο όλων των αριθμών εκτός από τον
# τελευταίο και να συγκρίνει το μέσο όρο με τον τελευταίο αριθμό. Αν
# οι δύο ποσότητες είναι ίσες, το πρόγραμμα πρέπει να τυπώνει
# 'Equal', αλλιώς πρέπει να τυπώνει 'Smaller' ή 'Larger' ανάλογα με το
# αν ο μέσος όρος είναι μικρότερος ή μεγαλύτερος από τον τελευταίο
# αριθμό. Όλα τα αποτελέσματα θα πρέπει να εκτυπωθούν στην
# οθόνη. Χρησιμοποιήστε σχόλια στο πρόγραμμά σας

# creating an empty list
numList = []

# looping 5 times to get the numbers & add them into the list
for i in range(0, 5):
    number = input('Give the {0} number'.format(i + 1))
    numList.append(number)

# init totalCounter & loop to get the total of the first 4 numbers given
total = 0

for i in range(0, len(numList) - 1):
    total += int(numList[i])

# printing total
print('The sum of the first four numbers is : {0}'.format(total))

# output logic according to the request
if total == int(numList[-1]):
    print('Equal')
elif total > int(numList[-1]):
    print('Larger')
else:
    print('Smaller')