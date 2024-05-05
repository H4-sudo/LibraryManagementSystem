import java.io.Serializable;
import java.util.ArrayList;

// Initialize the Member class
public class Member implements Serializable {
    private String name;
    private String email;
    private ArrayList<Book> borrowedBooks;
    private double fine;

    // Constructor for the Member class
    public Member(String name, String email) {
        this.name = name;
        setEmail(email);
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and Setters for the Member class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Invalid email format, please try again.");
        }
    }

    public double getFines() {
        return fine;
    }

    public void setFines(double fine) {
        this.fine = fine;
    }

    // Method to check if an entered email is valid
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // Method to get the borrowed books of a member
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to set the borrowed books of a member
    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    // Method to add a borrowed book to a member
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method to remove a borrowed book from a member
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }
}
