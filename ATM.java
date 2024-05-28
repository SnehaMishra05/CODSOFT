package CODSOFT;

import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else
            System.out.println("Invalid deposit amount.");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount > balance)
            System.out.println("Insufficient balance.");
        else
            System.out.println("Invalid withdrawal amount.");
    }
}

class ATM {
    BankAccount bankAccount;

    ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs. " + bankAccount.getBalance());
    }

    public void showMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}

class execution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance for the account: ");
        double initialBalance = sc.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);
        boolean exit = false;
        while (!exit) {
            atm.showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Have a Good day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
        sc.close();
    }
}