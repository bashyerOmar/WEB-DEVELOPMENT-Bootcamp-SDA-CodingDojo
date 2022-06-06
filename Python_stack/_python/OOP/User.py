

class User:
    def __init__(self, name, email_address):
        self.name = name
        self.email = email_address
        self.account_balance = 0

    def make_withdrawal(self, amount):
        self.account_balance -= amount

    def make_deposit(self, amount):
        self.account_balance += amount

    def display_user_balance(self):
        return print(f"User:{self.name}, Balance: {self.account_balance}")

    def transfer_money(self, user, amount):
        user.make_deposit(amount)  # increase user's balance 
        self.make_withdrawal(amount) #decrease the present user balance 



Bashyer=User("besh","besh#gmail.com")
Bashyer.make_deposit(200)
Bashyer.display_user_balance() # User:besh, Balance: 200

khalid=User("khalid","user@gmail.com")
Bashyer.transfer_money(khalid,100)
khalid.display_user_balance() # User:khalid, Balance: 100
Bashyer.display_user_balance() # User:besh, Balance: 100