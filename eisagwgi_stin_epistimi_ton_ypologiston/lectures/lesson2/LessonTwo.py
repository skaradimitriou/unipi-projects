# learn if -elif-else schema
import math

a = float(input('Give the first number '))
b = float(input('Give the second number '))
c = float(input('Give the third number '))

diakrinousa = (b * b) - 4 * a * c

if diakrinousa > 0:
    x1 = (-b + math.sqrt(diakrinousa)) / 2 * a
    x2 = (-b - math.sqrt(diakrinousa)) / 2 * a
    print('Η εξίσωση έχει 2 ρίζες: x1 = {0:.2f}, x2 = {1:.2f}'.format(x1, x2))

elif diakrinousa == 0:
    x = -b / 2 * a
    print('Η εξίσωση έχει 1 ρίζα: x1 = {0}'.format(x))

else:
    print('Η εξίσωση είναι αδύνατη')