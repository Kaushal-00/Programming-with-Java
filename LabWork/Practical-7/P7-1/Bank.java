public class Bank {
    private double balance;

    Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        System.out.println("Old Balance: " + balance);
        balance += amount;
        System.out.println("Deposited " + amount);
        System.out.println("New Balance: " + balance);
    }

    void withdraw(double amount) throws NotEnoughMoneyException {
        System.out.println("Old Balance: " + balance);
        
        if (amount > balance) {
            throw new ArithmeticException("Insufficient Balance! Cannot withdraw " + amount);
        }
        
        balance -= amount;
        System.out.println("Withdrawn " + amount);
        System.out.println("New Balance: " + balance);

        if (balance < 500) {
            throw new NotEnoughMoneyException("Warning! Balance is below 500.");
        }
    }
}
