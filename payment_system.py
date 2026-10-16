class Payment:
    def calculate(self, amount):
        return amount

class CardPayment(Payment):
    def calculate(self, amount):
        return amount * 1.02

class WalletPayment(Payment):
    def calculate(self, amount):
        return amount * 1.01

class BankTransfer(Payment):
    def calculate(self, amount):
        return amount

# Main
n = int(input())
payments = {"CARD": CardPayment(), "WALLET": WalletPayment(), "BANKTRANSFER": BankTransfer()}
total = 0
for _ in range(n):
    ptype, amt = input().split()
    amt = float(amt)
    adjusted = payments[ptype].calculate(amt)
    print(f"{ptype}: {adjusted:.2f}")
    total += adjusted
print(f"Total: {total:.2f}")
