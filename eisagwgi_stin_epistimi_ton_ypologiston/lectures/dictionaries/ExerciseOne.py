# Γράψτε ένα πρόγραμμα σε γλώσσα Python που να ορίζει δύο λεξικά ως εξής:
# stock = { "banana": 6, "apple": 0, "orange": 32, "pear": 15} και
# prices = { "banana": 4, "apple": 2, "orange": 1.5, "pear": 3 }
# που αντιστοιχούν στις τιμές και στο στοκ κάποιων προϊόντων.
# Το πρόγραμμά σας να τυπώνει τα όλα τα στοιχεία των προϊόντων ως εξής:  apple - price: 2 - stock: 0
# Υπολογίστε το σύνολο όλων των τεμαχίων των προϊόντων καθώς και το συνολικό κόστος τους.

stock = {"banana": 6, "apple": 0, "orange": 32, "pear": 15}
prices = {"banana": 4, "apple": 2, "orange": 1.5, "pear": 3}

totalAmount = 0
totalRevenue = 0

for i in stock:
    totalAmount += stock[i]
    totalRevenue += (prices[i] * stock[i])
    print('{0} -- Price: {1} - Stock: {2}'.format(i.upper(), prices[i], stock[i]))

print('There are {0} items in total with a total cost of {1}€.'.format(totalAmount, totalRevenue))