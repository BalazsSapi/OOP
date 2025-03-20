package oop.labor04.lab4_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = readCustomersFromCSV("lab4_2.csv");

        // Print the list of customers and their accounts
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static ArrayList<Customer> readCustomersFromCSV(String fileName) {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer currentCustomer = null;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                String type = parts[0].trim();

                if (type.equalsIgnoreCase("Customer") && parts.length == 3) {
                    // Create a new Customer
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    currentCustomer = new Customer(firstName, lastName);
                    customers.add(currentCustomer);
                } else if (type.equalsIgnoreCase("Account") && parts.length == 3) {
                    // Add a BankAccount to the last created customer
                    if (currentCustomer != null) {
                        String accountNumber = parts[1].trim();
                        double balance = Double.parseDouble(parts[2].trim());
                        currentCustomer.addAccount(new BankAccount(accountNumber, balance));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("CSV file " + fileName + " not found.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance in file " + fileName);
            e.printStackTrace();
        }
        return customers;
    }
}
