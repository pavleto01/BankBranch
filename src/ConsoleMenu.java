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

    private static void getCustomerAndAccount(final String[] customerName,final int[] accountNumber) {
        do{
            System.out.println("Enter customer name: ");
            customerName[0] = scanner.nextLine();
            if (!bankBranch.doesCustomerNameExist(customerName[0])) {
                System.out.println("Customer name not found. Please try again.");
            }
        } while (!bankBranch.doesCustomerNameExist(customerName[0]));

        do{
            System.out.println("Enter account number: ");
            accountNumber[0] = scanner.nextInt();
            if (bankBranch.isAccountNumberUnique(accountNumber[0], customerName[0])) {
                System.out.println("Account number not found. Please try again.");
            }
        } while (bankBranch.isAccountNumberUnique(accountNumber[0], customerName[0]));
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

        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        int accountNumber;
        do {
            System.out.println("Enter account number: ");
            accountNumber = scanner.nextInt();
            if (!bankBranch.isAccountNumberUnique(accountNumber, customerName)) {
                System.out.println("Account number already exists for this customer. Please try again.");
            }
        } while (!bankBranch.isAccountNumberUnique(accountNumber, customerName));

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

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        bankBranch.removeAccount(accountNumber[0], customerName[0]);
        System.out.println("Account removed successfully!");
    }

    private static void deposit() {

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankBranch.deposit(accountNumber[0],customerName[0], amount);
        System.out.println("Deposit successful!");
    }

    private static void withdraw() {

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bankBranch.withdraw(accountNumber[0],customerName[0], amount);
        System.out.println("Withdraw successful!");

    }

    private static void checkBalance() {

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        bankBranch.checkBalance(accountNumber[0],customerName[0]);
    }

    private static void printAllAccounts() {
        bankBranch.printAccounts();
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