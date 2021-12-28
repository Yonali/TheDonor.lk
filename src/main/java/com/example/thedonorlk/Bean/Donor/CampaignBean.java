package com.example.thedonorlk.Bean.Donor;

public class CampaignBean {
    protected int id;
    protected String name;
    protected String date;
    protected String start_time;
    protected String end_time;
    protected String address_number;
    protected String address_street;
    protected String address_city;
    protected String bloodbank_code;
    protected String bloodbank_name;
    protected String bloodbank_contact;
    protected String bloodbank_address_street;
    protected String bloodbank_address_city;
    protected String bloodbank_email;

    public CampaignBean() {}

    public CampaignBean(int id, String name, String date, String start_time, String end_time, String address_number, String address_street, String address_city, String bloodbank_code, String bloodbank_name, String bloodbank_contact, String bloodbank_address_street, String bloodbank_address_city, String bloodbank_email) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.address_number = address_number;
        this.address_street = address_street;
        this.address_city = address_city;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
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
