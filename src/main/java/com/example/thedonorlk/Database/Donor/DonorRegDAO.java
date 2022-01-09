package com.example.thedonorlk.Database.Donor;

import com.example.thedonorlk.Bean.Donor.DonorRegBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DonorRegDAO {

    public DonorRegDAO() {}

    Connection con = DatabaseConnection.initializeDatabase();

    boolean status = true;
    public boolean addDonorReg(DonorRegBean donorRegBean){
        String id = createUser(donorRegBean.getEmail(), donorRegBean.getPwd());
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        String sql = "INSERT INTO user_donor (ID, First_Name, Last_Name, Contact, DOB, Gender, Email, Status, Join_Date) VALUES (?,?,?,?,?,?,?, 'Not Verified', ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,donorRegBean.getFname());
            ps.setString(3,donorRegBean.getLname());
            ps.setString(4,donorRegBean.getContact());
            ps.setString(5,donorRegBean.getDob());
            ps.setString(6,donorRegBean.getGender());
            ps.setString(7,donorRegBean.getEmail());
            ps.setDate(8, sqlDate);

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    private String createUser(String email, String pwd) {
        String id = "0";

        String sql = "INSERT INTO user (Username, Password, Role) VALUES (?,?,'donor')";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pwd);

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        sql = "select ID from user where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean validateEmail(String email) {
        boolean status = false;

        String sql = "select * from user where username = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
