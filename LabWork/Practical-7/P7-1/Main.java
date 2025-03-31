public class Main {
    public static void main(String[] args) {
        Bank account = new Bank(1000);

        try {
            account.deposit(500);
            account.withdraw(800);
            account.withdraw(300);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try{
            account.withdraw(1000);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
