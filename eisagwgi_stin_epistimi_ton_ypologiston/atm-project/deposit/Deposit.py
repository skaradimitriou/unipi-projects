
class Deposit:

    # The deposit class handles the deposit cases.

    userBalance = 0.0

    def __init__(self):
        # During the init stage the program informs the user about his choice.
        print('You chose Deposit option')

    def addAmount(self, amount):

        # This method adds the user desired amount to his bank account. It is wrapped into a
        # try/except block so we can handle the error cases and prevent our program from crashing.

        try:
            newAmount = float(input('Give the amount that you would like to deposit: '))
            amount += newAmount
            self.userBalance = amount
        except:
            print('Your number should be divided using a dot(.) instead of comma (e.g 100.50)')

    def updateBalance(self):
        print('Your new balance after the Deposit is {0:,.2f}€'.format(self.userBalance))
        return self.userBalance