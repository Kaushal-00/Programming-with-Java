import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();  // Reads the full line

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();  // Reads the next integer

        System.out.println("Enter your height in meters: ");
        double height = scanner.nextDouble();  // Reads the next double

        System.out.println("Hello " + name + ", you are " + age + " years old and " + height + " meters tall.");

        scanner.close();
    }
}