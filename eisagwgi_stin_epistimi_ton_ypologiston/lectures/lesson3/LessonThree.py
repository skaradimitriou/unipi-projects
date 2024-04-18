# Γράψτε ένα πρόγραμμα σε γλώσσα Python που να διαβάζει
# 10 ακέραιους αριθμούς από το πληκτρολόγιο και στη
# συνέχεια να υπολογίζει το πλήθος των άρτιων και το
# πλήθος των περιττών και στη συνέχεια να βρίσκει ποιοι
# ήταν οι περισσότεροι, οι περιττοί ή οι άρτιοι

evenNoCounter = 0
oddNoCounter = 0

i = 0
while i < 10:
    number = int(input('Give a number '))
    if number % 2 == 0:
        evenNoCounter += 1
    else:
        oddNoCounter += 1
    i = i + 1

print()
print('There are {0} even numbers'.format(evenNoCounter))
print('There are {0} odd numbers'.format(oddNoCounter))

print('Total:')
print()

if evenNoCounter > oddNoCounter:
    print('There are more even numbers ({0} numbers)'.format(evenNoCounter))
else:
    print('There are more odd numbers ({0} numbers)'.format(oddNoCounter))
