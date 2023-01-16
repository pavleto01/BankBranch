public abstract class BankAccount implements BankOperations{
    private int accountNumber;
    private String customerName;
    private double balance;
    private double feePercentage;


    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }



    @Override
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void setFeePercentage(double feePercentage) {
        this.feePercentage = feePercentage;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount){
        double fee = amount * feePercentage;
        if (amount + fee > balance) {
            System.out.println("Insufficient funds.");
        } else {
            setBalance(getBalance() - (amount + fee));
            System.out.println("Withdrew " + amount + " with a fee of " + fee);
        }
    }

    public void withdrawAll(double amount) {
        double fee = amount * feePercentage;
        double withdrawnAmount = balance - fee;
        System.out.println("Withdrew " + withdrawnAmount + " with a fee of " + fee);
    }

    @Override
    public String toString() {
        return "Customer: " + customerName +  "\n Account Number: " + accountNumber + "\n Balance: " + balance + "\n Fee Percentage: " + feePercentage*100 + "%";
    }
}
