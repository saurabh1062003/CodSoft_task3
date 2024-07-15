/BankAccount.java for class1/ package atm;

public class BankAccount { private double balance;

public BankAccount(double initialBalance) {
    this.balance = initialBalance;
}

public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    } else {
        System.out.println("Invalid amount. Deposit failed.");
    }
}

public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    } else {
        System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
    }
}

public double getBalance() {
    return balance;
}
}

/ATM.java for Class 2/

package atm;

import java.util.Scanner;

public class ATM { private BankAccount account; private Scanner scanner;

public ATM(BankAccount account) {
    this.account = account;
    this.scanner = new Scanner(System.in);
}

public void start() {
    boolean exit = false;
    while (!exit) {
        System.out.println("Welcome to the ATM. Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Your balance is: " + account.getBalance());
                break;
            case 4:
                exit = true;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    scanner.close();
    System.out.println("Thank you for using the ATM.");
}

public static void main(String[] args) {
    BankAccount account = new BankAccount(1000.00);
    ATM atm = new ATM(account);
    atm.start();
}
}