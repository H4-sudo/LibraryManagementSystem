
import java.time.LocalDate;

public class Book {
    // The properties of the book class
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;
    private LocalDate dueDate;
    private Member borrower;

    // This is the constructor for the class
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true; // This sets books available by default.
        this.dueDate = null;
        this.borrower = null;
    }

    // Getters and Setters for the Book class
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void toggleAvailability() {
        isAvailable = !isAvailable;
    }

    public boolean isBorrowed() {
        return !isAvailable;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower, LocalDate dueDate) {
        this.borrower = borrower;
        this.dueDate = dueDate;
        this.isAvailable = false;
    }

    public void removeBorrower() {
        this.borrower = null;
        this.dueDate = null;
        this.isAvailable = true;
    }
    
}
