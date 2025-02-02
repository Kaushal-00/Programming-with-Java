class BankAccount {
    
    private String depositorName;
    private int accNo;
    private String accType;
    private double balance;

    private static int nextAccNo = 1;

    public void createAcc(String name, String type, double initialDeposit) {
        depositorName = name;
        accType = type;
        balance = initialDeposit;

        accNo = nextAccNo;
        nextAccNo++;
       
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + accNo);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully! Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully! Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
        }
    }

    public void balanceInquiry() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Account Type: " + accType);
        System.out.println("Current Balance: " + balance);
    }
}