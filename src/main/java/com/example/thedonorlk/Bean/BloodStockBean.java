package com.example.thedonorlk.Bean;

public class BloodStockBean {
    protected int id;
    protected String blood_barcode;
    protected String blood_product;
    protected String blood_group;
    protected String bloodbank_code;
    protected String status;
    protected String collected_date;
    protected String processed_date;
    protected String expiry_date;

    public BloodStockBean() {}

    public BloodStockBean(int id, String blood_barcode, String blood_product, String blood_group, String bloodbank_code, String status, String collected_date, String processed_date, String expiry_date) {
        this.id = id;
        this.blood_barcode = blood_barcode;
        this.blood_product = blood_product;
        this.blood_group = blood_group;
        this.bloodbank_code = bloodbank_code;
        this.status = status;
        this.collected_date = collected_date;
        this.processed_date = processed_date;
        this.expiry_date = expiry_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlood_barcode() {
        return blood_barcode;
    }

    public void setBlood_barcode(String blood_barcode) {
        this.blood_barcode = blood_barcode;
    }

    public String getBlood_product() {
        return blood_product;
    }

    public void setBlood_product(String blood_product) {
        this.blood_product = blood_product;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getBloodbank_code() {
        return bloodbank_code;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollected_date() {
        return collected_date;
    }

    public void setCollected_date(String collected_date) {
        this.collected_date = collected_date;
    }

    public String getProcessed_date() {
        return processed_date;
    }

    public void setProcessed_date(String processed_date) {
        this.processed_date = processed_date;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
