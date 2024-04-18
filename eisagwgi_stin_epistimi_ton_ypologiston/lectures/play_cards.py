import random
from colorama import Fore, Back, Style

deck = []  # empty list
figures = ["J", "Q", "K"]  # card figures
cardNo = [i for i in range(1, 11)] + figures  # cards
colors = ["♣", "♦", "♠", "♥"]

for i in cardNo:
    for j in colors:
        deck.append([i, j])

random.shuffle(deck)


def calculateScore(cards):
    score = 0
    for card in cards:
        if card[0] in figures:
            score = score + 10
        else:
            score = score + card[0]
    return score


def printCards(cards):
    tmp = ""
    for c in cards:
        if c[1] in ["♦","♥"]:
            tmp = tmp + Fore.RED

        tmp += str(c[0]) + c[1] + " "

        if c[1] in ["♦","♥"]:
            tmp = tmp + Style.RESET_ALL

    return tmp


print("P1 joins the game...")

player1 = []

while calculateScore(player1) < 17:
    player1.append(deck.pop())

print(printCards(player1))

print("P2 joins the game...")
player2 = []

while calculateScore(player2) < 17:
    player2.append(deck.pop())

print(printCards(player2))

p1score = calculateScore(player1)
p2score = calculateScore(player2)

print(p1score)
print(p2score)

if p1score > 21:
    print("P1 burned")
elif p2score > 21:
    print("P2 burned")
elif p1score > p2score:
    print("P1 wins")
elif p1score < p2score:
    print("P2 wins")
else:
    print("Draw...")
