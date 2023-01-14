public class SpecialBankAccount extends BankAccount{
    public SpecialBankAccount(int accountNumber,String customerName, double balance) {
        super(accountNumber,customerName,balance);
        this.setFeePercentage(0.05);
    }
}
