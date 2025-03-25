package in.ac.adit.pwj.miniproject.library;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Library.Inventory inventory = library.new Inventory();

        // Add books
        inventory.addBook("Java Basics");
        inventory.addBook("Data Structures");
        inventory.addBook("OOP Concepts");

        // Load from file (optional)
        library.loadBooksFromFile("books.txt");

        // Threading simulation
        Thread t1 = new Thread(() -> {
            try {
                User s1 = new Student("Alice");
                s1.borrowBook(library, "Java Basics");
                Thread.sleep(1000);
                s1.returnBook(library, "Java Basics");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                User f1 = new Faculty("Dr. Bob");
                f1.borrowBook(library, "Java Basics");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();

        // Save after operations
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        library.saveBooksToFile("books.txt");
    }
}