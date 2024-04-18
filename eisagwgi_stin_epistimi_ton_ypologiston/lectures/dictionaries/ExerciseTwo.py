# Γράψτε ένα πρόγραμμα σε γλώσσα Python που διαβάζει τον κωδικό και την τιμή ενός προϊόντος
# για 5 προϊόντα από το πληκτρολόγιο και να τα αποθηκεύει σε ένα λεξικό. Το πρόγραμμά σας θα
# πρέπει να εκτυπώνει στην οθόνη τις τιμές όλων των προϊόντων.
# Το πρόγραμμά σας να αναζητά εάν ο κωδικός προϊόντος υπάρχει στο λεξικό και να εμφανίζει την
# αντίστοιχη τιμή για το προϊόν που δώσατε. Το πρόγραμμά σας να δείχνει ανάλογο μήνυμα εάν ο
# κωδικός δεν υπάρχει στο λεξικό. Οι τιμές να εμφανίζονται με 2 δεκαδικά ψηφία μόνο.
# Χρησιμοποιήστε σχόλια στο πρόγραμμά σας.

productDictionary = {}

for i in range(0, 4):
    productCode = input('Give the Product Code: ')
    productPrice = float(input('Give the Product Price: '))
    productDictionary[productCode] = productPrice

print(productDictionary)

for product in productDictionary:
    print('Code: {0} -- Price: {1:.2f}€'.format(product, productDictionary[product]))
