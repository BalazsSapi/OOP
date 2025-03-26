package oop.labor06.lab6_1;

public class BankAccount {
    private static final String PREFIX="BT";
    private static final int ACCOUNT_NUMBER_LENGTH=10;
    private static int numAccounts=0;
    private final String accountNumber;
    private double balance;

    public BankAccount() {
        numAccounts++;
        accountNumber=createAccountNumber();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', balance=" + balance + "}";
    }

    private static String createAccountNumber() {
        return PREFIX + String.format("%08d",numAccounts);
    }
}
