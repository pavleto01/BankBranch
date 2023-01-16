import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankBranch {

    private static BankBranch instance;
    private HashMap<String, List<BankAccount>> accounts;

    private BankBranch() {
        accounts = new HashMap<>();
    }

    public static BankBranch getInstance() {
        if (instance == null) {
            instance = new BankBranch();
        }
        return instance;
    }

    public boolean doesCustomerNameExist(String customerName) {
        return !accounts.containsKey(customerName);
    }

    public boolean isAccountNumberUnique(int accountNumber, String customerName) {
        List<BankAccount> customerAccounts = accounts.get(customerName);
        if (customerAccounts == null) {
            return true;
        }
        for (BankAccount account : customerAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                return false;
            }
        }
        return true;

    }

    public void createAccount(int accountNumber, String customerName, double balance, boolean isSpecial) {
        if (Validations.isValidName(customerName)) {
            System.out.println("Invalid customer name.");
            return;
        }
        if (Validations.isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number.");
            return;
        }
        if(!isAccountNumberUnique(accountNumber, customerName)) {
            System.out.println("Account number already exists.");
            return;
        }
        if (!Validations.isValidBalance(balance)) {
            System.out.println("Invalid balance.");
            return;
        }
        BankAccount account;
        if (isSpecial) {
            account = new SpecialBankAccount(accountNumber, customerName, balance);
        } else {
            account = new NormalBankAccount(accountNumber, customerName, balance);
        }
        if(!accounts.containsKey(customerName)) {
            accounts.put(customerName, new ArrayList<>());
        }
        accounts.get(customerName).add(account);
    }


    public void removeAccount(int accountNumber, String customerName) {
        if (Validations.isValidName(customerName)) {
            System.out.println("Invalid customer name.");
            return;
        }
        if (Validations.isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number.");
            return;
        }
        List<BankAccount> accountList = accounts.get(customerName);

        for (BankAccount bankAccount : accountList) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                accountList.remove(accountNumber);
                return;
            }
        }

    }

    public void deposit(int accountNumber, String customerName, double amount) {

        if (Validations.isValidName(customerName)) {
            System.out.println("Invalid customer name.");
            return;
        }
        if (Validations.isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number.");
            return;
        }

        if (Validations.isValidAmount(amount)) {
            System.out.println("Invalid amount.");
            return;
        }

        List<BankAccount> accountList = accounts.get(customerName);

        for (BankAccount bankAccount : accountList) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.deposit(amount);
                return;
            }
        }

    }

    public void withdraw(int accountNumber, String customerName, double amount) {
        if (Validations.isValidName(customerName)) {
            System.out.println("Invalid customer name.");
            return;
        }
        if (Validations.isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number.");
            return;
        }

        if (Validations.isValidAmount(amount)) {
            System.out.println("Invalid amount.");
            return;
        }
        List<BankAccount> accountList = accounts.get(customerName);

        for (BankAccount bankAccount : accountList) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                bankAccount.withdraw(amount);
                return;
            }
        }


    }

    public void checkBalance(int accountNumber, String customerName) {
        if (Validations.isValidName(customerName)) {
            System.out.println("Invalid customer name.");
            return;
        }
        if (Validations.isValidAccountNumber(accountNumber)) {
            System.out.println("Invalid account number.");
            return;
        }
        List<BankAccount> accountList = accounts.get(customerName);

        for (BankAccount bankAccount : accountList) {
            if (bankAccount.getAccountNumber() == accountNumber) {
                System.out.println("Balance: " + bankAccount.getBalance());
                return;
            }
        }

    }

    public void printAccounts() {
        if(accounts.isEmpty()){
            System.out.println("No accounts to print");
            return;
        }
        for (Map.Entry<String, List<BankAccount>> entry : accounts.entrySet()) {
            for (BankAccount account : entry.getValue()) {
                if(account instanceof NormalBankAccount) {
                    System.out.println( account + "\n" + "Account type: Normal" + "\n");
                } else if(account instanceof SpecialBankAccount) {
                    System.out.println( account + "\n" + "Account type: Special" + "\n");
                }
            }
        }
    }
}
