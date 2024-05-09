package com.raidwave.librarymanagementsystem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class SystemNotification {
    static Library library = App.loadLibrary();
    static Timer timer = new Timer();

    public static void displayTray(String title, String message) throws AWTException {
        // Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        // Create a simple, blank image to use as an icon
        BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();

        // Fill the image with color
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, 16, 16);

        TrayIcon trayIcon = new TrayIcon(image, "Library Management System");
        // Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        // Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);

        // Dispose the graphics object to free up resources
        graphics.dispose();
    }

    public static void enableNotifications() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkOverdueBooks();
                try {
                    displayTray("Library Management System", "You have overdue books!");
                } catch (AWTException e) {
                    System.out.println("System tray not supported!");
                }
            }
        }, 0, 60 * 1000); // Run every 5 seconds
    }

    private static void checkOverdueBooks() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Iterate through the books in the library
        for (Book book : library.getBooks()) {
            // Check if the book is overdue
            if (currentDate.isAfter(book.getDueDate())) {
                // Book is overdue, take appropriate action
                // For example, you can send a notification or mark the book as overdue in the system
                book.setOverdue(true);
            }
        }
    }

    public static void disableNotifications() {
        // Stop the timer to check for overdue books
        // This will stop the notifications from being displayed
        timer.cancel();
    }
}