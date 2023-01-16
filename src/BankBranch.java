import java.util.HashMap;
import java.util.Map;

public class BankBranch {

    private static BankBranch instance;
    private Map<Integer, BankAccount> accounts;

    private BankBranch() {
        accounts = new HashMap<>();
    }

    public static BankBranch getInstance() {
        if (instance == null) {
            instance = new BankBranch();
        }
        return instance;
    }

    public boolean isaccountNumberUnique(int accountNumber) {
        return !accounts.containsKey(accountNumber);
    }

    public void createAccount(int accountNumber, String customerName, double balance, boolean isSpecial) {
        BankAccount account;
        if (isSpecial) {
            account = new SpecialBankAccount(accountNumber, customerName, balance);
        } else {
            account = new NormalBankAccount(accountNumber, customerName, balance);
        }
        accounts.put(accountNumber, account);
    }

    public void removeAccount(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.withdrawAll(account.getBalance());
        accounts.remove(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.deposit(amount);
    }
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        account.withdraw(amount);
    }

    /*public double checkBalance(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return -1;
        }
        return account.getBalance();
    }*/

    public void checkBalance(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account number: "+account.getAccountNumber());
            System.out.println("Customer Name: "+account.getCustomerName());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid account.");
        }
    }

    public void printAllAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey());
            System.out.println("Customer Name: " + entry.getValue().getCustomerName());
            System.out.println("Balance: " + entry.getValue().getBalance());
        }
    }
}
