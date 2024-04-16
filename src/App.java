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
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "9780679783268"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));
        library.addMember(new Member("Jake Blake", "jake@email.co"));
        library.addMember(new Member("Emma Smith", "esmith@icould.co"));
        library.addMember(new Member("John Doe", "jdoe@mymail.co"));
        library.addMember(new Member("Jane Doe", "janed@themail.co"));
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
            System.out.println("11. View all books checked out");
            System.out.println("0. Exit");
            System.out.println("==========================================================");
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
                    System.out.println("Book added successfully!\n");
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to remove: ");
                    String bookTitle = System.console().readLine();
                    List<Book> searchResults = library.searchBooks(bookTitle);
                    if (searchResults.size() == 0) {
                        System.out.println("No books found with the title: " + bookTitle);
                    } else {
                        System.out.println("Select the book you want to remove: ");
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
                    System.out.println("Member added successfully!\n");
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
                        System.out.print("Enter the index of the book you want to check out: ");
                        int bookIndexC = Integer.parseInt(System.console().readLine());
                        Book bookToCheckOut = searchResultsBooksC.get(bookIndexC - 1);
                        System.out.print("Enter the name of the member: ");
                        String memberNameC = System.console().readLine();
                        List<Member> searchResultsMembersC = library.searchMembers(memberNameC);
                        if (searchResultsMembersC.size() == 0) {
                            System.out.println("No members found with the name: " + memberNameC);
                        } else {
                            System.out.println("Select the member you want to check out the book:");
                            for (int i = 0; i < searchResultsMembersC.size(); i++) {
                                System.out.println((i + 1) + ". " + searchResultsMembersC.get(i).getName() + " (" + searchResultsMembersC.get(i).getEmail() + ")");
                            }
                        }
                        int memberIndexC = Integer.parseInt(System.console().readLine());
                        Member memberToCheckOut = searchResultsMembersC.get(memberIndexC - 1);
                        library.lendBook(bookToCheckOut, memberToCheckOut);
                        library.getBooksCheckedOut().add(bookToCheckOut);
                        Book bookToCheckOutN = searchResultsBooksC.get(bookIndexC - 1);
                        bookToCheckOutN.setAvailable(false);
                        if (bookToCheckOutN.isAvailable() == false) {
                            System.out.println("Book is not available.");
                        } else {
                            System.out.println("Book checked out successfully!");
                        }
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
                        System.out.print("Enter the name of the member: ");
                        String memberNameI = System.console().readLine();
                        List<Member> searchResultsMembersI = library.searchMembers(memberNameI);
                        if (searchResultsMembersI.size() == 0) {
                            System.out.println("No members found with the name: " + memberNameI);
                        } else {
                            System.out.println("Select the member you want to check in the book:");
                            for (int i = 0; i < searchResultsMembersI.size(); i++) {
                                System.out.println((i + 1) + ". " + searchResultsMembersI.get(i).getName() + " (" + searchResultsMembersI.get(i).getEmail() + ")");
                            }
                        }
                        int memberIndexI = Integer.parseInt(System.console().readLine());
                        Member memberToCheckIn = searchResultsMembersI.get(memberIndexI - 1);
                        library.returnBook(bookToCheckIn, memberToCheckIn);
                        Book bookToCheckInRemove = searchResultsBooksI.get(bookIndexI - 1);
                        bookToCheckInRemove.setAvailable(true);
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

                case 11:
                    List<Book> allBooksCheckedOut = library.getBooksCheckedOut();
                    if (allBooksCheckedOut == null || allBooksCheckedOut.size() == 0) {
                        System.out.println("No books checked out in the library.");
                    } else {
                        System.out.println("All books checked out in the library:");
                        for (int i = 0; i < allBooksCheckedOut.size(); i++) {
                            System.out.println((i + 1) + ". " + allBooksCheckedOut.get(i).getTitle() + " by " + allBooksCheckedOut.get(i).getAuthor());
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