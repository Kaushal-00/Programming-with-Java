package in.ac.adit.pwj.miniproject.library;

import java.util.*;
import java.io.*;

public class Library {
    HashMap<String, Book> books = new HashMap<>();

    // Inner class for Inventory
    class Inventory {
        public void addBook(String title) {
            books.put(title, new Book(title));
        }
    }

    public void borrowBook(String title, User user) throws Exception {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            if (book.isAvailable) {
                book.isAvailable = false;
                System.out.println(user.name + " borrowed: " + title);
            } else {
                throw new Exception("Book '" + title + "' is not available.");
            }
        } else {
            throw new Exception("Book '" + title + "' does not exist.");
        }
    }

    public void returnBook(String title, User user) {
        if (books.containsKey(title)) {
            books.get(title).isAvailable = true;
            System.out.println(user.name + " returned: " + title);
        } else {
            System.out.println("Book '" + title + "' does not exist.");
        }
    }

    // File Handling: Save and Load
    public void saveBooksToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String title : books.keySet()) {
                bw.write(title + "," + books.get(title).isAvailable);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book(data[0]);
                book.isAvailable = Boolean.parseBoolean(data[1]);
                books.put(data[0], book);
            }
        } catch (IOException e) {
            System.out.println("Error loading books.");
        }
    }
}
