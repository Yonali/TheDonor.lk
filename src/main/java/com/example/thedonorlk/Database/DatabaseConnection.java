package com.example.thedonorlk.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() {

        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/thedonor";

        String dbUsername = "root";
        String dbPassword = "";

        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
