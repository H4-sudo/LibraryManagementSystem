import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addBook() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        library.addBook(book);
        assertEquals(1, library.getBooks().size()); // Should return 1
    }

    @Test
    void removeBook() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        library.addBook(book);
        library.removeBook(book);
        assertEquals(0, library.getBooks().size()); // Should return 0
    }

    @Test
    void addMember() {
        Library library = new Library();
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addMember(member);
        assertEquals(1, library.getMembers().size()); // Should return 1
    }

    @Test
    void removeMember() {
        Library library = new Library();
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addMember(member);
        library.removeMember(member);
        assertEquals(0, library.getMembers().size()); // Should return 0
    }

    @Test
    void searchBooks() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Book book1 = new Book("Java for You", "John Doe", "0987654321");
        Book book2 = new Book("Java for Beginners", "Jane Doe", "0987654321");
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.searchBooks("java").size()); // Should return 2
    }

    @Test
    void searchMembers() {
        Library library = new Library();
        Member member = new Member("John Doe", "jdoe@jmail.com");
        Member member1 = new Member("Jane Doe", "jadoe@jmail.com");
        library.addMember(member);
        library.addMember(member1);
        assertEquals(2, library.searchMembers("doe").size()); // Should return 2
    }

    @Test
    void lendBook() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addBook(book);
        library.addMember(member);
        library.lendBook(book, member);
        assertFalse(book.isAvailable()); // Should return false
    }

    @Test
    void returnBook() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addBook(book);
        library.addMember(member);
        library.lendBook(book, member);
        library.returnBook(book, member);
        assertTrue(book.isAvailable()); // Should return true
    }

    @Test
    void getBooks() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Book book1 = new Book("Java for You", "John Doe", "0987654321");
        library.addBook(book);
        library.addBook(book1);
        assertEquals(2, library.getBooks().size()); // Should return 2
    }

    @Test
    void getMembers() {
        Library library = new Library();
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addMember(member);
        assertEquals(1, library.getMembers().size()); // Should return 1
    }

    @Test
    void getBooksCheckedOut() {
        Library library = new Library();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        Member member = new Member("John Doe", "jdoe@jmail.com");
        library.addBook(book);
        library.addMember(member);
        library.lendBook(book, member);
        assertEquals(1, library.getBooksCheckedOut().size()); // Should return 1
    }

    @Test
    void addTenBooks() {
        Library library = new Library();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("Book " + i, "Author " + i, "ISBN " + i);
            library.addBook(book);
        }
        assertEquals(10, library.getBooks().size()); // Should return 10
    }

    @Test
    void addFourteenMembers() {
        Library library = new Library();
        Member member = new Member("John Doe", "jd@mail.co");
        Member member1 = new Member("Jane Doe", "jad@mail.co");
        Member member2 = new Member("Mike Doe", "md@mail.co");
        Member member3 = new Member("Mia Doe", "mid@mail.co");
        Member member4 = new Member("Johny Doe", "jyd@mail.co");
        Member member5 = new Member("Jenny Doe", "jed@mail.co");
        Member member6 = new Member("Mickey Doe", "mkd@mail.co");
        Member member7 = new Member("Mina Doe", "mind@mail.co");
        Member member8 = new Member("Jenny Doe", "jenn@mail.co");
        Member member9 = new Member("Mickey Doe", "mick@mail.co");
        Member member10 = new Member("Mina Doe", "mina@mail.co");
        Member member11 = new Member("John Doe", "john@mail.co");
        Member member12 = new Member("Jane Doe", "jane@mail.co");
        Member member13 = new Member("Mike Doe", "mike@mail.co");
        library.addMember(member);
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);
        library.addMember(member4);
        library.addMember(member5);
        library.addMember(member6);
        library.addMember(member7);
        library.addMember(member8);
        library.addMember(member9);
        library.addMember(member10);
        library.addMember(member11);
        library.addMember(member12);
        library.addMember(member13);
        assertEquals(14, library.getMembers().size()); // Should return 20
    }
}