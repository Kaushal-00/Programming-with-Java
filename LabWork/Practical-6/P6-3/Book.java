import java.util.*;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;
    String publisher;

    public Book(int bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public int compareTo(Book other) {
        return this.bookId - other.bookId;
    }

    public String toString() {
        return "[" + bookId + ", " + title + ", " + author + ", " + publisher + "]";
    }
}

class TitleComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.title.compareToIgnoreCase(b2.title);
    }
}

class AuthorComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.author.compareToIgnoreCase(b2.author);
    }
}

class PublisherComparator implements Comparator<Book> {
    public int compare(Book b1, Book b2) {
        return b1.publisher.compareToIgnoreCase(b2.publisher);
    }
}