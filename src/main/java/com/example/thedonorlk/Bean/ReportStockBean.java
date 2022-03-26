package com.example.thedonorlk.Bean;

import java.util.List;

public class ReportStockBean {
    private List<Integer> beginning;
    private List<Integer> campaigns;
    private List<Integer> appointments;
    private List<Integer> transfuse;
    private List<Integer> transfered;
    private List<Integer> remaining;

    public ReportStockBean() {
    }

    public ReportStockBean(List<Integer> beginning, List<Integer> campaigns, List<Integer> appointments, List<Integer> transfuse, List<Integer> transfered, List<Integer> remaining) {
        this.beginning = beginning;
        this.campaigns = campaigns;
        this.appointments = appointments;
        this.transfuse = transfuse;
        this.transfered = transfered;
        this.remaining = remaining;
    }

    public List<Integer> getBeginning() {
        return beginning;
    }

    public void setBeginning(List<Integer> beginning) {
        this.beginning = beginning;
    }

    public List<Integer> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Integer> campaigns) {
        this.campaigns = campaigns;
    }

    public List<Integer> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Integer> appointments) {
        this.appointments = appointments;
    }

    public List<Integer> getTransfuse() {
        return transfuse;
    }

    public void setTransfuse(List<Integer> transfuse) {
        this.transfuse = transfuse;
    }

    public List<Integer> getTransfered() {
        return transfered;
    }

    public void setTransfered(List<Integer> transfered) {
        this.transfered = transfered;
    }

    public List<Integer> getRemaining() {
        return remaining;
    }

    public void setRemaining(List<Integer> remaining) {
        this.remaining = remaining;
    }
}
