
from BankAccount import BankAccount


class User:
    def __init__(self, name, email_address):
        self.name = name
        self.email = email_address
        self.account = BankAccount(int_rate=0.02 , balance=0)

    def make_withdrawal(self, amount):
        self.account.balance -= amount
        return self

    def make_deposit(self, amount):
        self.account.balance += amount
        return self

    def display_user_balance(self):
        return print(f"User:{self.name}, Balance: {self.account.balance}")

    def transfer_money(self, user, amount):
        user.make_deposit(amount)  # increase user's balance 
        self.make_withdrawal(amount) #decrease the present user balance 
        return self



first_user=User("besh","besh#gmail.com")
# first_user.make_deposit(200)
# first_user.make_deposit(50)
# first_user.make_deposit(100)
# first_user.make_withdrawal(50)
# first_user.display_user_balance() # User:besh, Balance: 300

first_user.make_deposit(200).make_deposit(50).make_deposit(100).make_withdrawal(50).display_user_balance() 


second_user=User("khalid","user@gmail.com")
# second_user.make_deposit(200)
# second_user.make_deposit(80)
# second_user.make_withdrawal(80)
# second_user.make_withdrawal(50)
# second_user.display_user_balance() #User:khalid, Balance: 150

second_user.make_deposit(200).make_deposit(80).make_withdrawal(80).make_withdrawal(50).display_user_balance()


third_user=User("mohammed","user@gmail.com")
# third_user.make_deposit(300)
# third_user.make_withdrawal(100)
# third_user.make_withdrawal(100)
# third_user.make_withdrawal(100)
# third_user.display_user_balance() #User:mohammed, Balance: 0

third_user.make_deposit(300).make_withdrawal(100).make_withdrawal(100).make_withdrawal(100).display_user_balance()


#transfer money from first user to third user 
first_user.transfer_money(third_user,100).display_user_balance() # User:besh, Balance: 200
third_user.display_user_balance() # User:mohammed, Balance: 100