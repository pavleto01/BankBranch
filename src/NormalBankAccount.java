public class NormalBankAccount extends BankAccount{

    public NormalBankAccount(int accountNumber,String customerName, double balance) {
        super(accountNumber,customerName,balance);
        this.setFeePercentage(0.1);
    }
}

