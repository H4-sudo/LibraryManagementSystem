package com.raidwave.librarymanagementsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {
    private static final double FINE_AMOUNT = 2.50;
    private static final int GRACE_PERIOD = 3;
    private static final int CHARGING_INTERVAL = 5;

    public double calculateFines(LocalDate dueDate, LocalDate returnDate) {
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);

        if (daysOverdue <= GRACE_PERIOD) {
            return 0.0;
        }

        return FINE_AMOUNT * Math.ceil((double)(daysOverdue - GRACE_PERIOD) / CHARGING_INTERVAL);
    }
    
}
