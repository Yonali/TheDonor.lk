package com.example.thedonorlk.Bean;

public class DeferralHistoryBean {
    private int donation_id;
    private String donor_id;
    private String doc_id;
    private String deferral_remark;
    private String start_date;
    private String end_date;
    private String type;
    private String doc_name;

    public DeferralHistoryBean() {
    }

    public DeferralHistoryBean(int donation_id, String donor_id, String doc_id, String deferral_remark, String start_date, String end_date, String type, String doc_name) {
        this.donation_id = donation_id;
        this.donor_id = donor_id;
        this.doc_id = doc_id;
        this.deferral_remark = deferral_remark;
        this.start_date = start_date;
        this.end_date = end_date;
        this.type = type;
        this.doc_name = doc_name;
    }

    public int getDonation_id() {
        return donation_id;
    }

    public void setDonation_id(int donation_id) {
        this.donation_id = donation_id;
    }

    public String getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getDeferral_remark() {
        return deferral_remark;
    }

    public void setDeferral_remark(String deferral_remark) {
        this.deferral_remark = deferral_remark;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }
}
