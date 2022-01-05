package com.example.thedonorlk.Bean;

public class BloodRequestBean {
    protected int id;
    protected String from_bloodbank_code;
    protected String to_bloodbank_code;
    protected String blood_group;
    protected String blood_product;
    protected String required_count;
    protected String remark;
    protected String request_date;
    protected String request_time;
    protected String status;

    public BloodRequestBean() {}

    public BloodRequestBean(int id, String from_bloodbank_code, String to_bloodbank_code, String blood_group, String blood_product, String required_count, String remark, String request_date, String request_time, String status) {
        this.id = id;
        this.from_bloodbank_code = from_bloodbank_code;
        this.to_bloodbank_code = to_bloodbank_code;
        this.blood_group = blood_group;
        this.blood_product = blood_product;
        this.required_count = required_count;
        this.remark = remark;
        this.request_date = request_date;
        this.request_time = request_time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRequired_count() {
        return required_count;
    }

    public void setRequired_count(String required_count) {
        this.required_count = required_count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getRequest_time() {
        return request_time;
    }

    public void setRequest_time(String request_time) {
        this.request_time = request_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
