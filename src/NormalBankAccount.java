public class NormalBankAccount extends BankAccount{

    public NormalBankAccount(String customerName, double balance, double FEE_PERCENTAGE) {
        super(customerName,balance,FEE_PERCENTAGE);
        FEE_PERCENTAGE = 0.1;
    }
}

