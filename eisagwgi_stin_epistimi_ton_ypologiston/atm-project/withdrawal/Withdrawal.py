class Withdrawal():
    userBalance = 0

    def __init__(self):
        # during the init stage of the class, the program informs the user about his choice
        print('You chose Withdrawal option')

    def getAmount(self, userBalance):
        print('')

        # the program gets an input of the amount that the user wants to withdraw from his account
        # and checks if this is possible according to his account. In order to eliminate the errors, the procedure
        # is wrapped in a try/except block to handle the errors thrown

        try:
            withdrawalAmount = float(input('What is the amount that you would like to withdraw?'))

            if userBalance >= withdrawalAmount:
                userBalance -= withdrawalAmount
                self.userBalance = userBalance
                print('Your account balance after this action is {0:,.2f}€'.format(self.userBalance))
            else:
                print('Your account balance is not enough to make this action.')
        except:
            # handling error input such as 100,50 instead of 100.50
            print('Your number should be divided using a dot(.) instead of comma (e.g 100.50€)')

    def updateBalance(self):
        # returns the userBalance to the main class
        return self.userBalance
