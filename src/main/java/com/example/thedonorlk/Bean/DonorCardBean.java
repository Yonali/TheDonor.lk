package com.example.thedonorlk.Bean;

public class DonorCardBean {
    private int id;
    private String name;
    private String nic;
    private String blood_group;
    private String contact;
    private String gender;
    private String email;
    private String status;
    private String donation_count;
    private String age;

    public DonorCardBean() {
    }

    public DonorCardBean(int id, String name, String nic, String blood_group, String contact, String gender, String email, String status, String donation_count, String age) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.blood_group = blood_group;
        this.contact = contact;
        this.gender = gender;
        this.email = email;
        this.status = status;
        this.donation_count = donation_count;
        this.age = age;
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
}
