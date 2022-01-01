package com.example.thedonorlk.Bean.Donor;

public class AppointmentBean {
    protected int id;
    protected String bloodbank_code;
    protected String appointment_time;
    protected String appointment_date;
    protected String donor_id;
    protected String status;
    protected String bloodbank_name;
    protected String bloodbank_contact;
    protected String bloodbank_address_street;
    protected String bloodbank_address_city;
    protected String bloodbank_email;

    public AppointmentBean() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloodbank_code() {
        return bloodbank_code;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public AppointmentBean(int id, String bloodbank_code, String appointment_time, String appointment_date, String donor_id, String status, String bloodbank_name, String bloodbank_contact, String bloodbank_address_street, String bloodbank_address_city, String bloodbank_email) {
        this.id = id;
        this.bloodbank_code = bloodbank_code;
        this.appointment_time = appointment_time;
        this.appointment_date = appointment_date;
        this.donor_id = donor_id;
        this.status = status;
        this.bloodbank_name = bloodbank_name;
        this.bloodbank_contact = bloodbank_contact;
        this.bloodbank_address_street = bloodbank_address_street;
        this.bloodbank_address_city = bloodbank_address_city;
        this.bloodbank_email = bloodbank_email;
    }
}
