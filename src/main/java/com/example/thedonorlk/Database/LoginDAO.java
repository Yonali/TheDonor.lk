package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.LoginBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean validate(LoginBean loginBean)
    {
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
}
