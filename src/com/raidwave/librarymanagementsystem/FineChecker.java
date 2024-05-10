package com.raidwave.librarymanagementsystem;

/**
 *
 * @author henrico
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FineChecker implements Runnable {
    private final Library library;

    public FineChecker (Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::checkOverdueBooks, 0, 5, TimeUnit.SECONDS);
    }

    public void checkOverdueBooks() {
        for (Book book : library.getBooks()) {
            if (book.isOverdue()) {
                System.out.println("The book " + book.getTitle() + " is overdue.");
                library.notifyAdmin(book);
            }
        }
    }
}
