public class SpecialBankAccount extends BankAccount{
    private static final double FEE_PERCENTAGE = 0.05;

    public SpecialBankAccount(String customerName, double initialDeposit) {
        super(customerName, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        double fee = amount * FEE_PERCENTAGE;
        if (amount + fee > getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            setBalance(getBalance() - (amount + fee));
            System.out.println("Withdrew " + amount + " with a fee of " + fee);
        }
    }

    @Override
    public void withdrawAll(double amount) {
        double fee = amount * FEE_PERCENTAGE;
        double withdrawnAmount = getBalance() - fee;
        System.out.println("Withdrew " + withdrawnAmount + " with a fee of " + fee);
    }
}
