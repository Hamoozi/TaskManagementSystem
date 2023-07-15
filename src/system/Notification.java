package system;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Notification {
    private String message;
    private LocalDate timestamp;
    private Task associatedTask;

    public Notification(String message, LocalDate timestamp, Task associatedTask) {
        this.message = message;
        this.timestamp = timestamp;
        this.associatedTask = associatedTask;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Task getAssociatedTask() {
        return associatedTask;
    }

    public void setAssociatedTask(Task associatedTask) {
        this.associatedTask = associatedTask;
    }
}
