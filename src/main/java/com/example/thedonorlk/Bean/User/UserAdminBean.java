package com.example.thedonorlk.Bean.User;

public class UserAdminBean {
    protected int id;
    protected String username;

    public UserAdminBean() {}

    public UserAdminBean(int id, String username) {
        this.id = id;
        this.username = username;
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
}
