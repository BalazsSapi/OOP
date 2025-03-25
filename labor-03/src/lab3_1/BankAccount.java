package lab3_1;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        if(value > 0){
            balance += value;
        }
    }

    public boolean withdraw(double value) {
        if(value > balance){
            return false;
        }
        balance -= value;
        return true;
    }

    public String toString() {
        return "Bank Account{"+accountNumber + ": " + balance+"}";
    }


}
