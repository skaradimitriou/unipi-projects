# In this lesson I'll learn about the primitive types in Python and play around the IDE

# String
name = 'Stathis'

# Integer
age = 25

# Float
coffeePrice = 1.70

# Boolean
adult = True
negativeBoolean = False

# Int to String
newString = str(age)

# Join strings
greeting = 'Hello' + ' ' + name + '!'
print(greeting)

print('{0} is {1} years old'.format(name, age))

# Reading from keyboard
userName = input('Whats your name? ')
print('Nice to meet you {0}'.format(userName))
