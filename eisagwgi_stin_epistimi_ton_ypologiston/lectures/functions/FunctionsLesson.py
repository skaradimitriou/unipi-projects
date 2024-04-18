# Γράψτε ένα πρόγραμμα σε python που να έχει μια συνάρτηση η
# οποία βρίσκει το μέγιστο από 3 αριθμούς. Στη συνέχεια
# χρησιμοποιήστε τη συνάρτηση για να βρείτε το μέγιστο από 3
# δεκαδικούς αριθμούς που θα διαβάσετε από το πληκτρολόγιο.

a = int(input('Give the 1st number: '))
b = int(input('Give the 2nd number: '))
c = int(input('Give the 3rd number: '))


# Easy way
def getMaxNumber(a, b, c):
    maxNumber = max(a, b, c)
    print('The max number between {0}, {1}, {2} is {3}'.format(a, b, c, maxNumber))


getMaxNumber(a, b, c)


# Full logic
def getMaxNumbers(a, b, c):
    if (a >= b) and (a >= c):
        largest = a
    elif (b >= a) and (b >= c):
        largest = b
    else:
        largest = c

    print('The max number between {0}, {1}, {2} is {3}'.format(a, b, c, largest))


getMaxNumbers(a, b, c)
