"""
Έστω ένα τετράγωνο 3*3 στο οποίο τοποθετείτε δακτυλίους. Έχετε στην κατοχή σας 27 δακτυλίους, 9 για κάθε μέγεθος
(μικρό, μεσαίο, μεγάλο). Μια τριάδα που τερματίζει το παιχίνδι γίνεται οριζόντια, κάθετα ή διαγώνια. Η τριάδα
αποτελείται από δακτυλίους είτε του ίδιου μεγέθους είτε από το μικρό προς το μεγαλύτερο. Επειδή έχετε δακτύλιους,
ένας δακτύλιος μπορεί να μπει σε οποιοδήποτε τετράγωνο, αρκεί να μην έχει ήδη δακτύλιο του ίδιου μεγέθους.
Γράψτε ένα πρόγραμμα το οποίο παίζει τυχαία το παιχνίδι 100 φορές και επιστρέφει το μέσο όρο των βημάτων για να
λήξει το παιχνίδι.
"""

import random


def checkRows(list):
    triple = False
    if [1, 1] in list and [1, 2] in list and [1, 3] in list:
        triple = True
    elif [2, 1] in list and [2, 2] in list and [2, 3] in list:
        triple = True
    elif [3, 1] in list and [3, 2] in list and [3, 3] in list:
        triple = True

    return triple

def checkRowsFull(smallRings, mediumRings, bigRings):
    triple = False
    if [1, 1] in smallRings and [1, 1] in mediumRings and [1, 1] in bigRings and [1,2] in smallRings and [1,2] in mediumRings and [1,2] in bigRings and [1,3] in smallRings and [1,3] in mediumRings and [1,3] in bigRings:
        triple = True
    elif [2, 1] in smallRings and [2, 1] in mediumRings and [2, 1] in bigRings and [2,2] in smallRings and [2,2] in mediumRings and [2,2] in bigRings and [2,3] in smallRings and [2,3] in mediumRings and [2,3] in bigRings:
        triple = True
    elif [3, 1] in smallRings and [3, 1] in mediumRings and [3, 1] in bigRings and [3,2] in smallRings and [3,2] in mediumRings and [3,2] in bigRings and [3,3] in smallRings and [3,3] in mediumRings and [3,3] in bigRings:
        triple = True

    return triple

def checkColumns(list):
    triple = False
    if [1, 1] in list and [2, 1] in list and [3, 1] in list:
        triple = True
    elif [1, 2] in list and [2, 2] in list and [3, 2] in list:
        triple = True
    elif [1, 3] in list and [2, 3] in list and [3, 3] in list:
        triple = True

    return triple


def checkColumnsFull(smallRings, mediumRings, bigRings):
    triple = False
    if [1, 1] in smallRings and [1, 1] in mediumRings and [1, 1] in bigRings and [2,1] in smallRings and [2,1] in mediumRings and [2,1] in bigRings and [3,1] in smallRings and [3,1] in mediumRings and [3,1] in bigRings:
        triple = True
    elif [1, 2] in smallRings and [1, 2] in mediumRings and [1, 2] in bigRings and [2,2] in smallRings and [2,2] in mediumRings and [2,2] in bigRings and [3,2] in smallRings and [3,2] in mediumRings and [3,2] in bigRings:
        triple = True
    elif [1, 3] in smallRings and [1, 3] in mediumRings and [1, 3] in bigRings and [2,3] in smallRings and [2,3] in mediumRings and [2,3] in bigRings and [3,3] in smallRings and [3,3] in mediumRings and [3,3] in bigRings:
        triple = True

    return triple


def checkDiagonals(list):
    triple = False
    if [1, 1] in list and [2, 2] in list and [3, 3] in list:
        triple = True
    elif [1, 3] in list and [2, 2] in list and [3, 1] in list:
        triple = True

    return triple

