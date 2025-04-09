package oop.labor08.lab8_1;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Customer getCustomer(int ID) {
        for (Customer c : customers) {
            if (c.getID() == ID) {
                return c;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getNumCustomers() {
        return customers.size();
    }

    private void printCustomers(PrintStream out) {
        out.println("ID, Firstname, Last name, Number of bank accounts");
        for( Customer customer: customers ) {
            out.println( customer.getID()+", " + customer.getFirstName() + ", "+ customer.getLastName()+", "+customer.getNumAccounts());
        }
    }

    public void printCustomersToStdout() {
        printCustomers( System.out );
    }

    public void printCustomersToFile( String filename ) {
        try (PrintStream out = new PrintStream(filename)) {
            printCustomers(out);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}