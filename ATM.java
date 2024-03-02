import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount userAccount;

    public static void main(String[] args) {
        userAccount = new BankAccount(1000.0);

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // consume invalid input
        }
        return scanner.nextInt();
    }

    private static void withdraw() {
        System.out.print("Enter the withdrawal amount: $");
        double amount = getUserAmount();

        userAccount.withdraw(amount);
    }

    private static void deposit() {
        System.out.print("Enter the deposit amount: $");
        double amount = getUserAmount();

        userAccount.deposit(amount);
    }

    private static void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }

    private static double getUserAmount() {
        while (true) {
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a valid amount: $");
                scanner.next(); // consume invalid input
            }

            double amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.print("Invalid amount. Please enter a positive value: $");
            } else {
                return amount;
            }
        }
    }
}