def checkDiagonalsFull(smallRings, mediumRings, bigRings):
    triple = False
    if [1, 1] in smallRings and [1, 1] in mediumRings and [1, 1] in bigRings and [2,2] in smallRings and [2,2] in mediumRings and [2,2] in bigRings and [3,3] in smallRings and [3,3] in mediumRings and [3,3] in bigRings:
        triple = True
    elif [1, 3] in smallRings and [1, 3] in mediumRings and [1, 3] in bigRings and [2,2] in smallRings and [2,2] in mediumRings and [2,2] in bigRings and [3,1] in smallRings and [3,1] in mediumRings and [3,1] in bigRings:
        triple = True

    return triple

def checkIfAnyoneWins(smallRings,mediumRings,bigRings):
    gameInProgress = True

    smallRings.sort()
    mediumRings.sort()
    bigRings.sort()

    if checkRows(smallRings) or checkDiagonals(smallRings) or checkColumns(smallRings):
        gameInProgress = False
    elif checkRows(mediumRings) or checkDiagonals(mediumRings) or checkColumns(mediumRings):
        gameInProgress = False
    elif checkRows(bigRings) or checkDiagonals(bigRings) or checkColumns(bigRings):
        gameInProgress = False
    elif checkRowsFull(smallRings, mediumRings, bigRings) or checkColumnsFull(smallRings, mediumRings,bigRings) or checkDiagonalsFull(
            smallRings, mediumRings, bigRings):
        gameInProgress = False

    return gameInProgress


def playRingGame():
    board = []

    numbers = [i for i in range(1, 4)]

    for i in numbers:
        for j in numbers:
            board.append([i, j])

    print("Board => {0}".format(board))

    smallRingsInventory = 9
    mediumRingsInventory = 9
    bigRingsInventory = 9

    smallRings = []
    mediumRings = []
    bigRings = []

    gameInProgress = True
    stepsToEndGame = 0

    while gameInProgress:

        stepsToEndGame = stepsToEndGame + 1

        randomRing = random.randint(1, 3)
        choice = random.choice(board)

        if randomRing == 1:
            if len(smallRings) == 0:
                smallRings.append(choice)
                smallRingsInventory = smallRingsInventory - 1
                print("You have {0} small rings left.".format(smallRingsInventory))
            else:
                if not choice in smallRings:
                    smallRings.append(choice)
                    smallRingsInventory = smallRingsInventory - 1
                    print("You have {0} small rings left.".format(smallRingsInventory))
        elif randomRing == 2:
            if len(mediumRings) == 0:
                mediumRings.append(choice)
                mediumRingsInventory = mediumRingsInventory - 1
                print("You have {0} medium rings left.".format(mediumRingsInventory))
            else:
                if not choice in mediumRings:
                    mediumRings.append(choice)
                    mediumRingsInventory = mediumRingsInventory - 1
                    print("You have {0} medium rings left.".format(mediumRingsInventory))
        else:
            if len(bigRings) == 0:
                bigRings.append(choice)
                bigRingsInventory = bigRingsInventory - 1
                print("You have {0} big rings left.".format(bigRingsInventory))
            else:
                if not choice in bigRings:
                    bigRings.append(choice)
                    bigRingsInventory = bigRingsInventory - 1
                    print("You have {0} big rings left.".format(bigRingsInventory))

        """
        Check if the game is completed. If the game is completed, set gameInProgress to false so the game will stop
        """

        gameInProgress = checkIfAnyoneWins(smallRings,mediumRings,bigRings)

    print("***********")
    print("Small Rings located on {0} positions".format(smallRings))
    print("Medium Rings located on {0} positions".format(mediumRings))
    print("Big Rings located on {0} positions".format(bigRings))
    print("***********")
    print("")
    return stepsToEndGame


"""
Play the game 100 times and append to my list the steps it took to end each game
"""

totalStepsInGames = []
for i in range(100):
    totalStepsInGames.append(playRingGame())

"""
calculate the average steps needed to end a game based on our games played before.
"""

sum = 0
for i in totalStepsInGames:
    sum += i

averageSteps = round(sum / 100)

print("----------------------------------------------------------------------")
print("The average steps to end a game based on 100 played games is: {0} steps".format(averageSteps))