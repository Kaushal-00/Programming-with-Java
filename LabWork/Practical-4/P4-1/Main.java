import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Match[] players = new Match[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Player " + (i + 1) + ":");
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            
            System.out.print("Enter number of ODIs: ");
            int no_of_odi = scanner.nextInt();
            
            System.out.print("Enter number of Test matches: ");
            int no_of_test = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            players[i] = new Match();
            players[i].setData(name, age, no_of_odi, no_of_test);
        }

        System.out.println("\n===== Player Details =====");
        for (int i = 0; i < 5; i++) {
            players[i].display();
        }

        scanner.close();
    }
}