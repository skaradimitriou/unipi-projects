# H υπηρεσία https://www.cloudflare.com/en-gb/leagueofentropy/ προσφέρει τυχαίους αριθμούς.
# Χρησιμοποιείστε αρχικά την διεύθυνση https://drand.cloudflare.com/public/latest για να πάρετε
# το τελευταίο randomness το οποίο θα το χωρίσετε σε δυάδες δεκαεξαδικών χαρακτήρων, και κάθε μια
# θα την μετρέψετε σε ακέραιο και θα την κάνετε modulo 80. Κρατείστε αυτούς τους 32 αριθμούς
# μοναδική φορά το καθένα και υπολογίστε πόσοι από αυτούς τους αριθμούς θα κληρονόντουσαν στην
# τελευταία κλήρωση του ΚΙΝΟ που θα βρείτε εδώ https://api.opap.gr/draws/v3.0/1100/last-result-and-active


import requests as req

print("Welcome to exercise 13!")
print("------------------------")
print("FullName: Stathis Karadimitriou")
print("AM: MPPL21024")
print("------------------------")

print("Getting data from remotes....")
print("------------------------")

leaqueOfEntropy = req.get("https://drand.cloudflare.com/public/latest")
kino = req.get('https://api.opap.gr/draws/v3.0/1100/last-result-and-active')

leaqueOfEntropyBody = leaqueOfEntropy.json()
kinoBody = kino.json()

kinoNums = kinoBody['last']['winningNumbers']['list']
randomness = leaqueOfEntropyBody['randomness']

randomness = str(int(randomness, 16))

leageNums = [int(randomness[i:i + 2]) % 80 for i in range(0, len(randomness), 2)]

print("The winning numbers from Kino are: {0}".format(kinoNums))
print("The numbers from leagueOfEntropy are: {0}".format(leageNums))

print("--------------------------------")
print("Calculating how many numbers from leagueOfEntropy exist in Kino latest numbs....")
print("--------------------------------")

numbersFound = 0
numbersExistInKino = []

for i in kinoNums:
    for k in leageNums:
        if i == k:
            numbersFound += 1
            numbersExistInKino.append(i)


if numbersFound > 0:
    print("There are {0} numbers from leagueOfEntropy found in Kino numbers. Those numbers are: {1}".format(numbersFound,numbersExistInKino))
else:
    print("Kino Numbers didn't contain any of the leagueOfEntropy numbers.")