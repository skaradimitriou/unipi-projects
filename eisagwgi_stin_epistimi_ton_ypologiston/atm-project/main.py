from balance.Balance import Balance
from billing.BillPayment import BillPayment
from deposit.Deposit import Deposit
from helper.InstructionsHelper import InstructionsHelper
from withdrawal.Withdrawal import Withdrawal

# The user has a fixed balance account
userBalance = 5000.0

# Calling the Instructions Helper Class which contains
# all the usefull printing messages to the console

helper = InstructionsHelper()
helper.printWelcomeMessage()

# This loop runs until the user selects the Exit Option from the menu
while True:

    # In every iteration of the loop, the program is asking for an integer from the keyboard
    # Each integer is identified into one option and the system handles the user choice

    helper.printInstructions()
    userChoice = int(input('Give your option: '))

    if userChoice == 5:
        # User selected 5 -> So the program will stop looping through actions and it will stop.
        helper.printExitMessage()
        break
    elif userChoice == 1:
        # User selected 1 -> The program will call the Check Balance class
        # and it will print out the user balance

        balance = Balance()
        balance.printBalanceInfo(userBalance)
    elif userChoice == 2:
        # User selected 2 (Deposit) -> The program will call the Deposit class
        deposit = Deposit()
        deposit.addAmount(userBalance)
        userBalance = deposit.updateBalance()
    elif userChoice == 3:
        # User selected 3 (Withdrawal) -> The program will call the Withdrawal class
        withdrawal = Withdrawal()
        withdrawal.getAmount(userBalance)
        userBalance = withdrawal.updateBalance()
    elif userChoice == 4:
        # User selected 4 (Bill Payment) -> The program will call the Bill Payment class
        billing = BillPayment()
        billing.payTheBill(userBalance)
        userBalance = billing.updateBalance()