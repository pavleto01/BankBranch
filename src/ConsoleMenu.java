import java.util.Scanner;

public class ConsoleMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static BankBranch bankBranch = BankBranch.getInstance();

    public static void run() {
        while (true) {
            printMenu();
            int choice = getChoice();
            performAction(choice);
        }
    }

    private static void printMenu() {
        System.out.println("1. Create Account");
        System.out.println("2. Remove Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. Print All Accounts");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    private static int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }


    private static void createAccount() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        if (!bankBranch.isaccountNumberUnique(accountNumber)) {
            System.out.println("Account number already exists. Please try again.");
            return;
        }
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        int type;
        do {
            System.out.print("1: Normal Account, 2: Special Account: \n");
            System.out.print("Type 1 or 2 for account type: ");
            type = scanner.nextInt();
        } while(type < 1 || type > 2);
        boolean isSpecial = type == 2;
        bankBranch.createAccount(accountNumber, customerName, balance, isSpecial);
        System.out.println("Account created successfully!");
    }

    private static void removeAccount() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        bankBranch.removeAccount(accountNumber);
        System.out.println("Account removed successfully!");
    }

    private static void deposit() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankBranch.deposit(accountNumber, amount);
        System.out.println("Deposit successful!");
    }

    private static void withdraw() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankBranch.withdraw(accountNumber, amount);
    }

    private static void checkBalance() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        bankBranch.checkBalance(accountNumber);
    }

    private static void printAllAccounts() {
        bankBranch.printAllAccounts();
    }

    private static void exit() {
        System.out.println("Thank you for using our bank!");
        System.exit(0);
    }

    private static void performAction(int choice) {
        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                removeAccount();
                break;
            case 3:
                deposit();
                break;
            case 4:
                withdraw();
                break;
            case 5:
                checkBalance();
                break;
            case 6:
                printAllAccounts();
                break;
            case 7:
                exit();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }


}