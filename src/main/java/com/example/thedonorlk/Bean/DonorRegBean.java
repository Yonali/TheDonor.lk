package com.example.thedonorlk.Bean;

public class DonorRegBean {

    private String fname;
    private String lname;
    private String email;
    private String dob;
    private String pwd;
    private String cpwd;

    public DonorRegBean() {
    }

    public DonorRegBean(String fname, String lname, String email, String dob, String pwd, String cpwd) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.pwd = pwd;
        this.cpwd = cpwd;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }
}
