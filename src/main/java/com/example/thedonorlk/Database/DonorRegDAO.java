package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.DonorRegBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorRegDAO {

    public boolean addDonorReg(DonorRegBean donorRegBean){
        boolean status = true;
        String id = "1";

        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "INSERT INTO user (Username, Password, Role) VALUES (?,?,'donor')";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,donorRegBean.getEmail());
            ps.setString(2,donorRegBean.getPwd());

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        sql = "select ID from user where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, donorRegBean.getEmail());
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "INSERT INTO user_donor (ID, First_Name, Last_Name, Contact, DOB, Gender, Email) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,donorRegBean.getFname());
            ps.setString(3,donorRegBean.getLname());
            ps.setString(4,donorRegBean.getContact());
            ps.setString(5,donorRegBean.getDob());
            ps.setString(6,donorRegBean.getGender());
            ps.setString(7,donorRegBean.getEmail());

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    public boolean validateEmail(DonorRegBean donorRegBean) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user where username = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, donorRegBean.getEmail());
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
