public class TestBank {
    public static void main(String []args){

        BankAccount Account1 = new BankAccount();
        Account1.depositChecking(100);
        System.out.println(Account1.getCheckingBalance());
        Account1.withdrawChecking(10);
        System.out.println(Account1.getCheckingBalance());
        
        Account1.depositSaving(100);
        System.out.println(Account1.getTotalMoney()); // 190 
        System.out.println(BankAccount.numberOfAccounts()); //1
        System.out.println(Account1.getAccountNum()); // 7529445312 randomely
    }
}
