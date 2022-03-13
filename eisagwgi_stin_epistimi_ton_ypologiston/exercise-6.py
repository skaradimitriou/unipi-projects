"""
Ασκηση 6.

Έστω μία σκακίερα στην οποία τοποθετούμε πάνω της, σε τυχαίες θέσεις, έναν λευκό πύργο και αξιωματικό
και μια μαύρη βασίλισσα. Ο κάθε παίκτης παίρνει ως δυο βαθμούς σε κάθε γύρο ανάλογα με το αν τρώει κομμάτι
του αντιπάλου. Έτσι, ο λευκός μπορεί να πάρει 2 βαθμούς αν ο πύργος τρώει τη βασίλισσα και το ίδιο κάνει και
ο αξιωματικός του. Αν μόνο ένα από τα κομμάτια του τρώει τη βασίλισσα τότε παίρνει ένα βαθμό. Αντίστοιχα, ο
μαύρος παίρνει δύο βαθμούς αν η βασίλισσά του μπορεί να φάει και τα δύο κομμάτια του λευκού ή ένα αν μπορεί
να φάει μόνο ένα. Μετά από 100 παιχνίδια, εμφανίστε τους βαθμούς των δύο παικτών.
"""

import random
from itertools import chain

whitePoints = 0
blackPoints = 0


def diagonals(coord, size):
    x, y = coord
    return list(chain(
        [(x, y)],
        zip(range(x - 1, -1, -1), range(y - 1, -1, -1)),
        zip(range(x + 1, size + 1, 1), range(y + 1, size + 1, 1)),
        zip(range(x + 1, size, 1), range(y - 1, -1, -1)),
        zip(range(x - 1, -1, -1), range(y + 1, size, 1)),
    ))


def calculateWinner(whitePoints, blackPoints):
    if whitePoints > blackPoints:
        print("Whites: {0} - Blacks: {1}. Whites wins!".format(whitePoints, blackPoints))
    elif whitePoints < blackPoints:
        print("Whites: {0} - Blacks: {1}. Blacks wins!".format(whitePoints, blackPoints))
    else:
        print("Whites: {0} - Blacks: {1}. It's a DRAW!".format(whitePoints, blackPoints))


def playChess(chessGameAttempt, whitePoints, blackPoints):
    print("----------------------------------------------")
    print("Chess Game #{0}".format(chessGameAttempt + 1))
    print("----------------------------------------------")

    board = []

    numbers = [i for i in range(1, 9)]

    for i in numbers:
        for j in numbers:
            board.append([i, j])


    random.shuffle(board)

    """
    The board has been created. 

    Assigning random position to White Bishop, White Rook & Black Queen to the board.
    """

    whiteBishop = board.pop()
    whiteRook = board.pop()
    blackQueen = board.pop()

    print("White Bishop is placed on {0},{1} on board".format(whiteBishop[0], whiteBishop[1]))
    print("White Rook is placed on {0},{1} on board".format(whiteRook[0], whiteRook[1]))
    print("Black Queen is placed on {0},{1} on board".format(blackQueen[0], blackQueen[1]))

    print("-------------------------")

    print("Game ON!")

    """
    Calculating White Rook Points:
    """

    if whiteRook[0] == blackQueen[0] or whiteRook[1] == blackQueen[1]:
        print("White Rook kills Black Queen")
        whitePoints += 1
    else:
        pass

    """
    Calculating White Bishop Points...
    """

    ## Getting all possible diagonal moves for bishop and loops to check if the queen is located in one of them
    bishopMoves = diagonals((whiteBishop[0], whiteBishop[1]), 8)

    for i in bishopMoves:
        if blackQueen[0] == i[0] and blackQueen[1] == i[1]:
            print("White Bishop kills Black Queen")
            whitePoints += 1

    """
    Calculating Black Queen Points...
    """

    ## Getting all possible diagonal moves for black queen and loops to check if the white bishop is located in one of them
    blackQueenMoves = diagonals((blackQueen[0], blackQueen[1]), 8)

    for i in blackQueenMoves:
        if whiteBishop[0] == i[0] and whiteBishop[1] == i[1]:
            print("Black Queen kills White Bishop")
            blackPoints += 1

    if blackQueen[0] == whiteRook[0] or blackQueen[1] == whiteRook[1]:
        print("Black Queen kills White Rook")
        blackPoints += 1
    else:
        pass

    print("-------------------------------------")
    print("Calculating score for Blacks & Whites")
    print("-------------------------------------")

    calculateWinner(whitePoints, blackPoints)

    return whitePoints, blackPoints


chessScores = []
numberOfGames = 100  # We could even ask the user to input the numberOfGames he wants our system to play later on

for gameNo in range(numberOfGames):
    score = playChess(gameNo, whitePoints, blackPoints)
    chessScores.append(score)

for game in chessScores:
    whitePoints += game[0]
    blackPoints += game[1]

print("******************************************")
print("***** TOTAL SCORE AFTER {0} CHESS GAMES **********".format(numberOfGames))

calculateWinner(whitePoints, blackPoints)