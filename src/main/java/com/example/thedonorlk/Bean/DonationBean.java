package com.example.thedonorlk.Bean;

public class DonationBean {
    private int id;
    private String status;
    private String date;
    private String time;
    private String bloodbank_code;
    private String nurse_id;
    private String doctor_id;
    private String donor_id;
    private String blood_id;
    private String campaign_id;
    private String appointment_id;
    private String donor_name;
    private String donor_nic;

    public DonationBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBloodbank_code() {
        return bloodbank_code;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }

    public String getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(String nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }

    public String getBlood_id() {
        return blood_id;
    }

    public void setBlood_id(String blood_id) {
        this.blood_id = blood_id;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public String getDonor_nic() {
        return donor_nic;
    }

    public void setDonor_nic(String donor_nic) {
        this.donor_nic = donor_nic;
    }

    public DonationBean(int id, String status, String date, String time, String bloodbank_code, String nurse_id, String doctor_id, String donor_id, String blood_id, String campaign_id, String appointment_id, String donor_name, String donor_nic) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.time = time;
        this.bloodbank_code = bloodbank_code;
        this.nurse_id = nurse_id;
        this.doctor_id = doctor_id;
        this.donor_id = donor_id;
        this.blood_id = blood_id;
        this.campaign_id = campaign_id;
        this.appointment_id = appointment_id;
        this.donor_name = donor_name;
        this.donor_nic = donor_nic;
    }
}
