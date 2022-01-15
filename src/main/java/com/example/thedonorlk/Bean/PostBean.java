package com.example.thedonorlk.Bean;

import java.io.InputStream;

public class PostBean {
    protected int id;
    protected String caption;
    private InputStream image_video;
    private byte[] imgBytes;
    protected String date;
    protected String time;
    protected String donor_id;
    protected String donor_name;
    private byte[] donor_profile;

    public PostBean() {}

    public PostBean(int id, String caption, InputStream image_video, byte[] imgBytes, String date, String time, String donor_id, String donor_name, byte[] donor_profile) {
        this.id = id;
        this.caption = caption;
        this.image_video = image_video;
        this.imgBytes = imgBytes;
        this.date = date;
        this.time = time;
        this.donor_id = donor_id;
        this.donor_name = donor_name;
        this.donor_profile = donor_profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public InputStream getImage_video() {
        return image_video;
    }

    public void setImage_video(InputStream image_video) {
        this.image_video = image_video;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }

    public String getDonor_name() {
        return donor_name;
    }

    public void setDonor_name(String donor_name) {
        this.donor_name = donor_name;
    }

    public byte[] getDonor_profile() {
        return donor_profile;
    }

    public void setDonor_profile(byte[] donor_profile) {
        this.donor_profile = donor_profile;
    }
}
