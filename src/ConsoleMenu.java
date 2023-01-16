import java.util.Scanner;

public class ConsoleMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static BankBranch bankBranch = BankBranch.getInstance();

    public static void run() {
        do {
            printMenu();
            int choice = getChoice();
            performAction(choice);
        } while (true);
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

    private static void getCustomerAndAccount(final String[] customerName,final int[] accountNumber) {
        do{
            System.out.println("Enter customer name: ");
            customerName[0] = scanner.nextLine();
            if (bankBranch.doesCustomerNameExist(customerName[0])) {
                System.out.println("Customer name not found or invalid. Please try again.");
            }
        } while (bankBranch.doesCustomerNameExist(customerName[0]) || Validations.isValidName(customerName[0]));

        do {
            System.out.println("Enter account number: ");
            if (scanner.hasNextInt()) {
                accountNumber[0] = scanner.nextInt();
                if (Validations.isValidAccountNumber(accountNumber[0])) {
                    System.out.println("Account number is invalid or already exists. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid account number. Please enter a positive integer.");
                scanner.nextLine();
            }
        } while (true);
    }

    private static void createAccount() {
        String customerName;
        do {
            System.out.println("Enter customer name: ");
            customerName = scanner.nextLine();
            if (Validations.isValidName(customerName)) {
                System.out.println("Customer name is invalid. Please try again.");
            }
        } while (Validations.isValidName(customerName));
        int accountNumber;
        do {
            System.out.println("Enter account number: ");
            if (scanner.hasNextInt()) {
                accountNumber = scanner.nextInt();
                if (Validations.isValidAccountNumber(accountNumber) || !bankBranch.isAccountNumberUnique(accountNumber, customerName)) {
                    System.out.println("Account number is invalid or already exists. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid account number. Please enter a positive integer.");
                scanner.nextLine();
            }
        } while (true);

        double balance;
        do {
            System.out.println("Enter balance: ");
            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                if (!Validations.isValidBalance(balance)) {
                    System.out.println("Balance is invalid. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid balance. Please enter a positive number.");
                scanner.nextLine();
            }
        } while (true);

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

    }

    private static void deposit() {

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        double amount;
        do {
            System.out.println("Enter amount to deposit: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (Validations.isValidAmount(amount)) {
                    System.out.println("Amount is invalid. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
                scanner.nextLine();
            }
        } while (true);
        bankBranch.deposit(accountNumber[0],customerName[0], amount);

    }

    private static void withdraw() {

        final String[] customerName = new String[1];
        final int[] accountNumber = new int[1];
        getCustomerAndAccount(customerName, accountNumber);
        double amount;
        do {
            System.out.println("Enter amount to withdraw: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (Validations.isValidAmount(amount)) {
                    System.out.println("Amount is invalid. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
                scanner.nextLine();
            }
        } while (true);
        bankBranch.withdraw(accountNumber[0],customerName[0], amount);


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
            case 1 -> createAccount();
            case 2 -> removeAccount();
            case 3 -> deposit();
            case 4 -> withdraw();
            case 5 -> checkBalance();
            case 6 -> printAllAccounts();
            case 7 -> exit();
            default -> System.out.println("Invalid choice.");
        }
    }
}