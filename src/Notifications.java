import java.util.Timer;
import java.util.TimerTask;

public class Notifications {
    private final Library library = App.loadLibrary();
    // This is the class for displaying notifications to the user
    public void displayFineNotification(String message) {
        System.out.println("FINE NOTIFICATION: " + message);
    }

    public void startFineCheckThread() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Check for fines due here
                // If fines are due, call displayFineNotification method
                FineChecker fineChecker = new FineChecker(library);
                fineChecker.checkOverdueBooks();
                
            }
        };

        // Schedule the task to run every 1 minute (adjust the delay and period as needed)
        timer.schedule(task, 0, 60 * 1000);
    }

    public void stopFineCheckThread() {
        // Stop the fine check thread
        Timer timer = new Timer();
        timer.cancel();
    }

    public void enableNotifications() {
        // Start the fine check thread
        startFineCheckThread();
    }

    public void disableNotifications() {
        // Stop the fine check thread
        stopFineCheckThread();
    }
}
