import java.util.List;
import java.util.Scanner;

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
        // Create a new Library object
        Library library = new Library();
        
        Scanner scanner = new Scanner(System.in);
        String enter;

        // Add some initial books and members to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "9780679783268"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));
        library.addMember(new Member("Jake Blake", "jake@email.co"));
        library.addMember(new Member("Emma Smith", "esmith@icould.co"));
        library.addMember(new Member("John Doe", "jdoe@mymail.co"));
        library.addMember(new Member("Jane Doe", "janed@themail.co"));
        while (true) {
            RefreshScreen.refresh();
            // This is the main menu of the Library Management System
            System.out.println("==========================================================");
            System.out.println("    ____        _     __   ____              __       ");
            System.out.println("   / __ \\____ _(_)___/ /  / __ )____  ____  / /_______");
            System.out.println("  / /_/ / __ `/ / __  /  / __  / __ \\/ __ \\/ //_/ ___/");
            System.out.println(" / _, _/ /_/ / / /_/ /  / /_/ / /_/ / /_/ / ,< (__  ) ");
            System.out.println("/_/ |_|\\__,_/_/\\__,_/  /_____/\\____/\\____/_/|_/____/  ");
            System.out.println("                                                      ");
            System.out.println("==========================================================");
            System.out.println("Welcome to the Library Management System! How can we help you today?");
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
            String choice = scanner.nextLine();
            RefreshScreen.refresh();
            switch (choice) {
                case "1":
                    // This is the switch case for adding extra books to the library
                    System.out.println("==========================================================");
                    System.out.println("Add a Book");
                    System.out.println("==========================================================");
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    if (title.isEmpty()) {
                        System.out.println("Title cannot be empty.");
                        break;
                    }
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    if (author.isEmpty()) {
                        System.out.println("Author cannot be empty.");
                        break;
                    }
                    System.out.print("Enter the ISBN of the book: ");
                    String ISBN = scanner.nextLine();
                    if (ISBN.isEmpty()) {
                        System.out.println("ISBN cannot be empty.");
                        break;
                    }
                    Book book = new Book(title, author, ISBN);
                    library.addBook(book);
                    book.setAvailable(true);
                    System.out.println("Book added successfully!\n");
                    System.out.println("==========================================================");
                    System.out.println("Press Enter to continue...");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }

                case "2":
                    // This is the switch case for removing books from the library
                    System.out.println("==========================================================");
                    System.out.println("Remove a Book");
                    System.out.println("==========================================================");
                    System.out.print("Enter the title of the book you want to remove: ");
                    String bookTitle = scanner.nextLine();
                    List<Book> searchResults = library.searchBooks(bookTitle);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found with the title: " + bookTitle);
                    } else {
                        System.out.println("Select the book you want to remove: ");
                        for (int i = 0; i < searchResults.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResults.get(i).getTitle() + " by " + searchResults.get(i).getAuthor());
                        }
                        try {
                            int bookIndex = Integer.parseInt(scanner.next());
                            library.removeBook(searchResults.get(bookIndex - 1));
                            System.out.println("Book removed successfully!");
                            System.out.println("==========================================================");
                            System.out.println("Press Enter to continue...");
                            enter = scanner.nextLine();
                            if (enter.isEmpty()) {
                                break;
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                    break;

                case "3":
                    // This is the switch case for adding extra members to the library
                    System.out.println("==========================================================");
                    System.out.println("Add a Member");
                    System.out.println("==========================================================");
                    System.out.print("Enter the name of the member: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the email of the member: ");
                    String email = scanner.nextLine();
                    Member member = new Member(name, email);
                    if (library.getMembers().contains(member)) {
                        System.out.println("Member already exists in the system.");
                        break;
                    }
                    if (!member.isValidEmail(email)){
                        System.out.println("Invalid email format, please try again.");
                        break;
                    }
                    library.addMember(member);
                    System.out.println("Member added successfully!\n");
                    System.out.println("==========================================================");
                    System.out.println("Press Enter to continue...");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }

                case "4":
                    // This is the switch case for removing members from the library
                    System.out.println("==========================================================");
                    System.out.println("Remove a Member");
                    System.out.println("==========================================================");
                    System.out.print("Enter the name of the member you want to remove: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Searching for member '" + memberName + "' in the system.");
                    List<Member> searchResultsMembers = library.searchMembers(memberName);
                    if (searchResultsMembers.isEmpty()) {
                        System.out.println("No members found with the name: " + memberName);
                    } else {
                        System.out.println("Select the member you want to remove:");
                        for (int i = 0; i < searchResultsMembers.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsMembers.get(i).getName() + " (" + searchResultsMembers.get(i).getEmail() + ")");
                        }
                        try {
                            int memberIndex = Integer.parseInt(scanner.next());
                            library.removeMember(searchResultsMembers.get(memberIndex - 1));
                            System.out.println("Member removed successfully!");
                            System.out.println("==========================================================");
                            System.out.println("Press Enter to continue...");
                            enter = scanner.nextLine();
                            if (enter.isEmpty()) {
                                break;
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                    break;

                case "5":
                    // This is the switch case for searching for books in the library
                    System.out.println("==========================================================");
                    System.out.println("Search for Books");
                    System.out.println("==========================================================");
                    System.out.print("Enter the title of the book you want to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> searchResultsBooks = library.searchBooks(searchTitle);
                    if (searchResultsBooks.isEmpty()) {
                        System.out.println("No books found with the title: " + searchTitle);
                        System.out.println("==========================================================");
                    } else {
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultsBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsBooks.get(i).getTitle() + " by " + searchResultsBooks.get(i).getAuthor());
                            System.out.println("\n==========================================================");
                        }
                    }
                    System.out.println("Press Enter to continue...");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }

                case "6":
                    // This is the switch case for searching for members in the library
                    System.out.println("==========================================================");
                    System.out.println("Search for Members");
                    System.out.println("==========================================================");
                    System.out.print("Enter the name of the member you want to search: ");
                    String searchName = scanner.nextLine();
                    List<Member> searchResultsMembersS = library.searchMembers(searchName);
                    if (searchResultsMembersS.isEmpty()) {
                        System.out.println("No members found with the name: " + searchName);
                    } else {
                        System.out.println("Search results:");
                        for (int i = 0; i < searchResultsMembersS.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsMembersS.get(i).getName() + " (" + searchResultsMembersS.get(i).getEmail() + ")\n");
                            System.out.println("==========================================================");
                        }
                        System.out.println("Press Enter to continue...");
                        enter = scanner.nextLine();
                        if (enter.isEmpty()) {
                            break;
                        } else {
                            break;
                        }
                    }

                case "7":
                    // This is the switch case for checking out books from the library
                    System.out.println("==========================================================");
                    System.out.println("Check out a Book");
                    System.out.println("==========================================================");
                    System.out.print("Enter the title of the book you want to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    List<Book> searchResultsBooksC = library.searchBooks(checkoutTitle);
                    if (searchResultsBooksC.isEmpty()) {
                        System.out.println("No books found with the title: " + checkoutTitle);
                    } else {
                        System.out.println("Select the book you want to check out:");
                        for (int i = 0; i < searchResultsBooksC.size(); i++) {
                            System.out.println((i + 1) + ". " + searchResultsBooksC.get(i).getTitle() + " by " + searchResultsBooksC.get(i).getAuthor());
                        }
                        try {
                            System.out.print("Enter the index of the book you want to check out: ");
                            int bookIndexC = Integer.parseInt(scanner.nextLine());
                            Book bookToCheckOut = searchResultsBooksC.get(bookIndexC - 1);
                            System.out.print("Enter the name of the member: ");
                            String memberNameC = scanner.nextLine();
                            List<Member> searchResultsMembersC = library.searchMembers(memberNameC);
                            if (searchResultsMembersC.isEmpty()) {
                                System.out.println("No members found with the name: " + memberNameC);
                            } else {
                                System.out.println("Select the member you want to check out the book:");
                                for (int i = 0; i < searchResultsMembersC.size(); i++) {
                                    System.out.println((i + 1) + ". " + searchResultsMembersC.get(i).getName() + " (" + searchResultsMembersC.get(i).getEmail() + ")");
                                }
                            }
                            System.out.print("Enter the index of the member you want to check out the book: ");
                            int memberIndexC = Integer.parseInt(scanner.nextLine());
                            Member memberToCheckOut = searchResultsMembersC.get(memberIndexC - 1);
                            library.lendBook(bookToCheckOut, memberToCheckOut);
                            library.getBooksCheckedOut().add(bookToCheckOut);
                            Book bookToCheckOutN = searchResultsBooksC.get(bookIndexC - 1);
                            bookToCheckOutN.setAvailable(false);
                            if (!bookToCheckOutN.isAvailable()) {
                                System.out.println("==========================================================");
                                System.out.println("Book is not available.");
                                System.out.println("==========================================================");
                                System.out.println("Press Enter to continue...");
                                enter = scanner.nextLine();
                                if (enter.isEmpty()) {
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                System.out.println("==========================================================");
                                System.out.println("Book checked out successfully!");
                                System.out.println("==========================================================");
                                System.out.println("Press Enter to continue...");
                                enter = scanner.nextLine();
                                if (enter.isEmpty()) {
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }

                case "8":
                    // This is the switch case for checking in books to the library
                    System.out.println("==========================================================");
                    System.out.println("Check in a Book");
                    System.out.println("==========================================================");
                    System.out.print("Enter the title of the book you want to check in: ");
                    String checkInTitle = scanner.nextLine();
                    List<Book> searchResultsBooksI = library.searchBooks(checkInTitle);
                    if (searchResultsBooksI.isEmpty()) {
                        System.out.println("No books found with the title: " + checkInTitle);
                    } else {
                        System.out.println("Select the book you want to check in:");
                        for (int i = 0; i < searchResultsBooksI.size(); i++) {
                            Book bookCI = searchResultsBooksI.get(i);
                            if (!bookCI.isAvailable()) {
                                System.out.println((i + 1) + ". " + searchResultsBooksI.get(i).getTitle() + " by " + searchResultsBooksI.get(i).getAuthor());
                            }
                        }
                        try {
                            System.out.print("Enter the index of the book you want to check in: ");
                            int bookIndexI = Integer.parseInt(scanner.nextLine());
                            Book bookToCheckIn = searchResultsBooksI.get(bookIndexI - 1);
                            System.out.print("Enter the name of the member: ");
                            String memberNameI = scanner.nextLine();
                            List<Member> searchResultsMembersI = library.searchMembers(memberNameI);
                            if (searchResultsMembersI.isEmpty()) {
                                System.out.println("No members found with the name: " + memberNameI);
                            } else {
                                System.out.println("Select the member you want to check in the book:");
                                for (int i = 0; i < searchResultsMembersI.size(); i++) {
                                    System.out.println((i + 1) + ". " + searchResultsMembersI.get(i).getName() + " (" + searchResultsMembersI.get(i).getEmail() + ")");
                                }
                            }
                            System.out.println("Enter the index of the member you want to check in the book: ");
                            int memberIndexI = Integer.parseInt(scanner.next());
                            Member memberToCheckIn = searchResultsMembersI.get(memberIndexI - 1);
                            library.returnBook(bookToCheckIn, memberToCheckIn);
                            Book bookToCheckInRemove = searchResultsBooksI.get(bookIndexI - 1);
                            if (bookToCheckInRemove.isAvailable()) {
                                System.out.println("==========================================================");
                                System.out.println("Book is already available.");
                            } else {
                                bookToCheckInRemove.setAvailable(true);
                                System.out.println("==========================================================");
                                System.out.println("Book checked in successfully!");

                            }
                            System.out.println("==========================================================");
                            System.out.println("Press Enter to continue...");
                            enter = scanner.nextLine();
                            if (enter.isEmpty()) {
                                break;
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                    break;

                case "9":
                    // This is the switch case for viewing all books in the library
                    System.out.println("==========================================================");
                    System.out.println("All Books");
                    System.out.println("==========================================================");
                    List<Book> allBooks = library.getBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("==========================================================");
                        System.out.println("No books found in the library.");
                        System.out.println("==========================================================");
                    } else {
                        System.out.println("==========================================================");
                        System.out.println("All books in the library:");
                        System.out.println("==========================================================");
                        for (int i = 0; i < allBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + allBooks.get(i).getTitle() + " by " + allBooks.get(i).getAuthor() + " (ISBN: " + allBooks.get(i).getISBN() + ") (Available: " + allBooks.get(i).isAvailable() + ")");
                        }
                    }
                    System.out.println("==========================================================");
                    System.out.println("Press Enter to continue...");
                    System.out.println("==========================================================");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }
                
                case "10":
                    // This is the switch case for viewing all members in the library
                    System.out.println("==========================================================");
                    System.out.println("All Members");
                    System.out.println("==========================================================");
                    List<Member> allMembers = library.getMembers();
                    if (allMembers.isEmpty()) {
                        System.out.println("==========================================================");
                        System.out.println("No members found in the library.");
                        System.out.println("==========================================================");
                    } else {
                        System.out.println("==========================================================");
                        System.out.println("All members in the library:");
                        System.out.println("==========================================================");
                        for (int i = 0; i < allMembers.size(); i++) {
                            System.out.println((i + 1) + ". " + allMembers.get(i).getName() + " (" + allMembers.get(i).getEmail() + ")");
                        }
                    }
                    System.out.println("==========================================================");
                    System.out.println("Press Enter to continue...");
                    System.out.println("==========================================================");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }

                case "11":
                    // This is the switch case for viewing all books checked out in the library
                    System.out.println("==========================================================");
                    System.out.println("All Books Checked Out");
                    System.out.println("==========================================================");
                    List<Book> allBooksCheckedOut = library.getBooksCheckedOut();
                    if (allBooksCheckedOut == null || allBooksCheckedOut.isEmpty()) {
                        System.out.println("==========================================================");
                        System.out.println("No books checked out in the library.");
                        System.out.println("==========================================================");
                    } else {
                        System.out.println("==========================================================");
                        System.out.println("All books checked out in the library:");
                        System.out.println("==========================================================");
                        for (int i = 0; i < allBooksCheckedOut.size(); i++) {
                            System.out.println((i + 1) + ". " + allBooksCheckedOut.get(i).getTitle() + " by " + allBooksCheckedOut.get(i).getAuthor());
                        }
                    }
                    System.out.println("==========================================================");
                    System.out.println("Press Enter to continue...");
                    System.out.println("==========================================================");
                    enter = scanner.nextLine();
                    if (enter.isEmpty()) {
                        break;
                    } else {
                        break;
                    }

                case "0":
                    // This is the switch case for exiting the application
                    scanner.close();
                    System.out.println("==========================================================");
                    System.out.println("Thank you for using the Library Management System!");
                    System.out.println("==========================================================");
                    System.exit(0);
                
            }
        }
    }
}