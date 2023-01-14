public abstract class BankAccount implements BankOperations{
    private String customerName;
    private double balance;
    private double FEE_PERCENTAGE;

    /*public BankAccount(String customerName, double FEE_PERCENTAGE, double initialDeposit) {
        this.customerName = customerName;
        deposit(initialDeposit);
    }*/

    public BankAccount(String customerName, double balance, double FEE_PERCENTAGE) {
        this.customerName = customerName;
        this.balance = balance;
        this.FEE_PERCENTAGE = FEE_PERCENTAGE;
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

    public double getFEE_PERCENTAGE() {
        return FEE_PERCENTAGE;
    }

    public void setFEE_PERCENTAGE(double FEE_PERCENTAGE) {
        this.FEE_PERCENTAGE = FEE_PERCENTAGE;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount){
        double fee = amount * FEE_PERCENTAGE;
        if (amount + fee > getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            setBalance(getBalance() - (amount + fee));
            System.out.println("Withdrew " + amount + " with a fee of " + fee);
        }
    }

    public void withdrawAll(double amount) {
        double fee = amount * FEE_PERCENTAGE;
        double withdrawnAmount = getBalance() - fee;
        System.out.println("Withdrew " + withdrawnAmount + " with a fee of " + fee);
    }

}
