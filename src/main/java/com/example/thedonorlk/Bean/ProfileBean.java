package com.example.thedonorlk.Bean;

import java.io.InputStream;

public class ProfileBean {
    private String id;
    private String username;
    private InputStream profile;
    private byte[] imgBytes;

    public ProfileBean() {
    }

    public ProfileBean(String id, String username, InputStream profile, byte[] imgBytes) {
        this.id = id;
        this.username = username;
        this.profile = profile;
        this.imgBytes = imgBytes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public InputStream getProfile() {
        return profile;
    }

    public void setProfile(InputStream profile) {
        this.profile = profile;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }
}
