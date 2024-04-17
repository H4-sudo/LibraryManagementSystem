import java.util.ArrayList;
import java.util.List;

// Class to represent a library
public class Library {
    private List<Book> books;
    private List<Member> members;

    // Constructor for the library class
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to add a member to the library
    public void addMember(Member member) {
        members.add(member);
    }

    // Method to remove a member from the library
    public void removeMember(Member member) {
        members.remove(member);
    }

    // Method to search for books in the library
    public List<Book> searchBooks(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // Method to search for members in the library
    public List<Member> searchMembers(String keyword) {
        List<Member> searchResults = new ArrayList<>();
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(keyword.toLowerCase()) || member.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(member);
            }
        }
        return searchResults;
    }

    // Method to lend a book to a member
    public void lendBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.toggleAvailability();
            member.addBorrowedBook(book);
        }
    }

    // Method to return a book from a member
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            book.toggleAvailability();
            member.removeBorrowedBook(book);
        }
    }

    // Getters for the library class
    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    // Method to get the books checked out by members
    public List<Book> getBooksCheckedOut() {
        List<Book> checkedOutBooks = new ArrayList<>();
        for (Member member : members) {
            if (member.getBorrowedBooks().size() > 0) {
                System.out.println(member.getName() + " has the following books checked out:");
                for (Book book : member.getBorrowedBooks()) {
                    System.out.println(book.getTitle());
                }
            }
        }
        return checkedOutBooks;
    }
}
