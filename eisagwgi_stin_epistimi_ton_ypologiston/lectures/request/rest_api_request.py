import requests

# Επιστρέφει το DrawID, τα στοιχεία, και τα αποτελέσματα της πιο πρόσφατης κλήρωσης/ διαγωνισμού του παιχνιδιού

kino = requests.get('https://api.opap.gr/draws/v3.0/1100/last-result-and-active')
latestDraw = requests.get('https://api.opap.gr/draws/v3.0/1100/928694')

kinoResponse = kino.json()
latestDrawResponse = latestDraw.json()

# printing response
print(kinoResponse)
print(latestDrawResponse)

# dictionary
# print(type(kinoResponse))

# looping keys
# print(kinoResponse.keys())

# looping keys from 'last' key
# print(kinoResponse['last'].keys())

# get list of winningNumbers
nums = kinoResponse['last']['winningNumbers']['list']
print(nums)