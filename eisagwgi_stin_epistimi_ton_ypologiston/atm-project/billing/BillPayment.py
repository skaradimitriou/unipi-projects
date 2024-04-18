class BillPayment:

    userBalance = 0.0

    def __init__(self):
        # The program informs the user about the option he gave to the console
        print('You chose Bill Payment option')

    def payTheBill(self,userBalance):
        # The user should enter 3 things. The company that the payment will go, the Electronic code of the payment
        # and the amount of the bill. The billing amount has been wrapped into a try/except block so it can handle
        # the case of an error answer

        billingCompany = input('Type the company that you want to perform the payment: ')
        billingQrCode = input('Type the electronic payment code: ')

        try:
            billingAmount = float(input('Type the bill Amount (e.g 100.50€):'))
        except:
            print('Your number should be divided using a dot(.) instead of comma (e.g 100.50€)')

        # The program checks if the billing amount is smaller than the user balance and performs the action
        # Then the program informs the user about the payment details

        if userBalance >= billingAmount:
            userBalance -= billingAmount
            self.userBalance = userBalance

            print('You paid {0}€ to {1}'.format(billingAmount, billingCompany))
            print('')
        else:
            print('The amount that you want to pay is bigger than your bank account balance.')

    def updateBalance(self):
        print('Your new balance after the Deposit is {0:,.2f}€'.format(self.userBalance))
        return self.userBalance