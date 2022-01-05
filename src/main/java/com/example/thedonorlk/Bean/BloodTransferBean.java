package com.example.thedonorlk.Bean;

public class BloodTransferBean {
    protected int id;
    protected String blood_barcode;
    protected String from_bloodbank_code;
    protected String to_bloodbank_code;
    protected String blood_group;
    protected String blood_product;
    protected String transfer_date;
    protected String transfer_time;

    public BloodTransferBean() {}

    public BloodTransferBean(int id, String blood_barcode, String from_bloodbank_code, String to_bloodbank_code, String blood_group, String blood_product, String transfer_date, String transfer_time) {
        this.id = id;
        this.blood_barcode = blood_barcode;
        this.from_bloodbank_code = from_bloodbank_code;
        this.to_bloodbank_code = to_bloodbank_code;
        this.blood_group = blood_group;
        this.blood_product = blood_product;
        this.transfer_date = transfer_date;
        this.transfer_time = transfer_time;
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

    public String getFrom_bloodbank_code() {
        return from_bloodbank_code;
    }

    public void setFrom_bloodbank_code(String from_bloodbank_code) {
        this.from_bloodbank_code = from_bloodbank_code;
    }

    public String getTo_bloodbank_code() {
        return to_bloodbank_code;
    }

    public void setTo_bloodbank_code(String to_bloodbank_code) {
        this.to_bloodbank_code = to_bloodbank_code;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getBlood_product() {
        return blood_product;
    }

    public void setBlood_product(String blood_product) {
        this.blood_product = blood_product;
    }

    public String getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
    }

    public String getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(String transfer_time) {
        this.transfer_time = transfer_time;
    }
}
