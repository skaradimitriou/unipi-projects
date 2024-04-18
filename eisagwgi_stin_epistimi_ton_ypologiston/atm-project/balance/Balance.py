# This is the balance class

class Balance:

    # The Balance class contains only one method, the printBalanceMethod,
    # which only returns the balance that the user has in his account

    def __init__(self):
        # The program prints the option that the user selected
        # at the init of the class

        print('You chose the Check Balance Option')

    def printBalanceInfo(self, balance):
        print('Your account balance is: {0:,.2f}€.'.format(balance))
