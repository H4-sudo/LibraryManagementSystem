# This is my implementation of a library management system

- This project consists of three different classes to handle the library management system.
- The `Library` class handles string manipulation for member searches and book searches.
- The `EmailRegistrar` class ensures that entered email addresses are valid.
- The project also includes predefined books and some members.

## Usage

To use this library management system, follow these steps:

1. Clone the repository: `git clone https://github.com/H4-sudo/FA2Java.git`
2. Open the project in your preferred Java IDE.
3. Compile and run the `Main` class to start the library management system.

## Features

- Member Search: The `Library` class provides methods to search for members by their names or IDs.
- Book Search: The `Library` class provides methods to search for books by their titles or authors.
- Email Validation: The `EmailRegistrar` class validates the format of entered email addresses.

## Reasons for my design choices
- Using separate files make it easy to maintain in the future, therefor a new developer that wants to maintain the project will have an easier time.
- All variable names are clear to understand where it fits in, helping convey a strong structure.
- The `Library` class makes use of the `Member` and `Book` classes to make the library management system functional.
- The `RefreshScreen` class clears all previous output to ensure that the system deals with unnecessary clutter.(Note that IntelliJ has an issue with the `RefreshScreen` class)
- The `Member` class ensures that the user's entered email goes through a simple email register check to ensure that only correctly formatted email addresses are accepted.
- Using String inputs for the switch case made it easier to correctly deal with errors. Within the cases however, I made use of try/catch blocks to ensure that the data gets parsed correctly.
- The main menu has been systematically created to have all add/remove menu options in their own area and all search options are grouped together as well.
- When exiting the program the scanner closes, which ensures no memory leaks.
- Making a separate list for checked out books make it easier for the user to see which books can be checked in.
- Gave the functionality that when checking books out or in, that the user can only type the first few letters or leave it blank entirely to see the full list. Same goes for selecting the member lending the book.

## Note
Please take note that the tests folder contains the testing parameters for testing the function of all classes. The `/lib/` folder contains the modules required to run these tests.