import java.util.Scanner;

public class CommandLineCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the first number: ");
            int num1 = scanner.nextInt();
            // float num1 = scanner.nextFloat();

            System.out.println("Enter the Second number: ");
            int num2 = scanner.nextInt();

            System.out.println("Enter the operator (+, -, *, /) || Enter 'E' for exit: ");
            char operator = scanner.next().charAt(0);

            float result = 0;

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num2 != 0) {
                        result = (float) num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid operator!");
                    return;
            }

            System.out.println("Result: " + result);
        } while(true);

        // scanner.close(); //Can't reachable because loop never stops..
    }
}