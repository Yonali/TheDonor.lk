package com.example.thedonorlk.Bean;

import java.util.List;

public class DashboardBean {
    private List<Integer> rbc;
    private List<Integer> wbc;
    private List<Integer> platelets;
    private List<Integer> plasma;
    private int total_donors;
    private int new_donors;
    private int campaigns;
    private int appointment;
    private int donation;

    public DashboardBean() {
    }

    public DashboardBean(List<Integer> rbc, List<Integer> wbc, List<Integer> platelets, List<Integer> plasma, int total_donors, int new_donors, int campaigns, int appointment, int donation) {
        this.rbc = rbc;
        this.wbc = wbc;
        this.platelets = platelets;
        this.plasma = plasma;
        this.total_donors = total_donors;
        this.new_donors = new_donors;
        this.campaigns = campaigns;
        this.appointment = appointment;
        this.donation = donation;
    }

    public List<Integer> getRbc() {
        return rbc;
    }

    public void setRbc(List<Integer> rbc) {
        this.rbc = rbc;
    }

    public List<Integer> getWbc() {
        return wbc;
    }

    public void setWbc(List<Integer> wbc) {
        this.wbc = wbc;
    }

    public List<Integer> getPlatelets() {
        return platelets;
    }

    public void setPlatelets(List<Integer> platelets) {
        this.platelets = platelets;
    }

    public List<Integer> getPlasma() {
        return plasma;
    }

    public void setPlasma(List<Integer> plasma) {
        this.plasma = plasma;
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
