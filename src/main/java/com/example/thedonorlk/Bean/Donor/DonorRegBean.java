package com.example.thedonorlk.Bean.Donor;

public class DonorRegBean {

    private String fname;
    private String lname;
    private String email;
    private String contact;
    private String dob;
    private String gender;
    private String pwd;
    private String cnfrm_pwd;

    public DonorRegBean() {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCnfrm_pwd() {
        return cnfrm_pwd;
    }

    public void setCnfrm_pwd(String cnfrm_pwd) {
        this.cnfrm_pwd = cnfrm_pwd;
    }
}
