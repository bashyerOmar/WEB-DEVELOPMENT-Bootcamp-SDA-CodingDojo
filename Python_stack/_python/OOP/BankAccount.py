class BankAccount:
    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        self.balance -= amount
        return self

    def display_account_info(self):
        return print(f"int rate:{self.int_rate}, Balance: {self.balance}")

    def yield_interest(self):
        return self



Account1=BankAccount(100,200)
Account2=BankAccount(10,500)
Account1.deposit(100).deposit(50).deposit(70).withdraw(100).yield_interest().display_account_info()
Account2.deposit(100).deposit(20).withdraw(200).withdraw(50).withdraw(20).withdraw(50).yield_interest().display_account_info()