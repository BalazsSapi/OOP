package oop.labor06.lab6_1;

import java.util.ArrayList;

public class Customer {
    private final int ID;
    private static int numCustomers=0;
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        ID=++numCustomers;
    }

    public int getID() {
        return ID;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public ArrayList<String> getAccountNumbers(){
        ArrayList<String> accountNumbers = new ArrayList<>();
        for(BankAccount account:accounts){
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void closeAccount(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append(" ID: ").append(ID).append("\naccounts:\n");
        for (BankAccount account : accounts) {
            sb.append("\t" + account).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
