import java.util.Scanner;

public class ConsoleMenu {
    public static void ConsoleMenu() {
        BankBranch bank = BankBranch.getInstance();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Print all accounts");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = sc.next();
                    System.out.print("Enter initial deposit: ");
                    double deposit = sc.nextDouble();
                    System.out.print("Is this a special account (true/false)? ");
                    boolean isSpecial = sc.nextBoolean();
                    bank.createAccount(customerName, deposit, isSpecial);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    customerName = sc.next();
                    int accountIndex = bank.searchAccount(customerName);
                    if (accountIndex != -1) {
                        bank.removeAccount(accountIndex);
                        System.out.println("Account removed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    customerName = sc.next();
                    accountIndex = bank.searchAccount(customerName);
                    if (accountIndex != -1) {
                        System.out.print("Enter deposit amount: ");
                        deposit = sc.nextDouble();
                        bank.deposit(accountIndex, deposit);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter customer name: ");
                    customerName = sc.next();
                    accountIndex = bank.searchAccount(customerName);
                    if (accountIndex != -1) {
                        System.out.print("Enter withdraw amount: ");
                        double withdraw = sc.nextDouble();
                        bank.withdraw(accountIndex, withdraw);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter customer name: ");
                    customerName = sc.next();
                    accountIndex = bank.searchAccount(customerName);
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