package JAVA;

import java.util.Scanner;

public class UserInterface {
    private Account[] accounts;
    private int accountCount;
    private Scanner scanner;

    public UserInterface() {
        accounts = new Account[100];  // Array to hold up to 100 accounts
        accountCount = 0;
        scanner = new Scanner(System.in);
    }

    // Create a new account
    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        int accountNumber = 1001 + accountCount;
        accounts[accountCount] = new Account(accountNumber, name, initialDeposit, email, phone);
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    // Find account by number
    private Account findAccount(int accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    // Deposit money
    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw money
    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show account details
    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Update contact details
    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();

        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Main menu
    public void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("Thank you for using the Banking Application!"); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
