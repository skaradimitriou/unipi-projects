"""
Έστω μία σκακίερα 8*8 στην οποία τοποθετούμε πάνω της, σε τυχαίες θέσεις, έναν λευκό πύργο και ένα μαύρο αξιωματικό.
Σε κάθε γύρο, ο κάθε παίκτης παίρνει ένα βαθμό αν το κομμάτι του τρώει κομμάτι του αντιπάλου.
Μετά από 100 παιχνίδια, εμφανίστε τους βαθμούς των δύο παικτών. Επαναλλάβετε το πείραμα 100 φορές
για σκακιέρες 7*7 και 7*8 και εμφανίστε τους αντίστοιχους βαθμούς των παικτών.
"""

import random
from itertools import chain

def calculateWinner(whitePoints, blackPoints):
    if whitePoints > blackPoints:
        print("Whites: {0} - Blacks: {1}. Whites wins!".format(whitePoints, blackPoints))
    elif whitePoints < blackPoints:
        print("Whites: {0} - Blacks: {1}. Blacks wins!".format(whitePoints, blackPoints))
    else:
        print("Whites: {0} - Blacks: {1}. It's a DRAW!".format(whitePoints, blackPoints))


def diagonals(coord, size):
    x, y = coord
    return list(chain(
        [(x, y)],
        zip(range(x - 1, -1, -1), range(y - 1, -1, -1)),
        zip(range(x + 1, size + 1, 1), range(y + 1, size + 1, 1)),
        zip(range(x + 1, size, 1), range(y - 1, -1, -1)),
        zip(range(x - 1, -1, -1), range(y + 1, size, 1)),
    ))


def playChess(chessGameAttempt, whitePoints, blackPoints, chessDimen1, chessDimen2):
    print("----------------------------------------------")
    print("Chess Game #{0}".format(chessGameAttempt + 1))
    print("----------------------------------------------")

    board = []

    chessDimens1 = [i for i in range(1, chessDimen1)]
    chessDimens2 = [i for i in range(1, chessDimen2)]

    for i in chessDimens1:
        for j in chessDimens2:
            board.append([i, j])

    random.shuffle(board)

    """
    The board has been created. 

    Assigning random position to White Bishop, White Rook & Black Queen to the board.
    """

    whiteRook = board.pop()
    blackBishop = board.pop()

    print("Black Bishop is placed on {0},{1} on board".format(blackBishop[0], blackBishop[1]))
    print("White Rook is placed on {0},{1} on board".format(whiteRook[0], whiteRook[1]))

    print("-------------------------")

    print("Game ON!")

    """
    Calculating White Rook Points:
    """

    if whiteRook[0] == blackBishop[0] or whiteRook[1] == blackBishop[1]:
        print("White Rook kills Black Bishop")
        whitePoints += 1
    else:
        pass

    """
    Calculating Black Bishop Points...
    """

    ## Getting all possible diagonal moves for bishop and loops to check if the queen is located in one of them
    bishopMoves = diagonals((blackBishop[0], blackBishop[1]), 8)

    for i in bishopMoves:
        if whiteRook[0] == i[0] and whiteRook[1] == i[1]:
            print("White Bishop kills White Rook")
            blackPoints += 1

    print("-------------------------------------")
    print("Calculating score for Blacks & Whites")
    print("-------------------------------------")

    calculateWinner(whitePoints, blackPoints)

    return whitePoints, blackPoints


numberOfGames = 100  # We could even ask the user to input the numberOfGames he wants our system to play later on

"100 games on 8x8 chess board"

chessScores8x8 = []
whitePoints8x8 = 0
blackPoints8x8 = 0

for gameNo in range(numberOfGames):
    score = playChess(gameNo, whitePoints8x8, blackPoints8x8, 8, 8)
    chessScores8x8.append(score)

for game in chessScores8x8:
    whitePoints8x8 += game[0]
    blackPoints8x8 += game[1]

print("******************************************")
print("***** TOTAL SCORE AFTER {0} CHESS GAMES ON 8x8 BOARD **********".format(numberOfGames))

calculateWinner(whitePoints8x8, blackPoints8x8)

"100 games on 7x7 chess board"

chessScores7x7 = []
whitePoints7x7 = 0
blackPoints7x7 = 0

for gameNo in range(numberOfGames):
    score = playChess(gameNo, whitePoints7x7, blackPoints7x7, 7, 7)
    chessScores7x7.append(score)

for game in chessScores7x7:
    whitePoints7x7 += game[0]
    blackPoints7x7 += game[1]

print("******************************************")
print("***** TOTAL SCORE AFTER {0} CHESS GAMES ON 7x7 BOARD **********".format(numberOfGames))

calculateWinner(whitePoints7x7, blackPoints7x7)

"100 games on 7x8 chess board"

chessScores7x8 = []
whitePoints7x8 = 0
blackPoints7x8 = 0

for gameNo in range(numberOfGames):
    score = playChess(gameNo, whitePoints7x8, blackPoints7x8, 7, 8)
    chessScores7x8.append(score)

for game in chessScores7x8:
    whitePoints7x8 += game[0]
    blackPoints7x8 += game[1]

print("******************************************")
print("***** TOTAL SCORE AFTER {0} CHESS GAMES ON 7x8 BOARD **********".format(numberOfGames))

calculateWinner(whitePoints7x8, blackPoints7x8)