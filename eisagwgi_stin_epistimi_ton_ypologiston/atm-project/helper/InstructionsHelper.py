class InstructionsHelper:

    # This is the Helper Class. This is the class that contains every console
    # init message for the user and helps him navigate

    def printWelcomeMessage(self):
        print()
        print('--- Welcome to the ATM Project --')
        print('How can we help you with today?')

    def printInstructions(self):
            print('1. Check Balance | 2. Deposit | 3. Withdrawal | 4. Pay a bill | 5. Exit')

    def printExitMessage(self):
       print('You have been logged out successfully')
