class App {
    public static void main(String[] args) {
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
            System.out.println("7. Exit");
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
                    System.out.print("Searching for member {0} in database.", memberName);
        }
    }
}