package com.example.thedonorlk.Bean.User;

public class UserDonorBean {

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String contact;
    private String gender;

    public UserDonorBean() {}

    public UserDonorBean(int id, String fname, String lname, String email, String contact, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
