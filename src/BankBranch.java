public class BankBranch {
    private static BankBranch instance;
    private BankAccount[] accounts;
    private int accountCount;

    private BankBranch() {
        accounts = new BankAccount[10];
    }

    public static BankBranch getInstance() {
        if (instance == null) {
            instance = new BankBranch();
        }
        return instance;
    }

    public void createAccount(String customerName, double balance, double FEE_PERCENTAGE, boolean isSpecial) {
        BankAccount account;
        if (isSpecial) {
            account = new SpecialBankAccount(customerName, balance, FEE_PERCENTAGE);
        } else {
            account = new NormalBankAccount(customerName, balance, FEE_PERCENTAGE);
        }
        accounts[accountCount++] = account;
    }
    public int searchAccount(String customerName) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getCustomerName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public void removeAccount(int accountIndex) {
        accounts[accountIndex].withdrawAll(accounts[accountIndex].getBalance());
        accounts[accountIndex] = null;
    }

    public void deposit(int accountIndex, double amount) {
        if (accounts[accountIndex] != null) {
            accounts[accountIndex].deposit(amount);
        } else {
            System.out.println("Invalid account.");
        }
    }
    public void withdraw(int accountIndex, double amount) {
        if (accounts[accountIndex] != null) {
            accounts[accountIndex].withdraw(amount);
        } else {
            System.out.println("Invalid account.");
        }
    }

    public void checkBalance(int accountIndex) {
        if (accounts[accountIndex] != null) {
            System.out.println("Customer Name: "+accounts[accountIndex].getCustomerName());
            System.out.println("Balance: " + accounts[accountIndex].getBalance());
        } else {
            System.out.println("Invalid account.");
        }
    }
    public void printAccount() {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null) {
                System.out.println("Account type: " + accounts[i].getClass().getName());
                System.out.println("Account Index: " + i);
                System.out.println("Customer Name: " + accounts[i].getCustomerName());
                System.out.println("Balance: " + accounts[i].getBalance());
                System.out.println("-------------------");
            }
        }
    }
}
