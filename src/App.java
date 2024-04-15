import java.util.List;

class App {
    /**
     * The main method is the entry point of the Library Management System application.
     * It displays a menu of options to the user and performs corresponding actions based on the user's choice.
     * The user can add books, remove books, add members, remove members, search for books, search for members, or exit the application.
     * The method uses the Library class to perform these operations.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("==========================================================");
        System.out.println("    ____        _     __   ____              __       ");
        System.out.println("   / __ \\____ _(_)___/ /  / __ )____  ____  / /_______");
        System.out.println("  / /_/ / __ `/ / __  /  / __  / __ \\/ __ \\/ //_/ ___/");
        System.out.println(" / _, _/ /_/ / / /_/ /  / /_/ / /_/ / /_/ / ,< (__  ) ");
        System.out.println("/_/ |_|\\__,_/_/\\__,_/  /_____/\\____/\\____/_/|_/____/  ");
        System.out.println("                                                      ");
        System.out.println("==========================================================");
        System.out.println("Welcome to the Library Management System! How can we help you today?");
        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Add a member");
            System.out.println("4. Remove a member");
            System.out.println("5. Search for books");
            System.out.println("6. Search for members");
            System.out.println("7. Check out a book");
            System.out.println("8. Check in a book");
            System.out.println("9. View all books");
            System.out.println("10. View all members");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = System.console().readLine();
                    System.out.print("Enter the author of the book: ");
                    String author = System.console().readLine();
                    System.out.print("Enter the ISBN of the book: ");
                    String ISBN = System.console().readLine();
                    Book book = new Book(title, author, ISBN);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to remove: ");
                    String bookTitle = System.console().readLine();
                    List<Book> searchResults = library.searchBooks(bookTitle);
                    if (searchResults.size() == 0) {
                        System.out.println("No books found with the title: " + bookTitle);
                    } else {
                        System.out.println("Select the book you want to remove:");
                        for (int i = 0; i < searchResults.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResults.get(i).getTitle() + " by " + searchResults.get(i).getAuthor());
                        }
                        int bookIndex = Integer.parseInt(System.console().readLine());
                        library.removeBook(searchResults.get(bookIndex - 1));
                        System.out.println("Book removed successfully!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the member: ");
                    String name = System.console().readLine();
                    System.out.print("Enter the email of the member: ");
                    String email = System.console().readLine();
                    Member member = new Member(name, email);
                    library.addMember(member);
                    System.out.println("Member added successfully!");
                    break;
                case 4:
                    System.out.print("Enter the name of the member you want to remove: ");
                    String memberName = System.console().readLine();
                    System.out.print("Searching for member '" + memberName + "' in the system.");
                    List<Member> searchResultsMembers = library.searchMembers(memberName);
                    if (searchResultsMembers.size() == 0) {
                        System.out.println("No members found with the name: " + memberName);
                    } else {
                        System.out.println("Select the member you want to remove:");
                        for (int i = 0; i < searchResultsMembers.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsMembers.get(i).getName() + " (" + searchResultsMembers.get(i).getEmail() + ")");
                        }
                        int memberIndex = Integer.parseInt(System.console().readLine());
                        library.removeMember(searchResultsMembers.get(memberIndex - 1));
                        System.out.println("Member removed successfully!");
                    }
                    break;
                case 5:
                    System.out.print("Enter the title of the book you want to search: ");
                    String searchTitle = System.console().readLine();
                    List<Book> searchResultsBooks = library.searchBooks(searchTitle);
                    if (searchResultsBooks.size() == 0) {
                        System.out.println("No books found with the title: " + searchTitle);
                    } else {
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultsBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsBooks.get(i).getTitle() + " by " + searchResultsBooks.get(i).getAuthor());
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter the name of the member you want to search: ");
                    String searchName = System.console().readLine();
                    List<Member> searchResultsMembersS = library.searchMembers(searchName);
                    if (searchResultsMembersS.size() == 0) {
                        System.out.println("No members found with the name: " + searchName);
                    } else {
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultsMembersS.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsMembersS.get(i).getName() + " (" + searchResultsMembersS.get(i).getEmail() + ")");
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter the title of the book you want to check out: ");
                    String checkoutTitle = System.console().readLine();
                    List<Book> searchResultsBooksC = library.searchBooks(checkoutTitle);
                    if (searchResultsBooksC.size() == 0) {
                        System.out.println("No books found with the title: " + checkoutTitle);
                    } else {
                        System.out.println("Select the book you want to check out:");
                        for (int i = 0; i < searchResultsBooksC.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsBooksC.get(i).getTitle() + " by " + searchResultsBooksC.get(i).getAuthor());
                        }
                        int bookIndexC = Integer.parseInt(System.console().readLine());
                        Book bookToCheckOut = searchResultsBooksC.get(bookIndexC - 1);
                        System.out.print("Enter the name of the member: ");
                        String memberNameC = System.console().readLine();
                        Member memberToCheckOut = new Member(memberNameC, "");
                        library.lendBook(bookToCheckOut, memberToCheckOut);
                        System.out.println("Book checked out successfully!");
                    }
                    break;

                case 8:
                    System.out.print("Enter the title of the book you want to check in: ");
                    String checkinTitle = System.console().readLine();
                    List<Book> searchResultsBooksI = library.searchBooks(checkinTitle);
                    if (searchResultsBooksI.size() == 0) {
                        System.out.println("No books found with the title: " + checkinTitle);
                    } else {
                        System.out.println("Select the book you want to check in:");
                        for (int i = 0; i < searchResultsBooksI.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsBooksI.get(i).getTitle() + " by " + searchResultsBooksI.get(i).getAuthor());
                        }
                        System.out.print("Enter the index of the book you want to check in: ");
                        int bookIndexI = Integer.parseInt(System.console().readLine());
                        Book bookToCheckIn = searchResultsBooksI.get(bookIndexI - 1);
                        
                        Member memberToCheckIn = new Member("", ""); // Initialize memberToCheckIn with a valid value
                        library.returnBook(bookToCheckIn, memberToCheckIn);
                        System.out.println("Book checked in successfully!");
                    }
                    break;

                case 9:
                    List<Book> allBooks = library.getBooks();
                    if (allBooks.size() == 0) {
                        System.out.println("No books found in the library.");
                    } else {
                        System.out.println("All books in the library:");
                        for (int i = 0; i < allBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + allBooks.get(i).getTitle() + " by " + allBooks.get(i).getAuthor());
                        }
                    }
                    break;
                
                case 10:
                    List<Member> allMembers = library.getMembers();
                    if (allMembers.size() == 0) {
                        System.out.println("No members found in the library.");
                    } else {
                        System.out.println("All members in the library:");
                        for (int i = 0; i < allMembers.size(); i++) {
                            System.out.println((i + 1) + ". " + allMembers.get(i).getName() + " (" + allMembers.get(i).getEmail() + ")");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using the Library Management System!");
                    System.exit(0);
                
            }
        }
    }
}