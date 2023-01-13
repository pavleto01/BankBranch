public interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void withdrawAll(double amount);
    double getBalance();
}
