public class Validations {
    public static boolean isValidName(String name) {
        // check if the name is not null or empty
        if (name == null || name.isEmpty()) {
            return true;
        }
        // check if the name contains only alphabetic characters
        return !name.matches("^[a-zA-Z]+$");
    }
    public static boolean isValidAccountNumber(int accountNumber) {
        if(accountNumber < 0)
            return true;
        String accountNumberString = String.valueOf(accountNumber);
        return !accountNumberString.matches("^[0-9]+$");
    }
    public static boolean isValidBalance(double balance) {
        // check if the balance is positive
        return !(balance < 0);
    }
    public static boolean isValidAmount(double amount) {
        // check if the amount is positive
        return !(amount <= 0);
    }
}