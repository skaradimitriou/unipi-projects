# A date in Python is not a data type of its own,
# but we can import a module named datetime to work
# with dates as date objects.
import datetime

date_format = "%m/%d/%Y"

dateNow = datetime.datetime.now()
print(dateNow)

day = dateNow.strftime("%A")
print('Today is {0}'.format(day))

x = datetime.datetime(2021, 6, 1)
print(x.strftime("%A"))

# how many days to certain date

birthdayDate = datetime.datetime(2021, 9, 19)

calcDate = birthdayDate - dateNow

print('There are {0} days'.format(calcDate.days))
