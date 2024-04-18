# Γράψτε ένα πρόγραμμα σε python που να έχει μια συνάρτηση η
# οποία βρίσκει το άθροισμα, το πλήθος, το μέσο όρο και το γινόμενο
# από μία λίστα πραγματικών αριθμών που θα δέχεται σαν
# παράμετρο. Τη λίστα να τη διαβάσετε από το πληκτρολόγιο και να
# προσθέτετε συνεχώς αριθμούς στη λίστα έως ότου να δώσετε τη
# συμβολοσειρά 'quit' ώστε να τερματίσετε την εισαγωγή δεδομένων
# στη λίστα

numberList = []

while True:
    inputValue = input('Give your number or type quit to exit')
    if inputValue == 'quit':
        print('You typed quit')
        break
    else:
        numberList.append(int(inputValue))

average = sum(numberList) / len(numberList)

productValue = 1
for i in numberList:
    productValue *= i

print('Thank you!')
print('The sum of the elements inside the list is: {0}'.format(sum(numberList)))
print('There are {0} items in the list you gave'.format(len(numberList)))
print('The average value of the elements you gave is: {0}'.format(average))
print('The product of the values you gave is {0}'.format(productValue))
