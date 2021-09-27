package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.DonorRegBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonorRegDAO {

    public boolean addDonorreg(DonorRegBean donorRegBean){
        boolean status = false;

        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "INSERT INTO user_donor VALUES(?,?,?,?,?,?)";
        PreparedStatement ps;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,donorRegBean.getFname());
            ps.setString(2,donorRegBean.getLname());
            ps.setString(3,donorRegBean.getEmail());
            ps.setString(4,donorRegBean.getDob());
            ps.setString(5,donorRegBean.getPwd());
            ps.setString(6,donorRegBean.getCpwd());
        } catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
