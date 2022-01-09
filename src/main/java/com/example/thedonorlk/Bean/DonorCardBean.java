package com.example.thedonorlk.Bean;

public class DonorCardBean {
    private int id;
    private String first_name;
    private String last_name;
    private String nic;
    private String blood_group;
    private String contact;
    private String gender;
    private String email;
    private String status;
    private String donation_count;
    private String age;
    private String add_street;
    private String add_city;
    private String about;


    public DonorCardBean() {
    }

    public DonorCardBean(int id, String first_name, String last_name, String nic, String blood_group, String contact, String gender, String email, String status, String donation_count, String age, String add_street, String add_city, String about) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.blood_group = blood_group;
        this.contact = contact;
        this.gender = gender;
        this.email = email;
        this.status = status;
        this.donation_count = donation_count;
        this.age = age;
        this.add_street = add_street;
        this.add_city = add_city;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDonation_count() {
        return donation_count;
    }

    public void setDonation_count(String donation_count) {
        this.donation_count = donation_count;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
