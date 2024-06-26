package com.raidwave.librarymanagementsystem;

/**
 *
 * @author henrico
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Class to represent a library
public class Library implements Serializable {
    private transient FineCalculator fineCalculator;
    private final List<Book> books;
    private final List<Member> members;

    // Constructor for the library class
    public Library() {
        this.fineCalculator = new FineCalculator();
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
            if (!member.getBorrowedBooks().isEmpty()) {
                System.out.println(member.getName() + " has the following books checked out:");
                for (Book book : member.getBorrowedBooks()) {
                    System.out.println(book.getTitle());
                    checkedOutBooks.add(book);
                }
            }
        }
        return checkedOutBooks;
    }

    // This is the new method for adding the member to the checked out book and adding a due date.
    public void borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            LocalDate dueDate = LocalDate.now().plusDays(14); // This sets the due date to 14 days from now
            book.setBorrower(member, dueDate);
            member.addBorrowedBook(book);
            book.setAvailable(false);
            System.out.printf("Book '%s' borrowed by %s.", book.getTitle(), member.getName());
        } else {
            System.out.printf("Book '%s' cannot be returned by %s", book.getTitle(), member.getName());
        }
    }

    // This is the new method for returning the books
    public void returnBook(Book book, Member member, LocalDate returnDate) {
        if (!book.isAvailable()) {
            LocalDate dueDate = book.getDueDate();
            double fineAmount = fineCalculator.calculateFines(dueDate, returnDate);
            member = book.getBorrower();
            book.removeBorrower();
            member.removeBorrowedBook(book);
            book.setAvailable(true);
            System.out.printf("Book '%s' has been returned by %s.", book.getTitle(), member.getName());
            if (fineAmount <= 0) {
                System.out.printf("No fines were issued to %s", member.getName());
            } else {
                System.out.printf("%s had gotten a fine of %.2f%n, due to missing the due date.", member.getName(), fineAmount);
                member.addFine(fineAmount);
            }
        } else {
            System.out.printf("Book '%s' is currently not borrowed.", book.getTitle());
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        fineCalculator = new FineCalculator();
    }

    public void notifyAdmin(Book book) {
        System.out.println("Admin notified about the overdue book: " + book.getTitle());
    }

    void payFines(Member memberToPayFines, double amount) {
        // This method is used to pay fines for a member
        double amountFined = memberToPayFines.getFines();
        if (amount >= amountFined) {
            memberToPayFines.setFines(0);
            System.out.printf("Fines paid successfully by %s. Remaining balance: %.2f%n", memberToPayFines.getName(), memberToPayFines.getFines());
        } else {
            memberToPayFines.setFines(amountFined - amount);
            System.out.printf("Fines paid successfully by %s. Remaining balance: %.2f%n", memberToPayFines.getName(), memberToPayFines.getFines());
        }
    }

    // This method is solely used for testing purposes
    void borrowBookForTesting(Book book, Member member, LocalDate dueDate) {
        if (book.isAvailable()) {
            book.setBorrower(member, dueDate);
            member.addBorrowedBook(book);
            book.setAvailable(false);
            System.out.printf("Book '%s' borrowed by %s.", book.getTitle(), member.getName());
        } else {
            System.out.printf("Book '%s' cannot be returned by %s", book.getTitle(), member.getName());
        }
    }
}
