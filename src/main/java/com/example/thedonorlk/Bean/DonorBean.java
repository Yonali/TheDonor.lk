package com.example.thedonorlk.Bean;

public class DonorBean {
    private int id;
    private String fname;
    private String lname;
    private String nic;
    private String blood_group;
    private String contact;
    private String dob;
    private String gender;
    private String email;
    private String add_street;
    private String add_city;
    private String profile;
    private String description;
    private String bloodbank_code;
    private String status;

    public DonorBean() {
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd_street() {
        return add_street;
    }

    public void setAdd_street(String add_street) {
        this.add_street = add_street;
    }

    public String getAdd_city() {
        return add_city;
    }

    public void setAdd_city(String add_city) {
        this.add_city = add_city;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DonorBean(int id, String fname, String lname, String nic, String blood_group, String contact, String dob, String gender, String email, String add_street, String add_city, String profile, String description, String bloodbank_code, String status) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
        this.blood_group = blood_group;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.add_street = add_street;
        this.add_city = add_city;
        this.profile = profile;
        this.description = description;
        this.bloodbank_code = bloodbank_code;
        this.status = status;
    }
}
