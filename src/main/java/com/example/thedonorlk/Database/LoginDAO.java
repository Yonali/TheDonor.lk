package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.LoginBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public LoginDAO() {}

    public boolean validate(LoginBean loginBean) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user where username = ? and password =?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginBean.getUsername());
            ps.setString(2, loginBean.getPassword());
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public String getUserRole(LoginBean loginBean) {
        String role = "";

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user where username = ? and password =?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginBean.getUsername());
            ps.setString(2, loginBean.getPassword());
            ResultSet rs = ps.executeQuery();
            rs.next();
            role = rs.getString("Role");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public int getUserID(LoginBean loginBean) {
        int id = 0;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select ID from user where username = ? and password =?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, loginBean.getUsername());
            ps.setString(2, loginBean.getPassword());
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
