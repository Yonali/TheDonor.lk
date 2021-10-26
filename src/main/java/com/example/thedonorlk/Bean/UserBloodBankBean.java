package com.example.thedonorlk.Bean;

public class UserBloodBankBean {
    protected int id;
    protected String code;
    protected String username;
    protected String name;
    protected String contact;
    protected String email;
    protected String add_street;
    protected String add_city;

    public UserBloodBankBean() {}

    public UserBloodBankBean(int id, String code, String username, String name, String contact, String email, String add_street, String add_city) {
        this.id = id;
        this.code = code;
        this.username = username;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.add_street = add_street;
        this.add_city = add_city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
}
