package oop.labor06.lab6_1;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            bankAccounts.add(new BankAccount());
        }
        //System.out.println(bankAccounts);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Andras", "Molnar"));
        customers.add(new Customer("Balazs", "Domokos"));
        customers.add(new Customer("Ferenc", "Veress"));

        customers.get(0).addAccount(bankAccounts.get(0));
        customers.get(0).addAccount(bankAccounts.get(1));

        customers.get(1).addAccount(bankAccounts.get(2));
        customers.get(1).addAccount(bankAccounts.get(3));

        customers.get(2).addAccount(bankAccounts.get(4));

        /*System.out.println("-----------------");
        for(Customer c:customers){
            System.out.println(c);
        }
        System.out.println("-----------------");*/

        Bank bank = new Bank("Banca Transilvania");
        bank.addCustomer(customers.get(0));
        bank.addCustomer(customers.get(1));
        System.out.println(bank.getCustomer(1));
        for (int i = 0; i < bank.getNumCustomers(); i++) {
            Customer c = bank.getCustomer(i + 1);
            ArrayList<String> accNumbers = c.getAccountNumbers();
            int j = i;
            for (String accNumber : accNumbers) {

                BankAccount account = c.getAccount(accNumber);
                account.deposit((j + 1) * 10 + i*10);
                j++;
            }
        }
        System.out.println(bank.getCustomer(2));
        printCustomersOfBank("bank_customers.csv", bank);
    }

    public static void printCustomersOfBank(String fileName, Bank bank) {
        bank.printCustomersToFile(fileName);
    }
}
