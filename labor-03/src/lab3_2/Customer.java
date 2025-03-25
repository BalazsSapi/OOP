package lab3_2;

import lab3_1.BankAccount;

public class Customer {
    public static final int MAX_ACCOUNTS=10;

    private String firstName, lastName;
    private BankAccount[] accounts=new BankAccount[MAX_ACCOUNTS];
    private int numAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName + ' ' + lastName + " accounts:\n");
        for(int i=0; i<numAccounts; ++i){
            result.append( "\t" + accounts[i] +"\n");
        }
        return result.toString();
    }


    public void addAccount(BankAccount account) {
        if (numAccounts>=MAX_ACCOUNTS)
        {
            return;
        }
        this.accounts[numAccounts++] = account;
    }

    /*public void closeAccount() {
        account = null;
    }*/

    public BankAccount getAccount(String accountNumber) {
        for (int i=0; i<numAccounts; i++) {
            if(accounts[i].getAccountNumber().equals(accountNumber)){
                return accounts[i];
            }
        }
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
