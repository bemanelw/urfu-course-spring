package org.example.orderstatusserver.models;

import java.time.LocalDateTime;

public class OrderStatusEvent {
    private String status;
    private LocalDateTime date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
