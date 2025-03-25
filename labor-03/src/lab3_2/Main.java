package lab3_2;

import lab3_1.BankAccount;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Domokos", "Balazs");
        System.out.println(customer1);
        customer1.addAccount(new BankAccount("OTP1"));
        customer1.addAccount(new BankAccount("OTP2"));
        customer1.getAccount("OTP1").deposit(1000);
        System.out.println(customer1);
    }
}
