class Main {

    public static void main(String[] args) {
    
    BankAccount account = new BankAccount();
    account.createAcc("Kaushal", "Savings", 1000.0);

    // Perform operations
    System.out.println("\n--- Performing Operations ---");
    account.deposit(500.0); 
    account.withdraw(200.0); 
    account.balanceInquiry(); 

    }
}