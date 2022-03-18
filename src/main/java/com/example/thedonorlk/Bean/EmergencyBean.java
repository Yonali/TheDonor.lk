package com.example.thedonorlk.Bean;

public class EmergencyBean {
    protected int id;
    protected String blood_group;
    protected int req_amount;
    protected String date;
    protected String time;
    protected String status;
    protected String bloodbank_code;

    public EmergencyBean() {}

    public EmergencyBean(int id, String blood_group, int req_amount, String date, String time, String status, String bloodbank_code) {
        this.id = id;
        this.blood_group = blood_group;
        this.req_amount = req_amount;
        this.date = date;
        this.time = time;
        this.status = status;
        this.bloodbank_code = bloodbank_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public void setReq_amount(int req_amount) {
        this.req_amount = req_amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }

    public int getId() {
        return id;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public int getReq_amount() {
        return req_amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getBloodbank_code() {
        return bloodbank_code;
    }
}
