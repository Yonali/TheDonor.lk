package com.example.thedonorlk.Bean;

public class NotificationBean {
    protected int id;
    protected int notifyee_id;
    protected int notifier_id;
    protected String type;
    protected String message;
    protected String datetime;
    protected String status;

    public NotificationBean() {}

    public NotificationBean(int id, int notifyee_id, int notifier_id, String type, String message, String datetime, String status) {
        this.id = id;
        this.notifyee_id = notifyee_id;
        this.notifier_id = notifier_id;
        this.type = type;
        this.message = message;
        this.datetime = datetime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNotifyee_id() {
        return notifyee_id;
    }

    public void setNotifyee_id(int notifyee_id) {
        this.notifyee_id = notifyee_id;
    }

    public int getNotifier_id() {
        return notifier_id;
    }

    public void setNotifier_id(int notifier_id) {
        this.notifier_id = notifier_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
