package com.example.thedonorlk.Bean.Donor;

public class EmergencyBean {
    protected int id;
    protected String blood_group;
    protected String date;
    protected String time;
    protected String status;
    protected String bloodbank_code;
    protected String bloodbank_name;
    protected String bloodbank_contact;
    protected String bloodbank_address_street;
    protected String bloodbank_address_city;
    protected String bloodbank_email;


    public EmergencyBean() {

    }

    public EmergencyBean(int id, String blood_group, String date, String time, String status, String bloodbank_code, String bloodbank_name, String bloodbank_contact, String bloodbank_address_street, String bloodbank_address_city, String bloodbank_email) {
        this.id = id;
        this.blood_group = blood_group;
        this.date = date;
        this.time = time;
        this.status = status;
        this.bloodbank_code = bloodbank_code;
        this.bloodbank_name = bloodbank_name;
        this.bloodbank_contact = bloodbank_contact;
        this.bloodbank_address_street = bloodbank_address_street;
        this.bloodbank_address_city = bloodbank_address_city;
        this.bloodbank_email = bloodbank_email;

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

    public String getBloodbank_name() {
        return bloodbank_name;
    }

    public void setBloodbank_name(String bloodbank_name) {
        this.bloodbank_name = bloodbank_name;
    }

    public String getBloodbank_contact() {
        return bloodbank_contact;
    }

    public void setBloodbank_contact(String bloodbank_contact) {
        this.bloodbank_contact = bloodbank_contact;
    }

    public String getBloodbank_address_street() {
        return bloodbank_address_street;
    }

    public void setBloodbank_address_street(String bloodbank_address_street) {
        this.bloodbank_address_street = bloodbank_address_street;
    }

    public String getBloodbank_address_city() {
        return bloodbank_address_city;
    }

    public void setBloodbank_address_city(String bloodbank_address_city) {
        this.bloodbank_address_city = bloodbank_address_city;
    }

    public String getBloodbank_email() {
        return bloodbank_email;
    }

    public void setBloodbank_email(String bloodbank_email) {
        this.bloodbank_email = bloodbank_email;
    }
}
