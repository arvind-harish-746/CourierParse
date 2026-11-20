package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Records one status change with its time
public class StatusLog {
    private final ParcelStatus status;
    private final LocalDateTime timestamp;

    public StatusLog(ParcelStatus status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return status + " at " + timestamp.format(formatter);
    }
}
