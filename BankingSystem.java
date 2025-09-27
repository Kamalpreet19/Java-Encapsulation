/*Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and 
calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest dynamically. */

abstract class BankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getbalance() {
        return balance;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited : " + amount);
        } else {
            System.out.println("Invalid amount to deposit");
        }

    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn : " + amount);
        } else {
            System.err.println("Invalid amount to withdraw");
        }

    }

    abstract void calculateInterest();

    public void displayDetails() {
        System.out.println("----Account Holder's Details----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account holder name : " + holderName);
        System.out.println("Account balance : " + balance);
    }

}

interface Loanable {
    void applyForLoan();

    void calculateLoanEligibility();

}

class SavingsAccount extends BankAccount implements Loanable {
    private static final double interest_rate = 0.02;

    SavingsAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void calculateInterest() {
        double interest = getbalance() * interest_rate;
        System.out.println("Amount of interest : " + interest);

    }

    public void applyForLoan() {
        System.out.println("Loan applied from Savings Account");

    }

    public void calculateLoanEligibility() {
        if (getbalance() > 5000) {
            System.out.println("Eligible for loan ");
        } else {
            System.out.println("Not eligible for loan");

        }

    }

}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double interest_rate = 0.04;

    CurrentAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void calculateInterest() {
        double interest = getbalance() * interest_rate;
        System.out.println("Amount of interest : " + interest);
    }

    public void applyForLoan() {
        System.out.println("Loan applied from Current Account");
    }

    public void calculateLoanEligibility() {
        if (getbalance() >= 10000) {
            System.out.println("Eligible for loan");
        } else {
            System.out.println("Not eligible for loan");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount obj1 = new SavingsAccount(46874843L, "Kamalpreet", 78000);
        BankAccount obj2 = new CurrentAccount(678985878L, "Natasha", 45000);
        obj1.displayDetails();
        obj1.deposit(12000);
        obj1.withdraw(10500);
        obj1.calculateInterest();
        ((Loanable) obj1).calculateLoanEligibility();

        System.out.println();
        obj2.displayDetails();
        obj2.deposit(16000);
        obj2.withdraw(10000);
        obj2.calculateInterest();
        ((Loanable) obj2).calculateLoanEligibility();

    }

}
