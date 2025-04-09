import java.io.*;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter word to search: ");
        String wordToSearch = scanner.nextLine();

        int count = 0;

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                if (word.equalsIgnoreCase(wordToSearch)) {
                    count++;
                }
            }

            fileScanner.close();

            System.out.println("The word '" + wordToSearch + "' occurred " + count + " times.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        scanner.close();
    }
}
