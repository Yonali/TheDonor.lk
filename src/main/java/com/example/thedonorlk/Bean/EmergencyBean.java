package com.example.thedonorlk.Bean;

public class EmergencyBean {
    protected int id;
    protected String blood_group;
    protected String date;
    protected String time;
    protected String status;
    protected String bloodbank_code;

    public EmergencyBean() {}

    public EmergencyBean(int id, String blood_group, String date, String time, String status, String bloodbank_code) {
        this.id = id;
        this.blood_group = blood_group;
        this.date = date;
        this.time = time;
        this.status = status;
        this.bloodbank_code = bloodbank_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBloodbank_code() {
        return bloodbank_code;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }
}
