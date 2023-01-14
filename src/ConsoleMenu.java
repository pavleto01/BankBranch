import java.util.Scanner;

public class ConsoleMenu {
    private int menu(Scanner sc){
        System.out.println("1. Create Account");
        System.out.println("2. Remove Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. Print all accounts");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    public static void executeCommands() {
        BankBranch bank = BankBranch.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = new ConsoleMenu().menu(sc);

            switch (choice) {
                case 1:
                    int accountNumber;
                    do {
                        System.out.print("Enter account number: ");
                        accountNumber = sc.nextInt();
                        if (!bank.isaccountNumberUnique(accountNumber)) {
                            System.out.println("Account number already exists.");
                        }
                    } while (bank.isaccountNumberUnique(accountNumber) == false);
                    System.out.print("Enter customer name: ");
                    String customerName = sc.next();
                    System.out.print("Enter initial deposit: ");
                    double deposit = sc.nextDouble();
                    int type;
                    do {
                        System.out.print("1: Normal Account, 2: Special Account: \n");
                        System.out.print("Type 1 or 2 for account type: ");
                        type = sc.nextInt();
                    } while(type < 1 || type > 2);
                    boolean isSpecial = type == 2;
                    bank.createAccount(accountNumber,customerName, deposit, isSpecial);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    int accountIndex = bank.searchAccount(accountNumber);
                    if (accountIndex != -1) {
                        bank.removeAccount(accountIndex);
                        System.out.println("Account removed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    accountIndex = bank.searchAccount(accountNumber);
                    if (accountIndex != -1) {
                        System.out.print("Enter deposit amount: ");
                        deposit = sc.nextDouble();
                        bank.deposit(accountIndex, deposit);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    accountIndex = bank.searchAccount(accountNumber);
                    if (accountIndex != -1) {
                        System.out.print("Enter withdraw amount: ");
                        double withdraw = sc.nextDouble();
                        bank.withdraw(accountIndex, withdraw);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();
                    accountIndex = bank.searchAccount(accountNumber);
                    if (accountIndex != -1) {
                        bank.checkBalance(accountIndex);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    bank.printAccount();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}