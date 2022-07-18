public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts;
    private static double totalMoney;
    private long accountNumber;

    public BankAccount() {
        numOfAccounts++;
        totalMoney = checkingBalance + savingsBalance;
        accountNum();
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingBalance() {
        return this.savingsBalance;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void depositChecking(double money) {

        this.checkingBalance += money;
        totalMoney += money;

    }

    public void depositSaving(double money) {

        this.savingsBalance += money;
        totalMoney += money;

    }

    public void withdrawSavings(double money) {
        if (savingsBalance - money < 0) {
            System.out.println("you dont have enough balance to withdraw");
        } else {
            savingsBalance -= money;
            totalMoney -= money;
        }
    }

    public void withdrawChecking(double money) {
        if (checkingBalance - money < 0) {
            System.out.println("you dont have enough balance to withdraw");
        } else {
            checkingBalance -= money;
            totalMoney -= money;
        }
    }

    public static int numberOfAccounts(){
        return numOfAccounts;
    }

    private void accountNum(){
        long theRandomNum = (long) (Math.random()*Math.pow(10,10)); // ten digit random number 
        accountNumber = theRandomNum;
    }

    public long getAccountNum(){
        return accountNumber;
    }
}
