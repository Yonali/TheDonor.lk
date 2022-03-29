package com.example.thedonorlk.Bean;

public class AppointmentBean {
    protected int id;
    protected String name;
    protected String bloodbank_code;
    protected String appointment_time;
    protected String appointment_date;
    protected String donor_id;
    protected String status;

    public AppointmentBean() {
    }

    public AppointmentBean(int id, String name, String bloodbank_code, String appointment_time, String appointment_date, String donor_id, String status) {
        this.id = id;
        this.name = name;
        this.bloodbank_code = bloodbank_code;
        this.appointment_time = appointment_time;
        this.appointment_date = appointment_date;
        this.donor_id = donor_id;
        this.status = status;
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
}
