package com.example.thedonorlk.Bean;

public class DashboardBean {
    private int a_pos;
    private int a_neg;
    private int b_pos;
    private int b_neg;
    private int ab_pos;
    private int ab_neg;
    private int o_pos;
    private int o_neg;
    private int total_donors;
    private int new_donors;
    private int campaigns;
    private int appointment;
    private int donation;

    public DashboardBean() {
    }

    public DashboardBean(int a_pos, int a_neg, int b_pos, int b_neg, int ab_pos, int ab_neg, int o_pos, int o_neg, int total_donors, int new_donors, int campaigns, int appointment, int donation) {
        this.a_pos = a_pos;
        this.a_neg = a_neg;
        this.b_pos = b_pos;
        this.b_neg = b_neg;
        this.ab_pos = ab_pos;
        this.ab_neg = ab_neg;
        this.o_pos = o_pos;
        this.o_neg = o_neg;
        this.total_donors = total_donors;
        this.new_donors = new_donors;
        this.campaigns = campaigns;
        this.appointment = appointment;
        this.donation = donation;
    }

    public int getA_pos() {
        return a_pos;
    }

    public void setA_pos(int a_pos) {
        this.a_pos = a_pos;
    }

    public int getA_neg() {
        return a_neg;
    }

    public void setA_neg(int a_neg) {
        this.a_neg = a_neg;
    }

    public int getB_pos() {
        return b_pos;
    }

    public void setB_pos(int b_pos) {
        this.b_pos = b_pos;
    }

    public int getB_neg() {
        return b_neg;
    }

    public void setB_neg(int b_neg) {
        this.b_neg = b_neg;
    }

    public int getAb_pos() {
        return ab_pos;
    }

    public void setAb_pos(int ab_pos) {
        this.ab_pos = ab_pos;
    }

    public int getAb_neg() {
        return ab_neg;
    }

    public void setAb_neg(int ab_neg) {
        this.ab_neg = ab_neg;
    }

    public int getO_pos() {
        return o_pos;
    }

    public void setO_pos(int o_pos) {
        this.o_pos = o_pos;
    }

    public int getO_neg() {
        return o_neg;
    }

    public void setO_neg(int o_neg) {
        this.o_neg = o_neg;
    }

    public int getTotal_donors() {
        return total_donors;
    }

    public void setTotal_donors(int total_donors) {
        this.total_donors = total_donors;
    }

    public int getNew_donors() {
        return new_donors;
    }

    public void setNew_donors(int new_donors) {
        this.new_donors = new_donors;
    }

    public int getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(int campaigns) {
        this.campaigns = campaigns;
    }

    public int getAppointment() {
        return appointment;
    }

    public void setAppointment(int appointment) {
        this.appointment = appointment;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }
}
