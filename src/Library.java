import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public List<Member> searchMembers(String keyword) {
        List<Member> searchResults = new ArrayList<>();
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(keyword.toLowerCase()) || member.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(member);
            }
        }
        return searchResults;
    }
}
