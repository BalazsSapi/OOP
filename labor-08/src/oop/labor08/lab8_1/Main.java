package oop.labor08.lab8_1;

public class Main {
    public static void main(String[] args) {
        Bank bank=new Bank("Banca Transilvania");
        Customer customer1=new Customer("Balazs","Domokos"),customer2=new Customer("Daniel","Bartos");
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        customer1.addAccount(new CheckingAccount(1200.50));
    }
}
// a CheckingAccount és a SavingsAccount constructora még nincs jól, fejezd be a maint