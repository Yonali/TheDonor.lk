package com.example.thedonorlk.Bean;

public class UserNurseBean {
    protected int id;
    protected String username;
    protected String first_name;
    protected String last_name;
    protected String contact;
    protected String nic;
    protected String email;
    protected String section;
    protected String bloodbank_code;

    public UserNurseBean() {}

    public UserNurseBean(int id, String username, String first_name, String last_name, String contact, String nic, String email, String section, String bloodbank_code) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact = contact;
        this.nic = nic;
        this.email = email;
        this.section = section;
        this.bloodbank_code = bloodbank_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBloodbank_code() {
        return bloodbank_code;
    }

    public void setBloodbank_code(String bloodbank_code) {
        this.bloodbank_code = bloodbank_code;
    }
}
