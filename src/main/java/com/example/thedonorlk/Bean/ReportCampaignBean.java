package com.example.thedonorlk.Bean;

public class ReportCampaignBean {
    protected int id;
    protected String name;
    protected String date;
    protected String address_street;
    protected String address_city;
    protected String a_pos;
    protected String a_neg;
    protected String b_pos;
    protected String b_neg;
    protected String ab_pos;
    protected String ab_neg;
    protected String o_pos;
    protected String o_neg;
    protected String total;

    public ReportCampaignBean() {}

    public ReportCampaignBean(int id, String name, String date, String address_street, String address_city, String a_pos, String a_neg, String b_pos, String b_neg, String ab_pos, String ab_neg, String o_pos, String o_neg, String total) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address_street = address_street;
        this.address_city = address_city;
        this.a_pos = a_pos;
        this.a_neg = a_neg;
        this.b_pos = b_pos;
        this.b_neg = b_neg;
        this.ab_pos = ab_pos;
        this.ab_neg = ab_neg;
        this.o_pos = o_pos;
        this.o_neg = o_neg;
        this.total = total;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getA_pos() {
        return a_pos;
    }

    public void setA_pos(String a_pos) {
        this.a_pos = a_pos;
    }

    public String getA_neg() {
        return a_neg;
    }

    public void setA_neg(String a_neg) {
        this.a_neg = a_neg;
    }

    public String getB_pos() {
        return b_pos;
    }

    public void setB_pos(String b_pos) {
        this.b_pos = b_pos;
    }

    public String getB_neg() {
        return b_neg;
    }

    public void setB_neg(String b_neg) {
        this.b_neg = b_neg;
    }

    public String getAb_pos() {
        return ab_pos;
    }

    public void setAb_pos(String ab_pos) {
        this.ab_pos = ab_pos;
    }

    public String getAb_neg() {
        return ab_neg;
    }

    public void setAb_neg(String ab_neg) {
        this.ab_neg = ab_neg;
    }

    public String getO_pos() {
        return o_pos;
    }

    public void setO_pos(String o_pos) {
        this.o_pos = o_pos;
    }

    public String getO_neg() {
        return o_neg;
    }

    public void setO_neg(String o_neg) {
        this.o_neg = o_neg;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
