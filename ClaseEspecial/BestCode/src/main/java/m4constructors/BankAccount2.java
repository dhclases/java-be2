package m4constructors;

class BankAccount2 {

    private double balance;
    private double interest;

    BankAccount2() {
        this(0);
    }

    BankAccount2(double balance) {
        this(balance, 0.01);
    }

    BankAccount2(double balance, double interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Interest rate can't be less than 0");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance can't be less than 0");
        }
        this.balance = balance;
        this.interest = interest;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Balance: " + this.balance + "; interest:" + this.interest;
    }
}
