public abstract class BankAccount implements BankOperations{
    private String customerName;
    private double balance;

    public BankAccount(String customerName, double initialDeposit) {
        this.customerName = customerName;
        deposit(initialDeposit);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract void withdraw(double amount);

    public abstract void withdrawAll(double amount);

}
