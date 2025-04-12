import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book(102, "Java Basics", "Alice", "TechBooks"));
        books.add(new Book(101, "Python Guide", "Bob", "CodePress"));
        books.add(new Book(103, "C++ Pro", "Charlie", "LearnWell"));

        System.out.println("Original (Unsorted by bookId):");
        for (Book b : books)
            System.out.println(b);

        Collections.sort(books);
        System.out.println("\nSorted by bookId (Comparable):");
        for (Book b : books)
            System.out.println(b);

        Collections.sort(books, new TitleComparator());
        System.out.println("\nSorted by Title:");
        for (Book b : books)
            System.out.println(b);

        Collections.sort(books, new AuthorComparator());
        System.out.println("\nSorted by Author:");
        for (Book b : books)
            System.out.println(b);

        Collections.sort(books, new PublisherComparator());
        System.out.println("\nSorted by Publisher:");
        for (Book b : books)
            System.out.println(b);
    }
}
