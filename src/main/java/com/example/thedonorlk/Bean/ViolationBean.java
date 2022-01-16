package com.example.thedonorlk.Bean;

public class ViolationBean {
    protected int id;
    protected int post_id;
    protected int donor_id;
    protected String date;
    protected String time;
    protected String reason;
    protected String status;

    public ViolationBean() {}

    public ViolationBean(int id, int post_id, int donor_id, String date, String time, String reason, String status) {
        this.id = id;
        this.post_id = post_id;
        this.donor_id = donor_id;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
