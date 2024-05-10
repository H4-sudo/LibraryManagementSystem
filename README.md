# This is a Library Management System

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
- Data Persistence: The program utilises data streams to keep data persistent, ensuring that all new entries are saved to the system using an external file.

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

## New classes added

- Added a class to display notifications to the user regarding overdue books.
- Added a new method in the `Member` class, `Book` class and into the `Library` class for setting fines.
- Fines have been added to penalise members that don't comply with the borrowing agreement.
- The `SystemNotification` class notifies the user using a small Prompt box in the form of a GUI.
- The `Menu` class has been updated to manage notifications, by making them toggleable from on to off.
- Some concurency issues were fixed that weren't picked up during the creation of the Library Management System.
- The system now utilises serialised data streams to ensure that data isn't lost.
- The `FineCalculator` class utilises a simple calculation for calculating fines for members.
- The system has error handling to ensure that incorrect user inputs don't cause any unforseen issues.

## How to run this system

1. **Install Java**: Ensure that you have Java installed on your system. You can check this by running `java -version` in your terminal. If Java is not installed, you can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Download the project**: Download the project from GitHub. You can do this by clicking the `Code` button on the GitHub page and then clicking `Download ZIP`. Extract the ZIP file to a location of your choice.

3. **Open the terminal**: Open your terminal. On Windows, you can do this by searching for `cmd` in the Start menu. On Mac, you can do this by searching for `terminal` in Spotlight. On Linux, you can do this by searching for `terminal` in your application menu.

4. **Navigate to the project directory**: In the terminal, navigate to the root directory of the project. You can do this by using the `cd` command followed by the path to the directory. For example, if you extracted the project to `C:\Users\YourName\Documents\LibraryManagementSystem`, you would type `cd C:\Users\YourName\Documents\LibraryManagementSystem`.

5. **Run the JAR file**: Run the JAR file by typing the following command in the terminal:

```bash
java -jar dist/LibraryManagementSystem.jar
```

## Note

Please take note that the tests folder contains the testing parameters for testing the function of all classes. The `/lib/` folder contains the modules required to run these tests.

## Possible improvements

1. Implementing a better fining system, that scales according to the set due date.
2. Using a better notification system.
3. Making use of a GUI(The project outlined it should be a console application, however I will be creating a new branch focussing solely on creating a GUI implementation).
4. The use of more threads to make the program run at full potential.
