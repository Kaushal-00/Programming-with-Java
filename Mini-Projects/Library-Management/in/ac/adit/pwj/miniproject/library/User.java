package in.ac.adit.pwj.miniproject.library;

public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public void borrowBook(Library library, String title) throws Exception {
        library.borrowBook(title, this);
    }

    public void returnBook(Library library, String title) {
        library.returnBook(title, this);
    }
}
