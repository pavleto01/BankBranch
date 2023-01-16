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

    public boolean isaccountNumberUnique(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return false;
            }
        }
        return true;
    }

    public void createAccount(int accountNumber,String customerName, double balance, boolean isSpecial) {
        if(accountNumber <= 0){
            System.out.println("Invalid account number");
            return;
        }
        if(customerName == null || customerName.trim().length() == 0){
            System.out.println("Invalid customer name");
            return;
        }
        if(balance < 0){
            System.out.println("Invalid balance");
            return;
        }
        BankAccount account;
        if (isSpecial) {
            account = new SpecialBankAccount(accountNumber,customerName, balance);
        } else {
            account = new NormalBankAccount(accountNumber,customerName, balance);
        }
        accounts[accountCount++] = account;
    }

    public int searchAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber()== accountNumber) {
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

    private String typeOfAccount(boolean type) {
        return type ? "Special" : "Normal";
    }

    public void printAccount() {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null) {
                System.out.println("Account type: " + typeOfAccount(accounts[i] instanceof SpecialBankAccount));
                System.out.println("Customer Name: " + accounts[i].getCustomerName());
                System.out.println("Balance: " + accounts[i].getBalance());
                System.out.println("-------------------");
            }
        }
    }
}
